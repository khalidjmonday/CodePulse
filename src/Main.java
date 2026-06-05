public class Main {

    // TODO: Add AI code analysis

    public static void main(String[] args) {

        System.out.println(
                "================================");
        System.out.println(
                "          CODEPULSE v1.1");
        System.out.println(
                "================================\n");

        ProjectStats stats =
                new ProjectStats();

        ProjectScanner scanner =
                new ProjectScanner(stats);

        scanner.scanProject("src");

        System.out.println(
                "\n========== SUMMARY ==========\n");

        System.out.println(
                "Java Files: " + stats.javaFiles);

        System.out.println(
                "Total Lines: " + stats.totalLines);

        System.out.println(
                "Code Lines: " + stats.codeLines);

        System.out.println(
                "Comment Lines: "
                        + stats.commentLines);

        System.out.println(
                "Blank Lines: "
                        + stats.blankLines);

        System.out.println(
                "TODOs Found: "
                        + stats.todoCount);

        System.out.println(
                "\nLargest File:");

        System.out.println(
                stats.largestFileName
                        + " ("
                        + stats.largestFileLines
                        + " lines)");

        double codePercent =
                ((double) stats.codeLines
                        / stats.totalLines) * 100;

        System.out.printf(
                "\nCode Percentage: %.2f%%\n",
                codePercent);

        ReportGenerator report =
                new ReportGenerator();

        report.generate(stats);
    }
}