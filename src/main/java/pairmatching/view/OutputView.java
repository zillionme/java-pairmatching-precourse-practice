package pairmatching.view;

import java.util.List;

import static pairmatching.util.ErrorCode.NOT_HAS_HISTORY;

public class OutputView {
    private final String COURSE_MENU = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "###########################################";
    private final String MESSAGE_RESULT = "페어 매칭 결과입니다.";

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printCourseMenu() {
        System.out.println(COURSE_MENU);
    }

    public void printMatchingResult(List<String> matchingResult) {
        for (String matchedCrew : matchingResult) {
            System.out.println(matchedCrew);
        }
    }

}
