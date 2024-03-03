package library.file;

import configuration.loaders.BaseLoader;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class FileUtils {
    public static String getResourcePath(String filename) {
        try {
            ClassLoader classLoader = BaseLoader.class.getClassLoader();
            URL url = classLoader.getResource(filename);

            File file = new File(Objects.requireNonNull(url).toURI());
            return file.getPath();

        } catch (URISyntaxException ex) {
            System.out.println("Could not found filename");
            return "";
        }
    }
}
