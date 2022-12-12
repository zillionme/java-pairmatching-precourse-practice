package pairmatching.domain;

import pairmatching.contants.Course;
import pairmatching.contants.Level;

import java.util.List;

public class MatchingInfo {
    private Course course;
    private Level level;
    private String mission;


    public MatchingInfo(List<String> matchingInfo) {
        course = Course.getCourseBy(matchingInfo.get(0));
        level = Level.getLevelBy(matchingInfo.get(1));
        mission = Level.getMissionBy(matchingInfo.get(2));
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
