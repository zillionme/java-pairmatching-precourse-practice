package pairmatching.domain;

import pairmatching.contants.Course;
import pairmatching.contants.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crew {
    private Course course;
    private String name;

    public String getName() {
        return name;
    }

    private Map<Level, List<Crew>> matchingHistory = new HashMap<>();

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean isMatchableWith(Level level, List<Crew> otherCrew) {
        List<Crew> matchingHistoryByLevel = matchingHistory.getOrDefault(level, new ArrayList<>());

        for(Crew other : otherCrew) {
            if(!this.equals(other) && matchingHistoryByLevel.contains(other)){
                return false;
            }
        }
        return true;
    }

    public void addMatchingHistory(Level level, List<Crew> otherCrew) {
        List<Crew> matchingHistoryByLevel = matchingHistory.getOrDefault(level, new ArrayList<>());

        for(Crew other : otherCrew) {
            if(!this.equals(other)){
                matchingHistoryByLevel.add(other);
                matchingHistory.put(level, matchingHistoryByLevel);
            }
        }
    }
}
