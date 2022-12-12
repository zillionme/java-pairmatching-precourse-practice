package pairmatching.domain;

import pairmatching.contants.Course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewLoader {

    public List<String> loadBy(Course course) {
        try {
            File file = new File(course.getResource());
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            return getCrewNames(buffer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getCrewNames(BufferedReader buffer) throws IOException {
        List<String> crewNames = new ArrayList<>();
        String crewName;

        while ((crewName = buffer.readLine()) != null) {
            if (!crewName.isEmpty()) {
                crewNames.add(crewName);
            }
        }

        return crewNames;
    }
}
