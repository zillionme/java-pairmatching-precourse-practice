package pairmatching;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니","결제","지하철노선도")),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList("성능개선","배포")),
    LEVEL5("레벨5", Arrays.asList() );

    private final String level;
    private final List<String> mission;

    Level(String level, List<String> mission) {
        this.level = level;
        this.mission = mission;
    }

    public String getLevel() {
        return level;
    }

    public List<String> getMission() {
        return mission;
    }
}
