package pairmatching;

import java.util.List;

public class Crew {
    private Course course;
    private String name;
    private List<Crew> matchedCrew;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean isMatchable(Crew other) {
        return !matchedCrew.contains(other);
    }

    public String getName() {
        return name;
    }

    public void add(Crew other) {

        matchedCrew.add(other);
    }
}
