
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;



    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }



    public void addBook(Book book) {
        books.add(book);
    }



    public void addUser(User user) {
        users.add(user);
    }



    public void listAvailableBooks() {
        System.out.println("--- Available Books ---");

        for (Book book : books) {
            if (book.isAvailable()) {
                book.printBookInfo();
            }
        }
    }



    public void getBorrowedBooksForAllUsers() {
        for (User user : users) {
            System.out.println("User: " + user.getName() + ", Borrowed: " + user.getBorrowedBooks());
        }

    }



    public void borrowBook(User user, String title) throws BookAlreadyBorrowedException {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    throw new BookAlreadyBorrowedException("The book '" + title + "' is already borrowed.");
                }

                book.setAvailable(false);
                user.borrowBook(title);
                System.out.println("You have successfully borrowed: " + title);
                return;
            }
        }

        System.out.println("Book not found or not available: " + title);
    }
}


