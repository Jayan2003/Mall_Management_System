
package mall_management_system;
import java.util.*;
public class Finedining extends Restaurant{
    int capacity;
    int rating;
    List<String> cuisines;

    //Argument-based constructor
    public Finedining(int capacity, int rating, List<String> cuisines, String rest_name, String rest_phone, String rest_email, Manager manager, String rest_openingHours, String rest_closingHours,Employee employee) {
        super(rest_name, rest_phone, rest_email, manager, rest_openingHours, rest_closingHours,employee);
        this.capacity = capacity;
        this.rating = rating;
        this.cuisines = cuisines;
    }

    //Default constructor
    public Finedining() {
        super();
        this.capacity =0;
        this.rating = 0;
        this.cuisines = null; 
    }

    //Copy constructor
    public Finedining(Finedining fd) {
        super(fd);
        this.capacity = fd.capacity;
        this.rating = fd.rating;
        this.cuisines =fd. cuisines;
    }
    
    
}
