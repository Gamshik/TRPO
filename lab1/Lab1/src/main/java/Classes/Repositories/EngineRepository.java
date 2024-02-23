package Classes.Repositories;

import Classes.Driver;
import Classes.Engine;

import java.util.ArrayList;

public class EngineRepository {
    private ArrayList<Engine> engines;

    public  EngineRepository(){
        engines = new ArrayList<Engine>();
    }

    /**
     * Метод для добавления нового двигателя в коллекцию
     * @param engine
     */
    public void CreateEngine(Engine engine){
        engines.add(engine);
    }

    /**
     * Метод для получения списка всех двигателей
     * @return
     */
    public ArrayList<Engine> GetAllEngines(){
        return  engines;
    }

    /**
     * Метод для обновления информации об определённом двигателе
     * @param id
     * @param engine
     */
    public void UpdateEngineById(int id, Engine engine){
        engines.set(id, engine);
    }

    /**
     * Удаление двигателя по id
     * @param id
     */
    public  void DeleteEngineById(int id){
        engines.remove(id);
    }
}
