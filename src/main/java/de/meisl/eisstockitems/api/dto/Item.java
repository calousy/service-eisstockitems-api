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

import de.meisl.eisstockitems.api.dto.Category;
import de.meisl.eisstockitems.api.dto.Producer;

/**
 * Item
 * @author kmeisl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private Long id;

	private Date registrationDate; // Erstzulassung

	private Date sellingProhibited; // Verkaufsverbot

	private Date expired;

	private Date productionCeased;

	private Date sellingCeased;

	private Date updated;

	private String regNumber;

	private String remark;

	private Category category;

	private Producer producer;

	/**
	 * Gets the registration ID of the item
	 * @return the registration ID
	 */
	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	/**
	 * Gets the initial registration date of the item.
	 * @return The initial registration date
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * Gets the date when selling the item was prohibited.
	 * @return The initial registration date
	 */
	public Date getSellingProhibited() {
		return sellingProhibited;
	}

	public void setSellingProhibited(Date sellingProhibited) {
		this.sellingProhibited = sellingProhibited;
	}

	/**
	 * Gets the date when the item expires.
	 * @return The expiration date
	 */
	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

	/**
	 * Gets the date when item production has been ceased.
	 * @return The production cease date
	 */
	public Date getProductionCeased() {
		return productionCeased;
	}

	public void setProductionCeased(Date productionCeased) {
		this.productionCeased = productionCeased;
	}

	/**
	 * Gets the date when item selling has been ceased.
	 * @return The selling cease date
	 */
	public Date getSellingCeased() {
		return sellingCeased;
	}

	public void setSellingCeased(Date sellingCeased) {
		this.sellingCeased = sellingCeased;
	}

	/**
	 * Gets a remark.
	 * @return Remark
	 */
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getUpdated() {
		return updated;
	}

	public Long getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		return String.format("[Item: (%s) %s, '%s']", getId(), getRegNumber(), getRemark());
	}
}
