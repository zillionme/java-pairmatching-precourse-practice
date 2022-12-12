package pairmatching;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingProgram {
    private List<List<Crew>> matchingResult;

    public boolean isRunning() {
        return isRunning;
    }

    private boolean isRunning = true;

    public List<String> getMatchingResult() {
        List<String> matchingResultToString = new ArrayList<>();
        for(List<Crew> matchedCrew : matchingResult) {
            List<String> matchedCrewName = getMatchedCrewName(matchedCrew);
            matchingResultToString.add(String.join(" : ", matchedCrewName));
        }

        return matchingResultToString;
    }
    
    public List<String> getMatchedCrewName(List<Crew> matchedCrew) {
        return matchedCrew.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public void match(List<String> matchingInfo) {
        Matching matching = new Matching(matchingInfo);
        matchingResult = matching.getMatchingResult();
    }

    public void look(List<String> matchingInfo) {

    }

    public void initiate() {

    }
    public void endProgram() {
        isRunning = false;
    }

}
