
package mall_management_system;
import javax.swing.JOptionPane;
import java.util.*;
public class Restaurant {
   
     String rest_name;
     String rest_phone;
     String rest_email;
     Manager manager;//Aggregation
     String rest_openingHours;
     String rest_closingHours;
     String dishName;
     Map<String, Double> menu;
     List<String> orders;
     Employee employee;//Aggregation

    //argument-based Constructor
    public Restaurant(String rest_name, String rest_phone, String rest_email, Manager manager, String rest_openingHours, String rest_closingHours,Employee employee ) {
        this.rest_name = rest_name;
        this.rest_phone = rest_phone;
        this.rest_email = rest_email;
        this.manager = manager;//shallow copy
        this.rest_openingHours = rest_openingHours;
        this.rest_closingHours = rest_closingHours;
        this.orders = new ArrayList<>(); 
        this.employee=employee;//shallow copy
        this.menu = new HashMap<>();
        // Assign default menu values
        this.menu.put("Burger", 10.0);
        this.menu.put("Pizza", 12.0);
        this.menu.put("Salad", 8.0);
        this.menu.put("Pasta", 15.0);
        this.menu.put("Sandwich", 7.0);
        
       
    }

    //Default Constructor
    public Restaurant() {
        this.rest_name = "default";
        this.rest_phone = "default";
        this.rest_email = "default";
        manager=new Manager();
        this.rest_openingHours = "default";
        this.rest_closingHours = "default";
        this.orders = new ArrayList<>();
        employee=new Employee();
        this.menu = new HashMap<>();
        // Assign default menu values
        this.menu.put("Burger", 10.0);
        this.menu.put("Pizza", 12.0);
        this.menu.put("Salad", 8.0);
        this.menu.put("Pasta", 15.0);
        this.menu.put("Sandwich", 7.0);
       
    }
    //Copy Constructor
    public Restaurant(Restaurant r)
    {
        this.rest_name = r.rest_name;
        this.rest_phone = r.rest_phone;
        this.rest_email = r.rest_email;
        this.manager = r.manager;//shallow copy
        this.rest_openingHours =r.rest_openingHours;
        this.rest_closingHours = r.rest_closingHours;
        this.menu = new HashMap<>(r.menu);//deep copy
        this.orders = new ArrayList<>(r.orders);//deep copy
        this.employee=r.employee;//shallow copy
        
    }
     // Method to add a dish to the menu
    public void addDishToMenu(String dishName, double price) {
        menu.put(dishName, price);
        System.out.println("Dish '" + dishName + "' added to menu with price $" + price + ".");
    }

    // Method to remove a dish from the menu
    public void removeDishFromMenu(String dishName) {
        if (menu.containsKey(dishName)) 
        {
            menu.remove(dishName);
            System.out.println("Dish '" + dishName + "' removed from the menu.");
        } else {
            System.out.println("Dish '" + dishName + "' not found in the menu.");
        }
    }
    
       public void takeOrderFromUser() {
        String dishName = JOptionPane.showInputDialog(null, "Enter your order (dish name):");
        if (menu.containsKey(dishName)) {
            double price = menu.get(dishName);
            addOrders("Order: " + dishName + " ($" + price + ")");
            JOptionPane.showMessageDialog(null, "Order successfully placed: " + dishName + "\nBill: $" + price);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, the dish '" + dishName + "' is not available.");
        }
    }
        public void addOrders(String order) {
        orders.add(order);
        System.out.println("Order added: " + order);
    }
    
     public Map<String, Double> getMenu() {
        return this.menu;
    }
}
  
    


   
