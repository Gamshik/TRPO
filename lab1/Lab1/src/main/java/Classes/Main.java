package Classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Главный метод
     * @param args
     */
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // Создание водителей
        Driver driver1 = new Driver("Иванов Иван Иванович", 6);
        Driver driver2 = new Driver("Петров Петр Петрович", 4);

        // Создание двигателей
        Engine engine1 = new Engine(200, "СССР");
        Engine engine2 = new Engine(150, "Toyota");

        // Создание автомобилей и добавление их в список
        cars.add(new Car("Жигули", "Седан", driver1, 1200, engine1));
        cars.add(new Car("Toyota Corolla", "Седан", driver2, 1100, engine2));

        // Вывести водителей со стажем более 5 лет
        for (Car car : cars) {
            if (car.CarDriver.Experiense > 5) {
                System.out.println(car.CarDriver.FIO);
            }
        }

        // Вывести автомобили советского производства
        for (Car car : cars) {
            if (car.Motor.Manufacturer.equals("СССР")) {
                System.out.println(car.Brand);
            }
        }
    }
}
