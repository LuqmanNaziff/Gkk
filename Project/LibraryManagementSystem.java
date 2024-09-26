import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();
    
    library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345", true));
    library.addBook(new Book("Lord of the Rings",  "J.R.R. Tolkien", "67890", false));

    User user1 = new User("Alice", 30);
    User user2 = new User("Bob", 25);

    library.addUser(user1);
    library.addUser(user2);


    library.listAvailableBooks();

     try {
         library.borrowBook(user1, "Harry Potter");
         library.borrowBook(user2, "Lord of the Rings");
         // Attempt to borrow the same book again
         library.borrowBook(user1, "Harry Potter"); // This should throw an exception
    } catch (BookAlreadyBorrowedException e) {
        System.out.println(e.getMessage());
     }

     library.getBorrowedBooksForAllUsers();


     user1.checkDueDates();
     user1.checkOverdueBooks();
    }
}

    
