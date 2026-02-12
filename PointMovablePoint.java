
/**
 * Write a description of class Point here.
 *
 * @author (Nassra Hassan)
 * @version (24BIA014)
 */
class Point
{
    private double x = 0.0;
    private double y = 0.0;
    
        // Default constructor 
    public Point() { 
        this.x = 0.0; 
        this.y = 0.0; 
    } 
    
        // Parameterized constructor 
    public Point(double x, double y) { 
        this.x = x; 
        this.y = y; 
    } 
    
    // Getters and setters 
    public double getX() { 
        return x; 
    } 
 
    public void setX(double x) { 
        this.x = x; 
    } 
 
    public double getY() { 
        return y; 
    } 
 
    public void setY(double y) { 
        this.y = y; 
    } 
 
    // Set both x and y 
    public void setXY(double x, double y) { 
        this.x = x; 
        this.y = y; 
    } 
 
    // Get both x and y 
    public double[] getXY() { 
        return new double[]{x, y}; 
    } 
    // toString 
    @Override 
    public String toString() { 
        return "(" + x + ", " + y + ")"; 
    } 
} 
class MovablePoint extends Point { 
    private double xSpeed = 0.0; 
    private double ySpeed = 0.0; 
 
    // Default constructor 
    public MovablePoint() { 
        super(); 
    } 
 
    // Constructor with speed 
    public MovablePoint(double xSpeed, double ySpeed) { 
        super(); 
        this.xSpeed = xSpeed; 
        this.ySpeed = ySpeed; 
    } 
    // Constructor with position and speed 
    public MovablePoint(double x, double y, double xSpeed, double ySpeed) { 
        super(x, y); 
        this.xSpeed = xSpeed; 
        this.ySpeed = ySpeed; 
    } 
    // Getters and setters 
    public double getXSpeed() { 
        return xSpeed; 
    } 
 
    public void setXSpeed(double xSpeed) { 
        this.xSpeed = xSpeed; 
    } 
 
    public double getYSpeed() { 
        return ySpeed; 
    } 
 
    public void setYSpeed(double ySpeed) { 
        this.ySpeed = ySpeed; 
    } 
public void setSpeed(double xSpeed, double ySpeed) { 
        this.xSpeed = xSpeed; 
        this.ySpeed = ySpeed; 
    } 
 
    public double[] getSpeed() { 
        return new double[]{xSpeed, ySpeed}; 
    } 
 
    // Move method 
    public MovablePoint move() { 
        setX(getX() + xSpeed); 
        setY(getY() + ySpeed); 
        return this; 
    } 
 
    // Override toString 
    @Override 
    public String toString() { 
        return "(" + getX() + ", " + getY() + ") speed=(" + xSpeed + ", " + ySpeed + ")"; 
    } 
} 
 public class PointMovablePoint { 
    public static void main(String[] args) { 
 
        System.out.println("===="); 
        System.out.println("  Point and Movable Point"); 
        System.out.println("===\n"); 
 
        // Point Objects 
        System.out.println(" Point Objects "); 
 
        Point p1 = new Point(); 
        System.out.println("Default point: " + p1); 
 
        Point p2 = new Point(3.0, 4.0); 
        System.out.println("Point at (3, 4): " + p2); 
 
        p2.setX(5.0); 
        p2.setY(6.0); 
        System.out.println("After setX(5), setY(6): " + p2); 
 
        double[] coords = p2.getXY(); 
        System.out.println("getXY() = [" + coords[0] + ", " + coords[1] + "]"); 
                // Movable Point Objects 
        System.out.println("\n--- Section 2: MovablePoint Objects ---"); 
 
        MovablePoint mp1 = new MovablePoint(0.0, 0.0, 2.0, 3.0); 
        System.out.println("Initial position: " + mp1); 
 
        System.out.println("X coordinate: " + mp1.getX()); 
        System.out.println("Y coordinate: " + mp1.getY()); 
 
        // Movement 
        System.out.println("\n--- Section 3: Movement ---"); 
 
        System.out.println("Before move: " + mp1); 
        mp1.move(); 
        System.out.println("After 1st move: " + mp1); 
        mp1.move(); 
        System.out.println("After 2nd move: " + mp1); 
        mp1.move(); 
        System.out.println("After 3rd move: " + mp1); 
 
        mp1.setSpeed(1.0, -1.0); 
        System.out.println("\nSpeed changed to (1.0, -1.0)"); 
        mp1.move(); 
        System.out.println("After move: " + mp1); 
        mp1.move(); 
        System.out.println("After move: " + mp1); 
 
        //: Polymorphism 
        System.out.println("\n--- Section 4: Polymorphism ---"); 
 
        Point p3 = new MovablePoint(1.0, 1.0, 0.5, 0.5); 
        System.out.println("p3 (Point ref): " + p3); 
        System.out.println("p3 class: " + p3.getClass().getSimpleName()); 
 
        // p3. Point has no move() 
 
        if (p3 instanceof MovablePoint) { 
            MovablePoint mp2 = (MovablePoint) p3; 
            mp2.move(); 
            System.out.println("After downcast and move: " + mp2); 
            System.out.println("p3 also changed: " + p3); 
        } 
                //Simulation 
        System.out.println("\n--- Section 5: Simple Movement Simulation ---"); 
 
        MovablePoint[] points = { 
            new MovablePoint(0.0, 0.0, 1.0, 1.0), 
            new MovablePoint(10.0, 0.0, -1.0, 0.5), 
            new MovablePoint(5.0, 5.0, 0.0, -2.0) 
        }; 
 
        System.out.println("Starting positions:"); 
        for (int i = 0; i < points.length; i++) { 
            System.out.println("  Point " + (i + 1) + ": " + points[i]); 
        } 
 
        for (int step = 1; step <= 5; step++) { 
            System.out.println("\nStep " + step + ":"); 
            for (int i = 0; i < points.length; i++) { 
                points[i].move(); 
                System.out.println("  Point " + (i + 1) + ": " + points[i]); 
            } 
        } 
                System.out.println("\n==="); 
        System.out.println("  End of Lab 3"); 
        System.out.println("==="); 
    } 
} 


 

 

 


 

 



    
    