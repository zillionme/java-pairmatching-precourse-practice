package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.ErrorCode.NOT_VALID_INPUT;
import static pairmatching.ErrorCode.NOT_VALID_MATCHING_INFO;

public class InputView {
    private static final String functionMenu = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";
    private static final String matchingMenu = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n" +
            "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    public String inputFunction() {
        System.out.println(functionMenu);
        String input = Console.readLine();
        validateInput(input);

        return input;
    }

    public void validateInput(String input) {
        if(input.isEmpty()) {
            NOT_VALID_INPUT.throwError();
        }
    }
    public List<String> inputMatchingInfo() {
        System.out.println(functionMenu);
        String input = Console.readLine();
        validateInput(input);

        List<String> matchingInfo = castToList(input);
        validateMatchingInfo(matchingInfo);

        return matchingInfo;
    }

    public List<String> castToList(String input) {

        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public void validateMatchingInfo(List<String> matchingInfo) {
        if(matchingInfo.size()!=3) {
            NOT_VALID_MATCHING_INFO.throwError();
        }
    }
}
