import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

public class Activity01 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.home"));

        Files.walkFileTree(path, Collections.emptySet(), 3, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                String [] pathArray = path.toString().split("/");
                int depthInit = pathArray.length;
                String [] fileArray = dir.toString().split("/");
                int depthCurrent = fileArray.length;
                for (int i = depthInit; i < depthCurrent; i++) {
                    System.out.print("    ");
                }
                System.out.println(fileArray[fileArray.length - 1]);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc)
                    throws IOException {
                System.out.println("visitFileFailed: " + file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}