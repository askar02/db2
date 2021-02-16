package com.company.controllers;

import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.entities.User;
import com.company.repositories.interfaces.ILocomotiveRepo;
import com.company.repositories.interfaces.ITrainRepo;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class TrainController {
    private final ITrainRepo trainRepo;
    private final ILocomotiveRepo locomotiveRepo;

    public TrainController(ITrainRepo trainRepo, ILocomotiveRepo locomotiveRepo) {
        this.trainRepo = trainRepo;
        this.locomotiveRepo = locomotiveRepo;
    }

    public String createTrain(String name, int capacity, int locomotiveID) {
        Train train = new Train(name, capacity, locomotiveID);

        boolean created = trainRepo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrainById(int id) {
        Train train = trainRepo.getTrainById(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = trainRepo.getAllTrains();

        return trains.toString();
    }

    public String createLocomotive(String name){
        Locomotive locomotive = new Locomotive(name);
        boolean created = locomotiveRepo.createLocomotive(locomotive);
        return (created ? "Locomotive was created" : "Locomotive creation was failed!");
    }

    public Locomotive getLocomotiveById(int id){
        Locomotive locomotive = locomotiveRepo.getLocomotiveById(id);

        return locomotive;
    }

    public String getAllLocomotives(){
        List<Locomotive> Locomotives = locomotiveRepo.getAllLocomotives();

        return Locomotives.toString();
    }

    public String getTrainByLocomotiveId(int locomotiveID){
        Train train = trainRepo.getTrainByLocomotiveId(locomotiveID);

        return (train == null ? "Train was not found by current locomotive ID!" : train.toString());
    }
}
