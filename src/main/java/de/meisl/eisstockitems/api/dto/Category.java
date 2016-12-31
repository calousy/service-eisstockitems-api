/**
 * service-eisstockitems-api, an API for easier access to service-eisstockitems
 * 
 * Copyright (C) 2016 Klaus Meisl <info@klaus-meisl.de>
 * 
 * This file is part of service-eisstockitems-api.
 * 
 * service-eisstockitems-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * service-eisstockitems-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with service-eisstockitems-api.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @license GPL-3.0+ <http://spdx.org/licenses/GPL-3.0+>
 */
package de.meisl.eisstockitems.api.dto;

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
	
	@Override
	public String toString() {
		return String.format("[Category: (%s) %s]", getId(), getName());
	}
}
