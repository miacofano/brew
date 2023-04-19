package com.java.brew.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="beans")
public class Bean {

	//TABLE & VALIDATORS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name required")
	private String name;
	
	@NotBlank(message="Brand required")
	private String brand;
	
	@NotBlank(message="Region required")
	private String region;
	
	@NotBlank(message="Roast required")
	private String roast;
	
	@NotNull(message="Price required")
	private Integer price;
	
	@NotBlank(message="Brew method required")
	private String brew;
	
	@NotNull(message="Rating required")
	@Min(value = 0, message = "Must be greater than 0")
	@Max(value = 10, message = "Must be less than 10")
	private Integer rating;
	
	@NotBlank(message="Flavor profile required")
	private String flavor;
	
	//TIME STAMPS
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	    
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	
	//RELATIONS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    //OBJECT
    public Bean() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRoast() {
		return roast;
	}
	public void setRoast(String roast) {
		this.roast = roast;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getBrew() {
		return brew;
	}
	public void setBrew(String brew) {
		this.brew = brew;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
