package com.ensim.tp3.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.ensim.tp3.demo.model.AddressResponse;
import com.ensim.tp3.demo.model.MeteoResponse;
import com.ensim.tp3.demo.model.Weather;
import com.ensim.tp3.demo.repository.AddressRepository;

@Controller
public class MeteoController {

	@Autowired
	AddressRepository addressRepository;

	
	@Autowired
	RestTemplate restTemplate ;
	
	String METEO_API_TOKEN = "60b09614a09207cc47e044eee4613f41822fa3e1f83bdc6205155ff1a92be0bf";
	@GetMapping(value = "/meteo")
	public String showMeteoPage(ModelMap model) {

		return "addAddresse";
	}

	@PostMapping("/meteo")
	public String handleMeteoForm(@RequestParam("address") String address, Model model) {
		List<Double> coords = ( getCoords(address).getFeatures()).get(0).getGeometry().getCoordinates();
		double lon = coords.get(0);
		double lat = coords.get(1);
		Weather meteoRep =	Weather.values()[getForecast(lat,lon).getForecast().get(0).getWeather()];
		System.out.println(meteoRep);
		model.addAttribute("lat", lat);
		model.addAttribute("lon", lon);
		model.addAttribute("weather", meteoRep);
		model.addAttribute("temp", getForecast(lat,lon).getForecast().get(0).getTmin());

		model.addAttribute("city", getForecast(lat,lon).getCity().getName());
		model.addAttribute("wind",getForecast(lat,lon).getForecast().get(0).getWind10m());


		return "meteo";
	}

	public AddressResponse getCoords(String address) {
		String url = "https://api-adresse.data.gouv.fr/search/?q=" + address;
		ResponseEntity<AddressResponse> response = restTemplate.exchange(url, HttpMethod.GET, null,
				AddressResponse.class);
		AddressResponse addressResponse = response.getBody();
		return addressResponse;
	}
	
	
	public MeteoResponse getForecast(double latitude, double longitude) {
		String url = "https://api.meteo-concept.com/api/forecast/daily?token="+METEO_API_TOKEN+"&latlng="+latitude+","+longitude+"&world=false&start=0&end=1";
    	System.out.println("INFO:"+ url);

    	ResponseEntity<MeteoResponse> response = restTemplate.exchange(url, HttpMethod.GET, null,
    			MeteoResponse.class);
    	MeteoResponse meteoResponse = response.getBody();
		return meteoResponse;
    }
	
}
