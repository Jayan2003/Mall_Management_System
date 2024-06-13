package mall_management_system;
public class Manager {
    String name;
    int age;
    double salary;
    String position;
   
    //Default constructor
    Manager(){
        name="John";
        age=20;
        salary=20000;
        position="Ceo";
    }
    
    //Argument-Based constructor
    public Manager(String name, int age, double salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }
   
    //Copy constructor
    Manager(Manager m){
        name=m.name;
        age=m.age;
        salary=m.age;
    }
   
   
   
}