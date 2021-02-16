package com.company.repositories.interfaces;

import com.company.entities.Locomotive;
import com.company.entities.Train;

import java.util.List;

public interface ILocomotiveRepo {
    boolean createLocomotive(Locomotive locomotive);
    Locomotive getLocomotiveById(int id);
    List<Locomotive> getAllLocomotives();
}
