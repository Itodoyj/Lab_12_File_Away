import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        }
    }

    private static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int numLines = 0;
            int numWords = 0;
            int numChars = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                numLines++;
                numWords += line.split("\\s+").length;
                numChars += line.length();
            }

            System.out.println("File Summary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + numLines);
            System.out.println("Number of Words: " + numWords);
            System.out.println("Number of Characters: " + numChars);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}