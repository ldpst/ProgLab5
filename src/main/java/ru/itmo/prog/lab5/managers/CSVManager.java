package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.utils.StreamHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

/**
 * Метод для загрузки и сохранения коллекции в csv файл
 *
 * @author ldpst
 */
public class CSVManager {
    private final StreamHandler stream;

    private String[] header;

    public CSVManager(StreamHandler stream) {
        this.stream = stream;
    }

    public ArrayDeque<Movie> loadFromCSV() {
        String fileName = loadFileNameFromEnvironment();
        if (fileName == null) {
            return null;
        }
        ArrayDeque<Movie> movies = new ArrayDeque<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            if (line == null) {
                stream.printErr("В файле отсутствует строка-заголовок\n");
                return null;
            }
            this.header = line.split(",");
            int id = find("id"),
                    name = find("name"),
                    coordinatesX = find("coordinates.x"),
                    coordinatesY = find("coordinates.y"),
                    creationDate = find("creationDate"),
                    oscarCount = find("oscarCount"),
                    genre = find("genre"),
                    mpaaRating = find("mpaaRating"),
                    operatorName = find("operator.name"),
                    operatorBirthday = find("operator.birthday"),
                    operatorWeight = find("operator.weight"),
                    operatorPassportID = find("operator.passportID");


            line = br.readLine();
            while (line != null) {

                line = br.readLine();
            }

        } catch (IOException e) {
            stream.printErr("Файл с названием " + fileName + " не найден");
            return null;
        }


        return movies;
    }

    /**
     * Метод для получения имени файла из переменной окружения
     *
     * @return имя файла
     */
    private String loadFileNameFromEnvironment() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String filePath = processBuilder.environment().get("Lab5FileName");
        if (filePath == null) {
            stream.printErr("Переменная окружения с названием файла Lab5FileName пуста\n");
            return null;
        }
        return "config/" + filePath + ".csv";
    }

    private int find(String head) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(head)) {
                return i;
            }
        }
        return -1;
    }
}
