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

import uk.gov.dwp.jbes2000.departure.model.DepartureAuthorised;
import uk.gov.dwp.jbes2000.departure.service.DepartureAuthorisedService;
import uk.gov.dwp.jbes2000.departure.service.DepartureService;
 
@RestController
public class DepartureAuthorisedController {
 
	private Logger logger = LoggerFactory.getLogger(DepartureAuthorisedController.class);
	
    @Autowired
    DepartureAuthorisedService departureAuthorisedService;
    
    @Autowired
    DepartureService departureService;
    
 
    //-------------------Retrieve Departure Authorised--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/departureAuthorised/", method = RequestMethod.GET)
    public ResponseEntity<List<DepartureAuthorised>> getDepartureAuthorised() {
        List<DepartureAuthorised> departureAuthorisedList = departureAuthorisedService.getDepartureAuthorised();
        if(departureAuthorisedList.isEmpty()){
            return new ResponseEntity<List<DepartureAuthorised>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DepartureAuthorised>>(departureAuthorisedList, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Departure Authorised By Authorised Id--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/departureAuthorisedList/{departureAuthorisedId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartureAuthorised> getDepartureAuthorisedById(@PathVariable("departureAuthorisedId") long departureAuthorisedId) {
        logger.debug("Fetching Departure Authorised with departureAuthorisedId " + departureAuthorisedId);
        DepartureAuthorised departureAuthorised = departureAuthorisedService.findByDepartureAutorisedId(departureAuthorisedId);
        if (departureAuthorised == null) {
            logger.debug("Departure Authorised with departureAuthorisedId " + departureAuthorisedId + " not found");
            return new ResponseEntity<DepartureAuthorised>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DepartureAuthorised>(departureAuthorised, HttpStatus.OK);
    }
 
     
     
    //-------------------Create Departure Authorised--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/createDepartureAuthorised/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createDepartureAuthorised(@RequestBody DepartureAuthorised departureAuthorised,    UriComponentsBuilder ucBuilder) {
        logger.debug("Creating DepartureAuthorised " + departureAuthorised.getDepartureAuthId());
 
        
        departureAuthorised.setDeparture(departureService.findByDepartureId(1l));
        
/*        if (departureAuthorisedService.isDepartureAuthorisedExist(departureAuthorised)) {
            logger.debug("A DepartureAuthorised with Id " + departureAuthorised.getDepartureAuthId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
 
        departureAuthorisedService.saveDepartureAuthorised(departureAuthorised);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/jbes2000/createDepartureAuthorised/{"
        		+ ""
        		+ "}").buildAndExpand(departureAuthorised.getDepartureAuthId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update Departure Authorised --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/updateDepartureAuthorised/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartureAuthorised> updateDepartureAuthorised(@RequestBody DepartureAuthorised departureAuthorised,  UriComponentsBuilder ucBuilder) {
        long departureAuthorisedId = departureAuthorised.getDepartureAuthId();
    	logger.debug("Updating Departure Authorised " + departureAuthorisedId);
         
    	DepartureAuthorised currentDepartureAuthorised = departureAuthorisedService.findByDepartureAutorisedId(departureAuthorisedId);
         
        if (currentDepartureAuthorised==null) {
            logger.debug("DepartureAuthorised with authorised Id " + departureAuthorised.getDepartureAuthId() + " not found");
            return new ResponseEntity<DepartureAuthorised>(HttpStatus.NOT_FOUND);
        }
 
        currentDepartureAuthorised.setDays(departureAuthorised.getDays());
        currentDepartureAuthorised.setFromDate(departureAuthorised.getFromDate());
        currentDepartureAuthorised.setRate(departureAuthorised.getRate());
        currentDepartureAuthorised.setToDate(departureAuthorised.getToDate());
        currentDepartureAuthorised.setTotal(departureAuthorised.getTotal());

         
        departureAuthorisedService.updateDepartureAuthorised(currentDepartureAuthorised);
        return new ResponseEntity<DepartureAuthorised>(currentDepartureAuthorised, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete Departure Authorised --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/deleteDepartureAuthorised/{departureAuthorisedId}", method = RequestMethod.DELETE)
    public ResponseEntity<DepartureAuthorised> deleteDepartureAuthorised(@PathVariable("departureAuthorisedId") long departureAuthorisedId) {
        logger.debug("Fetching & Deleting DepartureAuthorised with authorised id " + departureAuthorisedId);
 
        DepartureAuthorised departureAuthorised = departureAuthorisedService.findByDepartureAutorisedId(departureAuthorisedId);
        if (departureAuthorised == null) {
            logger.debug("Unable to delete. DepartureAuthorised with authorised " + departureAuthorisedId + " not found");
            return new ResponseEntity<DepartureAuthorised>(HttpStatus.NOT_FOUND);
        }
 
        departureAuthorisedService.deleteDepartureAuthorisedById(departureAuthorisedId);
        return new ResponseEntity<DepartureAuthorised>(HttpStatus.NO_CONTENT);
    }

 
}