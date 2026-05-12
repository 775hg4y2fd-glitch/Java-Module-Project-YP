import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for (int i = 1; i <= 3; i++) {
            String name;
            while (true) {
                System.out.println("Введите название машины №" + i + ":");
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    break;
                }
                System.out.println("Название не может быть пустым");
            }
            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                if (!scanner.hasNextInt()) {
                    System.out.println("Неправильная скорость машины");
                    scanner.nextLine();
                    continue;
                }
                speed = scanner.nextInt();
                scanner.nextLine();
                if (speed > 0 && speed <= 250) {
                    break;
                }
                System.out.println("Неправильная скорость машины");
            }
            Tachka tachka = new Tachka (name, speed);
            race.calculateLeader(tachka);
        }
        System.out.println("Самая быстрая машина: " + race. leaderName);
        scanner.close();
    }
}

class Tachka {
    String name;
    int speed;
    public Tachka(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    String leaderName = "";
    int leaderDistance = 0;
    public void calculateLeader(Tachka tachka) {
        int distance = tachka.speed * 24;
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = tachka.name;
        }
    }
}