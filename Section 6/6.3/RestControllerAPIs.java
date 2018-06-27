package com.javasampleapproach.webflux.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.webflux.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/api/customer")
public class RestControllerAPIs {
	
	Map<Long, Customer> custStores = new HashMap<Long, Customer>();
	
    @PostConstruct
    public void initIt() throws Exception {
        custStores.put(Long.valueOf(1), new Customer(1, "Jack", "Smith", 20));
        custStores.put(Long.valueOf(2), new Customer(2, "Peter", "Johnson", 25));
    }
	
    @GetMapping("/")
    public Flux<Customer> getAll() {
    	return Flux.fromIterable(custStores.entrySet().stream()
    	        										.map(entry -> entry.getValue())
    	        										.collect(Collectors.toList()));
    }
    
	@GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable Long id) {
		return Mono.justOrEmpty(custStores.get(id));
    }
	
	
	@PostMapping("/post")
    public Mono<ResponseEntity<String>> postCustomer(@RequestBody Customer customer){
		// do post
		custStores.put(customer.getCustId(), customer);
		
		// log on console
		System.out.println("########### POST:" + customer);
				
		return Mono.just(new ResponseEntity<>("Post Successfully!", HttpStatus.CREATED));
	}
	
	@PutMapping("/put/{id}")
	public Mono<ResponseEntity<Customer>> putCustomer(@PathVariable Long id, @RequestBody Customer customer){
		// reset customer.Id
		customer.setCustId(id);
		
		custStores.put(id, customer);
		
		// log on console
		System.out.println("########### PUT:" + customer);
		
		return Mono.just(new ResponseEntity<>(customer, HttpStatus.CREATED));
	}
	
	@DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteMethod(@PathVariable Long id) {
		// delete processing
    	custStores.remove(id);
    	return Mono.just(new ResponseEntity<>("Delete Succesfully!", HttpStatus.ACCEPTED));
    }
}
