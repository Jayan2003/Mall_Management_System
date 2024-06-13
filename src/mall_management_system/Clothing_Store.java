package mall_management_system;
import java.util.ArrayList;
import java.util.List;
public class Clothing_Store extends Store{
 
    int numberOfClothingItems;
    String clothingCategory;
    String specialOffer;
    String seasonalCollection;

    // Default constructor
    public Clothing_Store() {
        super();
        this.numberOfClothingItems = 0;
        this.clothingCategory = "General";
        this.specialOffer = "";
        this.seasonalCollection = "";
    }

    // Argument-based constructor
    public Clothing_Store(String Store_Name, String closing_hour, String opening_hour,Manager m,Employee e,int numberOfClothingItems, String clothingCategory, String specialOffer, String seasonalCollection) {
        super(Store_Name, closing_hour, opening_hour,m,e);
        this.numberOfClothingItems = numberOfClothingItems;
        this.clothingCategory = clothingCategory;
        this.specialOffer = specialOffer;
        this.seasonalCollection = seasonalCollection;
        this.m=m;
        this.e=e;
    }

    // Copy constructor
    public Clothing_Store(Clothing_Store otherClothingStore) {
        super(otherClothingStore);
        this.numberOfClothingItems = otherClothingStore.numberOfClothingItems;
        this.clothingCategory = otherClothingStore.clothingCategory;
        this.specialOffer = otherClothingStore.specialOffer;
        this.seasonalCollection = otherClothingStore.seasonalCollection;
    }
    // Method to get available stores
    public List<String> getAvailableStores() {
       
        List<String> availableStores = new ArrayList<>();
        availableStores.add("Bershka");
        availableStores.add("Pull and Bear");
        availableStores.add("H&M");
        availableStores.add("Zara");
        availableStores.add("Concrete");
       
        return availableStores;
    }
    }
