package com.mcommerce.microserviceexpedition.web.controller;


import com.mcommerce.microserviceexpedition.dao.ExpeditionDao;
import com.mcommerce.microserviceexpedition.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping("/nouvelleExpedition")
    public ResponseEntity<Expedition> nouvelleExpedition(@RequestBody Expedition expedition){


        //Optionnel : Vous pouvez ajouter ici une vérification pour voir s'il y a déjà  une expédition pour cette commande.
        //puis renvoyer une exception dans ce cas

        Expedition nouvelleExpedition = expeditionDao.save(expedition);


        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);

    }

    @GetMapping("/etatExpedition/{id}")
    public Expedition etatExpedition(@PathVariable int id){

        Optional<Expedition> expedition = expeditionDao.findById(id);

        return expedition.get();

    }

    @PutMapping("/updateExpedition")
    public void updateExpedition(@RequestBody Expedition expedition){

        expeditionDao.save(expedition);

    }
}
