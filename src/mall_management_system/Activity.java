package mall_management_system;

                                                                   
public abstract class Activity {
    double registration_fee;
    int phonenumber;
    String email;
    Manager manager;//Aggregation
    String opening_hour;
    String closing_hour;
    Employee employee;//Aggregation

    //Default constructor
    public Activity() {
        registration_fee=120.0;
        phonenumber=12233;
        email="activity@gmail.com";
        opening_hour="9 AM";
        closing_hour="12 AM";
        manager=new Manager();
        employee=new Employee();
    }

    public double getRegistration_fee() {
        return registration_fee;
    }

    public void setRegistration_fee(double registration_fee) {
        this.registration_fee = registration_fee;
    }
    

    //Argument-based constructor
    public Activity(double registration_fee, int phonenumber, String email, Manager manager, String opening_hour, String closing_hour,Employee employee) {
        this.registration_fee = registration_fee;
        this.phonenumber = phonenumber;
        this.email = email;
        this.manager = manager;//shallow copy
        this.opening_hour = opening_hour;
        this.closing_hour = closing_hour;
        this.employee=employee;//shallow copy
    }
    //Copy constructor
    public Activity(Activity a){
        registration_fee=a.registration_fee;
        phonenumber=a.phonenumber;
        email=a.email;
        manager=a.manager;//shallow copy
        opening_hour = opening_hour;
        closing_hour = closing_hour;
        employee=a.employee;//shallow copy
    }
    public abstract void Welcome();
}
