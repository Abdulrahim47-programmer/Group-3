
/**
 * Write a description of class MobilePhone here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MobilePhone
{
    private String brand;
    private String model;
    private double price;
    private int batteryLevel; 
    private boolean isOn;

    public MobilePhone() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.price = 0;
        this.batteryLevel = 100;
        this.isOn = false;
    }

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        setPrice(price);
        this.batteryLevel = 100;
        this.isOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        }
    }

    public void turnOn() {
        if (batteryLevel > 0) {
            isOn = true;
        }
    }

    public void turnOff() {
        isOn = false;
    }

    public void makeCall(String contactName) {
        if (isOn && batteryLevel >= 5) {
            System.out.println("Calling " + contactName + "...");
            batteryLevel -= 5;
        } else {
            System.out.println("Cannot make call. Phone is off or battery too low.");
        }
    }

    public void chargeBattery(int minutes) {
        if (minutes > 0) {
            batteryLevel += minutes * 2;
            if (batteryLevel > 100) {
                batteryLevel = 100;
            }
        }
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Phone On: " + isOn);
        System.out.println("-----------------------------");
    }
    public static void main(String[] args) {

        MobilePhone phone1 = new MobilePhone();
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S24", 250000000);

        phone1.displayInfo();
        phone2.displayInfo();

        phone2.turnOn();
        phone2.makeCall("");
        phone2.chargeBattery(10);

        phone2.displayInfo();
    }
}




