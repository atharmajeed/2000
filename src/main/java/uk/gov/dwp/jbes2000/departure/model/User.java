package uk.gov.dwp.jbes2000.departure.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	// The user's name
	@Column(name = "NAME")
	private String name;

	// The user's address
	@Column(name = "ADDRESS")
	private String address;

	// The user's email
	@Column(name = "EMAIL")
	private String email;

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	public User() {
	}

	public User(long id) {
		this.id = id;
	}

	public User(String name, String address, String email) {
		this.email = email;
		this.name = name;
		this.address = address;
	}

	// Getter and setter methods

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [name=").append(name).append("]");
        return builder.toString();
    }

}
