package uk.gov.dwp.jbes2000.departure.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 */
@Entity
@Table(name = "person")
public class Person implements Serializable{

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID", nullable = false)
	private Long personId;
	

	
	@Column(name = "NAME")
	private Long name;
	
	@Column(name = "NI_NUMBER")
	private int niNumber;
	
	//@OneToMany(mappedBy="person",targetEntity=Departure.class,fetch=FetchType.EAGER)
	//private Collection<Departure> Departures;

	
	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * @return the name
	 */
	public Long getName() {
		return name;
	}

	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Long name) {
		this.name = name;
	}

	/**
	 * @return the niNumber
	 */
	public int getNiNumber() {
		return niNumber;
	}

	/**
	 * @param niNumber the niNumber to set
	 */
	public void setNiNumber(int niNumber) {
		this.niNumber = niNumber;
	}
/*
	*//**
	 * @return the departures
	 *//*
	public Collection<Departure> getDepartures() {
		return Departures;
	}

	*//**
	 * @param departures the departures to set
	 *//*
	public void setDepartures(Collection<Departure> departures) {
		Departures = departures;
	}*/
	
}
