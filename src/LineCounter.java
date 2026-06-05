import java.io.*;

public class LineCounter {

    public void countLines(File file, ProjectStats stats) {

        int fileLines = 0;

        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                fileLines++;
                stats.totalLines++;

                String trimmed = line.trim();

                if (trimmed.isEmpty()) {
                    stats.blankLines++;
                }
                else if (trimmed.startsWith("//")
                        || trimmed.startsWith("/*")
                        || trimmed.startsWith("*")) {

                    stats.commentLines++;
                }
                else {
                    stats.codeLines++;
                }
            }

            if (fileLines > stats.largestFileLines) {
                stats.largestFileLines = fileLines;
                stats.largestFileName = file.getName();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}