package com.karima.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    private final String API_URL = "http://localhost:5000";

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/file-error")
    public String fileError(Model model) {
        return callApi("/api/file-error", model);
    }

    @GetMapping("/db-error")
    public String dbError(Model model) {
        return callApi("/api/db-error", model);
    }

    @GetMapping("/pokemon-error")
    public String pokemonError(Model model) {
        return callApi("/api/pokemon-error", model);
    }

    private String callApi(String endpoint, Model model) {
    RestTemplate restTemplate = new RestTemplate();
    try {
        String response = restTemplate.getForObject(API_URL + endpoint, String.class);
        model.addAttribute("resultado", response);
    } catch (org.springframework.web.client.HttpStatusCodeException e) {
   String body = e.getResponseBodyAsString();

   if (body.contains("Error al leer archivo")) {
       model.addAttribute("resultado", "No se pudo acceder al archivo");
   } else if (body.contains("Error en base de datos")) {
       model.addAttribute("resultado", "Error al acceder a la base de datos");
   } else if (body.contains("Error llamando a API externa")) {
       model.addAttribute("resultado", "Error al consultar el servicio externo");
   } else {
       model.addAttribute("resultado", "Error desconocido");
   }
}

