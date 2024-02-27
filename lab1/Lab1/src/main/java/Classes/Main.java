package Classes;

import Classes.Repositories.CarRepository;
import Classes.Repositories.DriverRepository;
import Classes.Repositories.EngineRepository;
import Classes.Repositories.RepositoryGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
public class Main {
    /**
     * Главный метод
     * @param args
     */
    public static void main(String[] args) {
        RepositoryGUI repositoryGUI = new RepositoryGUI();

        repositoryGUI.createAndShowGUI();
    }
}
