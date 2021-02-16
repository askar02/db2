package com.company;

import com.company.controllers.TrainController;
import com.company.controllers.UserController;
import com.company.entities.Locomotive;
import com.company.repositories.interfaces.ILocomotiveRepo;
import com.company.repositories.interfaces.ITrainRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.util.Scanner;

public class TrainFrontEnd {
    private final TrainController controller;
    private final Scanner scanner;

    public TrainFrontEnd(ITrainRepo trainRepo, ILocomotiveRepo locomotiveRepo) {
        controller = new TrainController(trainRepo, locomotiveRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to train Application");
            System.out.println("Select option:");
            System.out.println("1. Get all trains");
            System.out.println("2. Get train by id");
            System.out.println("3. Create train");
            System.out.println("4. Create locomotive");
            System.out.println("5. Get all locomotives");
            System.out.println("6. Get locomotive by ID");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
                } else if (option == 4) {
                    createLocomotiveMenu();
                } else if(option == 5){
                    getAllLocomotivesMenu();
                } else if(option == 6){
                    getLocomotivesByIdMenu();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllTrainMenu() {
        String response = controller.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getTrainById(id);
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter locomotiveID");
        int locomotiveID = scanner.nextInt();
        try {
            var locoId = controller.getLocomotiveById(locomotiveID).getId();
        } catch (Exception ex){
            System.out.println("locomotive is not found");
            return;
        }

        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter capacity");
        int capacity = scanner.nextInt();


        String response = controller.createTrain(name, capacity, locomotiveID);
        System.out.println(response);
    }

    public void createLocomotiveMenu() {
        System.out.println("Please enter name of locomotive");
        String name = scanner.next();
        String response = controller.createLocomotive(name);
        System.out.println(response);
    }

    public void getAllLocomotivesMenu(){
        String response = controller.getAllLocomotives();
        System.out.println(response);
    }

    public void getLocomotivesByIdMenu() {
        System.out.println("Please enter id of loco:");

        int id = scanner.nextInt();
        Locomotive loco = controller.getLocomotiveById(id);
        String response = (loco == null ? "Train was not found!" : loco.toString());

        System.out.println(response);
    }
}
