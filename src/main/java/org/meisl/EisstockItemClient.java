package org.meisl;

import java.util.Arrays;
import java.util.List;

import org.meisl.dto.Category;
import org.meisl.dto.Item;
import org.meisl.dto.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class EisstockItemClient {

	private static final Logger log = LoggerFactory.getLogger(EisstockItemClient.class);
	private RestTemplate _restTemplate;
	private String url;

	/**
	 * Initializes a new Client
	 * @param url The URL of the server with an final slash, e.g. <code>http://localhost:8080/</code>
	 */
	public EisstockItemClient(String url) {
		this.url = url;
		if (!this.url.endsWith("/")) {
			this.url += "/";
		}
		_restTemplate = new RestTemplate();
	}

	private List<Item> getItems(String path) {
		Item[] items = _restTemplate.getForObject(url + "items/" + path, Item[].class);
		List<Item> itemList = Arrays.asList(items);
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
	 * Gets a list of Items.
	 * @param regId
	 */
	public List<Item> getItemByRegId(String regId) {

		List<Item> itemList = getItems(regId);

		log.info(itemList.toString());

		return itemList;
	}
}
