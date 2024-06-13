package mall_management_system;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MagicPlanet extends Activity{
    int numberofgames;
    String game_name;
    boolean prizes_available;
    

    //Default constructor
    public MagicPlanet() {
        numberofgames=10;
        game_name="Trampoline";
        prizes_available=true;
    }

    //Argument-based constructor
    public MagicPlanet(int numberofgames, String game_name, boolean prizes_available, double registration_fee, int phonenumber, String email, Manager manager, String opening_hour, String closing_hour,Employee employee) {
        super(registration_fee, phonenumber, email, manager, opening_hour, closing_hour,employee);
        this.numberofgames = numberofgames;
        this.game_name = game_name;
        this.prizes_available = prizes_available;
    }
    //Copy Constructor
    public MagicPlanet(MagicPlanet m) {
        super(m);
        numberofgames=m.numberofgames;
        game_name=m.game_name;
        prizes_available=m.prizes_available;
    }
    public String toString(){
        return "game name is "+ game_name+"\nnumber of games is " +numberofgames+"\nprizes "+prizes_available;
    }
    public void displayRides(VBox root) {
        // Implement the logic to display rides
        
        Label rideLabel1 = new Label("Roller Coaster");
        Label rideLabel2 = new Label("Ferris Wheel");
        Label rideLabel3= new Label("Trampoline");
        root.getChildren().addAll(rideLabel1, rideLabel2,rideLabel3);
    }
    public void Welcome()
    {
        System.out.println("Welcome to Magic Planet");
    }

    
}
