package com.urlBackend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.urlBackend.api.model.urlData;
import com.urlBackend.api.repository.urlRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class urlController {

	@Autowired
	public urlRepository repository;
	
	@GetMapping(value="/all")
	public List<urlData> getAllurl(){
		
		return repository.findAll();
	}
	
	@PostMapping(value="/create")
	public String createurl(@RequestBody urlData data) {
		
		urlData urldata=repository.insert(data);
		return "URL succesfully Added with Id :-" + urldata.getId();
	}
	
	@PutMapping(value="/update/{id}")
	public String update(@PathVariable("id") String id, @RequestBody urlData data) {
		
		Optional<urlData> urldataoptional = repository.findById(id);
		if(urldataoptional.isPresent())
		{
			urlData savedData=urldataoptional.get();
			savedData.setCount(data.getCount());
			savedData.setLongurl(data.getLongurl());
			savedData.setShorturl(data.getShorturl());
			repository.save(savedData);
			return "Updated";
		}
		else
		{
			return "Something Went Wrong";
		}
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		String showid=id;
		repository.deleteById(id);
		return "Deleted url with this ID :- "+showid;
	}
}
