package ru.itmo.prog.lab5.managers;

import ru.itmo.prog.lab5.object.*;
import ru.itmo.prog.lab5.utils.Element;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

/**
 * Класс для хранения и управления коллекцией
 *
 * @author ldpst
 */
public class CollectionManager {
    private Deque<Movie> movies = new ArrayDeque<Movie>();
    private java.time.ZonedDateTime creationTime;

    public CollectionManager() {
        movies.add(new Movie("Test1", new Coordinates((float) 12, 10), (long) 1, MovieGenre.DRAMA, MpaaRating.G, new Person("Alex", new Date(), 10, "45674")));
        movies.add(new Movie("Test1", new Coordinates((float) 12, 10), (long) 1, MovieGenre.DRAMA, MpaaRating.G, new Person("Alex", new Date(), 10, "45674")));
        creationTime = java.time.ZonedDateTime.now();
    }

    /**
     * Метод для добавления movie в файл
     *
     * @param movie элемент для добавления типа Movie
     */
    public void add(Movie movie) {
        movies.push(movie);
        Movie.increaseNextInt();
    }

    /**
     * Метод для сохранения в файл
     *
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

    /**
     * Метод для поиска элемента по id
     *
     * @param id айди
     * @return Movie
     */
    public Movie findElemById(long id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Метод для удаления элемента по id
     *
     * @param id айди
     */
    public void removeById(long id) {
        Movie elem = (Movie) findElemById(id);
        movies.remove(elem);
    }

    /**
     * Метод, возвращающий первый элемент
     *
     * @return Movie
     */
    public Movie getHead() {
        return movies.getFirst();
    }

    /**
     * Метод, возвращающий размер коллекции
     *
     * @return int
     */
    public int getSize() {
        return movies.size();
    }

    /**
     * Метод, возвращающий тип коллекции
     *
     * @return Class[?]
     */
    public Class<?> getCollectionClass() {
        return movies.getClass();
    }

    /**
     * Метод, возвращающий значение поля creationTime
     *
     * @return ZonedDateTime
     */
    public java.time.ZonedDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Метод, возвращающий содержимое коллекции
     *
     * @return Deque[Movie]
     */
    public Deque<Movie> getMovies() {
        return movies;
    }
}
