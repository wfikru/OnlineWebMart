package edu.mum.cs490.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ADMIN")
public class Admin extends SystemUser implements Serializable{

}
