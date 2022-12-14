package Model;

public class Person {
    private int ID;
    private String name;
    private String email;
    private String gender;
    private String address;



    public Person(int ID, String name, String email, String gender, String address) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
