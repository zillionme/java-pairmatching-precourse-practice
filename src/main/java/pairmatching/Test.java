package pairmatching;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
//        File file = new File(".");
//        String rootPath = String.valueOf(file.getAbsoluteFile());
//        String path = System.getProperty("user.dir"); // 위와 같음
//        Path currentPath = Paths.get("");
//        String paths = currentPath.toAbsolutePath().toString();
//
//        System.out.println(paths);
        try {
            FileInputStream fis = new FileInputStream("C:\\WOOTAECO_ing\\java-pairmatching-precourse-practice\\src\\main\\java\\pairmatching\\hello.txt");
            FileReader fileReader = new FileReader( "src/main/java/pairmatching/hello.txt");
            int data = 0;
            while((data= fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
