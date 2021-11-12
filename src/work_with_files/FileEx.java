package work_with_files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("text1.txt");
        File folder = new File("C:\\Paata\\Java");
        //из файла, можем получить абсолютный путь
        System.out.println(file.getAbsoluteFile());
        //Проверяет абсолютный ли путь или нет
        System.out.println(file.isAbsolute());
        //проверяет папка эта или нет
        System.out.println(file.isDirectory());
        //проверяет существует ли файл или папка
        System.out.println(file.exists());
        //Cоздать новый файл
        System.out.println(file.createNewFile());
        //Создать новую папку
        System.out.println(folder.mkdir());
        //.length размер в байтах
        //.delete удаляет файл или папку
        //узнать содержимое папки
        File[] files = folder.listFiles();
        System.out.println(Arrays.toString(files));
        //узнать скрыт ли файл
        System.out.println(file.isHidden());
        //доступ на чтение .canRead Запись .canWrite и Запуск .canExecute


    }
}
