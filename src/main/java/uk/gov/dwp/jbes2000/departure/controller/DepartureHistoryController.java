package uk.gov.dwp.jbes2000.departure.controller;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import uk.gov.dwp.jbes2000.departure.model.DepartureHistory;
import uk.gov.dwp.jbes2000.departure.service.DepartureHistoryService;
import uk.gov.dwp.jbes2000.departure.service.DepartureService;
 
@RestController
public class DepartureHistoryController {
 
	private Logger logger = LoggerFactory.getLogger(DepartureAuthorisedController.class);
	
    @Autowired
    DepartureHistoryService departureHistoryService;
    
    @Autowired
    DepartureService departureService;
    
 
    //-------------------Retrieve Departure History--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/departureHistory/", method = RequestMethod.GET)
    public ResponseEntity<List<DepartureHistory>> getDepartureHistory() {
        List<DepartureHistory> departureHistoryList = departureHistoryService.getDepartureHistory();
        if(departureHistoryList.isEmpty()){
            return new ResponseEntity<List<DepartureHistory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DepartureHistory>>(departureHistoryList, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Departure History By History Id--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/departureHistory/{historyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartureHistory> getDepartureHistoryById(@PathVariable("historyId") long historyId) {
        logger.debug("Fetching Departure History with historyId " + historyId);
        DepartureHistory departureHistory = departureHistoryService.findByDepartureHistoryId(historyId);
        if (departureHistory == null) {
            logger.debug("Departure History with historyId " + historyId + " not found");
            return new ResponseEntity<DepartureHistory>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DepartureHistory>(departureHistory, HttpStatus.OK);
    }
 
     
     
    //-------------------Create Departure History--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/createDepartureHistory/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createDepartureHistory(@RequestBody DepartureHistory departureHistory,    UriComponentsBuilder ucBuilder) {
        logger.debug("Creating DepartureHistory " + departureHistory.getHistoryId());
 
        
        departureHistory.setDeparture(departureService.findByDepartureId(1l));
        
        if (departureHistoryService.isDepartureHistoryExist(departureHistory)) {
            logger.debug("A DepartureHistory with Id " + departureHistory.getHistoryId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        departureHistoryService.saveDepartureHistory(departureHistory);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/jbes2000/createDepartureHistory/{"
        		+ ""
        		+ "}").buildAndExpand(departureHistory.getHistoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update Departure History --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/updateDepartureHistory/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartureHistory> updateDepartureHistory(@RequestBody DepartureHistory departureHistory,  UriComponentsBuilder ucBuilder) {
        Long departureHistoryId = departureHistory.getHistoryId();
    	logger.debug("Updating Departure History " + departureHistoryId);
         
    	DepartureHistory currentDepartureHistory = departureHistoryService.findByDepartureHistoryId(departureHistoryId);
         
        if (currentDepartureHistory==null) {
            logger.debug("DepartureHistory with history Id " + departureHistory.getHistoryId() + " not found");
            return new ResponseEntity<DepartureHistory>(HttpStatus.NOT_FOUND);
        }
 
        currentDepartureHistory.setAction(departureHistory.getAction());
        currentDepartureHistory.setSentTo(departureHistory.getSentTo());
        currentDepartureHistory.setFileTo(departureHistory.getFileTo());
        currentDepartureHistory.setBfDate(departureHistory.getBfDate());
        currentDepartureHistory.setRaisedDate(departureHistory.getRaisedDate());
        currentDepartureHistory.setFormType(departureHistory.getFormType());
         
        departureHistoryService.updateDepartureHistory(currentDepartureHistory);
        return new ResponseEntity<DepartureHistory>(currentDepartureHistory, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete Departure History --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/deleteDepartureHistory/{historyId}", method = RequestMethod.DELETE)
    public ResponseEntity<DepartureHistory> deleteDepartureHistory(@PathVariable("historyId") long historyId) {
        logger.debug("Fetching & Deleting DepartureHistory with history id " + historyId);
 
        DepartureHistory departureHistory = departureHistoryService.findByDepartureHistoryId(historyId);
        if (departureHistory == null) {
            logger.debug("Unable to delete. DepartureHistory with historyId " + historyId + " not found");
            return new ResponseEntity<DepartureHistory>(HttpStatus.NOT_FOUND);
        }
 
        departureHistoryService.deleteDepartureHistoryById(historyId);
        return new ResponseEntity<DepartureHistory>(HttpStatus.NO_CONTENT);
    }

 
}