import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Student {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("/Users/mac/Desktop/OOP/pract/student.txt"); // Вхідний файл
        Path file1 = Path.of("/Users/mac/Desktop/OOP/pract/kursant.txt"); // Вихідний файл

        try {
            try (BufferedWriter writer = Files.newBufferedWriter(file)) {
                writer.write("Student studying in Lviv State University of Life Safery");
                System.out.println("Дані успішно додано у файл." );
            }
            try (BufferedReader reader = Files.newBufferedReader(file);
                 BufferedWriter writer = Files.newBufferedWriter(file1)) {
                System.out.println("Вміст файлу: ");
                String line;
                while ((line = reader.readLine()) != null) {
                    String file2 = line.replaceAll("\\b[Ss]tudent\\b", "kursant");
                    writer.write(file2);
                    writer.newLine();
                    System.out.println(line);
                    System.out.println("Рядок змінено: " + file2);
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка під час обробки файлу: " + e.getMessage());
        }
    }
}