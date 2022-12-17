package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.contants.Course;
import pairmatching.contants.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.util.ErrorCode.UNABLE_MATCHING;

public class Matching {
    private final CrewLoader crewLoader = new CrewLoader();
    List<List<Crew>> matchingList;
    private int tries;
    private boolean isSucceeded;

    public Matching(Course course, Level level) {
        generate(course, level);
    }

    public List<String> getMatchingResult() {
        List<String> matchingResult = new ArrayList<>();

        for (List<Crew> matchingCrew : matchingList) {
            List<String> matchedCrew = matchingCrew.stream()
                    .map(Crew::getName)
                    .collect(Collectors.toList());

            matchingResult.add(String.join(" : ", matchedCrew));
        }

        return matchingResult;
    }

    public void generate(Course course, Level level) {
        List<String> crewNames = crewLoader.loadBy(course);
        tries = 0;

        do {
            if (tries >= 3) {
                break;
            }
            List<Crew> crew = getShuffledCrew(course, crewNames);
            tries++;

            matchingList = getMatchingList(crew);
            match(level, matchingList);
        } while (!isSucceeded);
    }

    public List<String> getResult() {
        if (isSucceeded) {
            return getMatchingResult();
        }

        throw UNABLE_MATCHING.throwError();
    }

    public List<Crew> getShuffledCrew(Course course, List<String> crewNames) {
        return Randoms.shuffle(crewNames).stream()
                .map((crewName) -> new Crew(course, crewName))
                .collect(Collectors.toList());
    }


    public void match(Level level, List<List<Crew>> matchingList) {
        for (List<Crew> matchingCrew : matchingList) {
            if (!validateMatch(level, matchingCrew)) {
                isSucceeded = false;
                return;
            }
            matchEachGroup(level, matchingCrew);
        }
        isSucceeded = true;
    }

    public boolean validateMatch(Level level, List<Crew> matchingCrew) {
        Crew one = matchingCrew.get(0);
        if (!one.isMatchableWith(level, matchingCrew)) { //만난적 있으면
            return false;
        }
        return true;
    }

    public void matchEachGroup(Level level, List<Crew> matchingCrew) {
        //만난적 있으면
        for (Crew crew : matchingCrew) {
            crew.addMatchingHistory(level, matchingCrew);
        }
    }

    public List<List<Crew>> getMatchingList(List<Crew> crew) {
        if (crew.size() % 2 == 0) { //짝수이면
            return matchEvenCrew(crew);
        }
        return matchOddCrew(crew);
    }


    public List<List<Crew>> matchEvenCrew(List<Crew> crew) {
        List<List<Crew>> matchingList = new ArrayList<>();
        for (int i = 0; i < crew.size(); i += 2) {
            Crew crewA = crew.get(i);
            Crew crewB = crew.get(i + 1);
            matchingList.add(List.of(crewA, crewB));
        }

        return matchingList;
    }

    public List<List<Crew>> matchOddCrew(List<Crew> crew) {
        List<List<Crew>> matchingList = matchEvenCrew(crew.subList(0, crew.size() - 3));

        List<Crew> restCrew = crew.subList(crew.size() - 3, crew.size());
        matchingList.add(matchRestCrew(restCrew));

        return matchingList;
    }

    public List<Crew> matchRestCrew(List<Crew> crew) {
        List<Crew> matchingCrew = new ArrayList<>();
        for (Crew one : crew) {
            matchingCrew.add(one);
        }
        return matchingCrew;
    }

}
