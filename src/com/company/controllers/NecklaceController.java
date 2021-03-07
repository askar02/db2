
package com.company.controllers;


import com.company.entities.Necklace;
import com.company.entities.Stone;


import com.company.repositories.interfaces.IStoneRepo;
import com.company.repositories.interfaces.INecklaceRepo;


import java.util.List;

public class NecklaceController {
    private final INecklaceRepo repo;
    private final IStoneRepo repo1;
    //using repositories
    public NecklaceController(INecklaceRepo repo, IStoneRepo repo1) {
        this.repo = repo;
        this.repo1 = repo1;
    }


    public String createNecklace(String name,double weight, int cost) {
        Necklace necklace = new Necklace( name, weight, cost);
        boolean created = repo.createNecklace(necklace); //do function
        return (created ? "Necklace created!" : "Failed!");
        // if all ok do first text if not second text. it about all code
    }


    public String getNecklace(int id) {
        Necklace necklace = repo.getNecklaceById(id); //do function
        return (necklace == null ? "Not founded!" : necklace.toString());
    }

    public String getStonesByNecklace(int id) {
        List<Stone> stoneList = repo.getStonesByOrder(id); //do function
        return (stoneList == null ? "We can't found Stones in this necklace!" : stoneList.toString());
    }

    public String getAllNecklaces() {
        List<Necklace> necklaces = repo.getAllNecklaces(); //do function
        return necklaces.toString();
    }

}