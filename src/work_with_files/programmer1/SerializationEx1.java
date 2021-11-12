package work_with_files.programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Первый программист будет записывать в файлы
 */
public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> employee = new ArrayList<>();
        employee.add("Paata");
        employee.add("Pasha");
        employee.add("Whomga");
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream("emp.bin"));
        ) {
            outputStream.writeObject(employee);
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
