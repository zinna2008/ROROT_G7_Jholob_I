import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) { // метод гри

        System.out.println("Ласкаво просимо до гри \\\"Robot duel\\\"!"); //вітання
        ArrayList<RobotsDuel> listOfRobots = new ArrayList(); //створюємо список з двох роботів
        for (int i = 0; i < 2; i++) {
            System.out.println("Введіть ім'я робота " + (i + 1) + ":");
            String nameRb = RobotsDuel.getInfoFromDisplay();// Отримуємо ім'я робота з консолі
            listOfRobots.add(new RobotsDuel(nameRb));// Додаємо нового робота до списку
            System.out.println("Ім'я робота " + (i + 1) + " - " + listOfRobots.get(i).getNameRobot());
            System.out.println("Здоров'я робота " +  listOfRobots.get(i).getNameRobot()  + " - " + listOfRobots.get(i).getHealthRobot());
            System.out.println("______________________");

        }
        boolean gameActive = true; // Додала змінну, яка вказує на активність гри
        String allowedLetters = "QWEASDZXCPL";

        System.out.println("Початок гри");

        do {
            for (int i = 0; i < listOfRobots.size(); i++) {
                System.out.println(("Стріляють по роботу " + (i + 1) + " " + listOfRobots.get(i).getNameRobot()));
                System.out.println("Для пострілу введіть одну з літер : Q, W, E, A, S, D, Z, X, C  або  P  для виходу з гри: ");
                 char letter;
                while (true) { // Перевіряємо чи введена літер зі списку дозволених до тих пір, поки не буде введена граюча літера
                    String shots = RobotsDuel.getInfoFromDisplay().toUpperCase(Locale.ROOT);// зчитуємо введений рядок і переводимо його в верхній регістр
                    letter = shots.charAt(0); // беремо перший символ з введеного рядка

                    if (!allowedLetters.contains(shots)) { // якщо нема в списку дозволених літер
                        System.out.println("Літера не активна. Оберіть літеру зі списку: Q,W,E,A,S,D,Z,X,C  або  P  для виходу з гри:");
                    } else {
                        break;
                    }
                }

                if (letter == 'P') {
                    System.out.println("Кінець гри. До побачення!");
                    gameActive = false; // Змінюю стан гри на неактивний
                    break;
                }

                listOfRobots.get(i).ShotCheck(letter);// Перевіряємо чи влучив робот
                if (listOfRobots.get(i).getHealthRobot() <= 0) { // Перевіряєю чи не закінчилось  здоров'я робота
                    System.out.println("Не пощастило роботу " + listOfRobots.get(i).getNameRobot() + " " + "здоров'я" + " " +  listOfRobots.get(i).getHealthRobot());
                    listOfRobots.remove(i);
                    System.out.println("Переміг робот " + listOfRobots.get(0).getNameRobot() + " " + "здоров'я" + " " + listOfRobots.get(0).getHealthRobot());
                    break;
                }
            }

            if (listOfRobots.size() > 1 && gameActive) { // Перевіряєю чи є більше одного робота та чи гра активна (щоб не виводити здоров'я роботів, якщо натиснули P)
                System.out.println("______________________");
                System.out.println("Медогляд роботів:"); // виводимо здоров'я роботів
                System.out.println("Здоров'я робота 1 " + listOfRobots.get(0).getNameRobot() + " = " + listOfRobots.get(0).getHealthRobot());
                System.out.println("Здоров'я робота 2 " + listOfRobots.get(1).getNameRobot() + " = " + listOfRobots.get(1).getHealthRobot());
                System.out.println("______________________");
            }
        } while (listOfRobots.size() > 1 && gameActive); // Гра продовжується, доки є більше одного робота та гра активна
    }
}
