package com.company.repositories.interfaces;

import com.company.entities.Project;
import com.company.entities.Developer;
import com.company.entities.Train;

import java.util.List;

/**
 * interface of project repository
 */
public interface IProjectRepo {
    boolean createProject(Project project);
    Project getProjectById(int id);
    List<Project> getAllProjects();
    int getTotalCostOfProject();
    boolean updateTotalCostOfProject();
}