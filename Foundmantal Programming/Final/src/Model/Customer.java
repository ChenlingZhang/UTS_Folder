package Model;
/**
 * @author ZaiYang Cui
 */
public class Customer extends Person{
    private String card;
    private String password;
    private String arrivintTime;
    private String group;

    public Customer(int id, String name, String gender, String phoneNumber, String email, String address, String password, String arrivintTime, String group, String card) {
        super(id, name, gender, phoneNumber, email, address);
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getArrivintTime() {
        return arrivintTime;
    }

    public void setArrivintTime(String arrivintTime) {
        this.arrivintTime = arrivintTime;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
