package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private com.serena.animalproject.dao.AnimalDao animalDao;

//    private ArrayList<ClienteDto> insertIntoArray(Collection<Cliente> clienteCollection) {
//        ArrayList<ClienteDto> clienteDtoArrayList = new ArrayList<>();
//        for (Cliente c : clienteCollection) {
//            ClienteDto clienteDto = new ClienteDto();
//            clienteDto.setIdCliente(c.getIdCliente());
//            clienteDto.setNomeCliente(c.getNomeCliente());
//            clienteDtoArrayList.add(clienteDto);
//        }
//        return clienteDtoArrayList;
//    }

    @Transactional
    public Collection<AnimalBean> getAnimals(){
        Collection<Animal> animal = animalDao.getAnimals();
        return createAnimalBeanListResponse(animal);
    }

//    private Integer findLastId(){
//        Integer n;
//        Collection<Cliente> clienteCollection = clienteDao.findAllCliente();
//        final Iterator iterator = clienteCollection.iterator();
//        if(clienteCollection.size() == 0) {
//            n = 1;
//        } else {
//            Cliente lastCliente = (Cliente) iterator.next();
//            while (iterator.hasNext()) {
//                lastCliente = (Cliente) iterator.next();
//            }
//            n = lastCliente.getIdCliente() + 1;
//        }
//        return n;
//    }

//    @Transactional
//    public boolean deleteCliente(int id) {
//        if(clienteDao.deleteCliente(id))
//            return true;
//        else
//            return false;
//    }

//    @Transactional
//    public boolean changeClienteName(int id, String newName) {
//        Collection<Cliente> cliente = clienteDao.findAllCliente();
//
//        for (Cliente c : cliente) {
//
//            if(c.getIdCliente() == id)
//                clienteDao.newClienteName(c , newName);
//        }
//        return true;
//    }

//    @Transactional
//    public boolean newCliente(String name) {
//        Cliente cliente = new Cliente();
//        cliente.setNomeCliente(name);
//        cliente.setIdCliente(findLastId());
//        if(clienteDao.insertCliente(cliente, name))
//            return true;
//        else
//            return false;
//    }

//    @Transactional
//    public Collection<ClienteDto> getClienteById(Integer id) {
//        Collection<Cliente> clienteCollection = clienteDao.findClienteById(id);
//        return insertIntoArray(clienteCollection);
//    }

//    @Transactional
//    public Collection<ClienteDto> getClienteByName(String name) {
//        Collection<Cliente> clienteCollection = clienteDao.findClienteByName(name);
//        return insertIntoArray(clienteCollection);
//    }

    /**
     *
     * @param animalCollection
     * @return
     */
    private Collection<AnimalBean> createAnimalBeanListResponse(Collection<Animal> animalCollection) {
        Collection<AnimalBean> animalBeanCollection = new ArrayList<AnimalBean>();
        if (animalCollection ==  null) {
            return animalBeanCollection;
        }

        AnimalBean animalBean = null;
        for(Animal animal : animalCollection) {
            animalBean = new AnimalBean();
            animalBean.setAnimal_id(animal.getAnimalId());
            animalBean.setAnimal_name(animal.getAnimalName());
            animalBean.setAnimal_family(animal.getAnimalFamily());
            animalBean.setAnimal_race(animal.getAnimalRace());
            animalBean.setAnimal_descent(animal.getAnimalDescent());

            animalBeanCollection.add(animalBean);
        }
        return animalBeanCollection;
    }
}

//@Service
//public class AnimalService extends JPAAbstractService<Animal> {
//
//    public AnimalService() {
//        super(Animal.class);
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public AnimalBeanListResponse animalList() {
//
//        System.out.println("START");
//
//        List<Animal> animalList = entityManager.createNamedQuery("getAnimals", Animal.class)
//                .getResultList();
//        System.out.println("animalList= " + animalList);
//        if (CollectionUtils.isEmpty(animalList)) {
//            System.out.println("No result founds in table TBL_ANIMAL");
//        }
//
//        List<AnimalBean> animalBeanListResponse = createAnimalBeanListResponse(animalList);
//        System.out.println("animalBeanListResponse=" + animalBeanListResponse);
//
//        AnimalBeanListResponse response = new AnimalBeanListResponse();
//        response.setContent(animalBeanListResponse);
//        System.out.println("END");
//        return response;
//    }
//
//    /**
//     *
//     * @param animalList
//     * @return
//     */
//    private List<AnimalBean> createAnimalBeanListResponse(List<Animal> animalList) {
//        List<AnimalBean> animalBeanList = new ArrayList<AnimalBean>();
//        if (animalList ==  null) {
//            return animalBeanList;
//        }
//
//        AnimalBean animalBean = null;
//        for(Animal animal : animalList) {
//            animalBean = new AnimalBean();
//            animalBean.setAnimal_id(animal.getAnimalId());
//            animalBean.setAnimal_name(animal.getAnimalName());
//            animalBean.setAnimal_family(animal.getAnimalFamily());
//            animalBean.setAnimal_race(animal.getAnimalRace());
//            animalBean.setAnimal_descent(animal.getAnimalDescent());
//
//            animalBeanList.add(animalBean);
//        }
//        return animalBeanList;
//    }
//}


