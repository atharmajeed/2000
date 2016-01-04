package uk.gov.dwp.jbes2000.departure.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 */
@Entity
@Table(name = "departure_authorised")
public class DepartureAuthorised implements Serializable{

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTH_ID")
	private Long departureAuthId;
	
    @ManyToOne
    @JoinColumn(name="departure",referencedColumnName="DEPARTURE_ID")
    @JsonIgnore
    private Departure departure;
	
	@Column(name = "FROM_DATE")
	private Date fromDate;
	
	@Column(name = "TO_DATE")
	private Date toDate;
	
	@Column(name = "DAYS")
	private int days;
	
	@Column(name = "RATE")
	private Double rate;
	
	@Column(name = "TOTAL")
	private Double total;
	
	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * @return the departure
	 */
	public Departure getDeparture() {
		return departure;
	}

	/**
	 * @return the departureAuthId
	 */
	public Long getDepartureAuthId() {
		return departureAuthId;
	}




	/**
	 * @param departureAuthId the departureAuthId to set
	 */
	public void setDepartureAuthId(Long departureAuthId) {
		this.departureAuthId = departureAuthId;
	}




	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(Departure departure) {
		this.departure = departure;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * @return the rate
	 */
	public Double getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
