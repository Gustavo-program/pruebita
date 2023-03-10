package com.avatar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.avatar.dto.Film;
import com.avatar.dto.People;
import com.avatar.dto.Swapi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmsService {

//	@Value("${spring.external.service.base-url}")
//	private String baseUrl;

	private final RestTemplate restTemplate;

//	public Swapi<Film> getFilms(Swapi<Film> films){
//		Swapi<Film> response = restTemplate.getForObject("https://swapi.dev/api/films", films.getClass());
//		return response;
//	}
	
	public Swapi<Film> getFilms(){
		
		Swapi<Film> response = restTemplate.getForObject("https://swapi.dev/api/films", Swapi.class);
		
		return response;
		//ArrayList people = new ArrayList<>();
		//ArrayList<Film> film = new ArrayList<Film>();
		//film.add((Film) response.getResults());
		
//		for (int i = 0; i < film.size(); i++) {
//			System.out.println(film.get(i).getCharacters());
//		}
//		System.out.println(response);
//		Swapi<Film> listafilm = new ArrayList<>();
//		//Swapi<Film>[] arrayObjetos=new Swapi[0];
//		listafilm=response;
//		for(Film cadena:arrayObjetos) {
//		      System.out.println(cadena);
//		      }
		
		//System.out.println(response.getResults());
		
		
		
	}


	public List<Film> getFilm(int id) {
		Film response = restTemplate.getForObject("https://swapi.dev/api/films/" + id, Film.class);
		return Arrays.asList(response);
	}
	
	
	public People getPeopleUrl(String url) {
		
		People response = restTemplate.getForObject(url, People.class);
		System.out.println(response.getName());
		return response;
	}
	
	

}
