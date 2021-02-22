package com.example.product.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.product.exception.ProductNotFoundException;
import com.example.product.models.Product;
import com.example.product.repository.MydomainRespository;

@RestController
@RequestMapping("/product")
@ComponentScan

public class ProductController {

	@Autowired
	MydomainRespository mydomainRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping("/index")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/{id}")
	public Optional<Object> getProduct(@PathVariable String id) {
		System.out.println("Inside get");
		if (mydomainRepository.existsById(id)) {
			//System.out.print("I am inside IF loop and Id is " + id);
			System.out.println("JSON :::"+mydomainRepository.findById(id));
			return mydomainRepository.findById(id).map(jsonArray -> jsonArray.toString());
		} else
			System.out.println("JSON ::: is empty");
		return null;
	}


	@PostMapping("/")
	public Product addProduct(@RequestBody Product myDomainDocument) {
		return mydomainRepository.save(myDomainDocument);
	}

	@PutMapping("/{id}")
	public Optional<Object>  updateProduct(@PathVariable String id, @RequestBody Product myDomainDocument){
		System.out.println("Inside Update product" + myDomainDocument.toString());
		if(mydomainRepository.existsById(id)){
			mydomainRepository.findById(id).map(jsonArray -> myDomainDocument);
			//System.out.println("JSON :::"+mydomainRepository.findById(id));
			mydomainRepository.save(myDomainDocument);
			return mydomainRepository.findById(id).map(jsonArray -> jsonArray.toString());
		}else
			System.out.println("No product exists with this id" + id);
		return null;
	}


	@RequestMapping(value = "/exception/{id}", method = RequestMethod.GET)

	public ResponseEntity<Object> getProductException(@PathVariable("id") String id) {
		LOGGER.info("response:::::"+mydomainRepository.findById(id));
		if((mydomainRepository.findById(id) != null))throw new ProductNotFoundException();
		return new ResponseEntity<>(mydomainRepository.findById(id), HttpStatus.OK);
	}

/*
	@RequestMapping(value = "/exception/{id}", method = RequestMethod.PUT)

	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		LOGGER.info("response:::::"+mydomainRepository.findById(id)+"request::::::"+product);

		List<String> prices = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		product.builder()
				.prices(prices);
	 .id(product.getId());
				//.name(product.getName()
						.
				)
		mydomainRepository.save(product);
		if((mydomainRepository.findById(id).isEmpty())) {
			throw new ProductNotFoundException();
		}
		return new ResponseEntity<>(mydomainRepository.findById(id), HttpStatus.OK);
	}

 */

}