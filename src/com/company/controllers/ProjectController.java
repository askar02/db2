package com.company.controllers;

import com.company.entities.Project;
import com.company.entities.Developer;
import com.company.entities.User;
import com.company.repositories.interfaces.IProjectRepo;
import com.company.repositories.interfaces.IDeveloperRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class ProjectController {
    private final IProjectRepo projectRepo;
    private final IDeveloperRepo developerRepo;

    public ProjectController(IProjectRepo projectRepo, IDeveloperRepo developerRepo) {
        this.projectRepo = projectRepo;
        this.developerRepo = developerRepo;
    }

    public String createProject(String name) {
        Project project = new Project(name);

        boolean created = projectRepo.createProject(project);

        return (created ? "Project was created!" : "Project creation was failed!");
    }

    public String getProjectById(int id) {
        Project project = projectRepo.getProjectById(id);

        return (project == null ? "Project was not found!" : project.toString());
    }

    public String getAllProjects() {
        List<Project> projects = projectRepo.getAllProjects();

        return projects.toString();
    }

    public String createDeveloper(String name, String surname, boolean gender, int salary){
        Developer developer = new Developer(name,surname,gender,salary);
        boolean created = developerRepo.createDeveloper(developer);
        return (created ? "Developer creation was failed!" : "Developer was created");
    }

    public Developer getDeveloperById(int id){
        Developer developer = developerRepo.getDeveloperById(id);

        return developer;
    }

    public String getAllDevelopers(){
        List<Developer> Developers = developerRepo.getAllDevelopers();

        return Developers.toString();
    }

    public String TotalCostOfProject(){
        int totalCost = projectRepo.getTotalCostOfProject();
        return "Total cost of project: " + totalCost;
    }

}
