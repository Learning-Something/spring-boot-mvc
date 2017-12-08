package com.algaworks.vinho.controller;

import com.algaworks.vinho.model.TipoVinho;
import com.algaworks.vinho.model.Vinho;
import com.algaworks.vinho.repository.Vinhos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

    @Autowired
    private Vinhos vinhos;

    @GetMapping("/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        return novo(vinhos.findOne(id));
    }

    @GetMapping("/novo")
    public ModelAndView novo(Vinho vinho) {
        ModelAndView modelAndView = new ModelAndView("vinhos/cadastro-vinho");

        modelAndView.addObject(vinho);
        modelAndView.addObject("tipos", TipoVinho.values());

        return modelAndView;
    }

    @PostMapping("/novo")
    public String salvar(Vinho vinho) {
        vinhos.save(vinho);

        return "redirect:/vinhos/novo";
    }
}
