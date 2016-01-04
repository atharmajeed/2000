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
import uk.gov.dwp.jbes2000.departure.model.User;
import uk.gov.dwp.jbes2000.departure.service.UserRegistrationService;
 
@RestController
public class UserRegistrationRestController {
 
	private Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
	
    @Autowired
    UserRegistrationService userRegistrationService;  //Service which will do all data retrieval/manipulation work
 
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRegistrationService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        logger.debug("Fetching User with id " + id);
        User user = userRegistrationService.findById(id);
        if (user == null) {
            logger.debug("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        logger.debug("Creating User " + user.getName());
 
        if (userRegistrationService.isUserExist(user)) {
            logger.debug("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userRegistrationService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/jbes2000/user/{"
        		+ ""
        		+ "}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/updateUser/", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user,  UriComponentsBuilder ucBuilder) {
        Long userId = user.getId();
    	logger.debug("Updating User " + userId);
         
        User currentUser = userRegistrationService.findById(userId);
         
        if (currentUser==null) {
            logger.debug("User with id " + userId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userRegistrationService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        logger.debug("Fetching & Deleting User with id " + id);
 
        User user = userRegistrationService.findById(id);
        if (user == null) {
            logger.debug("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userRegistrationService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/jbes2000/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        logger.debug("Deleting All Users");
 
        userRegistrationService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
}