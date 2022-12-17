package pairmatching.domain;

import pairmatching.contants.Course;
import pairmatching.contants.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pairmatching.util.ErrorCode.NOT_HAS_HISTORY;

public class PairProgram {
    private boolean isRunning;
    private Map<String, List<String>> matchingRepository;

    public PairProgram() {
        this.isRunning = true;
        this.matchingRepository = new HashMap<>();
    }

    public List<String> match(MatchingInfo matchingInfo) {
        Course course = matchingInfo.getCourse();
        Level level = matchingInfo.getLevel();
        String mission = matchingInfo.getMission();

        Matching matching = new Matching(course, level);
        updateMatchingRepository(mission, matching.getResult());

        return getMatchingResult(matchingInfo);
    }

    public void updateMatchingRepository(String mission, List<String> matchingResult) {
        matchingRepository.put(mission, matchingResult);
    }

    public List<String> getMatchingResult(MatchingInfo matchingInfo) {
        String mission = matchingInfo.getMission();
        return matchingRepository.getOrDefault(mission, new ArrayList<>());

    }

    public boolean hasMatchingHistory(MatchingInfo matchingInfo) {
        String mission = matchingInfo.getMission();
        if (matchingRepository.containsKey(mission)) {
            return true;
        }
        return false;
    }

    public List<String> lookup(MatchingInfo matchingInfo) {
        String mission = matchingInfo.getMission();
        List<String> matchingResult = matchingRepository.getOrDefault(mission, new ArrayList<>());

        if (matchingResult.size() == 0) {
            throw NOT_HAS_HISTORY.throwError();
        }
        return matchingResult;
    }

    public void initiate() {
        this.matchingRepository = new HashMap<>();
    }

    public void end() {
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
