package work_with_files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Повторение, как гайд записи в буфер и чтение буфера
 */
//TODO: test10    abcdefghij
public class Channelex2 {
    public static void main(String[] args) {
        try (RandomAccessFile file =
                     new RandomAccessFile("test10.txt", "r");
             FileChannel channel = file.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(5);//размерность буфера
            channel.read(buffer);//записали в буфер
            buffer.flip();//флипаем чтобы могли читать
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }

            buffer.clear();//очищаем буфер и заносим новые элементы
            channel.read(buffer);//записываем в буфер следующее
            buffer.flip();//переворачиваем, чтобы читать могли

            while (buffer.hasRemaining()){
                System.out.println("2"+(char)buffer.get());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
