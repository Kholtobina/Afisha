package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;


class AfishaMovieManagerDefaultLengthTest {

    private AfishaMovieManager manager = new AfishaMovieManager();
    private Movie first = new Movie(1, "1Url", "first", "1");
    private Movie second = new Movie(2, "2Url", "second", "2");
    private Movie third = new Movie(3, "3Url", "third", "3");
    private Movie fourth = new Movie(4, "4Url", "fourth", "4");
    private Movie fifth = new Movie(5, "5Url", "fifth", "5");
    private Movie sixth = new Movie(6, "6Url", "sixth", "6");
    private Movie seventh = new Movie(7, "7Url", "seventh", "7");
    private Movie eighth = new Movie(8, "8Url", "eighth", "8");
    private Movie ninth = new Movie(9, "9Url", "ninth", "9");
    private Movie tenth = new Movie(10, "10Url", "ninth", "10");
    private Movie eleventh = new Movie(11, "11Url", "eleventh", "11");
    private Movie twelve = new Movie(12, "12Url", "twelve", "12");

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
    }

    @Test
    public void shouldAddLessThenTenMovies() {
        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTenMovies() {
        manager.addMovie(tenth);
        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMoreThenTenMovies() {
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        manager.addMovie(twelve);
        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {twelve, eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

}