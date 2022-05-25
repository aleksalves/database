package com.aleks.team.controller;

import com.aleks.team.model.Membro;
import com.aleks.team.model.Time;
import com.aleks.team.repository.MembroRepository;
import com.aleks.team.repository.TimeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    TimeRespository timeRespository;

    @Autowired
    MembroRepository membroRepository;

    @GetMapping(value={"/", "/index", "/home"})
    public String Home(HttpSession session, Model model){

        Optional<Time> optTime = timeRespository.findById(1l);

        if(optTime.isEmpty()){
            return "404";
        }else{
            Time time = optTime.get();
            session.setAttribute("nomeTime", time.getNome());

            session.setAttribute("propositoTime", time.getProposito());

            model.addAttribute("listaMembros", Membro.ordenarMembros(membroRepository.findAll()));

            model.addAttribute("pagina", "time");

            return "main";
        }
    }

}
