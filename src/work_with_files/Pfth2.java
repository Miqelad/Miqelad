package work_with_files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Pfth2 {
    public static void main(String[] args) throws IOException {
        Path filePAth = Paths.get("Woww.txt");
        Files.createFile(filePAth);
        String dialog="Hello";
        //.write() записать в файл
        Files.write(filePAth,dialog.getBytes());
        //.readAllLines() читать все строки возвращает List
       List<String> arrayList = Files.readAllLines(filePAth);
       for (String s: arrayList){
           System.out.println(s);
       }
    }
}
