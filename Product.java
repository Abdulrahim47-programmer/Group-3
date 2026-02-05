
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;

    public Product() {
        this.reorderLevel = 10;
    }

    public Product(String productCode, String productName, String category,double unitPrice, int quantityInStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        setUnitPrice(unitPrice);
        setQuantityInStock(quantityInStock);
        this.reorderLevel = 10;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice > 0) {
            this.unitPrice = unitPrice;
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        }
    }

    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel > 0) {
            this.reorderLevel = reorderLevel;
        }
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            quantityInStock += quantity;
        }
    }

    public boolean sellProduct(int quantity) {
        if (quantity > 0 && quantity <= quantityInStock) {
            quantityInStock -= quantity;
            return true;
        }
        return false;
    }

    public double calculateStockValue() {
        return unitPrice * quantityInStock;
    }

    public boolean needsReorder() {
        return quantityInStock <= reorderLevel;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage < 100) {
            unitPrice -= unitPrice * (percentage / 100);
        }
    }

    public void displayProductInfo() {
        System.out.println("Product Code: " + productCode);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity In Stock: " + quantityInStock);
        System.out.println("Reorder Level: " + reorderLevel);
        System.out.println("Stock Value: " + calculateStockValue());
        System.out.println("Needs Reorder: " + needsReorder());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {

        System.out.println("=== Product Inventory Exercise ===\n");

         product1 =("PRD001", "Laptop", "Electronics", 1500000, 25);

         product2 =("PRD002", "Office Chair", "Furniture", 350000, 8);

         product3 =("PRD003", "Notebook", "Stationery", 5000, 100);

        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();

        product1.sellProduct(20);

        System.out.println("Office Chair needs reorder: " + product2.needsReorder());

        product2.addStock(50);

        product3.applyDiscount(15);
        
        System.out.println("\n=== Final Product Details ===\n");
        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();

        System.out.println("\n=== Exercise Complete ===");
    }
}
