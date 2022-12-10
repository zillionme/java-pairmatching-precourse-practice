package pairmatching;

import java.util.List;
public class PairMatchingProgram {

    private List<Crew> backendCrew;
    private List<Crew> frontendCrew;

    public PairMatchingProgram() {
        loadCrew();
    }

    public void loadCrew() {
        Loading loading = new Loading();

        backendCrew = loading.loadCrew(Course.BACKEND);
        frontendCrew = loading.loadCrew(Course.FRONTEND);
    }




    public void executeCommand(String command) {

    }

    public void match(List<String> matchingInfo) {
    }



}
