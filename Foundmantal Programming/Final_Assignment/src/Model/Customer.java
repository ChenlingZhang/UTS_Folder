package Model;

public class Customer extends Person{
    private String phoneNumber;
    private String clubCard;
    private int group;
    private String arriveTime;

    public Customer(int ID, String name, String email, String gender, String address, String phoneNumber, String clubCard, int group, String arriveTime) {
        super(ID, name, email, gender, address);
        this.phoneNumber = phoneNumber;
        this.clubCard = clubCard;
        this.group = group;
        this.arriveTime = arriveTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClubCard() {
        return clubCard;
    }

    public void setClubCard(String clubCard) {
        this.clubCard = clubCard;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }
}
