package ru.netology.domain;

import lombok.Getter;

@Getter

public class Movie {
    private int id;
    private String imageUrl;
    private String name;
    private String genre;

    public Movie(int id, String imageUrl, String name, String genre) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.genre = genre;
    }
}
