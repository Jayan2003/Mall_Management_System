package mall_management_system;
public class Employee {
    String name;
    int age;
    double salary;

    //Argument-based Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
   
    //Default Constructor
    Employee(){
        name="Alex";
        age=32;
        salary=30000;
    }
   
    //Copy constructor
    Employee(Employee e){
        name=e.name;
        age=e.age;
        salary=e.salary;
    }
   
}