package Model;
/**
 * @author ZaiYang Cui
 */
public class PershiableProduct extends Product {
    public PershiableProduct(int ID, String productName, int productType, int minStock, int maxStock, int currentStock, String stage) {
        super(ID, productName, productType, minStock, maxStock, currentStock, stage);
    }
}
