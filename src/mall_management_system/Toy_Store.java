package mall_management_system;

import java.util.*;
public class Toy_Store extends Store {
     int numberOfToys;
     String ageRange;
     String popularToy;
     String toyCategory;
     double monthlySales;
     String customerReview;

    // Default constructor
    public Toy_Store() {
        super();
        this.numberOfToys = 0;
        this.ageRange = "All Ages";
        this.popularToy = "";
        this.toyCategory = "General";
        this.monthlySales = 0.0;
        this.customerReview = "";
    }

    // Argument-based constructor
    public Toy_Store(String Store_Name, String closing_hour, String opening_hour, Manager m,Employee e,int numberOfToys, String ageRange, String popularToy,String toyCategory, double monthlySales, String customerReview) {
        super(Store_Name, closing_hour, opening_hour,m,e);
        this.numberOfToys = numberOfToys;
        this.ageRange = ageRange;
        this.popularToy = popularToy;
        this.toyCategory = toyCategory;
       
        this.monthlySales = monthlySales;
        this.customerReview = customerReview;
    }

    // Copy constructor
    public Toy_Store(Toy_Store otherToyStore) {
        super(otherToyStore);
        this.numberOfToys = otherToyStore.numberOfToys;
        this.ageRange = otherToyStore.ageRange;
        this.popularToy = otherToyStore.popularToy;
        this.toyCategory = otherToyStore.toyCategory;
        this.monthlySales = otherToyStore.monthlySales;
        this.customerReview = otherToyStore.customerReview;
    }
    
    public List<String> getAvailableStores() {
        List<String> availableStores = new ArrayList<>();
        availableStores.add("Toys 'R' Us");
        availableStores.add("LEGO Store");
        availableStores.add("Disney Store");
        availableStores.add("Build-A-Bear Workshop");
        availableStores.add("Mattel Toy Store");
       
        return availableStores;
    }
}
