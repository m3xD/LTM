package RMI;

import java.io.Serializable;

public class BookX implements Serializable {
    private String id;
    private String title;
    private String author;
    private int yearPublished;
    private String genre;
    private String code;
    private static final long serialVersionUID = 20241124L;

    public BookX(String id, String genre, String title, String author, int yearPublished) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public BookX() {}

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getGenre() {
        return genre;
    }
}