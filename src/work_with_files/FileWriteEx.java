package work_with_files;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно, —\n" +
                "Вот последний секрет из постигнутых мной.";
        //Автоматическое закрытие, внутренне джава, переведет в обычный
        //трай и файнали.
        try(FileWriter writer= new FileWriter("C:\\Paata\\Java" +
                "\\JavaPro\\text1.txt",true);) {
            writer.write(new String("Hello"));
            writer.write(rubai);
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
