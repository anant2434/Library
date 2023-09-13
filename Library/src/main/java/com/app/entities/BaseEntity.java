package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;


public BaseEntity() {
	super();
	// TODO Auto-generated constructor stub
}


public Long getId() {
	return Id;
}


public void setId(Long id) {
	Id = id;
}


}
