package com.example.lab4.controller;
import com.example.lab4.entity.Color;
import com.example.lab4.entity.Flores;
import com.example.lab4.repository.ColorRepository;
import com.example.lab4.repository.FloresRepository;

import com.example.lab4.repository.OcasionRepository;
import com.example.lab4.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/floreria")
public class FlorController {

    final FloresRepository floresRepository;
    final ColorRepository colorRepository;
    final TipoRepository tipoRepository;
    final OcasionRepository ocasionRepository;


    public FlorController(FloresRepository floresRepository,
                          ColorRepository colorRepository,
                          TipoRepository tipoRepository,
                          OcasionRepository ocasionRepository){

        this.floresRepository= floresRepository;
        this.colorRepository= colorRepository;
        this.tipoRepository= tipoRepository;
        this.ocasionRepository= ocasionRepository;
    }
    @GetMapping(value={"","/"})
    public String catalogoFlores(Model model){
        model.addAttribute("listaProductos", floresRepository.findAll());
        model.addAttribute("listaColor",colorRepository.findAll());
        model.addAttribute("listaTipo",tipoRepository.findAll());
        model.addAttribute("listaOcasion",ocasionRepository.findAll());
        return "floreria/catalogo";
    }


    @PostMapping("/buscarFlor")
    public String buscarFlor(

            @RequestParam(name = "color") String color,
            @RequestParam(name = "tipo") String tipo,
            @RequestParam(name = "ocasion") String ocasion,
            Model model) {



        List<Flores> listaFiltrada = floresRepository.buscarFloresConFiltros(color, tipo, ocasion);


        model.addAttribute("listaProductos", listaFiltrada);

        return "floreria/catalogo";
    }




}
