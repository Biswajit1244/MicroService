package com.biss.controller.rest;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biss.model.Product;
import com.biss.service.IProductService;

@RestController
@RequestMapping("/prod")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {
	@Autowired
	private IProductService ser;
	
	//Save product
	@PostMapping("/insert")
	ResponseEntity<String> saveProduct(@RequestBody Product prod){
		 ResponseEntity<String> resp=null;
		 try {
			 Integer id=ser.saveProduct(prod);
			resp=ResponseEntity.ok("Product "+id+" Saved");
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Save",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	//get one product
	@GetMapping("/one/{id}")
	ResponseEntity<?> getOneProduct(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
		try {
			Optional<Product> op=ser.getOneProduct(id);
			if(op.isPresent()) {
				resp=new ResponseEntity<Product>(op.get(),HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("NO DATA FOUND",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String> ("Unable To Fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
		
	}
	//get all product
	@GetMapping("/all")
	ResponseEntity<?> getAllProduct(){
		ResponseEntity<?> resp=null;
		try {
			List<Product> list=ser.getAllProduct();
			if(list!=null && !list.isEmpty()) {
				resp=new ResponseEntity<List<Product>>(list,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("No Data found",HttpStatus.OK);			
			}

		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch Record",HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return resp;
	}
	//Delete product
	@DeleteMapping("/remove/{id}")
	ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			Boolean exist=ser.isExit(id);
			if(exist) {
				ser.deleteOneProd(id);
				resp=new ResponseEntity<String>(id+" deleted",HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>(id+" no record not found",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to delete the record",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	//update product
	@PutMapping("/update")
	ResponseEntity<String> updateProd(@RequestBody Product prod){
		ResponseEntity<String> resp=null;
		try {
			boolean exist=ser.isExit(prod.getProdId());
			if(exist) {
				ser.saveProduct(prod);
				resp=new ResponseEntity<String>(prod.getProdId()+" data updated",HttpStatus.OK);
			}else {
			resp=new ResponseEntity<String>(prod.getProdId()+" data not found",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("unable to updated data",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
