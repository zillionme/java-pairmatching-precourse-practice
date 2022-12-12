package pairmatching.view;

import pairmatching.Crew;

import java.util.List;

public class OutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMatchingResult(List<String> matchingResult) {
        for(String matchedCrew : matchingResult) {
            System.out.println(matchedCrew);
        }

    }
}
