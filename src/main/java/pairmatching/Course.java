package pairmatching;

import java.util.Arrays;

import static pairmatching.ErrorCode.NOT_VALID_COURSE;

public enum Course {
    BACKEND("백엔드","backend-crew.md"),
    FRONTEND("프론트엔드","frontend-crew.md");

    private final String name;
    private final String resource;

    Course(String name, String resource) {
        this.name = name;
        this.resource = resource;
    }

    public static Course getCourseBy(String input) {
        return Arrays.stream(values())
                .filter(course -> course.getName().equals(input))
                .findFirst()
                .orElseThrow(NOT_VALID_COURSE::throwError);
    }


    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }
}
