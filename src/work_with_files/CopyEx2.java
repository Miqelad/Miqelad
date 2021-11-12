package work_with_files;
/**
 * Способ копирования файла
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) {
        try(FileInputStream inputStream =
                    new FileInputStream("picture.jpg");
            FileOutputStream outputStream =
                    new FileOutputStream("picture_new2.jpg")


                ){
            int i;
            while ((i= inputStream.read())!=-1){
                outputStream.write(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
