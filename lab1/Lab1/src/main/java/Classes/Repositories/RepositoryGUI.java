package Classes.Repositories;

import Classes.Car;
import Classes.Driver;
import Classes.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class RepositoryGUI {
    private CarRepository carRepository;
    private DriverRepository driverRepository;
    private EngineRepository engineRepository;

    public RepositoryGUI() {
        carRepository = new CarRepository();
        driverRepository = new DriverRepository();
        engineRepository = new EngineRepository();
    }

    public void createAndShowGUI() {
        JFrame mainFrame = new JFrame("Repository GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 500);

        JFrame frameForCarRegistration = new JFrame("Create car");
        frameForCarRegistration.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForCarRegistration.setResizable(false);
        frameForCarRegistration.setSize(400, 300);

        JFrame frameForEngineRegistration = new JFrame("Create engine");
        frameForEngineRegistration.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForEngineRegistration.setResizable(false);
        frameForEngineRegistration.setSize(300, 200);

        JFrame frameForDriverRegistration = new JFrame("Create driver");
        frameForDriverRegistration.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForDriverRegistration.setResizable(false);
        frameForDriverRegistration.setSize(300, 200);

        JFrame frameForCarsInfo = new JFrame("Car Information");
        frameForCarsInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForCarsInfo.setResizable(false);
        frameForCarsInfo.setSize(700, 400);

        JFrame frameForEnginesInfo = new JFrame("Engine Information");
        frameForEnginesInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForEnginesInfo.setResizable(false);
        frameForEnginesInfo.setSize(300,200);

        JFrame frameForDriversInfo = new JFrame("Driver Information");
        frameForDriversInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForDriversInfo.setResizable(false);
        frameForDriversInfo.setSize(300, 200);

        JFrame frameForUpdateCar = new JFrame("Update driver");
        frameForUpdateCar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForUpdateCar.setResizable(false);
        frameForUpdateCar.setSize(450, 350);

        JFrame frameForUpdateEngine = new JFrame("Update engine");
        frameForUpdateEngine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForUpdateEngine.setResizable(false);
        frameForUpdateEngine.setSize(350, 250);

        JFrame frameForUpdateDriver = new JFrame("Update driver");
        frameForUpdateDriver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForUpdateDriver.setResizable(false);
        frameForUpdateDriver.setSize(350, 250);

        JFrame frameForDeleteCar = new JFrame("Delete car");
        frameForDeleteCar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForDeleteCar.setResizable(false);
        frameForDeleteCar.setSize(250, 100);

        JFrame frameForDeleteEngine = new JFrame("Delete engine");
        frameForDeleteEngine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForDeleteEngine.setResizable(false);
        frameForDeleteEngine.setSize(250, 100);

        JFrame frameForDeleteDriver = new JFrame("Delete driver");
        frameForDeleteDriver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForDeleteDriver.setResizable(false);
        frameForDeleteDriver.setSize(250, 100);

        // Создаем кнопки
        JButton carCreateButton = new JButton("Создать автомобиль");
        JButton driverCreateButton = new JButton("Создать водителя");
        JButton engineCreateButton = new JButton("Создать двигатель");

        JButton carReadButton = new JButton("Вывести автомобили");
        JButton driverReadButton = new JButton("Вывести водителей");
        JButton engineReadButton = new JButton("Вывести двигатели");

        JButton carUpdateButton = new JButton("Обновить автомобиль");
        JButton driverUpdateButton = new JButton("Обновить водителя");
        JButton engineUpdateButton = new JButton("Обновить двигатель");

        JButton carDeleteButton = new JButton("Удалить автомобиль");
        JButton driverDeleteButton = new JButton("Удалить водителя");
        JButton engineDeleteButton = new JButton("Удалить двигатель");

        JButton okForCreateCarButton = new JButton("Создать");
        JButton badForCreateCarButton = new JButton("Отмена");

        JButton okForCreateDriverButton = new JButton("Создать");
        JButton badForCreateDriverButton = new JButton("Отмена");

        JButton okForCreateEngineButton = new JButton("Создать");
        JButton badForCreateEngineButton = new JButton("Отмена");

        JButton okForUpdateCarButton = new JButton("Обновить");
        JButton badForUpdateCarButton = new JButton("Отмена");

        JButton okForUpdateDriverButton = new JButton("Обновить");
        JButton badForUpdateDriverButton = new JButton("Отмена");

        JButton okForUpdateEngineButton = new JButton("Обновить");
        JButton badForUpdateEngineButton = new JButton("Отмена");

        JButton okForDeleteCarButton = new JButton("Обновить");
        JButton badForDeleteCarButton = new JButton("Отмена");

        JButton okForDeleteDriverButton = new JButton("Обновить");
        JButton badForDeleteDriverButton = new JButton("Отмена");

        JButton okForDeleteEngineButton = new JButton("Обновить");
        JButton badForDeleteEngineButton = new JButton("Отмена");

        // Создаём форматы для числовых полей
        NumberFormat doubleFormat = NumberFormat.getInstance();
        doubleFormat.setGroupingUsed(false);
        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setMaximumFractionDigits(0);

        // Создаём поля для ввода данных
        JTextField fieldForBrandCarCreate = new JTextField();
        JTextField fieldForClassAutoCarCreate = new JTextField();
        JFormattedTextField fieldForWeightCarCreate = new JFormattedTextField(doubleFormat);
        JTextField fieldForFioCarCreate = new JTextField();
        JFormattedTextField fieldForExperienceCarCreate = new JFormattedTextField(intFormat);
        JFormattedTextField fieldForCapacityCarCreate = new JFormattedTextField(doubleFormat);
        JTextField fieldForManufacturerCarCreate = new JTextField();

        JTextField fieldForFioDriverCreate = new JTextField();
        JFormattedTextField fieldForExperienceDriverCreate = new JFormattedTextField(intFormat);

        JFormattedTextField fieldForCapacityEngineCreate = new JFormattedTextField(doubleFormat);
        JTextField fieldForManufacturerEngineCreate = new JTextField();

        JFormattedTextField fieldForIdCarUpdate = new JFormattedTextField(intFormat);
        JTextField fieldForBrandCarUpdate = new JTextField();
        JTextField fieldForClassAutoCarUpdate = new JTextField();
        JFormattedTextField fieldForWeightCarUpdate = new JFormattedTextField(doubleFormat);
        JTextField fieldForFioCarUpdate = new JTextField();
        JFormattedTextField fieldForExperienceCarUpdate = new JFormattedTextField(intFormat);
        JFormattedTextField fieldForCapacityCarUpdate = new JFormattedTextField(doubleFormat);
        JTextField fieldForManufacturerCarUpdate = new JTextField();

        JFormattedTextField fieldForIdDriverUpdate = new JFormattedTextField(intFormat);
        JTextField fieldForFioDriverUpdate = new JTextField();
        JFormattedTextField fieldForExperienceDriverUpdate = new JFormattedTextField(intFormat);

        JFormattedTextField fieldForIdEngineUpdate = new JFormattedTextField(intFormat);
        JFormattedTextField fieldForCapacityEngineUpdate = new JFormattedTextField(doubleFormat);
        JTextField fieldForManufacturerEngineUpdate = new JTextField();

        JFormattedTextField fieldForIdCarDelete = new JFormattedTextField(intFormat);

        JFormattedTextField fieldForIdDriverDelete = new JFormattedTextField(intFormat);

        JFormattedTextField fieldForIdEngineDelete = new JFormattedTextField(intFormat);

        // Создаём лейблы для полей
        JLabel brandLabelCarCreate = new JLabel("Brand");
        brandLabelCarCreate.setLabelFor(fieldForBrandCarCreate);

        JLabel classAutoLabelCarCreate = new JLabel("Class Auto");
        classAutoLabelCarCreate.setLabelFor(fieldForClassAutoCarCreate);

        JLabel weightLabelCarCreate = new JLabel("Weight");
        weightLabelCarCreate.setLabelFor(fieldForWeightCarCreate);

        JLabel fioLabelCarCreate = new JLabel("Fio");
        fioLabelCarCreate.setLabelFor(fieldForFioCarCreate);

        JLabel experienceLabelCarCreate = new JLabel("Experience");
        experienceLabelCarCreate.setLabelFor(fieldForExperienceCarCreate);

        JLabel capacityLabelCarCreate = new JLabel("Capacity");
        capacityLabelCarCreate.setLabelFor(fieldForCapacityCarCreate);

        JLabel manufacturerLabelCarCreate = new JLabel("Manufacturer");
        manufacturerLabelCarCreate.setLabelFor(fieldForManufacturerCarCreate);

        JLabel fioLabelDriverCreate = new JLabel("Fio");
        fioLabelDriverCreate.setLabelFor(fieldForFioDriverCreate);

        JLabel experienceLabelDriverCreate = new JLabel("Experience");
        experienceLabelDriverCreate.setLabelFor(fieldForExperienceDriverCreate );

        JLabel capacityLabelEngineCreate = new JLabel("Capacity");
        capacityLabelEngineCreate.setLabelFor(fieldForCapacityEngineCreate);

        JLabel manufacturerLabelEngineCreate = new JLabel("Manufacturer");
        manufacturerLabelEngineCreate.setLabelFor(fieldForManufacturerEngineCreate);

        JLabel idLabelCarUpdate = new JLabel("Id");
        idLabelCarUpdate.setLabelFor(fieldForIdCarUpdate);

        JLabel brandLabelCarUpdate = new JLabel("Brand");
        brandLabelCarUpdate.setLabelFor(fieldForBrandCarUpdate);

        JLabel classAutoLabelCarUpdate = new JLabel("Class Auto");
        classAutoLabelCarUpdate.setLabelFor(fieldForClassAutoCarUpdate);

        JLabel weightLabelCarUpdate = new JLabel("Weight");
        weightLabelCarUpdate.setLabelFor(fieldForWeightCarUpdate);

        JLabel fioLabelCarUpdate = new JLabel("Fio");
        fioLabelCarUpdate.setLabelFor(fieldForFioCarUpdate);

        JLabel experienceLabelCarUpdate = new JLabel("Experience");
        experienceLabelCarUpdate.setLabelFor(fieldForExperienceCarUpdate);

        JLabel capacityLabelCarUpdate = new JLabel("Capacity");
        capacityLabelCarUpdate.setLabelFor(fieldForCapacityCarUpdate);

        JLabel manufacturerLabelCarUpdate = new JLabel("Manufacturer");
        manufacturerLabelCarUpdate.setLabelFor(fieldForManufacturerCarUpdate);

        JLabel idLabelDriverUpdate = new JLabel("Id");
        idLabelDriverUpdate.setLabelFor(fieldForIdDriverUpdate);

        JLabel fioLabelDriverUpdate = new JLabel("Fio");
        fioLabelDriverUpdate.setLabelFor(fieldForFioDriverUpdate);

        JLabel experienceLabelDriverUpdate = new JLabel("Experience");
        experienceLabelDriverUpdate.setLabelFor(fieldForExperienceDriverUpdate);

        JLabel idLabelEngineUpdate = new JLabel("Id");
        idLabelEngineUpdate.setLabelFor(fieldForIdEngineUpdate);

        JLabel capacityLabelEngineUpdate = new JLabel("Capacity");
        capacityLabelEngineUpdate.setLabelFor(fieldForCapacityEngineUpdate);

        JLabel manufacturerLabelEngineUpdate = new JLabel("Manufacturer");
        manufacturerLabelEngineUpdate.setLabelFor(fieldForManufacturerEngineUpdate);

        JLabel idLabelCarDelete = new JLabel("Id");
        idLabelCarDelete.setLabelFor(fieldForIdCarDelete);

        JLabel idLabelEngineDelete = new JLabel("Id");
        idLabelEngineDelete.setLabelFor(fieldForIdEngineDelete);

        JLabel idLabelDriverDelete = new JLabel("Id");
        idLabelDriverDelete.setLabelFor(fieldForIdDriverDelete);


        // Создаём текстовые области
        JTextArea carInfoTextArea = new JTextArea(25,40);
        carInfoTextArea.setEditable(false);
        carInfoTextArea.setLineWrap(true);

        JTextArea engineInfoTextArea = new JTextArea(20,40);
        engineInfoTextArea.setEditable(false);
        engineInfoTextArea.setLineWrap(true);

        JTextArea driverInfoTextArea = new JTextArea(20,40);
        driverInfoTextArea.setEditable(false);
        driverInfoTextArea.setLineWrap(true);

        // Добавляем обработчики событий для кнопок
        carCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frameForCarRegistration.setVisible(true);
            }
        });

        okForCreateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = fieldForBrandCarCreate.getText();
                String classAuto = fieldForClassAutoCarCreate.getText();
                double weight = Double.parseDouble(fieldForWeightCarCreate.getText());
                String fio = fieldForFioCarCreate.getText();
                long experienceValue = (long) fieldForExperienceCarCreate.getValue();
                int experience = (int) experienceValue;
                double capacity = Double.parseDouble(fieldForCapacityCarCreate.getText());
                String manufacturer = fieldForManufacturerCarCreate.getText();

                Driver driver = new Driver(fio, experience);
                Engine engine = new Engine(capacity, manufacturer);
                carRepository.CreateCar(new Car(brand, classAuto, driver, weight, engine));

                fieldForBrandCarCreate.setText("");
                fieldForClassAutoCarCreate.setText("");
                fieldForWeightCarCreate.setText("");
                fieldForFioCarCreate.setText("");
                fieldForExperienceCarCreate.setText("");
                fieldForCapacityCarCreate.setText("");
                fieldForManufacturerCarCreate.setText("");
            }
        });

        badForCreateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldForBrandCarCreate.setText("");
                fieldForClassAutoCarCreate.setText("");
                fieldForWeightCarCreate.setText("");
                fieldForFioCarCreate.setText("");
                fieldForExperienceCarCreate.setText("");
                fieldForCapacityCarCreate.setText("");
                fieldForManufacturerCarCreate.setText("");
                frameForCarRegistration.setVisible(false);
            }
        });

        driverCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameForDriverRegistration.setVisible(true);
            }
        });

        okForCreateDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fio = fieldForFioDriverCreate.getText();
                long experienceValue = (long) fieldForExperienceDriverCreate.getValue();
                int experience = (int) experienceValue;

                Driver driver = new Driver(fio, experience);
                driverRepository.CreateDriver(driver);

                fieldForFioDriverCreate.setText("");
                fieldForExperienceDriverCreate.setText("");
            }
        });

        badForCreateDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldForFioDriverCreate.setText("");
                fieldForExperienceDriverCreate.setText("");
                frameForDriverRegistration.setVisible(false);
            }
        });

        engineCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameForEngineRegistration.setVisible(true);
            }
        });

        okForCreateEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double capacity = Double.parseDouble(fieldForCapacityEngineCreate.getText());
                String manufacturer = fieldForManufacturerEngineCreate.getText();

                Engine engine = new Engine(capacity, manufacturer);

                engineRepository.CreateEngine(engine);

                fieldForCapacityEngineCreate.setText("");
                fieldForManufacturerEngineCreate.setText("");
            }
        });

        badForCreateEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldForCapacityEngineCreate.setText("");
                fieldForManufacturerEngineCreate.setText("");
                frameForEngineRegistration.setVisible(false);
            }
        });

        carReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> allCars = carRepository.GetAllCars();

                StringBuilder resultText = new StringBuilder();
                for (Car car : allCars) {
                    resultText.append(CarInfo(car)).append("\n");
                }

                carInfoTextArea.setText(resultText.toString());

                frameForCarsInfo.setVisible(true);
            }
        });

        driverReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Driver> allDrivers = driverRepository.GetAllDrivers();

                StringBuilder resultText = new StringBuilder();
                for (Driver driver : allDrivers){
                    resultText.append(DriverInfo(driver)).append("\n");
                }

                driverInfoTextArea.setText(resultText.toString());

                frameForDriversInfo.setVisible(true);
            }
        });

        engineReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Engine> allEngines = engineRepository.GetAllEngines();

                StringBuilder resultText = new StringBuilder();
                for (Engine engine : allEngines){
                    resultText.append(EngineInfo(engine)).append("\n");
                }

                engineInfoTextArea.setText(resultText.toString());

                frameForEnginesInfo.setVisible(true);
            }
        });

        carUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForUpdateCar.setVisible(true);
            }
        });

        okForUpdateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long idValue = (long) fieldForIdCarUpdate.getValue();
                int id = (int) idValue;
                String brand = fieldForBrandCarUpdate.getText();
                String classAuto = fieldForClassAutoCarUpdate.getText();
                double weight = Double.parseDouble(fieldForWeightCarUpdate.getText());
                String fio = fieldForFioCarUpdate.getText();
                long experienceValue = (long) fieldForExperienceCarUpdate.getValue();
                int experience = (int) experienceValue;
                double capacity = Double.parseDouble(fieldForCapacityCarUpdate.getText());
                String manufacturer = fieldForManufacturerCarUpdate.getText();

                Driver driver = new Driver(fio, experience);
                Engine engine = new Engine(capacity, manufacturer);
                carRepository.UpdateCarById(id, new Car(brand, classAuto, driver, weight, engine));

                fieldForIdCarUpdate.setText("");
                fieldForBrandCarUpdate.setText("");
                fieldForClassAutoCarUpdate.setText("");
                fieldForWeightCarUpdate.setText("");
                fieldForFioCarUpdate.setText("");
                fieldForExperienceCarUpdate.setText("");
                fieldForCapacityCarUpdate.setText("");
                fieldForManufacturerCarUpdate.setText("");
            }
        });

        badForUpdateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldForIdCarUpdate.setText("");
                fieldForBrandCarUpdate.setText("");
                fieldForClassAutoCarUpdate.setText("");
                fieldForWeightCarUpdate.setText("");
                fieldForFioCarUpdate.setText("");
                fieldForExperienceCarUpdate.setText("");
                fieldForCapacityCarUpdate.setText("");
                fieldForManufacturerCarUpdate.setText("");
                frameForUpdateCar.setVisible(false);
            }
        });

        driverUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForUpdateDriver.setVisible(true);
            }
        });

        okForUpdateDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long idValue = (long) fieldForIdDriverUpdate.getValue();
                int id = (int) idValue;
                String fio = fieldForFioDriverUpdate.getText();
                long experienceValue = (long) fieldForExperienceDriverUpdate.getValue();
                int experience = (int) experienceValue;

                Driver driver = new Driver(fio, experience);
                driverRepository.UpdateDriverById(id, driver);

                fieldForIdDriverUpdate.setText("");
                fieldForFioDriverUpdate.setText("");
                fieldForExperienceDriverUpdate.setText("");
            }
        });

        badForUpdateDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldForIdDriverUpdate.setText("");
                fieldForFioDriverUpdate.setText("");
                fieldForExperienceDriverUpdate.setText("");
                frameForUpdateDriver.setVisible(false);
            }
        });

        engineUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForUpdateEngine.setVisible(true);
            }
        });

        okForUpdateEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long idValue = (long) fieldForIdEngineUpdate.getValue();
                int id = (int) idValue;
                double capacity = Double.parseDouble(fieldForCapacityEngineUpdate.getText());
                String manufacturer = fieldForManufacturerEngineUpdate.getText();

                Engine engine = new Engine(capacity, manufacturer);

                engineRepository.UpdateEngineById(id, engine);

                fieldForIdEngineUpdate.setText("");
                fieldForCapacityEngineUpdate.setText("");
                fieldForManufacturerEngineUpdate.setText("");
            }
        });

        badForUpdateEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldForIdEngineUpdate.setText("");
                fieldForCapacityEngineUpdate.setText("");
                fieldForManufacturerEngineUpdate.setText("");
                frameForEngineRegistration.setVisible(false);
            }
        });

        carDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForDeleteCar.setVisible(true);
            }
        });

        driverDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForDeleteDriver.setVisible(true);
            }
        });

        engineDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForDeleteEngine.setVisible(true);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 3, 20, 20));

        mainPanel.add(carCreateButton);
        mainPanel.add(driverCreateButton);
        mainPanel.add(engineCreateButton);

        mainPanel.add(carReadButton);
        mainPanel.add(driverReadButton);
        mainPanel.add(engineReadButton);

        mainPanel.add(carUpdateButton);
        mainPanel.add(driverUpdateButton);
        mainPanel.add(engineUpdateButton);

        mainPanel.add(carDeleteButton);
        mainPanel.add(driverDeleteButton);
        mainPanel.add(engineDeleteButton);

        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);


        JPanel panelForCarCreate = new JPanel();
        panelForCarCreate.setLayout(new GridLayout(8, 2));

        panelForCarCreate.add(brandLabelCarCreate);
        panelForCarCreate.add(fieldForBrandCarCreate);

        panelForCarCreate.add(classAutoLabelCarCreate);
        panelForCarCreate.add(fieldForClassAutoCarCreate);

        panelForCarCreate.add(weightLabelCarCreate);
        panelForCarCreate.add(fieldForWeightCarCreate);

        panelForCarCreate.add(fioLabelCarCreate);
        panelForCarCreate.add(fieldForFioCarCreate);

        panelForCarCreate.add(experienceLabelCarCreate);
        panelForCarCreate.add(fieldForExperienceCarCreate);

        panelForCarCreate.add(capacityLabelCarCreate);
        panelForCarCreate.add(fieldForCapacityCarCreate);

        panelForCarCreate.add(manufacturerLabelCarCreate);
        panelForCarCreate.add(fieldForManufacturerCarCreate);

        panelForCarCreate.add(okForCreateCarButton);
        panelForCarCreate.add(badForCreateCarButton);

        frameForCarRegistration.add(panelForCarCreate);

        frameForCarRegistration.setVisible(false);


        JPanel panelForDriverCreate = new JPanel();
        panelForDriverCreate.setLayout(new GridLayout(3, 2));

        panelForDriverCreate.add(fioLabelDriverCreate);
        panelForDriverCreate.add(fieldForFioDriverCreate);

        panelForDriverCreate.add(experienceLabelDriverCreate);
        panelForDriverCreate.add(fieldForExperienceDriverCreate);

        panelForDriverCreate.add(okForCreateDriverButton);
        panelForDriverCreate.add(badForCreateDriverButton);

        frameForDriverRegistration.add(panelForDriverCreate);
        frameForDriverRegistration.setVisible(false);


        JPanel panelForEngineCreate = new JPanel();
        panelForEngineCreate.setLayout(new GridLayout(3, 2));

        panelForEngineCreate.add(capacityLabelEngineCreate);
        panelForEngineCreate.add(fieldForCapacityEngineCreate);

        panelForEngineCreate.add(manufacturerLabelEngineCreate);
        panelForEngineCreate.add(fieldForManufacturerEngineCreate);

        panelForEngineCreate.add(okForCreateEngineButton);
        panelForEngineCreate.add(badForCreateEngineButton);

        frameForEngineRegistration.add(panelForEngineCreate);
        frameForEngineRegistration.setVisible(false);


        JPanel panelForCarsInfo = new JPanel();
        panelForCarsInfo.add(carInfoTextArea);

        JScrollPane paneForCarInfo = new JScrollPane(carInfoTextArea);
        paneForCarInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frameForCarsInfo.getContentPane().add(paneForCarInfo);

        frameForCarsInfo.setVisible(false);

        JPanel panelForEnginesInfo = new JPanel();
        panelForEnginesInfo.add(engineInfoTextArea);

        JScrollPane paneForEngineInfo = new JScrollPane(engineInfoTextArea);
        paneForEngineInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frameForEnginesInfo.getContentPane().add(paneForEngineInfo);

        frameForEnginesInfo.setVisible(false);

        JPanel panelForDriverInfo = new JPanel();
        panelForDriverInfo.add(driverInfoTextArea);

        JScrollPane paneForDriverInfo = new JScrollPane(driverInfoTextArea);
        paneForDriverInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frameForDriversInfo.getContentPane().add(paneForDriverInfo);

        frameForDriversInfo.setVisible(false);

        JPanel panelForCarUpdate = new JPanel();
        panelForCarUpdate.setLayout(new GridLayout(9, 2));

        panelForCarUpdate.add(idLabelCarUpdate);
        panelForCarUpdate.add(fieldForIdCarUpdate);

        panelForCarUpdate.add(brandLabelCarUpdate);
        panelForCarUpdate.add(fieldForBrandCarUpdate);

        panelForCarUpdate.add(classAutoLabelCarUpdate);
        panelForCarUpdate.add(fieldForClassAutoCarUpdate);

        panelForCarUpdate.add(weightLabelCarUpdate);
        panelForCarUpdate.add(fieldForWeightCarUpdate);

        panelForCarUpdate.add(fioLabelCarUpdate);
        panelForCarUpdate.add(fieldForFioCarUpdate);

        panelForCarUpdate.add(experienceLabelCarUpdate);
        panelForCarUpdate.add(fieldForExperienceCarUpdate);

        panelForCarUpdate.add(capacityLabelCarUpdate);
        panelForCarUpdate.add(fieldForCapacityCarUpdate);

        panelForCarUpdate.add(manufacturerLabelCarUpdate);
        panelForCarUpdate.add(fieldForManufacturerCarUpdate);

        panelForCarUpdate.add(okForUpdateCarButton);
        panelForCarUpdate.add(badForUpdateCarButton);

        frameForUpdateCar.add(panelForCarUpdate);

        frameForUpdateCar.setVisible(false);

        JPanel panelForDriverUpdate = new JPanel();
        panelForDriverUpdate.setLayout(new GridLayout(4, 2));

        panelForDriverUpdate.add(idLabelDriverUpdate);
        panelForDriverUpdate.add(fieldForIdDriverUpdate);

        panelForDriverUpdate.add(fioLabelDriverUpdate);
        panelForDriverUpdate.add(fieldForFioDriverUpdate);

        panelForDriverUpdate.add(experienceLabelDriverUpdate);
        panelForDriverUpdate.add(fieldForExperienceDriverUpdate);

        panelForDriverUpdate.add(okForUpdateDriverButton);
        panelForDriverUpdate.add(badForUpdateDriverButton);

        frameForUpdateDriver.add(panelForDriverUpdate);
        frameForUpdateDriver.setVisible(false);


        JPanel panelForEngineUpdate = new JPanel();
        panelForEngineUpdate.setLayout(new GridLayout(4, 2));

        panelForEngineUpdate.add(idLabelEngineUpdate);
        panelForEngineUpdate.add(fieldForIdEngineUpdate);

        panelForEngineUpdate.add(capacityLabelEngineUpdate);
        panelForEngineUpdate.add(fieldForCapacityEngineUpdate);

        panelForEngineUpdate.add(manufacturerLabelEngineUpdate);
        panelForEngineUpdate.add(fieldForManufacturerEngineUpdate);

        panelForEngineUpdate.add(okForUpdateEngineButton);
        panelForEngineUpdate.add(badForUpdateEngineButton);

        frameForUpdateEngine.add(panelForEngineUpdate);
        frameForUpdateEngine.setVisible(false);

        JPanel panelForCarDelete = new JPanel();
        panelForCarDelete.setLayout(new GridLayout(2, 2));

        panelForCarDelete.add(idLabelCarDelete);
        panelForCarDelete.add(fieldForIdCarDelete);

        panelForCarDelete.add(okForDeleteCarButton);
        panelForCarDelete.add(badForDeleteCarButton);

        frameForDeleteCar.add(panelForCarDelete);
        frameForDeleteCar.setVisible(false);

        JPanel panelForEngineDelete = new JPanel();
        panelForEngineDelete.setLayout(new GridLayout(2, 2));

        panelForEngineDelete.add(idLabelEngineDelete);
        panelForEngineDelete.add(fieldForIdEngineDelete);

        panelForEngineDelete.add(okForDeleteEngineButton);
        panelForEngineDelete.add(badForDeleteEngineButton);

        frameForDeleteEngine.add(panelForEngineDelete);
        frameForDeleteEngine.setVisible(false);

        JPanel panelForDriverDelete = new JPanel();
        panelForDriverDelete.setLayout(new GridLayout(2, 2));

        panelForDriverDelete.add(idLabelDriverDelete);
        panelForDriverDelete.add(fieldForIdDriverDelete);

        panelForDriverDelete.add(okForDeleteDriverButton);
        panelForDriverDelete.add(badForDeleteDriverButton);

        frameForDeleteDriver.add(panelForDriverDelete);
        frameForDeleteDriver.setVisible(false);
    }

    private String CarInfo(Car car){
        return "Brand: " + car.Brand + ", Class: " + car.ClassAuto
                + ", "+ DriverInfo(car.CarDriver) + ", Weight: " + car.Weight + ", " + EngineInfo(car.Motor);
    }

    private String DriverInfo(Driver driver){
        return "Fio: " + driver.FIO + ", Experience: " + driver.Experience;
    }
    private  String EngineInfo(Engine engine){
        return "Capacity: " + engine.Capacity + ", Manufacturer: " + engine.Manufacturer;
    }
}