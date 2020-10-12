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
class AfishaMovieManagerAnotherLengthTest {

    @Mock
    private AfishaMovieRepository movieRepository;

    @InjectMocks
    private AfishaMovieManager manager = new AfishaMovieManager(movieRepository, 5);
    private Movie first = new Movie(1, "1Url", "first", "1");
    private Movie second = new Movie(2, "2Url", "second", "2");
    private Movie third = new Movie(3, "3Url", "third", "3");
    private Movie fourth = new Movie(4, "4Url", "fourth", "4");
    private Movie fifth = new Movie(5, "5Url", "fifth", "5");
    private Movie sixth = new Movie(6, "6Url", "sixth", "6");

    @Test
    public void shouldRemoveMovieById() {
        int idToRemove = 2;
        Movie[] returned = new Movie[] {first, third, fourth, fifth, sixth};
        doReturn(returned).when(movieRepository).findAll();
        doNothing().when(movieRepository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] expected = new Movie[] {sixth, fifth, fourth, third, first};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
        verify(movieRepository).removeById(idToRemove);
    }

    @Test
    public void shouldAddLessThenLengthAfisha() {
        Movie[] returned = new Movie[] {first, second, third, fourth};
        doReturn(returned).when(movieRepository).findAll();
        Movie[] expected = new Movie[] {fourth, third, second, first};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddEqualLengthAfisha() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth};
        doReturn(returned).when(movieRepository).findAll();
        Movie[] expected = new Movie[] {fifth, fourth, third, second, first};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public  void shouldAddMoreThenLengthAfisha() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(movieRepository).findAll();
        Movie[] expected = new Movie[] {sixth, fifth, fourth, third, second};
        Movie[] actual = manager.getLastMovies();
        assertArrayEquals(expected, actual);
    }
}