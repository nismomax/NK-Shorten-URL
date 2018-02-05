package com.nk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nk.model.ServiceResponse;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;

@Controller
public class MainController {
	
	final String bitlyToken = "fd0c170d432bbdfaeb758a7e5764f70fa363f8f3";
	
	@GetMapping("/")
	public String index(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "main";
	}
	
	@RequestMapping(value = "/api/shorten", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getShortenLink(@RequestBody String link) {
		ServiceResponse response = new ServiceResponse();
		BitlyClient client = new BitlyClient(bitlyToken);
		Response<ShortenResponse> respShort  = client.shorten().setLongUrl(link).call();
		if(respShort.deserialize_error) {
			response.setCode("0");
			response.setData(respShort.status_txt);
			return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
		}
		
		response.setCode("1");
		response.setData(respShort.data.url);
		return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
	}

}
