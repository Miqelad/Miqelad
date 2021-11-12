package work_with_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Parh {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test7.txt");
        Path directoryPath = Paths.get("C:\\Paata\\Java\\M");
        //.copy скопируется по пути дерриктории
        //нужно указать еще имя файла, но можем резолвить
        //Files.copy(filePath,directoryPath.resolve("test16.txt"));
        Files.copy(filePath,directoryPath.resolve(filePath));
        //если мы хотим перезаписать, то нужно юзать доп параметр
        Files.copy(filePath,directoryPath.resolve(filePath)
                , StandardCopyOption.REPLACE_EXISTING);
        //.move вырезает
        Files.move(filePath,directoryPath.resolve(filePath));
        //Таким методом можно и переименовать файл или папку
        Files.move(filePath,Paths.get("wow"));
        //.delete удалит файл или папку(если не пустая)


    }
}
