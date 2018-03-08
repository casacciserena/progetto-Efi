package com.serena.animalproject.utility;

import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.AnimalBeanResponse;
import com.serena.animalproject.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController  {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "/animal", method = RequestMethod.GET)
    @ResponseBody
    public AnimalBeanCollectionResponse animalBeanCollectionResponse() {
        return animalService.getAnimals();
    }

    @RequestMapping(value = "/animal/{animalId}", method = RequestMethod.GET)
    @ResponseBody
    public AnimalBeanResponse animalBeanResponse(@PathVariable(value = "animalId") long animalId) {
        return animalService.getAnimal(animalId);
    }

//    //cancella una riga dalla tabella CLIENTE con id selezionato
//    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public String deleteCliente(@PathVariable(value="id") int id) {
//        if (clienteService.deleteCliente(id)) {
//            return "Cliente cancellato";
//        }
//        else {
//            return "Cliente non cancellato";
//        }
//    }

//    //modifica il campo nomeCliente nella tabella CLIENTE
//    //selezionando l'oggetto attraverso l'id e inserendo il
//    //nuovo nome con cui sostituirlo
//    @RequestMapping(value = "/cambiaNomeCliente", method = RequestMethod.POST)
//    @ResponseBody
//    public String changeClienteName(@RequestParam(value="id") int id, @RequestParam(value="newClienteName") String newName) {
//        if (clienteService.changeClienteName(id, newName)) {
//            return "{\"status\" :\"ok\"}";
//        }
//        else {
//            return "{\"status\" :\" not ok\"}";
//        }
//    }

//    //permette di aggiungere una nuova riga alla tabella CLIENTE inserendo una stringa con il nome
//    //l'id viene generato automaticamente
//    @RequestMapping(method = RequestMethod.POST, value = "/addCliente")
//    @ResponseBody
//    public String addCliente(@RequestParam(value = "nomeNuovoCliente") String name) {
//        if (clienteService.newCliente(name)) {
//
//            return "Cliente inserito";
//        }
//        return "Cliente non inserito";
//    }
}
public class RestController  {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    @ResponseBody
    public OwnerBeanCollectionResponse ownerBeanCollectionResponse() {
        return ownerService.getOwners();
    }
}