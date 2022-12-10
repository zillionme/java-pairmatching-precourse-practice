package pairmatching;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String fileName;

    Course(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public String getName() {
        return this.name;
    }

    public String getFileName() {
        return fileName;
    }

//    public static String getFileName(String input) {
//        return Arrays.stream(values())
//                .findAny(course -> input.equals(course.getName()))
//                .orElseThrow(new IllegalArgumentException("일치하는 과정이 없습니다.")).getFileName();
//    }
}
