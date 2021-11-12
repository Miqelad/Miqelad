package work_with_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * копирование директории и использование легкого поиска,
 * для того, чтобы не оверрайдить все методы
 * extends SimpleFileVisitor<Path>
 */
public class CopyFileTree {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\PM\\Desktop\\X");
        Path destination = Paths.get("C:\\Users\\PM\\Desktop\\CopyHere");
        Files.walkFileTree(source,new MyFileVisitor2(source,destination));

    }
}
class MyFileVisitor2 extends SimpleFileVisitor<Path>{
    Path source;//откуда копируем
    Path destination;//куда копируем

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException {
      //  System.out.println("Enter to directory: " + dir);
        Path newDestination = destination.resolve(source.relativize(dir));
//        //если мы хотим перезаписать, то нужно юзать доп параметр
        Files.copy(dir,newDestination,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        //System.out.println("File name: "+file.getFileName());
        Path newDestination = destination.resolve(source.relativize(file));
        Files.copy(file,newDestination);
        return FileVisitResult.CONTINUE;

    }
}

