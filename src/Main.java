import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userInputFile;
        Scanner fileScanner;

        userInputFile = getFileName();
        try {
            fileScanner = openFile(userInputFile);
            createGraph(fileScanner);

        } catch (Exception e) {
            System.out.println("Make sure file is in the program directory");
            e.printStackTrace();
        }
    }

    public static String getFileName() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter file name: ");
        return reader.nextLine();

    }

    public static Scanner openFile(String userInputFile) throws Exception{
        File file = new File(userInputFile);
        Scanner fileScanner = new Scanner(file);
        return fileScanner;
    }

    public static void createGraph(@NotNull Scanner inputFile) {
        int n = inputFile.nextInt();
        int m = inputFile.nextInt();

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int source = inputFile.nextInt();
            int destination = inputFile.nextInt();
            graph.addEdge(source, destination);
        }

        graph.countTables(1);
        int numberTables = graph.getCount();
        System.out.println("Number of tables: " + numberTables);
    }
}
