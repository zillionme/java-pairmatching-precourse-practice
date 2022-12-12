package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.util.ErrorCode.NOT_VALID_INPUT;
import static pairmatching.util.ErrorCode.NOT_VALID_MATCHING_INFO;
import static pairmatching.util.ErrorCode.NOT_VALID_REMATCH;

public class InputView {
    private final String MESSAGE_FUNCTION_MENU = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    private final String MESSAGE_MATCHING_INFO = "\n" +
            "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private final String MESSAGE_REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오";

    public String readFunction() {
        System.out.println(MESSAGE_FUNCTION_MENU);
        String input = Console.readLine();
        validateInput(input);
        return input.trim();
    }

    public void validateInput(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw NOT_VALID_INPUT.throwError();
        }
    }

    public List<String> readMatchingInfo() {
        System.out.println(MESSAGE_MATCHING_INFO);
        String input = Console.readLine();
        validateInput(input);

        return getMatchingInfo(input);
    }

    public List<String> getMatchingInfo(String input) {
        List<String> matchingInfo = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        validateMatchingInfo(matchingInfo);
        return matchingInfo;
    }

    public void validateMatchingInfo(List<String> matchingInfo) {
        if(matchingInfo.size() != 3) {
            throw NOT_VALID_MATCHING_INFO.throwError();
        }
    }

    public String readRematch() {
        System.out.println(MESSAGE_REMATCH);
        String input = Console.readLine().trim();
        validateInput(input);
        validateRematch(input);
        return input;
    }

    public void validateRematch(String input) {
        if(!input.equals("네") && !input.equals("아니오")) {
            throw NOT_VALID_REMATCH.throwError();
        }
    }
}
