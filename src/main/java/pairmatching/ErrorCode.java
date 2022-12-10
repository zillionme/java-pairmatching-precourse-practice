package pairmatching;

public enum ErrorCode {
    NOT_VALID_INPUT("값을 입력하지 않았습니다."),
    NOT_VALID_MATCHING_INFO("과정, 레벨, 미션을 선택하지 않았습니다."),
    NOT_HAS_FILE("파일이 존재하지 않습니다."),
    NOT_HAS_COURSE("해당하는 과정이 없습니다."),
    NOT_HAS_LEVEL("해당하는 레벨이 없습니다."),
    NOT_HAS_MISSION("해당하는 미션이 없습니다.");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void throwError() {
        throw new IllegalArgumentException(this.errorMessage);
    }
}
