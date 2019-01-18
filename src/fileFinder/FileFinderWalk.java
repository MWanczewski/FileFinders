package fileFinder;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO find how to handle AccessDeniedException
public class FileFinderWalk {
    String findFilePathInDirectoryWalk(String startingPath, String filename) {

        Path startWalk = Paths.get(startingPath);
        int depth = 100;
        String walkedFile = "";

        try( Stream<Path> stream = Files.walk(startWalk, depth)) {

            walkedFile = stream
                    .map(String::valueOf)
                    .filter(path -> {
                        return String.valueOf(path).contains(filename);
                    })
                    .sorted()
                    .collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(walkedFile.equals("")){
            walkedFile = "file not found";
        }
        return walkedFile;
    }

}
