import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

public class CRUDApplication {
    private static List<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("=== CRUD Application ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void addBook() {
        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        bookList.add(newBook);
        System.out.println("Book added successfully!");
    }

    private static void viewAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("=== List of Books ===");
            for (int i = 0; i < bookList.size(); i++) {
                Book book = bookList.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    private static void updateBook() {
        viewAllBooks();
        System.out.print("Enter the book number you want to update: ");
        int bookNumber = scanner.nextInt();

        if (bookNumber < 1 || bookNumber > bookList.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        scanner.nextLine(); // Consume the newline character left by nextInt()

        Book bookToUpdate = bookList.get(bookNumber - 1);
        System.out.print("Enter the new title of the book: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter the new author of the book: ");
        String newAuthor = scanner.nextLine();

        bookToUpdate.setTitle(newTitle);
        bookToUpdate.setAuthor(newAuthor);

        System.out.println("Book updated successfully!");
    }

    private static void deleteBook() {
        viewAllBooks();
        System.out.print("Enter the book number you want to delete: ");
        int bookNumber = scanner.nextInt();

        if (bookNumber < 1 || bookNumber > bookList.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        bookList.remove(bookNumber - 1);
        System.out.println("Book deleted successfully!");
    }
}
