package pairmatching;

public enum ErrorCode {
    NOT_VALID_INPUT("값을 입력하지 않았습니다."),
    NOT_VALID_MATCHING_INFO("값을 입력하지 않았습니다."),
    NOT_VALID_COURSE("해당하는 과정이 없습니다."),
    NOT_VALID_LEVEL("해당하는 레벨이 없습니다."),
    NOT_VALID_MISSION("해당하는 미션이 없습니다."),
    NOT_VALID_FUNCTION("일치하는 기능이 없습니다."),
    NOT_VALID_TRIES("매칭을 3번 시도했습니다.");
    private static final String ERROR_BEGIN ="[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN+errorMessage;
    }

    public IllegalArgumentException throwError() {
        return new IllegalArgumentException(this.errorMessage);
    }
}
