package pairmatching;

import pairmatching.domain.MatchingInfo;
import pairmatching.domain.PairProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairProgram pairProgram = new PairProgram();
    //기능 입력받기
    //선택한 기능에 따라 입력받기 또는,

    public void generate() {
        try {
            while (pairProgram.isRunning()) {
                Function function = chooseFunction();
                executeFunctionBy(function);
            }
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    public Function chooseFunction() {
        try {
            String input = inputView.readFunction();
            return Function.getFunctionBy(input);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return chooseFunction();
    }

    public void executeFunctionBy(Function function) {
        if(function.equals(Function.END)){
            end();
        }
        function.run();
    }

    public MatchingInfo getMatchingInfo() {
        try {
            return new MatchingInfo(inputView.readMatchingInfo());

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return getMatchingInfo();
    }


    public void match() {
        outputView.printCourseMenu();
        MatchingInfo matchingInfo = getMatchingInfo();

        if(pairProgram.hasMatchingHistory(matchingInfo)) {
            askRematch(matchingInfo);
            return;
        }
        List<String> matchingResult = pairProgram.match(matchingInfo);
        outputView.printMatchingResult(matchingResult);
    }

    public void lookup() {
        outputView.printCourseMenu();
        MatchingInfo matchingInfo = getMatchingInfo();
        List<String> matchingResult = pairProgram.lookup(matchingInfo); //없으면 에러발생
        outputView.printMatchingResult(matchingResult);
    }

    public void askRematch(MatchingInfo matchingInfo) {
        String rematchCommand = getRematch();
        if(rematchCommand.equals("아니오")){
            List<String> matchingResult = pairProgram.getMatchingResult(matchingInfo);
            outputView.printMatchingResult(matchingResult);
            return;
        }
        rematch(matchingInfo); //네인 경우, 다시 매치.
    }

    public void rematch(MatchingInfo matchingInfo) {
        List<String> matchingResult = pairProgram.match(matchingInfo);
        outputView.printMatchingResult(matchingResult);
    }
    public String getRematch() {
        try {
            return inputView.readRematch();

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return getRematch();
    }

    public void initiate() {
        pairProgram.initiate();
    }

    public void end() {
        pairProgram.end();
    }
}
