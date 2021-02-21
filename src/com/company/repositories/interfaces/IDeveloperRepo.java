package com.company.repositories.interfaces;

import com.company.entities.Developer;
import com.company.entities.User;

import java.util.List;

/**
 * interface of developer repository
 */
public interface IDeveloperRepo {
    boolean createDeveloper(Developer developer);
    Developer getDeveloperById(int id);
    List<Developer> getAllDevelopers();
}
