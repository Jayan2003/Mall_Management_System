package mall_management_system;
import java.util.Arrays;
import java.util.List;
public class Book_Store extends Store {

    int numberOfBooks;
    String bookCategory;
    String bestSeller;

    // Default constructor
    public Book_Store() {
        super();
        this.numberOfBooks = 0;
        this.bookCategory = "General";
        this.bestSeller = "";
    }

    // Argument-based constructor
    public Book_Store(String Store_Name, String closing_hour, String opening_hour,Manager m,Employee e, int numberOfBooks, String bookCategory, String bestSeller) {
        super(Store_Name, closing_hour, opening_hour,m,e);
        this.numberOfBooks = numberOfBooks;
        this.bookCategory = bookCategory;
        this.bestSeller = bestSeller;
    }

    // Copy constructor
    public Book_Store(Book_Store otherBookStore) {
        super(otherBookStore);
        this.numberOfBooks = otherBookStore.numberOfBooks;
        this.bookCategory = otherBookStore.bookCategory;
        this.bestSeller = otherBookStore.bestSeller;

    }
      public List<String> getAvailableStores() {
        return Arrays.asList("Barnes & Noble", "Books-A-Million", "Waterstones", "Indigo", "Foyles");
    }
}