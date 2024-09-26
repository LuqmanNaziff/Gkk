import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks;
    private Map<String, LocalDate> borrowedBooksDueDates;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDates = new HashMap<>();
    }


    public String getName() {
        return name;
    }


    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }


    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
        LocalDate dueDate = LocalDate.now().plusDays(14);
        borrowedBooksDueDates.put(bookTitle, dueDate);
    }


    public void returnBook(String bookTitle) {
        if (borrowedBooks.remove(bookTitle)) {
            borrowedBooksDueDates.remove(bookTitle);
            System.out.println("Successfully returned: " + bookTitle);
        } else {
            System.out.println("Book not found: " + bookTitle);
        }

    }


    public void checkDueDates() {
        if (borrowedBooksDueDates.isEmpty()) {
            System.out.println("No borrowed books with due dates.");
        } else {
            for (String book : borrowedBooks) {
                LocalDate dueDate = borrowedBooksDueDates.get(book);
                System.out.println("Book: " + book + ", Due Date: " + dueDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
            }
        }
    }



    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        boolean hasOverdueBooks = false;


        for (String book : borrowedBooks) {
            LocalDate dueDate = borrowedBooksDueDates.get(book);
            if (dueDate.isBefore(today)) {
                long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(dueDate, today);
                System.out.println("Overdue Book: " + book + ", Overdue by: " + daysOverdue + " days");
                hasOverdueBooks = true;
            }
        }

        if (!hasOverdueBooks) {
            System.out.println("No overdue books.");
        }
    }
}