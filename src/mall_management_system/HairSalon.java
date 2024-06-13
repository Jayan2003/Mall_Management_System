package mall_management_system;
import java.util.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class HairSalon extends Activity{
    Map<String, Double> hairstyles; // Using Map instead of List for hairstyles with price
    Map<String, Double> hairdyecolors; // Using Map instead of List for hair dye colors with price

    //Argument-based constructor
    public HairSalon(Map<String, Double> hairstyles, Map<String, Double> hairdyecolors, double registration_fee, int phonenumber, String email, Manager manager, String opening_hour, String closing_hour,Employee employee) {
        super(registration_fee, phonenumber, email, manager, opening_hour, closing_hour,employee);
        this.hairstyles = new HashMap<>(hairstyles);//deepcopy
        this.hairdyecolors = new HashMap<>(hairdyecolors);//deepcopy
    }
    //default constructor
    public HairSalon() {
        super();
        hairstyles = new HashMap<>();
        hairdyecolors = new HashMap<>();
        hairstyles.put("Straight Haircut", 30.0);
        hairstyles.put("Layered Haircut", 40.0);
        hairstyles.put("Bob Cut", 35.0);
        hairdyecolors.put("Black", 10.0);
        hairdyecolors.put("Brown", 15.0);
        hairdyecolors.put("Blonde", 20.0);
    }
    //Copy constructor
    public HairSalon(HairSalon h) {
        super(h);
        this.hairstyles = new HashMap<>(h.hairstyles);//deepcopy
        this.hairdyecolors = new HashMap<>(h.hairdyecolors);//deepcopy
    }

    public void AddHairStyle(String hairStyle, double price){
        hairstyles.put(hairStyle, price);
    }

    public void RemoveHairStyle(String HairStyle){
        hairstyles.remove(HairStyle);
    }

    public void AddDyeColor(String hairdyecolor, double price){
        hairdyecolors.put(hairdyecolor, price);
    }

    public void RemoveDyeColor(String hairdyecolor){
        hairdyecolors.remove(hairdyecolor);
    }

    public void displayHairStyles1(){
        for(Map.Entry<String, Double> entry : hairstyles.entrySet()){
            System.out.println(entry.getKey() + " - Price: " + entry.getValue());
        }
    }

    public void displayHairDyeColors(){
        for(Map.Entry<String, Double> entry : hairdyecolors.entrySet()){
            System.out.println(entry.getKey() + " - Price: " + entry.getValue());
        }
    }
    public void displayHairStyles(VBox root) {
        for (Map.Entry<String, Double> entry : hairstyles.entrySet()) {
            Label label = new Label(entry.getKey() + " - Price: " + entry.getValue());
            root.getChildren().add(label);
        }
    }
    public void displayHairDyeColors(VBox root) {
        for (Map.Entry<String, Double> entry : hairdyecolors.entrySet()) {
            Label label = new Label(entry.getKey() + " - Price: " + entry.getValue());
            root.getChildren().add(label);
        }
    }
    public void Welcome()
    {
        System.out.println("Welcome to Alfred & Mina Hair Salon");
    }
    
}

