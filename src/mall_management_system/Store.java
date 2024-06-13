package mall_management_system;
public abstract class Store {
    String Store_Name;
    String closing_hour;
    String opening_hour;
    Manager m;//Aggregation
    Employee e;//Aggregation

    //Default constructor
    public Store() {
        super();
        Store_Name="H&M";
        closing_hour="9 AM";
        opening_hour="11 PM";
        m = new Manager();//shallow copy
        e= new Employee();//shallow copy
    }
    
    //Argument-based Constructor
    public Store(String Store_Name, String closing_hour, String opening_hour, Manager m,Employee e) {
       
        this.Store_Name = Store_Name;
        this.closing_hour = closing_hour;
        this.opening_hour = opening_hour;
        this.m = m;//shallow copy
        this.e= e;//shallow copy

    }
    //Copy constructor
    public Store(Store otherStore) {
        this.Store_Name = otherStore.Store_Name;
        this.closing_hour = otherStore.closing_hour;
        this.opening_hour = otherStore.opening_hour;
        this.m = otherStore.m;//shallow copy
        this.e=otherStore.e;//shallow copy
    }
}
   
    