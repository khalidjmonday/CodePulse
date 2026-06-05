import java.io.File;

public class ProjectScanner {

    private ProjectStats stats;
    private LineCounter counter;
    private TodoFinder todoFinder;

    public ProjectScanner(ProjectStats stats) {

        this.stats = stats;
        this.counter = new LineCounter();
        this.todoFinder = new TodoFinder();
    }

    public void scanProject(String folderPath) {

        File folder = new File(folderPath);

        if (!folder.exists()) {

            System.out.println("Folder does not exist.");
            return;
        }

        scanFolder(folder);
    }

    private void scanFolder(File folder) {

        File[] files = folder.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            if (file.isDirectory()) {

                scanFolder(file);
            }
            else if (file.getName().endsWith(".java")) {

                stats.javaFiles++;

                System.out.println(
                        "Found: " + file.getName());

                counter.countLines(file, stats);

                stats.todoCount +=
                        todoFinder.findTodos(file);
            }
        }
    }
}