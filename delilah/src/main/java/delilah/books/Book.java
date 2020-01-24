package delilah.books;

public class Book {
    
    private final String coverUrl;
    private final String title;
    private final String author;
    private final String description;

    public Book(String coverUrl, String title, String author, String description) {
        this.coverUrl = coverUrl;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
    
    
}
