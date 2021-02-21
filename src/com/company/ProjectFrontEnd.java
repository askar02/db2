package com.company;

import com.company.controllers.ProjectController;
import com.company.controllers.UserController;
import com.company.entities.Developer;
import com.company.repositories.interfaces.IDeveloperRepo;
import com.company.repositories.interfaces.IProjectRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.util.Scanner;

public class ProjectFrontEnd {
    private final ProjectController controller;
    private final Scanner scanner;

    public ProjectFrontEnd(IProjectRepo projectRepo, IDeveloperRepo developerRepo) {
        controller = new ProjectController(projectRepo, developerRepo);
        scanner = new Scanner(System.in);
    }

    /**
     * console of this project
     */
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to project developing Application");
            System.out.println("Select option:");
            System.out.println("1. Get all projects");
            System.out.println("2. Get project by id");
            System.out.println("3. Create project");
            System.out.println("4. Create developer");
            System.out.println("5. Get all developers");
            System.out.println("6. Get developer by ID");
            System.out.println("7. Get total cost of project");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-7): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllProjectMenu();
                } else if (option == 2) {
                    getProjectByIdMenu();
                }  else if (option == 3) {
                    createProjectMenu();
                }else if (option == 4) {
                    createDeveloperMenu();
                } else if(option == 5){
                    getAllDevelopersMenu();
                } else if(option == 6){
                    getDevelopersByIdMenu();
                }else if(option == 7){
                    getTotalCostOfProjectMenu();
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

    public void getAllProjectMenu() {
        String response = controller.getAllProjects();
        System.out.println(response);
    }

    public void getProjectByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getProjectById(id);
        System.out.println(response);
    }

    public void createProjectMenu() {
        System.out.println("Please enter name of project");
        String name = scanner.next();

        String response = controller.createProject(name);
        System.out.println(response);
    }

    public void createDeveloperMenu() {
        System.out.println("Please enter name of developer");
        String name = scanner.next();
        System.out.println("Please enter surname of developer");
        String surname = scanner.next();
        System.out.println("Please enter gender of developer");
        Boolean gender = scanner.next().matches("male");
        System.out.println("Please enter salary of developer");
        int salary = scanner.nextInt();


        String response = controller.createDeveloper(name,surname,gender,salary);
        System.out.println(response);
    }

    public void getTotalCostOfProjectMenu(){
        String response = controller.TotalCostOfProject();
        System.out.println(response);
    }

    public void getDevelopersByIdMenu() {
        System.out.println("Please enter id of developer:");

        int id = scanner.nextInt();
        Developer loco = controller.getDeveloperById(id);
        String response = (loco == null ? "Developer was not found!" : loco.toString());

        System.out.println(response);
    }

    public void getAllDevelopersMenu(){
        String response = controller.getAllDevelopers();
        System.out.println(response);
    }
}
