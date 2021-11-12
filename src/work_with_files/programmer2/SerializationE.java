package work_with_files.programmer2;
/**
 * empl1{name='Paata', departament='IT', age=25, salary=0.0}
 * зарплата была скрыта
 */

import work_with_files.programmer1.Empl1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationE {
    public static void main(String[] args) {
        try (ObjectInputStream inputStream = new ObjectInputStream
                (new FileInputStream("emp2.bin"))

        ) {
            System.out.println((Empl1)inputStream.readObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
