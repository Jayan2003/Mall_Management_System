package mall_management_system;
import java.util.*;

public class Cosmetics extends Store {
    private String bestSellerProduct;
    private boolean crueltyFree;

    // Default constructor
    public Cosmetics() {
        super();
        this.bestSellerProduct = "";
        this.crueltyFree = true;
    }

    // Argument-based constructor
    public Cosmetics(String storeName, String closingHour, String openingHour,Manager m,Employee e,String bestSellerProduct, boolean crueltyFree) {
        super(storeName, closingHour, openingHour,m,e);
        this.bestSellerProduct = bestSellerProduct;
        this.crueltyFree = crueltyFree;
        this.m=m;
        this.e=e;
        
    }

    // Copy constructor
    public Cosmetics(Cosmetics otherCosmetics) {
        super(otherCosmetics);
        this.bestSellerProduct = otherCosmetics.bestSellerProduct;
        this.crueltyFree = otherCosmetics.crueltyFree;
    }
   
   
    public List<String> getAvailableStores() {
        List<String> availableStores = new ArrayList<>();
        availableStores.add("Sephora");
        availableStores.add("Mikyaji");
        availableStores.add("Ulta");
       
        return availableStores;
    }
   
}


