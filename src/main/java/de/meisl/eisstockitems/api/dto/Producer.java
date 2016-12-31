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
