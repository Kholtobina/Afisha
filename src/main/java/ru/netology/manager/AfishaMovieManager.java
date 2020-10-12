package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaMovieRepository;

public class AfishaMovieManager {

    private AfishaMovieRepository repository;
    private int afishaLenght = 10;
    public AfishaMovieManager(AfishaMovieRepository repository, int afishaLenght) {
        this.repository = repository;
        this.afishaLenght = afishaLenght;
    }

    public AfishaMovieManager() {
    }

    public void addMovie(Movie addedMovie) {
        repository.saveMovie(addedMovie);
    }
    public void removeById(int idToRemove) {
        repository.removeById(idToRemove);
    }

    public Movie[] getLastMovies() {
        Movie[] movies = repository.findAll();

        int resultLength = Math.min(afishaLenght, movies.length);
        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
