package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaMovieManager {
    private Movie[] movies = new Movie[0];
    private int afishaLength = 10;
    public AfishaMovieManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public AfishaMovieManager() {
    }

    public void addMovie(Movie addedMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastMovieIndex = tmp.length - 1;
        tmp[lastMovieIndex] = addedMovie;
        movies = tmp;
    }

    public Movie[] getLastMovies() {
        int resultLength = Math.min(afishaLength, movies.length);
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
