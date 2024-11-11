import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GenerateTxt {
    public static String studentName = "";
    public static String assignmentNumber = "";
    public static String studentId = "";
    public static String folderName = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking User Input
        System.out.print("Student Name: ");
        studentName = sc.nextLine();
        System.out.print("Student ID: ");
        studentId = sc.next();
        System.out.print("Assignment Number: ");
        assignmentNumber = sc.next();
        System.out.print("Folder Name: ");
        folderName = sc.next();

        String fileName = "Assignment " + assignmentNumber + "_" + studentId + "_" + studentName + ".txt";

        // Setup the output file
        File outputFile = createTxtFile(fileName);
        try {
            FileWriter writer = new FileWriter(outputFile, true);

            // Reading files from directory
            File folder = new File("./" + folderName);
            if (folder.isDirectory()) {
                // Filtering only the .java files
                FileFilter filter = file -> file.getName().startsWith("Task") && file.getName().endsWith(".java");
                File[] files = folder.listFiles(filter);

                // Looping through every java file
                if (files != null) {
                    Arrays.sort(files, Comparator.comparingInt(file -> {
                        String name = file.getName();
                        String number = name.replaceAll("[^0-9]", "");
                        return Integer.parseInt(number);
                    }));

                    for (int i = 0; i < files.length; i++) {
                        FileReader reader = new FileReader(files[i]);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line;

                        writer.write("#Task" + ((int) i + 1) + ":");
                        writer.write("\n");
                        // Read each line from the file and write to the output file
                        while ((line = bufferedReader.readLine()) != null) {
                            writer.write(line);
                            writer.write("\n"); // Newline after each line
                        }

                        writer.write("\n"); // Add a newline after the content of each file
                        bufferedReader.close();
                    }
                } else {
                    System.out.println("No files found or an error occurred.");
                }
            } else {
                System.out.println("The provided path is not a directory.");
            }

            writer.close(); // Close the FileWriter
            System.out.println("Content written to " + fileName + " successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    public static void readFiles(File[] files) {
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[0]);

        }
    }

    public static File createTxtFile(String fileName) {
        File outputFile = new File(fileName);

        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
                System.out.println("File written successfully!");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }

        return outputFile;
    }
}
