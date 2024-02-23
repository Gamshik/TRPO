package Classes.Repositories;

import Classes.Car;
import Classes.Driver;
import Classes.Engine;

import java.util.ArrayList;

public class DriverRepository {
    private ArrayList<Driver> drivers;

    public  DriverRepository(){
        drivers = new ArrayList<Driver>();
    }

    /**
     * Метод для добавления нового водителя в коллекцию
     * @param driver
     */
    public void CreateDriver(Driver driver){
        drivers.add(driver);
    }

    /**
     * Метод для получения списка всех водителей
     * @return
     */
    public ArrayList<Driver> GetAllDrivers(){
        return  drivers;
    }

    /**
     * Метод для обновления информации об определённом водителе
     * @param id
     * @param driver
     */
    public void UpdateDriverById(int id, Driver driver){
        drivers.set(id, driver);
    }

    /**
     * Удаление водителя по id
     * @param id
     */
    public  void DeleteDriverById(int id){
        drivers.remove(id);
    }
}
