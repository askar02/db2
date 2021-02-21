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

    /**
     *creating project
     */
    public String createProject(String name) {
        Project project = new Project(name);

        boolean created = projectRepo.createProject(project);

        return (created ? "Project was created!" : "Project creation was failed!");
    }

    /**
     *getting project by id
     */
    public String getProjectById(int id) {
        Project project = projectRepo.getProjectById(id);

        return (project == null ? "Project was not found!" : project.toString());
    }

    /**
     *getting all project
     */
    public String getAllProjects() {
        List<Project> projects = projectRepo.getAllProjects();

        return projects.toString();
    }

    /**
     *creating developer
     */
    public String createDeveloper(String name, String surname, boolean gender, int salary){
        Developer developer = new Developer(name,surname,gender,salary);
        boolean created = developerRepo.createDeveloper(developer);
        return (created ? "Developer creation was failed!" : "Developer was created");
    }

    /**
     *getting developers by id
     */
    public Developer getDeveloperById(int id){
        Developer developer = developerRepo.getDeveloperById(id);

        return developer;
    }

    /**
     *getting all developers
     */
    public String getAllDevelopers(){
        List<Developer> Developers = developerRepo.getAllDevelopers();

        return Developers.toString();
    }

    /**
     *getting total cost of project
     */
    public String TotalCostOfProject(){
        int totalCost = projectRepo.getTotalCostOfProject();
        return "Total cost of project: " + totalCost;
    }

}
