import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public void generateReport(ProjectStats stats) {

        try {

            FileWriter writer =
                    new FileWriter("reports/project-report.txt");

            writer.write("========== CODEPULSE REPORT ==========\n\n");

            writer.write("Java Files: " +
                    stats.totalJavaFiles + "\n");

            writer.write("Total Lines: " +
                    stats.totalLines + "\n");

            writer.write("Code Lines: " +
                    stats.codeLines + "\n");

            writer.write("Comment Lines: " +
                    stats.commentLines + "\n");

            writer.write("Blank Lines: " +
                    stats.blankLines + "\n");

            writer.close();

            System.out.println("\nReport Generated Successfully!");

        }

        catch (IOException e) {

            System.out.println("Error generating report.");

        }
    }
}