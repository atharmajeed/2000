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

import uk.gov.dwp.jbes2000.departure.model.Departure;
import uk.gov.dwp.jbes2000.departure.service.DepartureService;
 
@RestController
public class DepartureController {
 
	private Logger logger = LoggerFactory.getLogger(DepartureController.class);
	
    @Autowired
    DepartureService departureService;
    
 
    //-------------------Retrieve Departure --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/Departure/", method = RequestMethod.GET)
    public ResponseEntity<List<Departure>> getDeparture() {
        List<Departure> DepartureList = departureService.getDeparture();
        if(DepartureList.isEmpty()){
            return new ResponseEntity<List<Departure>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Departure>>(DepartureList, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Departure By departure Id--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/Departure/{departureId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Departure> getDepartureById(@PathVariable("departureId") long departureId) {
    	logger.debug("Fetching Departure with departureId " + departureId);
        Departure Departure = departureService.findByDepartureId(departureId);
        if (Departure == null) {
            logger.debug("Departure with departureId " + departureId + " not found");
            return new ResponseEntity<Departure>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Departure>(Departure, HttpStatus.OK);
    }
 
     
     
    //-------------------Create Departure --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/createDeparture/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createDeparture(@RequestBody Departure Departure,    UriComponentsBuilder ucBuilder) {
    	logger.debug("Creating Departure ");
 
        if (departureService.isDepartureExist(Departure)) {
            logger.debug("A Departure with Id " + Departure.getDepartureId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        departureService.saveDeparture(Departure);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/jbes2000/createDeparture/{"
        		+ ""
        		+ "}").buildAndExpand(Departure.getDepartureId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update Departure --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/updateDeparture/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Departure> updateDeparture(@RequestBody Departure departure,  UriComponentsBuilder ucBuilder) {
        Long DepartureId = departure.getDepartureId();
        logger.debug("Updating Departure " + DepartureId);
         
    	Departure currentDeparture = departureService.findByDepartureId(DepartureId);
         
        if (currentDeparture==null) {
            logger.debug("Departure with departure Id " + departure.getDepartureId() + " not found");
            return new ResponseEntity<Departure>(HttpStatus.NOT_FOUND);
        }
 
        currentDeparture.setCountry(departure.getCountry());
        currentDeparture.setDepartureDate(departure.getDepartureDate());
        currentDeparture.setDlj401Rec(departure.getDlj401Rec());
        currentDeparture.setWeedDate(departure.getWeedDate());
        
        departureService.updateDeparture(currentDeparture);
        return new ResponseEntity<Departure>(currentDeparture, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete Departure --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/deleteDeparture/{departureId}", method = RequestMethod.DELETE)
    public ResponseEntity<Departure> deleteDeparture(@PathVariable("departureId") long departureId) {
    	logger.debug("Fetching & Deleting Departure with departure id " + departureId);
 
        Departure Departure = departureService.findByDepartureId(departureId);
        if (Departure == null) {
            logger.debug("Unable to delete. Departure with departureId " + departureId + " not found");
            return new ResponseEntity<Departure>(HttpStatus.NOT_FOUND);
        }
 
        departureService.deleteDepartureById(departureId);
        return new ResponseEntity<Departure>(HttpStatus.NO_CONTENT);
    }

 
}