package com.cinema.client.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 3529690178887414067L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identification")
    private String identification;

    @Column(name = "date_birth")
    private Date dob;

    public Client() {
    }

    public Client(String firstName, String lastName, Date dob) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
    }

    public Client(String firstName, String lastName, String identification, Date dob) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.identification = identification;
	this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Client client = (Client) o;
	return Objects.equals(id, client.id) &&
			Objects.equals(identification, client.identification);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, identification);
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getIdentification() {
	return identification;
    }

    public void setIdentification(String identification) {
	this.identification = identification;
    }

    public Date getDob() {
	return dob;
    }

    public void setDob(Date dob) {
	this.dob = dob;
    }
}
