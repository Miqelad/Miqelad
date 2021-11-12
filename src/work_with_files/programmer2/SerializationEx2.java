package work_with_files.programmer2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Второй программист будет читать из бинарника
 */
public class SerializationEx2 {
    public static void main(String[] args) {
        List<String> emp;
        try(ObjectInputStream inputStream = new
                ObjectInputStream(new FileInputStream("emp.bin")))
        {   //делаем кастинс, ведь имена в Аррей лист
            emp=(ArrayList)inputStream.readObject();
            System.out.println(emp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
