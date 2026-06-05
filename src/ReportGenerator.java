import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public void generate(ProjectStats stats) {

        try {

            FileWriter writer =
                    new FileWriter("reports/report.txt");

            writer.write("CODEPULSE REPORT\n");
            writer.write("========================\n\n");

            writer.write("Java Files: "
                    + stats.javaFiles + "\n");

            writer.write("Total Lines: "
                    + stats.totalLines + "\n");

            writer.write("Code Lines: "
                    + stats.codeLines + "\n");

            writer.write("Comment Lines: "
                    + stats.commentLines + "\n");

            writer.write("Blank Lines: "
                    + stats.blankLines + "\n");

            writer.write("TODOs Found: "
                    + stats.todoCount + "\n\n");

            writer.write("Largest File:\n");

            writer.write(
                    stats.largestFileName
                            + " ("
                            + stats.largestFileLines
                            + " lines)\n");

            writer.close();

            System.out.println(
                    "\nReport Generated Successfully!");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}