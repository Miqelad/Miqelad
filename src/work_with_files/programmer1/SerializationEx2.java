package work_with_files.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx2 {
    public static void main(String[] args) {
        Empl1 empl =
                new Empl1("Paata","IT",25,9.9);
    try(ObjectOutputStream outputStream = new
            ObjectOutputStream(new FileOutputStream("emp2.bin"))) {
        outputStream.writeObject(empl);
        System.out.println("Done");


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
