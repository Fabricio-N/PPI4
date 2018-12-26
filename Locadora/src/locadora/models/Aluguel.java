package locadora.models;

import java.util.Calendar;

public class Aluguel {

	private Cliente cliente;
	private Filme filme;
	private Calendar dataAluguel;
	private Calendar dataDevolucao;
	private Long id;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Calendar getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Calendar dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Aluguel [cliente=" + cliente + ", filme=" + filme + ", dataAluguel=" + dataAluguel + ", dataDevolucao="
				+ dataDevolucao + ", id=" + id + "]";
	}
	
	

}
