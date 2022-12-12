package pairmatching;

import java.util.Arrays;

import static pairmatching.ErrorCode.NOT_VALID_FUNCTION;

public enum Functions {
    MATCHING("1"),
    LOOKING("2"),
    INITIATING("3"),
    END("Q");

    private final String matchingNumber;

    Functions(String matchingNumber) {
        this.matchingNumber = matchingNumber;
    }

    public static Functions getFunctionBy(String input) {
        return Arrays.stream(values())
                .filter(function -> function.getMatchingNumber().equals(input))
                .findFirst()
                .orElseThrow(NOT_VALID_FUNCTION::throwError);
    }
    public String getMatchingNumber() {
        return matchingNumber;
    }


//    MATCHING("1", new Matching()),
//    LOOKING("2", new Looking()),
//    INITIATING("3", new Initiating()),
//    END("Q", new EndProgram());
//
//    private final String matchingNumber;
//    private final Runnable matchingFunction;
//
//    Functions(String matchingNumber, Runnable matchingFunction) {
//        this.matchingNumber = matchingNumber;
//        this.matchingFunction = matchingFunction;
//    }
//
//    public static Functions getFunctionBy(String input) {
//        return Arrays.stream(values())
//                .filter(function -> function.getMatchingNumber().equals(input))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("일치하는 기능이 없습니다."));
//    }
//    public String getMatchingNumber() {
//        return matchingNumber;
//    }
//
//    public Runnable getFunctionClass() {
//        return matchingFunction;
//    }
}
