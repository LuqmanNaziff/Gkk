import java.util.ArrayList;
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;



    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable();
    }


    public String getTitle() {
        return title;
    }


    public boolean isAvailable() {
        //return isAvailable;
        return true;
    }


    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    public void printBookInfo() {
        System.out.print("Tittle: " + title + "\n" + "Author: " + author + "\n" + "ISBN: " + isbn + "\n" +"Availability: " + isAvailable + "\n" + "\n");
    }
}