package uk.gov.dwp.jbes2000.departure.model;

import java.io.Serializable;
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
@Table(name = "departure_history")
public class DepartureHistory implements Serializable{

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HISTORY_ID")
	private Long historyId;
	
    @ManyToOne
    @JoinColumn(name="departure",referencedColumnName="DEPARTURE_ID")
    @JsonIgnore
    private Departure departure;
	
	@Column(name = "FORM_TYPE")
	private int formType;
	
	@Column(name = "RAISED_DATE")
	private Date raisedDate;
	
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "SENTTO")
	private String sentTo;
	
	@Column(name = "FILETO")
	private String fileTo;
	
	@Column(name = "BFDATE")
	private Date bfDate;

	
	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * @return the historyId
	 */
	public Long getHistoryId() {
		return historyId;
	}

	/**
	 * @param historyId
	 *            the historyId to set
	 */
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	/**
	 * @return the departure
	 */
	public Departure getDeparture() {
		return departure;
	}

	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(Departure departure) {
		this.departure = departure;
	}

	/**
	 * @return the formType
	 */
	public int getFormType() {
		return formType;
	}

	/**
	 * @param formType
	 *            the formType to set
	 */
	public void setFormType(int formType) {
		this.formType = formType;
	}

	/**
	 * @return the raisedDate
	 */
	public Date getRaisedDate() {
		return raisedDate;
	}

	/**
	 * @param raisedDate
	 *            the raisedDate to set
	 */
	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the sentTo
	 */
	public String getSentTo() {
		return sentTo;
	}

	/**
	 * @param sentTo
	 *            the sentTo to set
	 */
	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	/**
	 * @return the fileTo
	 */
	public String getFileTo() {
		return fileTo;
	}

	/**
	 * @param fileTo
	 *            the fileTo to set
	 */
	public void setFileTo(String fileTo) {
		this.fileTo = fileTo;
	}

	/**
	 * @return the bfDate
	 */
	public Date getBfDate() {
		return bfDate;
	}

	/**
	 * @param bfDate
	 *            the bfDate to set
	 */
	public void setBfDate(Date bfDate) {
		this.bfDate = bfDate;
	}

}
