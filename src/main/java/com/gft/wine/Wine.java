package com.gft.wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "wine")
public class Wine {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;	
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@Range(min=1900, max= 2022)
	private String year;
	@NotNull
	@Min(0)
	@Range(min=0, max=5)
	private Double rating;
	@NotNull
	@Min(0)
	private Integer num_reviews;
	@NotNull
	@Min(0)
	private Double price;
	@NotNull
	@Range(min=1, max=5)
	private String body;
	@NotNull
	@Range(min=1, max=5)
	private String acidity;
	@NotNull
	@ManyToOne
    @JoinColumn(name = "winery_id")
    private Winery winery;
	@NotNull
	@ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
	@NotNull
	@ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
	
    
    public Wine() {
		
	}


	public Wine(Integer id, String name, String year, Double rating, Integer num_reviews, Double price, String body,
			String acidity, Winery winery, Type type, Region region) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.num_reviews = num_reviews;
		this.price = price;
		this.body = body;
		this.acidity = acidity;
		this.winery = winery;
		this.type = type;
		this.region = region;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public Integer getNum_reviews() {
		return num_reviews;
	}


	public void setNum_reviews(Integer num_reviews) {
		this.num_reviews = num_reviews;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getAcidity() {
		return acidity;
	}


	public void setAcidity(String acidity) {
		this.acidity = acidity;
	}


	public Winery getWinery() {
		return winery;
	}


	public void setWinery(Winery winery) {
		this.winery = winery;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating + ", num_reviews="
				+ num_reviews + ", price=" + price + ", body=" + body + ", acidity=" + acidity + ", winery=" + winery
				+ ", type=" + type + ", region=" + region + "]";
	}


    
}	
    