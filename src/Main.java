public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("        CODEPULSE v1.0");
        System.out.println("=================================\n");

        ProjectStats stats = new ProjectStats();

        ProjectScanner scanner =
                new ProjectScanner(stats);

        scanner.scanProject("src");

        System.out.println("\n========== SUMMARY ==========");

        System.out.println("Java Files: " +
                stats.totalJavaFiles);

        System.out.println("Total Lines: " +
                stats.totalLines);

        System.out.println("Code Lines: " +
                stats.codeLines);

        System.out.println("Comment Lines: " +
                stats.commentLines);

        System.out.println("Blank Lines: " +
                stats.blankLines);

        ReportGenerator generator =
                new ReportGenerator();

        generator.generateReport(stats);
    }
}