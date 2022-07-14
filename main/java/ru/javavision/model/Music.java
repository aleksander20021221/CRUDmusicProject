package ru.javavision.model;

public class Music {

    private int id;

    private String title;
    private String album;
    private String year;
    private String artist;

    public Music(int id, String title, String album, String year, String artist) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.year = year;
        this.artist = artist;
    }

    public Music() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
