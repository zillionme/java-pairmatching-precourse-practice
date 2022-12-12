package pairmatching;

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

    private Map<Level, List<Crew>> crewHistory = new HashMap<>();

    public Crew(String name) {
        this.name = name;
    }

    public boolean isMatchableWith(Level level, Crew other) {
        if(crewHistory.containsKey(level) &&
                crewHistory.get(level).contains(other)){
            return false;
        }
        return true;
    }

    public void addCrewHistory(Level level, Crew other) {
        List<Crew> pastCrew = crewHistory.getOrDefault(level, new ArrayList<>());
        pastCrew.add(other);
        crewHistory.put(level, pastCrew);
    }

    public void addCrewHistory(Level level, List<Crew> others) {
        List<Crew> pastCrew = crewHistory.getOrDefault(level, new ArrayList<>());
        for(Crew other : others) {
            if(!this.equals(other)){
                pastCrew.add(other);
            }
        }
        crewHistory.put(level, pastCrew);
    }
}
