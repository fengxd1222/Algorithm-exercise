package contest.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

public class FileReader {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/27968/Desktop/新建文本文档.txt");

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(file.toPath(), StandardOpenOption.APPEND));
             BufferedWriter writer = new BufferedWriter(outputStreamWriter);){
            writer.newLine();
            writer.write("测试写入");
        }
        try(InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(file.toPath()));
            BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = null;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
    }
}
