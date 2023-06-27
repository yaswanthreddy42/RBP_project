package com.movieApp.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.movieApp.demo.Model.UserDTO;




@RestController
@RequestMapping("call/consumer")
@CrossOrigin(origins="*")
public class ConsumerController {
	
	@Autowired
    private KafkaTemplate<String,UserDTO> kafkaTemplate;
	
	private UserDTO userdto;
	
	UserDTO userDTO = new UserDTO();
	@PostMapping("/login")
	public ResponseEntity<?> consumeLogin(@RequestBody UserDTO userdto) throws RestClientException,Exception
	{
		
	String baseUrl ="http://localhost:8084/auth/v1/login";
	
	RestTemplate restTemplate = new RestTemplate();
	
	ResponseEntity<Map<String,String>> result =null;
	try
	{
		result=restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(userdto), new ParameterizedTypeReference<Map<String,String>>(){});
	}
	catch(Exception e)
	{	
		return new ResponseEntity<String>("Login was not successful", HttpStatus.UNAUTHORIZED);
		
	}
	try {

        kafkaTemplate.send("userlog",userdto);

    } catch (Exception e) {

        System.out.println(e);
    }
	return new ResponseEntity<Map<String,String>>(result.getBody(), HttpStatus.OK);
		
	}
	
	private static HttpEntity<UserDTO> getHeaders(UserDTO userdto)
	{
		HttpHeaders header = new HttpHeaders();
		
		header.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<UserDTO>(userdto, header);
	}

}