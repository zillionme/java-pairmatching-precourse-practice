package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pairmatching.ErrorCode.NOT_HAS_COURSE;
import static pairmatching.ErrorCode.NOT_HAS_LEVEL;
import static pairmatching.ErrorCode.NOT_HAS_MISSION;

public class Matching {
    private String inputCourse;
    private String inputLevel;
    private String inputMission;
    private Map<String, List<String>> matchingResult; //미션별 매칭 결과
    //과정, 레벨 맵 안에

    public Matching(List<String> matchingInfo) {
        getMatchingInfo(matchingInfo);
        validateMatchingInfo();
    }


    public void match(List<Crew> crew) {
        List<String> crewNames = crew.stream()
                .map(member -> member.getName())
                .collect(Collectors.toList());

        crewNames = Randoms.shuffle(crewNames);

        if(isEvenMember(crewNames)) {
            matchEvenCrew.
        }
    }
    public boolean isEvenMember(List<String> crewNames) {
        return crewNames.size()%2 == 0;
    }

    public void matchEvenCrew(List<Crew> randomCrew) {
        for(int i = 0; i < randomCrew.size(); i+=2) {
            Crew crew1 = randomCrew.get(i);
            Crew crew2 = randomCrew.get(i + 1);

            crew1.add(crew2);
            crew2.add(crew1);
        }
    }

    public void matchOddCrew(List<Crew> randomCrew) {

    }

        public void executeMatching(Crew crew1, Crew crew2) {

    }


    public void getMatchingInfo(List<String> matchingInfo) {
        inputCourse = matchingInfo.get(0);
        inputLevel = matchingInfo.get(1);
        inputMission = matchingInfo.get(2);
    }

    public void validateMatchingInfo() { // String inputCourse, String inputLevel, String inputMission
        validateCourse(inputCourse);
        validateLevel(inputLevel);
        validateMission(inputLevel, inputMission);
    }

    public void validateCourse(String inputCourse){
        boolean hasCourse = Arrays.stream(Course.values())
                .anyMatch(course -> course.getName().equals(inputCourse));

        if(!hasCourse) {
            NOT_HAS_COURSE.throwError();
        }
    }
    public void validateLevel(String inputLevel) {
        boolean hasLevel = Arrays.stream(Level.values())
                .anyMatch(level -> level.getLevel().equals(inputLevel));

        if(!hasLevel) {
            NOT_HAS_LEVEL.throwError();
        }
    }
    public void validateMission(String inputLevel, String inputMission) {
        boolean hasMission = Arrays.stream(Level.values())
                .filter(level -> level.getLevel().equals(inputLevel))
                .anyMatch(level -> level.getMission().contains(inputMission));

        if(!hasMission) {
            NOT_HAS_MISSION.throwError();
        }
    }

}
