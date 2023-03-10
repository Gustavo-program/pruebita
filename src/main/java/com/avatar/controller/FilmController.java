package com.avatar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avatar.dto.Film;
import com.avatar.dto.People;
import com.avatar.dto.Swapi;
import com.avatar.service.FilmsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FilmController {
	
	
	private final FilmsService service;
	
//	@GetMapping("/films")
//	public ResponseEntity<List<Swapi<Film>>> getAllFilms(){
//		return new ResponseEntity<>(service.getFilms(), HttpStatus.OK);
//	}
	
//	@GetMapping("/films")
//	public String ListaPeliculas(Model modelo){
//		List<Film> lista = (List<Film>)service.getFilms(new Swapi<Film>()).getResults();
//		modelo.addAttribute("peliculas", lista);
//		
////		for(Film films:lista) {
////			for (String text: films.getCharacters()) {
////				//ListaPersonas(modelo, text);
////			}
////		}
//		
////		List<Film> lista2 = new ArrayList<>();
////		lista2.addAll(lista);
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println("hola"+ lista.get(i).getEpisode_id());
//		}
		
		
	
	
		@GetMapping("/films")
		public String ListaPeliculas(Model modelo){
			modelo.addAttribute("peliculas", service.getFilms());
		
		return "peliculas";
	}
	
		
		
	@GetMapping("/films/{id}")
	//@ResponseBody
	public List<Film> getFilms(@PathVariable Integer id){
		return service.getFilm(id);
	}
	
	
	@GetMapping("/character")
	public String ListaPersona(Model modelo){
		//service.getPeopleUrl();
		//modelo.addAttribute("actores",service.getPeopleUrl());
		return "actores";
	}
	
	
	
	
	
//	public People persona(String url) {
//		return service.getPeopleUrl(url);
//	}
	
//	  @RequestMapping("/hola")
//	  public String hola(Model modelo) {
//	    
//	    
//	    modelo.addAttribute("mensaje","hola desde thymeleaf");
//	    return "peliculas";
//	  }
}
