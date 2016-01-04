package uk.gov.dwp.jbes2000.departure.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * An entity Departure composed by three fields (id, country, dlj401Rec, weeddate).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 */
@Entity
@Table(name = "departure")
public class Departure implements Serializable{

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTURE_ID")
	private Long departureId;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "DLJ401_REC")
	private Long dlj401Rec;
	
	@Column(name = "DEPARTURE_DATE")
	private Date departureDate;
	
	@Column(name = "WEED_DATE")
	private Date weedDate;
	
	@OneToMany(mappedBy="departure",cascade = CascadeType.ALL, fetch=FetchType.EAGER) //targetEntity=DepartureHistory.class,fetch=FetchType.EAGER)
	private Collection<DepartureHistory> departureHistory;

	@OneToMany(mappedBy="departure",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<DepartureAuthorised> departureAuthorised;
	
	// ------------------------
	// PUBLIC METHODS
	// ------------------------
	/**
	 * @return the departureId
	 */
	public Long getDepartureId() {
		return departureId;
	}

	/**
	 * @param departureId the departureId to set
	 */
	public void setDepartureId(Long departureId) {
		this.departureId = departureId;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the dlj401Rec
	 */
	public Long getDlj401Rec() {
		return dlj401Rec;
	}

	/**
	 * @param dlj401Rec the dlj401Rec to set
	 */
	public void setDlj401Rec(Long dlj401Rec) {
		this.dlj401Rec = dlj401Rec;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the weedDate
	 */
	public Date getWeedDate() {
		return weedDate;
	}

	/**
	 * @param weedDate the weedDate to set
	 */
	public void setWeedDate(Date weedDate) {
		this.weedDate = weedDate;
	}

	/**
	 * @return the departureHistory
	 */
	public Collection<DepartureHistory> getDepartureHistory() {
		return departureHistory;
	}

	/**
	 * @param departureHistory the departureHistory to set
	 */
	public void setDepartureHistory(Collection<DepartureHistory> departureHistory) {
		this.departureHistory = departureHistory;
	}

	/**
	 * @return the departureAuthorised
	 */
	public Collection<DepartureAuthorised> getDepartureAuthorised() {
		return departureAuthorised;
	}

	/**
	 * @param departureAuthorised the departureAuthorised to set
	 */
	public void setDepartureAuthorised(Collection<DepartureAuthorised> departureAuthorised) {
		this.departureAuthorised = departureAuthorised;
	}
	
	
}
