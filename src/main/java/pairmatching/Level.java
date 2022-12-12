package pairmatching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static pairmatching.ErrorCode.NOT_VALID_LEVEL;
import static pairmatching.ErrorCode.NOT_VALID_MISSION;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주","로또","숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니","결제","지하철노선도")),
    LEVEL3("레벨3", Collections.EMPTY_LIST),
    LEVEL4("레벨4", List.of("성능개선","배포")),
    LEVEL5("레벨5", Collections.EMPTY_LIST);

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level getLevelBy(String input) {
        return Arrays.stream(values())
                .filter(level -> level.getName().equals(input))
                .findFirst()
                .orElseThrow(NOT_VALID_LEVEL::throwError);
    }

    public static String getMissionBy(String input) {
        if(hasMissionBy(input)) {
            return input;
        }
        throw NOT_VALID_MISSION.throwError();
    }

    public static boolean hasMissionBy(String input) {
        return Arrays.stream(values())
                .anyMatch(level -> level.getMissions().contains(input));

    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }
}
