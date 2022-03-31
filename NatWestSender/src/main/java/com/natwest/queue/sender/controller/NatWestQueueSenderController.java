package com.natwest.queue.sender.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.queue.sender.dto.TransactionDTO;
import com.natwest.queue.sender.util.Utility;

@RestController
@CrossOrigin
public class NatWestQueueSenderController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NatWestQueueSenderController.class);
	
	@Autowired
	ObjectMapper mapper;

	@PostMapping(value = "/saveTransaction")
	public ResponseEntity<?> getTransactionDetails(@RequestBody String requestJson){
		TransactionDTO transaction = null;
		try {
			transaction = mapper.readValue(requestJson, TransactionDTO.class);
		} catch (JsonMappingException e) {
			LOGGER.error("Unable to map requestJson to transaction DTO, {}",e.getMessage());
		} catch (JsonProcessingException e) {
			LOGGER.error("Unable to process requestJson, ",e.getMessage());
		}
		if(transaction!=null) {
			return new ResponseEntity<>(Utility.encryptObject(transaction), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
