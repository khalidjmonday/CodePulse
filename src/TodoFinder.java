import java.io.*;

public class TodoFinder {

    public int findTodos(File file) {

        int count = 0;

        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.contains("TODO")) {
                    count++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}