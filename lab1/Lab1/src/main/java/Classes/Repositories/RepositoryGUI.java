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
        frameForEngineRegistration.setSize(400, 300);

        JFrame frameForDriverRegistration = new JFrame("Create driver");
        frameForDriverRegistration.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForDriverRegistration.setResizable(false);
        frameForDriverRegistration.setSize(400, 300);

        JFrame frameForCarsInfo = new JFrame("Car Information");
        frameForCarsInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameForCarsInfo.setResizable(false);
        frameForCarsInfo.setSize(400, 300);

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


        // Создаём форматы для числовых полей
        NumberFormat doubleFormat = DecimalFormat.getInstance();
        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setMaximumFractionDigits(0);

        // Создаём поля для ввода данных
        JTextField fieldForBrand = new JTextField();
        JTextField fieldForClassAuto = new JTextField();
        JFormattedTextField fieldForWeight = new JFormattedTextField(doubleFormat);
        JTextField fieldForFio = new JTextField();
        JFormattedTextField fieldForExperience = new JFormattedTextField(intFormat);
        JFormattedTextField fieldForCapacity = new JFormattedTextField(doubleFormat);
        JTextField fieldForManufacturer = new JTextField();


        // Создаём лейблы для полей
        JLabel fieldForBrandLabel = new JLabel("Brand");
        fieldForBrandLabel.setLabelFor(fieldForBrand);

        JLabel fieldForClassAutoLabel = new JLabel("Class Auto");
        fieldForClassAutoLabel.setLabelFor(fieldForClassAuto);

        JLabel fieldForWeightLabel = new JLabel("Weight");
        fieldForWeightLabel.setLabelFor(fieldForWeight);

        JLabel fieldForFioLabel = new JLabel("Fio");
        fieldForFioLabel.setLabelFor(fieldForFio);

        JLabel fieldForExperienceLabel = new JLabel("Experience");
        fieldForExperienceLabel.setLabelFor(fieldForExperience);

        JLabel fieldForCapacityLabel = new JLabel("Capacity");
        fieldForCapacityLabel.setLabelFor(fieldForCapacity);

        JLabel fieldForManufacturerLabel = new JLabel("Manufacturer");
        fieldForManufacturerLabel.setLabelFor(fieldForManufacturer);

        JTextArea carInfoTextArea = new JTextArea(25,40);
        carInfoTextArea.setEditable(false);
        carInfoTextArea.setLineWrap(true);

        // Добавляем обработчики событий для кнопок
        carCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameForCarRegistration.setVisible(true);
            }
        });

        okForCreateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = fieldForBrand.getText();
                String classAuto = fieldForClassAuto.getText();
                double weight = Double.parseDouble(fieldForWeight.getText());
                String fio = fieldForFio.getText();
                long experienceValue = (long) fieldForExperience.getValue();
                int experience = (int) experienceValue;
                double capacity = Double.parseDouble(fieldForCapacity.getText());
                String manufacturer = fieldForManufacturer.getText();

                Driver driver = new Driver(fio, experience);
                Engine engine = new Engine(capacity, manufacturer);
                carRepository.CreateCar(new Car(brand, classAuto, driver, weight, engine));
            }
        });

        badForCreateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameForCarRegistration.setVisible(false);
            }
        });

        driverCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Открываем диалоговое окно для ввода данных о водителе
                String driverName = JOptionPane.showInputDialog(mainFrame, "Введите имя водителя:");
                // Создаем нового водителя и добавляем его в репозиторий
                Driver newDriver = new Driver("ff", 12);
                driverRepository.CreateDriver(newDriver);
            }
        });

        engineCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Открываем диалоговое окно для ввода данных о двигателе
                String engineName = JOptionPane.showInputDialog(mainFrame, "Введите название двигателя:");
                // Создаем новый двигатель и добавляем его в репозиторий
                Engine newEngine = new Engine(12, "ff");
                engineRepository.CreateEngine(newEngine);
            }
        });

        carReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> allCars = carRepository.GetAllCars();

                StringBuilder resultText = new StringBuilder();
                for (Car car : allCars) {
                    resultText.append(car.Brand).append(" - ").append(car.ClassAuto).append("\n");
                }

                carInfoTextArea.setText(resultText.toString());

                frameForCarsInfo.setVisible(true);
            }
        });

        driverReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        engineReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        carUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        driverUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        engineUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        carDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        driverDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        engineDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        panelForCarCreate.add(fieldForBrandLabel);
        panelForCarCreate.add(fieldForBrand);

        panelForCarCreate.add(fieldForClassAutoLabel);
        panelForCarCreate.add(fieldForClassAuto);

        panelForCarCreate.add(fieldForWeightLabel);
        panelForCarCreate.add(fieldForWeight);

        panelForCarCreate.add(fieldForFioLabel);
        panelForCarCreate.add(fieldForFio);

        panelForCarCreate.add(fieldForExperienceLabel);
        panelForCarCreate.add(fieldForExperience);

        panelForCarCreate.add(fieldForCapacityLabel);
        panelForCarCreate.add(fieldForCapacity);

        panelForCarCreate.add(fieldForManufacturerLabel);
        panelForCarCreate.add(fieldForManufacturer);

        panelForCarCreate.add(okForCreateCarButton);
        panelForCarCreate.add(badForCreateCarButton);

        frameForCarRegistration.add(panelForCarCreate);

        frameForCarRegistration.setVisible(false);



        JPanel panelForCarsInfo = new JPanel();
        panelForCarsInfo.add(carInfoTextArea);

        //frameForCarsInfo.getContentPane().add(panelForCarsInfo);
        JScrollPane pane = new JScrollPane(carInfoTextArea);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frameForCarsInfo.getContentPane().add(pane);

        frameForCarsInfo.setVisible(false);

    }
}