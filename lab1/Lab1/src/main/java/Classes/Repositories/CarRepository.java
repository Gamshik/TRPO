package Classes.Repositories;

import Classes.Car;
import Classes.Driver;
import Classes.Engine;

import java.util.ArrayList;

public class CarRepository {
    private ArrayList<Car> cars;

    public CarRepository(){
        cars = new ArrayList<Car>();
    }

    /**
     * Метод для добавления новой машины в коллекцию
     * @param car
     */
    public void CreateCar(Car car){
        cars.add(car);
    }

    /**
     * Метод для получения списка всех машин
     * @return
     */
    public ArrayList<Car> GetAllCars(){
        return  cars;
    }

    /**
     * Метод для обновления информации об определённой машине
     * @param id
     * @param car
     */
    public void UpdateCarById(int id, Car car){
        cars.set(id, car);
    }

    /**
     * Удаление машины по id
     * @param id
     */
    public  void DeleteCarById(int id){
        cars.remove(id);
    }
}
