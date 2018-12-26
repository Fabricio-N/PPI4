package locadora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import locadora.models.Cliente;
import locadora.models.Aluguel;
import locadora.models.Filme;

public class AluguelDAO {
	private Connection connection;

	public AluguelDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Aluguel aluguel) {

		String query = "insert into alugueis (cliente, filme, dataDevolucao) values (?, ?, ?);";

		try {
			PreparedStatement p = connection.prepareStatement(query);

			Calendar calendario = Calendar.getInstance();
			Long calendarioEF = calendario.getTimeInMillis();

			p.setLong(1, aluguel.getCliente().getId());
			p.setLong(2, aluguel.getFilme().getId());
			p.setDate(3, new java.sql.Date(calendarioEF));

			p.execute();
			p.close();
			System.out.println("Salvo com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public boolean qtdAlugueis(Aluguel aluguel) throws SQLException {

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from alugueis where cliente = ? and dataDevolucao IS NULL;");
			stmt.setLong(1, aluguel.getCliente().getId());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
			}
			stmt.close();
			if (cont > 2) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public List<Aluguel> getListaAbertos() {
		try {

			List<Aluguel> alugueis = new ArrayList<Aluguel>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from alugueis where dataDevolucao is null;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				alugueis.add(montarAluguel(rs));
			}

			stmt.close();
			return alugueis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Aluguel> getListaAtraso() {
		try {

			List<Aluguel> alugueis = new ArrayList<Aluguel>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from alugueis where dataDevolucao is null and dataAluguel < ?;");
			Calendar date = Calendar.getInstance();
			stmt.setDate(1, new Date(date.getTimeInMillis() - 14 * 24 * 60 * 60 * 1000));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				alugueis.add(montarAluguel(rs));
			}
			stmt.close();
			return alugueis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Aluguel> getLista() {
		try {

			List<Aluguel> alugueis = new ArrayList<Aluguel>();
			PreparedStatement stmt = connection.prepareStatement("select * from alugueis;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				alugueis.add(montarAluguel(rs));
			}
			rs.close();
			stmt.close();
			return alugueis;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private Aluguel montarAluguel(ResultSet rs) throws SQLException {
		Aluguel aluguel = new Aluguel();

		aluguel.setId(rs.getLong("id"));
		Cliente cliente = new ClienteDAO().getClienteByID(rs.getLong("cliente"));
		aluguel.setCliente(cliente);
		Filme filme = new FilmeDAO().getFilmeByID(rs.getLong("filme"));
		aluguel.setFilme(filme);

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataAluguel"));
		aluguel.setDataAluguel(data);

		if (rs.getDate("dataDevolucao") != null) {
			Calendar data2 = Calendar.getInstance();
			data2.setTime(rs.getDate("dataDevolucao"));
			aluguel.setDataDevolucao(data2);
		}

		return aluguel;
	}

	public boolean devolucao(Aluguel aluguel) {
		String sql = "update alugueis set dataDevolucao=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(2, aluguel.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Aluguel getAluguelByID(Long id) {
		try {

			Aluguel aluguel = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from alugueis where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aluguel = montarAluguel(rs);
			}
			rs.close();
			stmt.close();
			return aluguel;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public boolean qtdFilmes(Aluguel aluguel) {
		String sql = "select * from alugueis where filme = ? and dataDevolucao IS NULL;";
		int FilmAlug = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, aluguel.getFilme().getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				FilmAlug++;
			}

			if (FilmAlug >= 1) {
				return false;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;

	}

}
