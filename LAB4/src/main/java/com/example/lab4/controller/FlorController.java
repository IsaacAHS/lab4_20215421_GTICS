package com.example.lab4.controller;
import com.example.lab4.entity.Flores;
import com.example.lab4.repository.FloresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/flores")
public class FlorController {

    final FloresRepository floresRepository;

    public FlorController(FloresRepository floresRepository){
        this.floresRepository= floresRepository;
    }
    public String catalogoFlores(Model model){
        model.addAttribute("listaProductos", floresRepository.findAll());
        return "flores/catalogo";
    }
}
