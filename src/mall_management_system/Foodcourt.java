
package mall_management_system;
import java.util.*;
public class Foodcourt extends Restaurant {
   List<String> cuisines;

   //Argument-based constructor
    public Foodcourt(String rest_name, String rest_phone, String rest_email, Manager manager, String rest_openingHours, String rest_closingHours,Employee employee) {
        super(rest_name, rest_phone, rest_email, manager, rest_openingHours, rest_closingHours,employee);
        this.cuisines = cuisines;
    }

    //Default constructor 
    public Foodcourt() {
        super();
        this.cuisines = null; 
    }
    
    //Copy constructor
    public Foodcourt(Foodcourt f) {
        super(f);
        this.cuisines = f.cuisines; 
    }
   
}
