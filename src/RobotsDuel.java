import java.util.Random;
import java.util.Scanner;

public class RobotsDuel {
    private int healthRobot = 100;
    private String nameRobot;
    private String getShootRandomAlf = "QWEASDZXC";

    public RobotsDuel(String nameRobot) { //конструктор
        this.nameRobot = nameRobot;
        setGetShootRandomAlf(KillerLettersForRobot(getShootRandomAlf));
        setHelthRobot(healthRobot);
    }

    public String getGetShootRandomAlf() {
        return this.getShootRandomAlf;
    }

    public void setGetShootRandomAlf(String getShootRandomAlf) { //метод для вибору вбивчих кнопок
        this.getShootRandomAlf = getShootRandomAlf;
    }

    public int getHealthRobot() {
        return healthRobot;
    }

    public int setHelthRobot(int healthRobot) { //метод для віднімання здоров'я
        this.healthRobot = healthRobot;
        return healthRobot;
    }

    public String getNameRobot() { //метод для отримання імені робота
        return nameRobot;
    }



    private static String KillerLettersForRobot(String getShootRandomAlf) { //метод для вибору вбивчих кнопок
        String alphabet = getShootRandomAlf; //вбивчі кнопки
        String alShoot = "";
        for (int i = 0; i < 5; i++) {
            int randIdx = new Random().nextInt(alphabet.length()); //рандомний вибір літери
            char randChar = alphabet.charAt(randIdx);
            alphabet = alphabet.replace(String.valueOf(randChar), "");
            alShoot = alShoot + randChar;
        }
        return alShoot;
    }

    public void ShotCheck(char args) { //метод для перевірки чи влучив
        String args1 = "" + args; //перетворюємо char в String
        int indexM = this.getGetShootRandomAlf().indexOf(args1); // Пошук символу у списку вбивчих кнопок
        if (indexM == -1) { //якщо не влучив
            System.out.println(" Промазав, перехід ходу");

        } else {
            System.out.println("Вітаю! Влучив, перехід ходу");
            this.setGetShootRandomAlf(this.getGetShootRandomAlf().replace(args1, "")); // деактивуємо вбивчу кнопку
            this.setHelthRobot(this.getHealthRobot() - 20); //віднімаємо здоров'я

        }
    }

    public static String getInfoFromDisplay() { // зчитування з дісплею
       Scanner scanner = new Scanner(System.in);
       return scanner.next();
    }
}

