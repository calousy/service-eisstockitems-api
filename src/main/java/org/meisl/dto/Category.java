package org.meisl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Item category
 * @author kmeisl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
	private Long id;

	private String name;
	
//	@OneToMany(mappedBy="category")
//	private Collection<Item> items;

	/**
	 * Gets the name of the category
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
}
