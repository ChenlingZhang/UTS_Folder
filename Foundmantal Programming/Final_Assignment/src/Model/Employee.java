package Model;

public class Employee extends Person{
    private String position;
    private String password;

    public Employee(int ID, String name, String email, String gender, String address, String position, String password) {
        super(ID, name, email, gender, address);
        this.position = position;
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
