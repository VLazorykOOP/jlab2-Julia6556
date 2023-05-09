import java.util.LinkedList; //є реалізацією інтерфейсу List, що забезпечує зв'язаний список об'єктів.
import java.util.Queue; //визначає спосіб організації черги елементів.
import java.util.Scanner; //введення даних з клавіатури.

public class QueueExample {
    //Оголошується приватний статичний об'єкт queue
    //буде використовуватися для зберігання елементів черги типу Integer.
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //буде використовуватися для введення даних з клавіатури.
        System.out.print("Введіть 4 цілих числа через пробіл для додавання до черги: ");
        String input = scanner.nextLine(); //для отримання рядка введеного користувачем з клавіатури.
        String[] nums = input.split(" ");//розділяється на масив рядків nums пробілом

        for (String num : nums) {
            //елементи масиву nums перетворюються з рядкового типу на тип Integer
            //додаються до черги queue за допомогою методу offer().
            queue.offer(Integer.parseInt(num));
        }

        int choice = 0;

        do {
            System.out.println("1. Додати елемент до черги");
            System.out.println("2. Вилучити елемент з черги");
            System.out.println("3. Знайти елемент у черзі");
            System.out.println("4. Переглянути чергу");
            System.out.println("5. Вийти");
            System.out.print("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть ціле число для додавання до черги: ");
                    int num = scanner.nextInt();
                    enqueue(num);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    System.out.print("Введіть ціле число, яке потрібно знайти: ");
                    int searchNum = scanner.nextInt();
                    search(searchNum);
                    break;
                case 4:
                    printQueue();
                    break;
                case 5:
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Введено неправильну опцію, спробуйте ще раз.");
                    break;
            }

        } while (choice != 5);//Виконується цикл do-while, доки користувач не вибере опцію "Вийти" (5).

        scanner.close();

    }

    private static void enqueue(int num) {
        //приймає ціле число num в якості параметру та додає його до черги queue
        queue.offer(num);
        System.out.println(num + " було додано до черги.");
    }

    private static void dequeue() {
        //видаляє елемент з черги
        if (queue.isEmpty()) {
            System.out.println("Черга порожня, немає елементів для вилучення.");
        } else {
            int num = queue.poll();
            System.out.println(num + " було вилучено з черги.");
        }
    }

    private static void search(int searchNum) {
        //шукає ціле число в черзі
        if (queue.isEmpty()) {
            System.out.println("Черга порожня, елемент не знайдено.");
        } else {
            Object[] queueArray = queue.toArray();
            for (int i = 0; i < queueArray.length; i++) {
                if (queueArray[i].equals(searchNum)) {
                    System.out.println(searchNum + " знайдено у черзі на позиції " + (i+1));
                    return;
                }
            }
            System.out.println(searchNum + " не знайдено у черзі.");
        }
    }

    private static void printQueue() {
        // виводить всі елементи черги
        if (queue.isEmpty()) {
            System.out.println("Черга порожня.");
        } else {
            System.out.println("Елементи у черзі:");
            for (int num : queue) {
                System.out.println(num);
            }
        }
    }
}
