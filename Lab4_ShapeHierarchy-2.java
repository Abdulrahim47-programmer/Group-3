
/**
 * Write a description of class shape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class Shape {
    private String color;
    private boolean filled;

    // Default constructor
    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    // Parameterized constructor
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getters and setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // toString method
    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}


class Circle extends Shape {
    private double radius;

    // Default constructor
    public Circle() {
        super(); // calls Shape() default
        this.radius = 1.0;
    }

    // Constructor with radius only
    public Circle(double radius) {
        super(); // default color and filled
        this.radius = radius;
    }

    // Constructor with all attributes
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // Getter and setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Area and perimeter
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // toString override
    @Override
    public String toString() {
        return "Circle[" + super.toString() + ", radius=" + radius + "]";
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    // Default constructor
    public Rectangle() {
        super();
        this.width = 1.0;
        this.length = 1.0;
    }

    // Constructor with width and length only
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    // Constructor with all attributes
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    // Getters and setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Area and perimeter
    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    // toString override
    @Override
    public String toString() {
        return "Rectangle[" + super.toString() + ", width=" + width + ", length=" + length + "]";
    }
}


class Square extends Rectangle {

    // Default constructor
    public Square() {
        super(); // width = length = 1.0
    }

    // Constructor with side only
    public Square(double side) {
        super(side, side); // calls Rectangle(width, length)
    }

    // Constructor with all attributes
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    // getSide returns width (which equals length)
    public double getSide() {
        return getWidth();
    }

    // setSide sets both width and length
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    // Override setWidth to maintain square invariant
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    // Override setLength to maintain square invariant
    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    // toString override
    @Override
    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}


public class Lab4_ShapeHierarchy {
    public static void main(String[] args) {
        

        //Creating Shape Objects

        Shape s1 = new Shape("yellow", false);
        System.out.println(s1);

        Circle c1 = new Circle(5.0, "blue", true);
        System.out.println(c1);
        System.out.println("  Area: " + c1.getArea());
        System.out.println("  Perimeter: " + c1.getPerimeter());

        Rectangle r1 = new Rectangle(4.0, 6.0, "green", true);
        System.out.println(r1);
        System.out.println("  Area: " + r1.getArea());
        System.out.println("  Perimeter: " + r1.getPerimeter());

        Square sq1 = new Square(5.0, "orange", false);
        System.out.println(sq1);
        System.out.println("  Area: " + sq1.getArea());
        System.out.println("  Perimeter: " + sq1.getPerimeter());

        // Square Invariant 
    

        Square sq2 = new Square(3.0);
        System.out.println("Initial: " + sq2);
        System.out.println("Width: " + sq2.getWidth() + ", Length: " + sq2.getLength());

        sq2.setWidth(7.0);
        System.out.println("\nAfter setWidth(7.0):");
        System.out.println("Width: " + sq2.getWidth() + ", Length: " + sq2.getLength());
        System.out.println("Both should be 7.0!");

        sq2.setLength(9.0);
        System.out.println("\nAfter setLength(9.0):");
        System.out.println("Width: " + sq2.getWidth() + ", Length: " + sq2.getLength());
        System.out.println("Both should be 9.0!");

        // Section 3: Polymorphism 
        

        Shape[] shapes = {
            new Circle(3.0, "red", true),
            new Rectangle(4.0, 5.0, "blue", false),
            new Square(6.0, "green", true),
            new Circle(7.0, "purple", true),
            new Rectangle(2.0, 8.0, "yellow", false)
        };

        double totalArea = 0;
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println("  -> Circle area: " + c.getArea());
                totalArea += c.getArea();
            } else if (shape instanceof Square) {
                
                Square sq = (Square) shape;
                System.out.println("  -> Square area: " + sq.getArea() + " (side=" + sq.getSide() + ")");
                totalArea += sq.getArea();
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                System.out.println("  -> Rectangle area: " + r.getArea());
                totalArea += r.getArea();
            }
        }
        System.out.println("\nTotal area of all shapes: " + totalArea);

        // Inheritance Chain
        System.out.println("\n--- Section 4: Inheritance Chain ---");

        Square sq3 = new Square(4.0, "cyan", true);
        System.out.println("sq3 instanceof Square:    " + (sq3 instanceof Square));
        System.out.println("sq3 instanceof Rectangle: " + (sq3 instanceof Rectangle));
        System.out.println("sq3 instanceof Shape:     " + (sq3 instanceof Shape));
        System.out.println("sq3 instanceof Object:    " + (sq3 instanceof Object));


        Rectangle r2 = sq3;      
        Shape s2 = sq3;         
        Object o = sq3;        
        System.out.println("\nAll upcasts work! Square -> Rectangle -> Shape -> Object");

        System.out.println("  End");
    
    }
}
