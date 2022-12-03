package pairmatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loading {
    // 파일 내용 불러와서 리스트에 저장하기
    String path = "src/main/resources/";
    String fileName = "backend-crew.md";
    File file = new File(path + fileName);


    // FileNotFoundException 과 IOException 발생가능성
    public List<String> load() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> result = new ArrayList<>();
        String line = "";

        while ((line = bufferedReader.readLine()) != null) { // 파일 내 문자열을 1줄씩 읽기 while
            //크루 이름 중복 불가 Set으로?
            result.add(line);
            }

        return result;
        }

}
