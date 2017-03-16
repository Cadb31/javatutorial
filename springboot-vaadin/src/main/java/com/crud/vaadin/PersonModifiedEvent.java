package com.crud.vaadin;

import java.io.Serializable;

import com.crud.backend.Person;

public class PersonModifiedEvent implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Person person;

    public PersonModifiedEvent(Person p) {
        this.person = p;
    }

    public Person getPerson() {
        return person;
    }
    
}
