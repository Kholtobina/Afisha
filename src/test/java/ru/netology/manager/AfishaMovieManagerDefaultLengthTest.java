package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaMovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaMovieManagerDefaultLengthTest {

    @Mock
    private AfishaMovieRepository movieRepository;

    @InjectMocks
    private AfishaMovieManager manager;
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

    @Test
    public void shouldRemoveMovieById() {
        int idToRemove = 5;
        Movie[] returned = new Movie[]{first, second, third, fourth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(movieRepository).findAll();
        doNothing().when(movieRepository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fourth, third, second, first};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        verify(movieRepository).removeById(idToRemove);
    }

    @Test
    public void shouldGetLessThenTenMovies() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(movieRepository).findAll();
        Movie[] expected = new Movie[] {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTenMovies() {
        Movie[] returned = new  Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(movieRepository).findAll();
        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoreThenTenMovies() {
        Movie[] returned = new  Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,
                eleventh, twelve};
        doReturn(returned).when(movieRepository).findAll();
        Movie[] expected = new Movie[]{twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

}
