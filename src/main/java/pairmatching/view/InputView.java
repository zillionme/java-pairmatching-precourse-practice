package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.ErrorCode.NOT_VALID_INPUT;
import static pairmatching.ErrorCode.NOT_VALID_MATCHING_INFO;

public class InputView {
    public String readFunction() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public List<String> readMatchingInfo() {
        String input = Console.readLine();
        validateInput(input);

        return castToList(input);
    }

    public void validateInput(String input) {
        if(input.isEmpty() || input.isBlank()) {
            throw NOT_VALID_INPUT.throwError();
        }
    }

    public List<String> castToList(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    public void validateMatchingInfo(List<String> matchingInfo) {
        //개수가 3개 아닌 경우,
        if(matchingInfo.size() !=3) {
            throw NOT_VALID_MATCHING_INFO.throwError();
        }

        //과정, 레벨, 미션 제대로 입력받지 않은경우
    }

}
