package fileFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileFinderRunner {
    public static void main(String[] args) throws IOException {

        FileFinderWalk fileFinder = new FileFinderWalk();
        System.out.println(fileFinder.findFilePathInDirectoryWalk("C:\\Users\\Szakhi\\Downloads", "28946352_1962414763800823_775515290_o (1)"));
        System.out.println();
        System.out.println();


        TreeFinder treeFinder = new TreeFinder("Steam");
        Files.walkFileTree(Paths.get("C:\\"), treeFinder);

        List paths = treeFinder.getFoundPaths();
        if(paths.size() == 0) {
            System.out.println("No such file in this directory");
        }
        for (Object p : paths) {
            System.out.println(p);
        }
    }
}
