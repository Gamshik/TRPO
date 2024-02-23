package Classes;

import Classes.Repositories.CarRepository;
import Classes.Repositories.DriverRepository;
import Classes.Repositories.EngineRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Главны                                                          й метод
     * @param args
     */
    public static void main(String[] args) {
        DriverRepository driverRepository = new DriverRepository();
        EngineRepository engineRepository = new EngineRepository();
        CarRepository carRepository = new CarRepository();

        Driver driver;
        Engine engine;
        Car car;

        ArrayList<Driver> drivers;
        ArrayList<Engine> engines;
        ArrayList<Car> cars;

        Scanner scanner = new Scanner(System.in);
        int choice, id;

        do {
            System.out.println("\nМеню репозитория водителей:");
            System.out.println("1. Добавить нового водителя");
            System.out.println("2. Просмотреть список всех водителей");
            System.out.println("3. Обновить информацию о водителе");
            System.out.println("4. Удалить водителя по ID");
            System.out.println("5. Добавить новый двигатель");
            System.out.println("6. Просмотреть список всех двигателей");
            System.out.println("7. Обновить информацию о двигателе");
            System.out.println("8. Удалить двигатель по ID");
            System.out.println("9. Добавить новую машину");
            System.out.println("10. Просмотреть список всех машин");
            System.out.println("11. Обновить информацию о машине");
            System.out.println("12. Удалить машину по ID");
            System.out.println("0. Выход");

            System.out.print("Введите номер операции: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    driver = GetDriver();
                    driverRepository.CreateDriver(driver);
                    System.out.println("Водитель успешно добавлен!");
                    break;
                case 2:
                    drivers = driverRepository.GetAllDrivers();
                    displayAllDrivers(drivers);
                    break;
                case 3:
                    System.out.print("Введите ID водителя для обновления: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Сброс символа новой строки
                    driver = GetDriver();
                    driverRepository.UpdateDriverById(id, driver);
                    break;
                case 4:
                    System.out.print("Введите ID водителя для удаления: ");
                    id = scanner.nextInt();
                    driverRepository.DeleteDriverById(id);
                    break;
                case 5:
                    engine = GetEngine();
                    engineRepository.CreateEngine(engine);
                    break;
                case 6:
                    engines = engineRepository.GetAllEngines();
                    displayAllEngines(engines);
                    break;
                case 7:
                    System.out.print("Введите ID двигателя для обновления: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Сброс символа новой строки
                    engine = GetEngine();
                    engineRepository.UpdateEngineById(id, engine);
                    break;
                case 8:
                    System.out.print("Введите ID двигателя для удаления: ");
                    id = scanner.nextInt();
                    engineRepository.DeleteEngineById(id);
                    break;
                case 9:
                    car = GetCar();
                    carRepository.CreateCar(car);
                    break;
                case 10:
                    cars = carRepository.GetAllCars();
                    displayAllCars(cars);
                    break;
                case 11:
                    System.out.print("Введите ID машины для обновления: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Сброс символа новой строки
                    car = GetCar();
                    carRepository.UpdateCarById(id, car);
                    break;
                case 12:
                    System.out.print("Введите ID машины для удаления: ");
                    id = scanner.nextInt();
                    carRepository.DeleteCarById(id);
                    break;
                case 0:
                    System.out.println("Выход из меню.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 0);
    }

    private static Driver GetDriver(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО водителя: ");
        String fio = scanner.nextLine();
        System.out.print("Введите стаж водителя: ");
        int experience = scanner.nextInt();
        return  new Driver(fio, experience);
    }

    private static void displayAllDrivers(ArrayList<Driver> drivers) {
        if (drivers.isEmpty()) {
            System.out.println("Список водителей пуст.");
        } else {
            System.out.println("Список всех водителей:");
            for (int i = 0; i < drivers.size(); i++) {
                System.out.println("ID: " + i + displayDriver(drivers.get(i)));
            }
        }
    }

    private static String displayDriver(Driver driver){
        return " ФИО: " +  driver.FIO + ", Стаж: " + driver.Experiense;
    }

    private static Engine GetEngine(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите мощность: ");
        double capacity = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите производителя: ");
        String manufacturer = scanner.nextLine();
        return  new Engine(capacity, manufacturer);
    }

    private static void displayAllEngines(ArrayList<Engine> engines) {
        if (engines.isEmpty()) {
            System.out.println("Список двигателей пуст.");
        } else {
            System.out.println("Список всех двигателей:");
            for (int i = 0; i < engines.size(); i++) {
                System.out.println("ID: " + i + displayEngine(engines.get(i)));
            }
        }
    }

    private static String displayEngine(Engine engine){
        return " Мощность двигателя: " +  engine.Capacity + ", Производитель двигателя: " + engine.Manufacturer;
    }

    private static Car GetCar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите марку машины: ");
        String brand = scanner.nextLine();
        System.out.print("Введите класс автомобиля: ");
        String classAuto = scanner.nextLine();
        Driver driver = GetDriver();
        System.out.print("Введите вес автомобиля: ");
        double weight = scanner.nextDouble();
        Engine engine = GetEngine();
        return new Car(brand, classAuto, driver, weight, engine);
    }

    private static void displayAllCars(ArrayList<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("Список машин пуст.");
        } else {
            System.out.println("Список всех машин:");
            for (int i = 0; i < cars.size(); i++) {
                System.out.println("ID: " + i + ", Марка: " + cars.get(i).Brand + ", Класс автомобиля: " +  cars.get(i).ClassAuto + displayDriver((cars.get(i).CarDriver))
                        + ", Weight: " + cars.get(i).Weight + displayEngine(cars.get(i).Motor));
            }
        }
    }
}
