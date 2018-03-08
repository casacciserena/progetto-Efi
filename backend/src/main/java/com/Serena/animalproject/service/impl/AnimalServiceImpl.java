package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.AnimalBeanResponse;
import com.serena.animalproject.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private com.serena.animalproject.dao.AnimalDao animalDao;

    @Transactional
    public AnimalBeanCollectionResponse getAnimals() {

        System.out.println("START");

        Collection<Animal> animalCollection = animalDao.getAnimals();

        System.out.println("animalCollection = " + animalCollection);
        if (animalCollection.isEmpty()) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        Collection<AnimalBean> animalBeanCollectionResponse = createAnimalBeanCollectionResponse(animalCollection);
        System.out.println("animalBeanCollectionResponse = " + animalBeanCollectionResponse);

        AnimalBeanCollectionResponse response = new AnimalBeanCollectionResponse();
        response.setContent(animalBeanCollectionResponse);
        System.out.println("END");
        return response;
    }

    @Transactional
    public AnimalBeanResponse getAnimal(@PathParam("animalId") long animalId) {

        System.out.println("START");
        System.out.println("@PathParam animalId: " + animalId);

        Animal animal = animalDao.getAnimal(animalId);
        System.out.println("animal = " + animal);
        if (animal == null) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        AnimalBean animalBean = createAnimalBean(animal);
        System.out.println("created AnimalBean object = " + animalBean);

        AnimalBeanResponse response = new AnimalBeanResponse();
        response.setContent(animalBean);
        System.out.println("END");
        return response;
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{displayId}")
//    public Response update(@HeaderParam(HttpHeaders.ACCEPT_LANGUAGE) String accept_language,
//                           @PathParam("displayId") long displayId,
//                           DisplayBean displayBean,
//                           @DefaultValue("true") @QueryParam("_metadata") boolean _metadata) throws WWSApplicationException {
//
//        logger.debug("START");
//        logger.info(String.format("Service Request [@HeaderParam: accept_language=%s,@PathParam: displayId=%d,displayBean =%s,@QueryParam: _metadata=%b]",accept_language,displayId,displayBean,_metadata));
//
//        Display fromFrontEnd = adaptDisplayBean(displayBean);
//        if (displayId < 0){
//            logger.error("Operation not admissible TBCM_DISPLAY: displayId < 1" + displayId);
//            throw new WWSApplicationException(Response.Status.BAD_REQUEST,
//                    new ErrorBuilder(Constants.ErrorLevel.ERROR)
//                            .code(WSErrorCode.DisplayService.CODE, WSErrorCode.DisplayService.UPDATE_DISPLAY, "001")
//                            .message(resourseBundleManager.getErrorMessage(accept_language, "service.display.not_exist"))
//                            .addParameter("" + displayId)
//                            .build());
//        }
//        Display displayFromDb = entityManager.find(typeParameterClass, displayId);
//        if (displayFromDb == null) {
//            logger.error("No result founds in table TBCM_DISPLAY");
//            throw new WWSApplicationException(Response.Status.BAD_REQUEST,
//                    new ErrorBuilder(Constants.ErrorLevel.ERROR)
//                            .code(WSErrorCode.DisplayService.CODE, WSErrorCode.DisplayService.UPDATE_DISPLAY, "002")
//                            .message(resourseBundleManager.getErrorMessage(accept_language, "service.display.not_exist"))
//                            .addParameter("" + displayId)
//                            .build());
//        }
//
//        logger.debug("displayId=" + displayId);
//        updateDisplay(displayFromDb, fromFrontEnd);
//
//        entityManager.merge(displayFromDb);
//        entityManager.flush();
//
//        String message = displayId == -1 ? "create" : "update";
//
//        logger.debug("Display " + message + " {}", displayId);
//        logger.debug("END");
//        return Response.status(Response.Status.NO_CONTENT).build();
//    }
//@Transactional
//public boolean changeClienteName(int id, String newName) {
//    Collection<Cliente> cliente = clienteDao.findAllCliente();
//
//    for (Cliente c : cliente) {
//
//        if(c.getIdCliente() == id)
//            clienteDao.newClienteName(c , newName);
//    }
//    return true;
//}

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public DisplayBeanResponse create(@HeaderParam(HttpHeaders.ACCEPT_LANGUAGE) String accept_language,
//                                      DisplayBean displayBean,
//                                      @DefaultValue("true") @QueryParam("_metadata") boolean _metadata) throws WWSApplicationException {
//
//        logger.debug("START");
//        logger.info(String.format("Service Request [@HeaderParam: accept_language=%s,displayBean =%s,@QueryParam: _metadata=%b]",accept_language,displayBean,_metadata));
//
//        Display display = adaptDisplayBean(displayBean);
//        LoggerUtils.debugObject(logger, "BEFORE PERSIST display",display);
//        entityManager.persist(display);
//        entityManager.flush();
//        LoggerUtils.debugObject(logger, "AFTER PERSIST display",display);
//
//        DisplayBean displayBeanResponse = createDisplayBean(display);
//        LoggerUtils.debugObject(logger, "created DisplayBeanResponse object= ",displayBeanResponse);
//
//        DisplayBeanResponse response = new DisplayBeanResponse();
//        response.setContent(displayBeanResponse);
//        if (_metadata) {
//            response.set_metadata(EntityMetadata.createEntityMetadata(display));
//        }
//
//        logger.debug("END");
//        return response;
//    }
//@Transactional
//public boolean newCliente(String name) {
//    Cliente cliente = new Cliente();
//    cliente.setNomeCliente(name);
//    cliente.setIdCliente(findLastId());
//    if(clienteDao.insertCliente(cliente, name))
//        return true;
//    else
//        return false;
//}

//    @DELETE
//    @Path("/{displayId}")
//    public Response delete(@HeaderParam(HttpHeaders.ACCEPT_LANGUAGE) String accept_language,
//                           @PathParam("displayId") long displayId,
//                           @DefaultValue("true") @QueryParam("_metadata") boolean _metadata) throws WWSApplicationException {
//
//        logger.debug("START");
//        logger.info(String.format("Service Request [@HeaderParam: accept_language=%s,@PathParam: displayId=%s,@QueryParam: _metadata=%b]",accept_language,displayId,_metadata));
//
//        Display display = entityManager.find(typeParameterClass, displayId);
//        LoggerUtils.debugObject(logger, "display=",display);
//        if (display == null) {
//            logger.error("No result founds in table TBCM_DISPLAY");
//            throw new WWSApplicationException(Response.Status.BAD_REQUEST,
//                    new ErrorBuilder(Constants.ErrorLevel.ERROR)
//                            .code(WSErrorCode.DisplayService.CODE, WSErrorCode.DisplayService.DELETE_DISPLAY, "001")
//                            .message(resourseBundleManager.getErrorMessage(accept_language, "service.branch.display.not_exist"))
//                            .addParameter("" + displayId)
//                            .build());
//        }
//
//        int recordDisplayDeleted = entityManager.createNamedQuery("deleteDisplayById")
//                .setParameter("displayId", displayId)
//                .executeUpdate();
//        entityManager.flush();
//
//        int recordResourceDeleted = 0;
//
//        logger.debug("deleted {} records recordDisplayDeleted recordResourceDeleted",
//                recordDisplayDeleted, recordResourceDeleted);
//        logger.debug("END");
//        return Response.status(Response.Status.NO_CONTENT).build();
//    }
//@Transactional
//public boolean deleteCliente(int id) {
//    if(clienteDao.deleteCliente(id))
//        return true;
//    else
//        return false;
//}

    /**
     *
     * @param animalCollection
     * @return
     */
    private Collection<AnimalBean> createAnimalBeanCollectionResponse(Collection<Animal> animalCollection) {
        Collection<AnimalBean> animalBeanCollection = new ArrayList<AnimalBean>();
        if (animalCollection ==  null) {
            return animalBeanCollection;
        }

//        AnimalBean animalBean = null;
//        Iterator iterator = animalCollection.iterator();
//        while(iterator.hasNext()) {
//            Animal[] animal = (Animal[]) iterator.next();
//            animalBean = new AnimalBean();
//            animalBean.setAnimal_id(animal.getAnimalId());
//            animalBean.setAnimal_name(animal.getAnimalName());
//            animalBean.setAnimal_family(animal.getAnimalFamily());
//            animalBean.setAnimal_race(animal.getAnimalRace());
//            animalBean.setAnimal_descent(animal.getAnimalDescent());
//            animalBean.setAnimal_legs(animal.getAnimalLegs());
//
//            animalBeanCollection.add(animalBean);
//        }

//        List<Object> result = (List<Object>) LoadSource.list();
//        Iterator itr = result.iterator();
//        while(itr.hasNext()){
//            Object[] obj = (Object[]) itr.next();
//            //now you have one array of Object for each row
//            String client = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String
//            Integer service = Integer.parseInt(String.valueOf(obj[1])); //SERVICE assumed as int
//            //same way for all obj[2], obj[3], obj[4]
//        }

        AnimalBean animalBean = null;
        for(Animal animal : animalCollection) {
            animalBean = new AnimalBean();
            animalBean.setAnimal_id(animal.getAnimalId());
            animalBean.setAnimal_name(animal.getAnimalName());
            animalBean.setAnimal_family(animal.getAnimalFamily());
            animalBean.setAnimal_race(animal.getAnimalRace());
            animalBean.setAnimal_descent(animal.getAnimalDescent());
            animalBean.setAnimal_legs(animal.getAnimalLegs());

            animalBeanCollection.add(animalBean);
        }
        return animalBeanCollection;
    }

    /**
     *
     * @param animal
     * @return
     */
    private AnimalBean createAnimalBean(Animal animal) {
        AnimalBean animalBean = new AnimalBean();
        animalBean.setAnimal_id(animal.getAnimalId());
        animalBean.setAnimal_name(animal.getAnimalName());
        animalBean.setAnimal_family(animal.getAnimalFamily());
        animalBean.setAnimal_race(animal.getAnimalRace());
        animalBean.setAnimal_descent(animal.getAnimalDescent());
        animalBean.setAnimal_legs(animal.getAnimalLegs());
        return animalBean;
    }

//    /**
//     *
//     * @param displayBean
//     * @return
//     */
//    private Display adaptDisplayBean(DisplayBean displayBean) {
//        Display display = new Display();
//        display.setDisplayName(displayBean.getDisplay_name());
//        display.setDisplayCode(displayBean.getDisplay_code());
//        display.setLayoutCode(displayBean.getLayout_code());
//        display.setVerticalResolution(displayBean.getVertical_resolution());
//        display.setHorizontalResolution(displayBean.getHorizontal_resolution());
//        display.setTotalHeight(displayBean.getTotal_height());
//        display.setResourceId(displayBean.getResource_id());
//
//        Set<Asset> assetSet = new HashSet<Asset>();
//        Asset asset = null;
//        for (AssetBean assetBean : displayBean.getAsset_set_bean()) {
//
//            asset = new Asset();
//            asset.setAssetId(assetBean.getAsset_id());
//            asset.setAssetName(assetBean.getName());
//
//            assetSet.add(asset);
//        }
//        display.setAssetSet(assetSet);
//
//        List<DisplayCell> displayCellList = new ArrayList<DisplayCell>();
//        DisplayCell displayCell = null;
//        for (DisplayCellBean displayCellBean : displayBean.getDisplay_cell_list_bean()) {
//            displayCell = adaptDisplayCellBean(displayCellBean);
//            displayCellList.add(displayCell);
//        }
//        display.setDisplayCellList(displayCellList);
//
//        return display;
//    }

//    /**
//     *
//     * @param displayFromDB
//     * @param displayFromFrontEnd
//     * @param displayBean
//     * @param language
//     */
//    private void updateDisplay(Display displayFromDB, Display displayFromFrontEnd) {
//
//        displayFromDB.setModificationDate(new Timestamp(new Date().getTime()));
//        displayFromDB.setDisplayName(displayFromFrontEnd.getDisplayName());
//        displayFromDB.setDisplayCode(displayFromFrontEnd.getDisplayCode());
//        displayFromDB.setLayoutCode(displayFromFrontEnd.getLayoutCode());
//        displayFromDB.setVerticalResolution(displayFromFrontEnd.getVerticalResolution());
//        displayFromDB.setHorizontalResolution(displayFromFrontEnd.getHorizontalResolution());
//        displayFromDB.setTotalHeight(displayFromFrontEnd.getTotalHeight());
//        displayFromDB.setResourceId(displayFromFrontEnd.getResourceId());
//
//        List<DisplayCell> removeCellList = new ArrayList<DisplayCell>();
//        for (DisplayCell displayCellFromDB : displayFromDB.getDisplayCellList()) {
//            DisplayCell displayCell = null;
//            for (DisplayCell displayCellFromFrontEnd : displayFromFrontEnd.getDisplayCellList()) {
//                if (displayCellFromDB.getDisplayCellId() == displayCellFromFrontEnd.getDisplayCellId()) {
//                    updateDisplayCell(displayCellFromDB, displayCellFromFrontEnd);
//                    displayCell = displayCellFromDB;
//                    break;
//                }
//            }
//            if (displayCell == null) {
//                removeCellList.add(displayCellFromDB);
//            }
//        }
//        for (DisplayCell cellToRemove : removeCellList) {
//            displayFromDB.removeCell(cellToRemove);
//        }
//        for (DisplayCell displayCellFromFrontEnd : displayFromFrontEnd.getDisplayCellList()) {
//            if (displayCellFromFrontEnd.getDisplayCellId() == 0) {
//                displayFromDB.addCell(displayCellFromFrontEnd);
//            }
//        }
//    }
}



