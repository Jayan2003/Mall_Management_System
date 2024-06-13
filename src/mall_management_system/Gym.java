package mall_management_system;
import java.util.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Gym extends Activity{
    List<String> classes;
    List<String> machines;

    //Default constructor
    public Gym() {
        super();
        classes=new ArrayList<>();
        machines=new ArrayList<>();
        classes.add("Yoga");
        classes.add("Pilates");
        classes.add("Spinning");
        classes.add("Zumba");

        machines.add("Treadmill");
        machines.add("Elliptical");
        machines.add("Stationary Bike");
        machines.add("Rowing Machine");
    }

    //Argument-based constructor
    public Gym(List<String> classes, List<String> machines, double registration_fee, int phonenumber, String email, Manager manager, String opening_hour, String closing_hour,Employee employee) {
        super(registration_fee, phonenumber, email, manager, opening_hour, closing_hour,employee);
        this.classes =new ArrayList<>(classes);//deepcopy
        this.machines = new ArrayList<>(machines);//deepcopy
    }


    //Copy constructor
    public Gym(Gym g) {
        super(g);
         this.classes =new ArrayList<>(g.classes);//deepcopy
        this.machines = new ArrayList<>(g.machines);//deepcopy
    }
    public void displayClasses(){
        for(String c:classes){
            System.out.println(c);
        }
    }
    public void displayMachines(){
        for(String m:machines){
            System.out.println(m);
        }
    }
    public void displayClasses(VBox root) {
        for (String c : classes) {
            Label label = new Label(c);
            root.getChildren().add(label);
        }
    }

    public void displayMachines(VBox root) {
        for (String m : machines) {
            Label label = new Label(m);
            root.getChildren().add(label);
        }
    }
    public void Welcome()
    {
        System.out.println("Welcome to Gold's Gym");
    }
} 

