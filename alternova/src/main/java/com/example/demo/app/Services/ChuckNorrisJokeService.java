package com.example.demo.app.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChuckNorrisJokeService {
	
	public String getChuckNorrisJoke() throws IOException, InterruptedException{
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.chucknorris.io/jokes/random"))
				.GET().build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		if(response.statusCode() == 200) {
			ObjectMapper object = new ObjectMapper();
			JsonNode node = object.readTree(response.body());
			//to get joke of Json Object
			return node.get("value").asText();
		}
		return null;
		
	}

}
