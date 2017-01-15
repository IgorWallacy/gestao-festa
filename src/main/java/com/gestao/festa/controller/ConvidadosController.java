package com.gestao.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.festa.model.Convidado;
import com.gestao.festa.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject(new Convidado());
		mv.addObject("convidados", convidados.findAll());

		return mv;
	}
	
	@PostMapping
	public String salvar(Convidado convidado){
		
		this.convidados.save(convidado);
		
		return "redirect:/convidados";
		
	}

}
