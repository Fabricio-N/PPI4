package locadora.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import locadora.dao.ClienteDAO;
import locadora.dao.AluguelDAO;
import locadora.dao.FilmeDAO;
import locadora.models.Cliente;
import locadora.models.Aluguel;
import locadora.models.Filme;

@Controller
@RequestMapping("/alugueis")
public class AlugueisController {
	
	@RequestMapping("/form")
	public ModelAndView form() {
		System.out.println("Chamou o meu método");
		ClienteDAO clienteDao = new ClienteDAO();
		List<Cliente> listaC = clienteDao.getLista();

		FilmeDAO filmeDao = new FilmeDAO();
		List<Filme> listaF = filmeDao.getLista();

		ModelAndView model = new ModelAndView("alugueis/formAluguel");

		model.addObject("clientes", listaC);
		model.addObject("filmes", listaF);

		return model;

	}

	@PostMapping
	public String adicionar(Aluguel aluguel) throws SQLException {
		System.out.println("Chamou o método de adicionar");
		AluguelDAO aluguelDAO = new AluguelDAO();

		if (aluguelDAO.qtdAlugueis(aluguel)) {
			if (aluguelDAO.qtdFilmes(aluguel)) {
				aluguelDAO.inserir(aluguel);
				return "redirect:/alugueis";

			} else {
				return "alugueis/relatorioFilme";

			}

		} else {
			return "alugueis/relatorioCliente";
		}

	}

	@GetMapping
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		AluguelDAO aluguelDao = new AluguelDAO();
		List<Aluguel> lista = aluguelDao.getLista();
		ModelAndView model = new ModelAndView("alugueis/listaAluguel");
		model.addObject("alugueis", lista);
		return model;
	}

	@GetMapping("/abertos")
	public ModelAndView listarAbertos() {
		System.out.println("Chamou o metódo de listagem");
		AluguelDAO aluguelDao = new AluguelDAO();
		List<Aluguel> lista = aluguelDao.getListaAbertos();
		ModelAndView model = new ModelAndView("alugueis/listaAlugAbertos");
		model.addObject("alugueis", lista);
		return model;
	}

	@GetMapping("/atrasados")
	public ModelAndView listarAtrasado() {
		System.out.println("Chamou o metódo de listagem");
		AluguelDAO aluguelDao = new AluguelDAO();
		List<Aluguel> lista = aluguelDao.getListaAtraso();
		ModelAndView model = new ModelAndView("alugueis/listaAlugAtrasados");
		model.addObject("alugueis", lista);
		return model;
	}

	@RequestMapping("/devolucao")
	public String devolucao(Aluguel aluguel) {
		System.out.println("Chamou o método devolução");
		AluguelDAO aluguelDao = new AluguelDAO();
		System.out.println(aluguel);
		aluguelDao.devolucao(aluguel);
		return "redirect:../alugueis/abertos";

	}
}
