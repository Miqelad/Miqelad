package work_with_files;

import java.io.*;

public class CopyEx {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader
                (new FileReader("picture.jpg"));
            BufferedWriter writer = new BufferedWriter
                    (new FileWriter("picture_new.jpg"));) {
            String line;
            while ((line= reader.readLine())!=null){
                writer.write(line+'\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
