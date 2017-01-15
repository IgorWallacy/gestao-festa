package com.gestao.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.festa.model.Convidado;
import com.gestao.festa.repository.Convidados;
import com.gestao.festa.service.ConvidadoService;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private Convidados convidados;
	
	@Autowired
	private ConvidadoService service;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject(new Convidado());
		mv.addObject("convidados", convidados.findAll());

		return mv;
	}
	
	@PostMapping
	public String salvar(Convidado convidado){
		
		this.service.salvar(convidado);
		
		return "redirect:/convidados";
		
	}

}
