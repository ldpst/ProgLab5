package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.object.Movie;
import ru.itmo.prog.lab5.utils.Element;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс для хранения и управления коллекцией
 * @author ldpst
 */
public class CollectionManager {
    Deque<Movie> movies = new ArrayDeque<Movie>();

    public CollectionManager() {
        // reader
    }

    /**
     * Метод для добавления movie в файл
     * @param movie элемент для добавления типа Movie
     */
    public void add(Movie movie) {
        movies.push(movie);
    }

    /**
     * Метод для сохранения в файл
     * @param filename имя файла, в который будет сохранена коллекция
     */
    public void save(String filename) {
        // saving
    }

    /**
     * Метод для очищения коллекции
     */
    public void clear() {
        movies = new ArrayDeque<Movie>();
    }

    public Element findElemById(long id) {
        for (Element movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
            movies.remove(movie);
        }
        return null;
    }
}
