package com.aleks.team.controller;

import com.aleks.team.model.Membro;
import com.aleks.team.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(path="/membro")
public class MembroController {

    @Autowired
    private MembroRepository repo;

    @GetMapping(value="/{id}")
    public String listaMembros(Model model, @PathVariable(value="id") Long id){

        Optional<Membro> optMembro = repo.findById(id);

        if(optMembro.isEmpty()){
            return "404";
        }

        model.addAttribute("pagina", "detalhesMembro");
        model.addAttribute("membro", optMembro.get());

        return "main";

    }

}
