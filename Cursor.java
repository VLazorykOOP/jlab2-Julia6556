import java.util.Scanner;

public class Cursor {
    private int x; // координата x
    private int y; // координата y
    private int size; // розмір курсору
    private boolean visible; // видимість курсору

    // конструктор
    public Cursor(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.visible = true; // курсор за замовчуванням видимий
    }

    // переміщення курсору
    public void moveCursor(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    // зміна розміру курсору
    public void changeSize(int newSize) {
        this.size = newSize;
    }

    // приховання курсору
    public void hideCursor() {
        this.visible = false;
    }

    // показ курсору
    public void showCursor() {
        this.visible = true;
    }

    // отримання координати x
    public int getX() {
        return this.x;
    }

    // отримання координати y
    public int getY() {
        return this.y;
    }

    // відображення курсору
    public void displayCursor() {
        if (this.visible) {
            System.out.println("Курсор розміру " + this.size + " знаходиться на координатах (" + this.x + ", " + this.y + ")");
        } else {
            System.out.println("Курсор схований.");
        }
    }

    // головний метод
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Створюємо курсор...");
        System.out.print("Введіть початкову координату x: ");
        int x = scanner.nextInt();
        System.out.print("Введіть початкову координату y: ");
        int y = scanner.nextInt();
        System.out.print("Введіть розмір курсору: ");
        int size = scanner.nextInt();

        Cursor cursor = new Cursor(x, y, size);
        cursor.displayCursor();

        while (true) {
            // меню
            System.out.println("\nМЕНЮ:");
            System.out.println("1 - Змінити координати курсору");
            System.out.println("2 - Змінити розмір курсору");
            System.out.println("3 - Перемістити курсор");
            System.out.println("4 - Приховати курсор");
            System.out.println("5 - Відновити курсор");
            System.out.println("6 - Завершити роботу програми");
            System.out.print("\nВведіть номер пункту меню: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // зчитування нових координат з консолі
                    System.out.print("Введіть нову координату x: ");
                    int newX = scanner.nextInt();
                    System.out.print("Введіть нову координату y: ");
                    int newY = scanner.nextInt();
                    // переміщення курсору на нові координати
                    cursor.moveCursor(newX, newY);
                    // відображення курсору з новими координатами
                    cursor.displayCursor();
                    break;
                case 2:
                    // зміна розміру курсору
                    System.out.print("Введіть новий розмір курсору: ");
                    int newSize = scanner.nextInt();
                    cursor.changeSize(newSize);
                    cursor.displayCursor();
                    break;
                case 3:
                    // переміщення курсору
                    System.out.print("Введіть зміщення по координаті x: ");
                    int deltaX = scanner.nextInt();
                    System.out.print("Введіть зміщення по координаті y: ");
                    int deltaY = scanner.nextInt();
                    // обчислення нових координат
                    int movedX = cursor.getX() + deltaX;
                    int movedY = cursor.getY() + deltaY;
                    // переміщення курсору на нові координати
                    cursor.moveCursor(movedX, movedY);
                    // відображення курсору з новими координатами
                    cursor.displayCursor();
                    break;
                case 4:
                    // приховання курсору
                    cursor.hideCursor();
                    cursor.displayCursor();
                    break;
                case 5:
                    // відображення курсору
                    cursor.showCursor();
                    cursor.displayCursor();
                    break;
                case 6:
                    // завершення роботи програми
                    System.out.println("Робота програми завершена.");
                    return;
                default:
                    // невірний ввід
                    System.out.println("Неправильний ввід. Спробуйте ще раз.");
            }
        }
    }
}
