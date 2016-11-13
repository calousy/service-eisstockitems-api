package org.meisl.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Producer {

	private Long id;

	private String ifiPartnerId;

	private String name;

//	@OneToMany(mappedBy = "producer")
//	private Collection<Item> items = new ArrayList<Item>();
	
	private Date updated;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfiPartnerId() {
		return ifiPartnerId;
	}

	public void setIfiPartnerId(String ifiPartnerId) {
		this.ifiPartnerId = ifiPartnerId;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	@Override
	public String toString() {
		return String.format("[Producer: (%s) %s]", getId(), getName());
	}

//	public Collection<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(Collection<Item> items) {
//		this.items = items;
//	}
}
