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
package de.meisl.eisstockitems.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.meisl.eisstockitems.api.EisstockItemClient;
import de.meisl.eisstockitems.api.dto.Category;
import de.meisl.eisstockitems.api.dto.Item;
import de.meisl.eisstockitems.api.dto.Producer;

public class EisstockItemClient {

	private static final Logger log = LoggerFactory.getLogger(EisstockItemClient.class);
	private RestTemplate _restTemplate;
	private String url;

	/**
	 * Initializes a new Client
	 * 
	 * @param url
	 *            The URL of the server with an final slash, e.g.
	 *            <code>http://localhost:8080/</code>
	 */
	public EisstockItemClient(String url) {
		this.url = url;
		if (!this.url.endsWith("/")) {
			this.url += "/";
		}
		_restTemplate = new RestTemplate();
	}

	private List<Item> getItems(String path, List<Long> listWithCategoryIds) {
		List<Item> itemList = new ArrayList<Item>();
		try {
			Map<String, String> map = new HashMap<>();
			map.put("regNumber", path);
			
            String uri = new String(url + "/items");

			Item[] items =_restTemplate.postForObject(uri, listWithCategoryIds, Item[].class, map);
			
			itemList = Arrays.asList(items);
		}
		catch (RestClientException e) {
			log.error(e.getMessage(), e);
		}
		return itemList;
	}

	private List<Category> getCategories(String path) {
		Category[] items = _restTemplate.getForObject(url + "categories/" + path, Category[].class);
		List<Category> itemList = Arrays.asList(items);
		return itemList;
	}

	private List<Producer> getProducers(String path) {
		Producer[] items = _restTemplate.getForObject(url + "producers/" + path, Producer[].class);
		List<Producer> itemList = Arrays.asList(items);
		return itemList;
	}

	/**
	 * Gets a list of Items starting with a registration number. You can also specify a list of category IDs.
	 * 
	 * @param regId
	 * @param listWithCategoryIds
	 */
	public List<Item> getItemsByRegIdAndCategories(String regId, List<Long> listWithCategoryIds) {

		List<Item> itemList = getItems(regId, listWithCategoryIds);

		log.info("Get items for '" + regId + "'. " + itemList.size() + " found:" + itemList.toString());

		return itemList;
	}

	public List<Category> getCategories() {
		List<Category> categories = getCategories("");
		log.info("Get categories " + categories.size() + " found:" + categories.toString());

		return categories;

	}
}
