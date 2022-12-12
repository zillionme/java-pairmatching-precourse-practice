package pairmatching;

import java.util.Arrays;
import static pairmatching.util.ErrorCode.NOT_VALID_FUNCTION;

public enum Function {
    MATCH("1") {
        void run() {
            controller.match();
        }
    },
    LOOKUP("2") {
        void run() {
            controller.lookup();
        }
    },
    INITIATE("3") {
        void run() {
            controller.initiate();
        }
    },
    END("Q") {
        void run() {
            controller.end();
        }
    };
    private static final Controller controller = new Controller();
    private final String name;
    abstract void run();

    Function(String name) {
        this.name = name;
    }

    public static Function getFunctionBy(String input) {
        return Arrays.stream(values())
                .filter((function)->input.equals(function.name))
                .findFirst()
                .orElseThrow(NOT_VALID_FUNCTION::throwError);
    }

}
