import java.util.Date;
public class Main {

public static void main(String[] args){

int id = 1;
String name = "John";
Date registered = new Date();
User user = new User(id, name, registered);
System.out.println(user.getId());
System.out.println(user.getName());
System.out.println(user.getRegisteredDate());
}
}