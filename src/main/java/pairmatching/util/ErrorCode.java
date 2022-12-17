package pairmatching.util;

public enum ErrorCode {
    NOT_VALID_INPUT("아무것도 입력하지 않았습니다."),
    NOT_VALID_FUNCTION("선택한 기능이 존재하지 않습니다."),
    NOT_VALID_MATCHING_INFO("과정, 레벨, 미션을 입력하지 않았습니다."),
    NOT_VALID_COURSE("해당하는 과정이 존재하지 않습니다."),
    NOT_VALID_LEVEL("해당하는 레벨이 존재하지 않습니다."),
    NOT_VALID_MISSION("해당하는 미션이 존재하지 않습니다."),
    UNABLE_MATCHING("매칭에 실패했습니다."),
    NOT_VALID_REMATCH("네, 아니오로 입력해주세요."),
    NOT_HAS_HISTORY("매칭 이력이 없습니다.");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN + errorMessage;
    }

    public IllegalArgumentException throwError() {
        return new IllegalArgumentException(this.errorMessage);
    }
}
