package locadora.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import locadora.dao.FilmeDAO;
import locadora.models.Filme;
import locadora.models.FilmesMaisAlugados;

@Controller
@RequestMapping("/filmes")
public class FilmessController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o meu m�todo");
		return "filmes/formFilme";
	}

	@PostMapping
	public String adicionar(Filme filme) {
		System.out.println("Chamou o m�todo de adicionar");
		FilmeDAO filmeDao = new FilmeDAO();
		filmeDao.adicionar(filme);
		return "redirect:filmes";
	}

	@GetMapping
	public ModelAndView listar() {
		System.out.println("Chamou o met�do de listagem");
		FilmeDAO filmeDao = new FilmeDAO();
		List<Filme> lista = filmeDao.getLista();
		ModelAndView model = new ModelAndView("filmes/listaFilme");
		model.addObject("filmes", lista);
		return model;
	}

	@RequestMapping("/remover")
	public String remover(Filme filme) {
		System.out.println("Chamou o m�todo remover");
		FilmeDAO filmeDao = new FilmeDAO();
		filmeDao.remover(filme);
		return "redirect:../filmes";

	}
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar(Filme filme) {
		FilmeDAO filmeDAO = new FilmeDAO();
		filme = filmeDAO.getFilmeByID(filme.getId());
		
		ModelAndView model = new ModelAndView("filmes/form-alterar-filme"); 
		model.addObject("filme", filme);
		return model;
	}
	
	@PostMapping("/alterar")
	public String alterar(Filme filme) {
		System.out.println("Chamou o m�todo alterar");
		FilmeDAO filmeDAO = new FilmeDAO();
		filmeDAO.alterar(filme);
		return "redirect:../filmes";
	}
	
	@RequestMapping("/MaisAlugados")
	public ModelAndView MaisAlugados (Filme filme) {
		FilmeDAO filmedao = new FilmeDAO();
		List<FilmesMaisAlugados> lista = filmedao.getListaMaisAlugados();
		
		System.out.println(lista);
		ModelAndView model = new ModelAndView("filmes/listaFilmeMaisAlugados");
		model.addObject("filmes", lista);
		return model;
	}
}
