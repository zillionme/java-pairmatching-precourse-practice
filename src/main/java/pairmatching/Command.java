package pairmatching;

public enum Command {
    Matching("1", "페어 매칭"),
    Looking("2", "페어 조회"),
    Initiating("3", "페어 초기화"),
    End("Q", "종료");

    private final String symbol;
    private final String command;

    Command(String symbol, String command) {
        this.symbol = symbol;
        this.command = command;
    }
}
