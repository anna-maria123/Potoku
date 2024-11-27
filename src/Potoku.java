import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Potoku {
    public static void main(String[] args) {
        Path file = Path.of("/Users/mac/Desktop/OOP/pract/first.txt");

        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
                System.out.println("Файл створено: " + file.toAbsolutePath());
            }
            try (BufferedWriter writer = Files.newBufferedWriter(file)) {
                writer.write("Anna,18,female");
                writer.newLine();
                writer.write("Sofia,18,female");
                writer.newLine();
                writer.write("Artyr,21,male");
                System.out.println("Дані успішно записані у файл.");
            }
            int count = 0;
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                System.out.println("Вміст файлу:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    count++;
                }
            }
            System.out.println("Кількість рядків у файлі: " + count);
        } catch (IOException e) {
            System.out.println("Помилка при підрахунку: " + e.getMessage());
        }
        InputStreamReader reader1 = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(reader1);
        try {
            String line = buff.readLine();
            Path file2 = Path.of(line);
            try {
                Files.copy(file, file2, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Файл скопійовано до: " + file2.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("Помилка при копіюванні: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}