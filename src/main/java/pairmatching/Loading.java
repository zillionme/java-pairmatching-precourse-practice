package pairmatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.ErrorCode.NOT_HAS_FILE;

public class Loading {
    // 파일 내용 불러와서 리스트에 저장하기
    private static final String path = "src/main/resources/";

    public File createFileBy(Course course) throws IOException {
        String fileName = course.getFileName();
        return new File(path + fileName);
    }

    // FileNotFoundException 과 IOException 발생가능성
    public List<String> getCrewNames(Course course) {
        try{
            FileReader fileReader = new FileReader(createFileBy(course));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            return load(bufferedReader);

        } catch (IOException e) {
            throw new IllegalArgumentException("파일이 없습니다");
        }
    }

    public List<String> load(BufferedReader bufferedReader) throws IOException {
        List<String> result = new ArrayList<>();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) { // 파일 내 문자열을 1줄씩 읽기 while
            //크루 이름 중복 불가 Set으로?
            result.add(line);
        }
        return result;
    }

    public List<Crew> loadCrew(Course course) {
        List<Crew> crew = new ArrayList<>();
        List<String> crewNames = getCrewNames(course);

        for(String crewName : crewNames ) {
            crew.add(new Crew(course, crewName));
        }

        return crew;
    }


}
