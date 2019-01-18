package fileFinder;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class TreeFinder extends SimpleFileVisitor<Path>{

    private List<Path> foundPaths = new ArrayList<>();
    private PathMatcher matcher;

    public TreeFinder(String fileName) {
      matcher = FileSystems.getDefault()
              .getPathMatcher("glob:" + fileName + ".*");
    }

    public void addFileToList(Path file) {
        Path fileName = file.getFileName();
        if(fileName != null && matcher.matches(fileName)) {
            foundPaths.add(file);
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.printf("Visiting failed for %s\n", file);

        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        addFileToList(file);

        return FileVisitResult.CONTINUE;

    }
    public List getFoundPaths() {
        return foundPaths;
    }
}
