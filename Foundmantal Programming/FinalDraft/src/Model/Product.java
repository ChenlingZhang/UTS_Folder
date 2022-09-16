package Model;
/**
 * @author ZaiYang Cui
 */
public class Product {
    private int ID;
    private String productName;
    private int productType;
    private int minStock;
    private int maxStock;
    private int currentStock;
    private String stage;

    public Product(int ID, String productName, int productType, int minStock, int maxStock, int currentStock, String stage) {
        this.ID = ID;
        this.productName = productName;
        this.productType = productType;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.currentStock = currentStock;
        this.stage = stage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
