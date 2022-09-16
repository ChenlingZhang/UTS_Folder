package Model;
/**
 * @author ZaiYang Cui
 */
public class Menu {
    private String name;
    private float price;
    private String avaliable;

    public Menu(String name, float price, String avaliable) {
        this.name = name;
        this.price = price;
        this.avaliable = avaliable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
}
