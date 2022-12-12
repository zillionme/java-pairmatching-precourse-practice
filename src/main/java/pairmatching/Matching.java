package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.ErrorCode.NOT_VALID_TRIES;

public class Matching {
    private static final String rootPath = "src/main/resources/";
    private FileReader fileReader;
    private List<List<Crew>> matchingResult;
    private final Course course;
    private final Level level;
    private final String mission;

    private int tries;
    private boolean isMatchable;


    public Matching(List<String> matchingInfo) {
        course = Course.getCourseBy(matchingInfo.get(0));
        level = Level.getLevelBy(matchingInfo.get(1));
        mission = Level.getMissionBy(matchingInfo.get(2));
        tries = 0;
    }

    public List<List<Crew>> getMatchingResult() {
        match();
        return matchingResult;
    }

    public void match() {
        try {
            loadFile();
            List<String> crewNames = getCrewNames();
            generate(crewNames);
        } catch (IOException e) {
        }
    }

    public void loadFile() throws IOException {
        String resource = course.getResource();
        File file = new File(rootPath + resource);
        fileReader = new FileReader(file);
    }

    public List<String> getCrewNames() throws IOException {
        BufferedReader br = new BufferedReader(fileReader);
        List<String> crewNames = new ArrayList<>();
        String line;
        while ((line = br.readLine())!=null) {
            crewNames.add(line);
        }

        return crewNames;
    }

    // 3번 반복하는동안/  만난적 있으면,
    public void generate(List<String> crewNames) {
        do{
            if(tries > 3) {
                throw NOT_VALID_TRIES.throwError();
            }
            List<Crew> shuffledCrew = getShuffledCrew(crewNames); //크루로 만들어서,
            tries++;
            pairMatch(shuffledCrew);

        } while(!isMatchable);

    }

    public void pairMatch(List<Crew> shuffledCrew) {
        matchingResult = new ArrayList<>();
        isMatchable = true;

        if (isEvenNumber(shuffledCrew)) {
            matchEvenCrew(shuffledCrew);
        }
        if(!isEvenNumber(shuffledCrew)){
            matchOddCrew(shuffledCrew);
        }
    }

    public List<Crew> getShuffledCrew(List<String> crewNames) {
        List<String> shuffledCrewNames = Randoms.shuffle(crewNames); //섞고
        return shuffledCrewNames.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
    }

    //짝수인지 홀수인지
    public boolean isEvenNumber(List<Crew> shuffledCrew) {
        return shuffledCrew.size()% 2 == 0;
    }

    //짝수 짝짓기
    public void matchEvenCrew(List<Crew> shuffledCrew) {
        for (int i = 0; i < shuffledCrew.size(); i += 2) {
            Crew crewA = shuffledCrew.get(i);
            Crew crewB = shuffledCrew.get(i + 1);

            matchTwoCrew(crewA, crewB);
        }
    }

    public void matchOddCrew(List<Crew> shuffledCrew) {
        matchEvenCrew(shuffledCrew.subList(0, shuffledCrew.size() - 3));
        matchRestCrew(shuffledCrew.subList(shuffledCrew.size() - 3, shuffledCrew.size()));
    }

    public void matchRestCrew(List<Crew> shuffledCrew) {
        Crew crewA = shuffledCrew.get(0);
        Crew crewB = shuffledCrew.get(1);
        Crew crewC = shuffledCrew.get(2);

        matchThreeCrew(crewA, crewB, crewC);
    }


    public void matchTwoCrew(Crew crewA, Crew crewB) {
        if (!crewA.isMatchableWith(level, crewB)) {
            isMatchable = false;
            return;
        }
        crewA.addCrewHistory(level, crewB);
        crewB.addCrewHistory(level, crewA);

        matchingResult.add(List.of(crewA, crewB));
    }

    public void matchThreeCrew(Crew crewA, Crew crewB, Crew crewC) {
        if (!crewA.isMatchableWith(level, crewB) && !crewA.isMatchableWith(level, crewC)) {
            isMatchable = false;
            return;
        }
        crewA.addCrewHistory(level, List.of(crewB, crewC));
        crewB.addCrewHistory(level, List.of(crewA, crewC));
        crewC.addCrewHistory(level, List.of(crewA, crewB));
        matchingResult.add(List.of(crewA, crewB, crewC));
    }

    //매치 되지 않으면 오류 발생시키기
}

