import java.util.Scanner;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public double getArea() {
        return length * width;
    }

    public boolean isSimilar(Rectangle other) {
        return (this.length / this.width) == (other.length / other.width);
    }

    public static double[] readDimensions(Scanner scanner) {
        System.out.print("Введіть довжину: ");
        double length = scanner.nextDouble();
        while (length <= 0) {
            System.out.print("Невірне значення. Введіть додатнє число для довжини: ");
            length = scanner.nextDouble();
        }

        System.out.print("Введіть ширину: ");
        double width = scanner.nextDouble();
        while (width <= 0) {
            System.out.print("Невірне значення. Введіть додатнє число для ширини: ");
            width = scanner.nextDouble();
        }

        return new double[]{length, width};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] dimensions1 = readDimensions(scanner);
        Rectangle r1 = new Rectangle(dimensions1[0], dimensions1[1]);

        double[] dimensions2 = readDimensions(scanner);
        Rectangle r2 = new Rectangle(dimensions2[0], dimensions2[1]);

        System.out.println("Периметр прямокутника 1: " + r1.getPerimeter());
        System.out.println("Площа прямокутника 1: " + r1.getArea());

        System.out.println("Периметр прямокутника 2: " + r2.getPerimeter());
        System.out.println("Площа прямокутника 2: " + r2.getArea());

        if (r1.isSimilar(r2)) {
            System.out.println("Прямокутники подібні");
        } else {
            System.out.println("Прямокутники не є подібними");
        }
    }
}
