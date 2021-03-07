package com.company.controllers;

import com.company.entities.Connector;

import com.company.repositories.interfaces.IConnectorRepo;


public class ConnectorController {
    private final IConnectorRepo repo;

    public ConnectorController(IConnectorRepo repo) {
        this.repo = repo;
    }
    public String enterStoneToNecklace(int order_id,int med_id) {
        Connector connector = new Connector( order_id, med_id);
        boolean created = repo.createConnector(connector); //do function
        return (created ? "Perfect stone was entered into necklace!" : "Not entered!");
    }
}