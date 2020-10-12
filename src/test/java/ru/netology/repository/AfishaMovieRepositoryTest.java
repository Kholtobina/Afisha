package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaMovieRepositoryTest {

    private AfishaMovieRepository movieRepository = new AfishaMovieRepository();
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
        movieRepository.saveMovie(first);
        movieRepository.saveMovie(second);
        movieRepository.saveMovie(third);
        movieRepository.saveMovie(fourth);
        movieRepository.saveMovie(fifth);
        movieRepository.saveMovie(sixth);
        movieRepository.saveMovie(seventh);
        movieRepository.saveMovie(eighth);
        movieRepository.saveMovie(ninth);
    }

    @Test
    public void shouldSaveAllMovies() {
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh,
                eighth,ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAllMoviesWithAdded() {
        movieRepository.saveMovie(tenth);
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh,
                eighth,ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieByIdIfExists() {
        Movie[] actual = movieRepository.findById(8);
        Movie[] expected = new Movie[] {eighth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieByIdIfNotExists() {
        Movie[] actual = movieRepository.findById(12);
        Movie[] expected = new Movie[] {null};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveMovieByIdIfExists() {

        movieRepository.removeById(2);
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[] {first, third, fourth, fifth, sixth, seventh,
                eighth,ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllMovies() {
        Movie[] actual = movieRepository.removeAll();
        Movie[] expected = new Movie[] {};
        assertArrayEquals(expected, actual);
    }
}