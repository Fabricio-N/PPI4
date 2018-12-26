package locadora.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import locadora.dao.ClienteDAO;
import locadora.models.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o meu método");
		return "clientes/FormCliente";
	}

	@PostMapping
	public String adicionar(Cliente cliente) {
		System.out.println("Chamou o método de adicionar");
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.inserir(cliente);
		return "redirect:clientes";
	}

	@GetMapping
	public ModelAndView listar() {
		System.out.println("Chamou o metódo de listagem");
		ClienteDAO clienteDao = new ClienteDAO();
		List<Cliente> lista = clienteDao.getLista();
		ModelAndView model = new ModelAndView("clientes/listaClientes");
		model.addObject("clientes", lista);
		return model;
	}

	@RequestMapping("/remover")
	public String remover(Cliente cliente) {
		System.out.println("Chamou o método remover");
		ClienteDAO clienteDao = new ClienteDAO();
		clienteDao.remover(cliente);
		return "redirect:../clientes";

	}
	
	@RequestMapping("/selecionar")
	public ModelAndView selecionar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		cliente = clienteDAO.getClienteByID(cliente.getId());
		
		ModelAndView model = new ModelAndView("contatos/form-alterar"); 
		model.addObject("cliente", cliente);
		return model;
	}
	
	@PostMapping("/alterar")
	public String alterar(Cliente cliente) {
		System.out.println("Chamou o método alterar");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.alterar(cliente);
		return "redirect:../clientes";
	}

}
