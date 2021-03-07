package com.company;

import com.company.controllers.*;
import com.company.repositories.interfaces.*;
import java.util.Scanner;


public class NecklaceFrontEnd {
    private final NecklaceController control1;
    private final StoneController control2;
    private final ConnectorController control3;
    private final Scanner scanner;

    public NecklaceFrontEnd(INecklaceRepo orderRepo, IStoneRepo medicamentRepo, IConnectorRepo bindRepo) {
        control1 = new NecklaceController(orderRepo,medicamentRepo);
        control2 = new StoneController(medicamentRepo);
        control3 = new ConnectorController(bindRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println(); //console interface
            System.out.println("Welcome to Necklace management System");
            System.out.println("Select option:");
            System.out.println("1. Get all necklaces");
            System.out.println("2. Get necklace by id");
            System.out.println("3. Create necklace");
            System.out.println("4. Get all stones");
            System.out.println("5. Get stone by id");
            System.out.println("6. Create stone");
            System.out.println("7. Enter stone to necklace");
            System.out.println("8. Select all stones of selected necklace");
            System.out.println("0. Exit");
            System.out.println();
            try { //function
                System.out.print("Enter option (1-8): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllNecklaces();
                } else if (option == 2) {
                    getNecklace();
                } else if (option == 3) {
                    createNecklace();
                }else if (option == 4) {
                    getAllStones();
                }else if (option == 5) {
                    getStone();
                }else if (option == 6) {
                    createStone();
                }else if (option == 7) {
                    enterStoneToNecklace();
                }else if (option == 8) {
                    getStonesByNecklace();
                }else {

                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }
    //describing functions
    public void enterStoneToNecklace(){
        System.out.println("Please enter necklace_id!");
        int id1 = scanner.nextInt();
        System.out.println("Please enter stone_id!");
        int id2 = scanner.nextInt();
        String response = control3.enterStoneToNecklace(id1,id2);
        System.out.println(response);
    }


    public void getAllNecklaces() {
        String response = control1.getAllNecklaces();
        System.out.println(response);
    }

    public void getNecklace() {
        System.out.println("Now you should enter needing necklace's id.");
        int id = scanner.nextInt();
        String response = control1.getNecklace(id);
        System.out.println(response);
    }

    public void getStonesByNecklace() {
        System.out.println("Please, enter id of needing necklace's stones!");
        int id = scanner.nextInt();
        String response = control1.getStonesByNecklace(id);
        System.out.println(response);
    }

    public void createNecklace() {
        System.out.println("Please, enter perfect necklace name!");
        String name = scanner.next();
        int cost=0;
        int weight=0;
        String response = control1.createNecklace(name,weight,cost);
        System.out.println(response);
    }


    public void getAllStones() {
        String response = control2.getAllStones();
        System.out.println(response);
    }

    public void getStone() {
        System.out.println("Now you should enter needing stone's id.");
        int id = scanner.nextInt();
        String response = control2.getStone(id);
        System.out.println(response);
    }

    public void createStone() {
        System.out.println("Please, enter stone name!");
        String name = scanner.next();
        System.out.println("Please, enter stone weight!");
        double weight = scanner.nextDouble();
        System.out.println("Please, enter stone cost!");
        int cost = scanner.nextInt();

        String response = control2.createStone(name,weight,cost);
        System.out.println(response);
    }

}