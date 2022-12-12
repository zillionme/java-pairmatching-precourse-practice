package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairMatchingProgram pairMatchingProgram = new PairMatchingProgram();

    public void generate() {
        //1. 기능선택-> 기능 실행
        try{
            do{
                Functions functionInput = chooseFunction();
                executeFunction(functionInput);
            } while(pairMatchingProgram.isRunning());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        //while(종료버튼 누르지 않을때까지계속 진행)***************
    }

    //1. 기능선택
    public Functions chooseFunction() {
        try {
            String input = inputView.readFunction();
            return Functions.getFunctionBy(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

        return chooseFunction();
    }

    //2. 선택한 기능 실행
    public void executeFunction (Functions function) {
        if(function == Functions.MATCHING || function == Functions.LOOKING) {
            executeMatchOrLooking(function);
        }
        if(function == Functions.INITIATING) {
            pairMatchingProgram.initiate();
        }
        if(function == Functions.END) {
            pairMatchingProgram.endProgram();
        }
    }

    public void executeMatchOrLooking(Functions function) {
        List<String> matchingInfo = getMatchingInfo();
        if(function == Functions.MATCHING) {
            pairMatchingProgram.match(matchingInfo);
            outputResult();
        }
        if(function == Functions.LOOKING) {
            pairMatchingProgram.look(matchingInfo);
        }
    }

    //3.페어 매칭 정보 입력받기
    public List<String> getMatchingInfo() {
        try {
            // 정보 유효성 검사 하기*********** Program Information
            return inputView.readMatchingInfo();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

        return getMatchingInfo();
    }

    //4. 페어매칭 결과 내기
    public void outputResult() {
        List<String> matchingResult = pairMatchingProgram.getMatchingResult();
        outputView.printMatchingResult(matchingResult);
    }
}
