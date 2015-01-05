package edu.mum.cs490.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "CATEGORY")
public class Category {
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int id; 
	
	@Column(name = "cat_name")
	private String name;
	
	@Column(name = "cat_image")
	private Byte[] image;
	
	@Column(name = "cat_description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "CATEGORY")
	//private List<Product> product;
	
	
}
