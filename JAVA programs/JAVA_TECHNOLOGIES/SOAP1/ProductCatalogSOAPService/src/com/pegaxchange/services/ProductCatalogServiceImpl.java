package com.pegaxchange.services;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogServiceImpl {
	private static List<Product> productCatalog;
	
	public ProductCatalogServiceImpl() {
		initializeProductCatalog();
	}
	public Product searchById(int id) throws Exception{
		for(Product p: productCatalog) {
			if(p.getId()== id) {
				return p;
			}
		}
		throw new Exception("No product found with id = " + id);
	}
	
	
	public Product[] getAllProducts() {
		Product [] products = new Product[productCatalog.size()];
		
		int i = 0 ;
		for(Product p : productCatalog) {
			products[i] = p;
			i++;
		}
		
		return products;
		
		
	}
	
	public void insertProduct(Product product) {
		productCatalog.add(product);
	}
	
	private void initializeProductCatalog() {
		if(productCatalog == null){
			productCatalog = new ArrayList<Product>();
			productCatalog.add(new Product(1,"Keybord","Electronics",29.99D));
			productCatalog.add(new Product(2, "Mouse", "Electronics", 9.95D));
	        productCatalog.add(new Product(3, "17\" Monitor", "Electronics", 159.49D));
	        productCatalog.add(new Product(4, "Hammer", "Hardware", 9.95D));
	        productCatalog.add(new Product(5, "Slot Screwdriver", "Hardware", 7.95D));
	        productCatalog.add(new Product(6, "The British Invasion of Java", "Books", 11.39D));
	        productCatalog.add(new Product(7, "A House in Bali", "Books", 15.99D));
	        productCatalog.add(new Product(8, "An Alaskan Odyssey", "Books", 799.99D));
	        productCatalog.add(new Product(9, "LCD Projector", "Electronics", 1199.19D));
			
		}
	}
}

