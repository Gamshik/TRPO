package Classes;

public class Car {
    public String Brand;
    public String ClassAuto;
    public Driver CarDriver;
    public double Weight;
    public Engine Motor;

    /**
     * Конструктор
     * @param brand
     * @param classAuto
     * @param carDriver
     * @param weight
     * @param motor
     */
    public Car(String brand, String classAuto, Driver carDriver, double weight, Engine motor) {
        Brand = brand;
        ClassAuto = classAuto;
        CarDriver = carDriver;
        Weight = weight;
        Motor = motor;
    }
}
