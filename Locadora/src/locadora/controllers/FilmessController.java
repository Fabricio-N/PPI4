package locadora.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import locadora.dao.FilmeDAO;

import locadora.models.Filme;

@Controller
@RequestMapping("/filmes")
public class FilmessController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o meu método");
		return "filmes/formFilme";
	}

	@PostMapping
	public String adicionar(Filme filme) {
		System.out.println("Chamou o método de adicionar");
		FilmeDAO filmeDao = new FilmeDAO();
		filmeDao.adicionar(filme);
		return "redirect:filmes";
	}

	@GetMapping
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		FilmeDAO filmeDao = new FilmeDAO();
		List<Filme> lista = filmeDao.getLista();
		ModelAndView model = new ModelAndView("filmes/listaFilme");
		model.addObject("filmes", lista);
		return model;
	}

	@RequestMapping("/remover")
	public String remover(Filme filme) {
		System.out.println("Chamou o método remover");
		FilmeDAO filmeDao = new FilmeDAO();
		filmeDao.remover(filme);
		return "redirect:../filmes";

	}
}
