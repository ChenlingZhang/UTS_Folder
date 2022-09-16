package Model;
/**
 * @author ZaiYang Cui
 */
public class Employee extends Person{
    private String position;
    private String password;


    public Employee(int id, String name, String gender, String phoneNumber, String email, String address, String position, String password) {
        super(id,name, gender, phoneNumber, email, address);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
