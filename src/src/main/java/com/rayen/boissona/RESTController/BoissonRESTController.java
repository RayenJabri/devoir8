package com.rayen.boissona.RESTController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rayen.boissona.entities.Boisson;
import com.rayen.boissona.service.BoissonService;
@RestController
@RequestMapping("/api")
@CrossOrigin

public class BoissonRESTController {


        @Autowired
        BoissonService boissonService;
        @RequestMapping(method = RequestMethod.GET)
        public List<Boisson> getAllBosons() {
            return boissonService.getAllBoisson();
        }



    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Boisson getBoissonById(@PathVariable("id") Long id) {
        return boissonService.getBoisson(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Boisson createBoisson(@RequestBody Boisson boisson) {
        return boissonService.saveBoisson(boisson);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Boisson updateBoisson(@RequestBody Boisson boisson) {
        return boissonService.updateBoisson(boisson);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteBoisson(@PathVariable("id") Long id)
    {
        boissonService.deleteBoissonById(id);
    }
    @RequestMapping(value="/prodscat/{idType}",method = RequestMethod.GET)
    public List<Boisson> getBoissonByTypeId(@PathVariable("idType") Long idType) {
        return boissonService.findByTypeIdType(idType);
    }
    @RequestMapping(value="/boisByName/{nom}",method = RequestMethod.GET)
    public List<Boisson> findByNomBoissonContains(@PathVariable("nom") String nom) {
        return boissonService.findByNomBoissonContains(nom);
    }

}
