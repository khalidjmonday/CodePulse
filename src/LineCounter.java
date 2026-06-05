import java.io.*;

public class LineCounter {

    public void analyzeFile(File file, ProjectStats stats) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                stats.totalLines++;

                line = line.trim();

                if (line.isEmpty()) {
                    stats.blankLines++;
                }

                else if (line.startsWith("//")) {
                    stats.commentLines++;
                }

                else {
                    stats.codeLines++;
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading file: " + file.getName());

        }
    }
}