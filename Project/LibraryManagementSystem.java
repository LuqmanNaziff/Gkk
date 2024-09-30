import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();
    
    library.addBook(new Book("Harry Potter", "J.K. Rowling", "12345", true));
    library.addBook(new Book("Lord of the Rings",  "J.R.R. Tolkien", "67890", true));
    
    library.listAvailableBooks();

    System.out.print("Enter the name of User 1: ");
    String name1 = scanner.nextLine();
    System.out.print("Enter the age of User 1: ");
    int age1 = scanner.nextInt();
    scanner.nextLine();  

        User user1 = new User(name1, age1);
        library.addUser(user1);

    System.out.print("Enter the name of User 2: ");
    String name2 = scanner.nextLine();
    System.out.print("Enter the age of User 2: ");
    int age2 = scanner.nextInt();
    scanner.nextLine(); 

        User user2 = new User(name2, age2);
        library.addUser(user2);


    try {
        System.out.print("Enter the title of the book User 1 wants to borrow: ");
        String title1 = scanner.nextLine();
        library.borrowBook(user1, title1);

        System.out.print("Enter the title of the book User 2 wants to borrow: ");
        String title2 = scanner.nextLine();
        library.borrowBook(user2, title2);
    } catch (BookAlreadyBorrowedException e) {
        System.out.println(e.getMessage());
    }

    // Show borrowed books for users
    library.getBorrowedBooksForAllUsers();

    // Checking due dates and overdue books
    user1.checkDueDates();
    user1.checkOverdueBooks();
    user2.checkDueDates();
    user2.checkOverdueBooks();

    // Close the scanner
    scanner.close();
}
}

    
