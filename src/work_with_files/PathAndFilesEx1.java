package work_with_files;
/**
 * Методы нового класса
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAndFilesEx1 {
    public static void main(String[] args) throws IOException {
        //файл сам создастся
        Path filePath = Paths.get("test7.txt");
        //папка тоже сама создастся
        Path directoryPath = Paths.get("C:\\Paata\\Java\\M");
        //.getFileName() имя файла или имя директории
        System.out.println(""+filePath.getFileName());
        System.out.println(directoryPath.getFileName());
        //.getParent() родителя покажет
        System.out.println(""+filePath.getParent());
        System.out.println(directoryPath.getParent());
        //.getRoot() укажет корень
        System.out.println(""+filePath.getRoot());
        System.out.println(directoryPath.getRoot());
        //.isAbsolute() Абсолютный ли путь?
        //.toAbsolutePath Узнать абсолютный путь
        //.resolve присоединение
        System.out.println(""+directoryPath.resolve(filePath));
        //C:\Paata\Java\M\test7.txt // но не кладет их туда)
        //. relativize относительный путь относительны двух папок к примеру
        Path directoryPath2 = Paths.get("C:\\Paata\\Java\\F");
        System.out.println(directoryPath.relativize(directoryPath2));
        ////TODO: Методы класса Files
        //!.exists(filePath) если нет файла
        //.createFile(filePath) создай файл
        if (!Files.exists(filePath)){
            System.out.println("Create");
            Files.createFile(filePath);
        }
        //Files.isReadable - если права на чтение
        //Files.isWritable
        //Files.isExecutable() -могу ли запускать
        //.isSameFile ссылаются ли на один и тот же файл
        Path file2 = Paths.get("test7.txt");
        System.out.println(Files.isSameFile(filePath,file2));
        //Files.size выводит размер файла
        //.getAttribute - проверить какой атрибут, их нужно знать либо гуглить
        //не ошибаться в написание
        Files.getAttribute(filePath,"creationTime");
        //.readAttributes узнать все атрибуты, возвращает map<String,Object>
        System.out.println(Files.readAttributes(filePath,"*"));



    }
}
