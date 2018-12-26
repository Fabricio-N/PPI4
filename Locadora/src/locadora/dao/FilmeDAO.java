package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locadora.dao.ConnectionFactory;
import locadora.models.Filme;

public class FilmeDAO {
	private Connection connec;

	public FilmeDAO() {
		connec = ConnectionFactory.getConnection();
	}

	public boolean adicionar(Filme l) {

		String query = "insert into filmes (titulo, genero, anoLancamento) values (?, ?, ?);";
		try {

			PreparedStatement p = connec.prepareStatement(query);
			p.setString(1, l.getTitulo());
			p.setString(2, l.getGenero());
			p.setLong(3, l.getAnoLancamento());
			

			p.execute();
			p.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public List<Filme> getLista() {
		try {

			List<Filme> filmes = new ArrayList<Filme>();
			PreparedStatement stmt = connec.prepareStatement("select * from filmes;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Filme filme = new Filme();
				filme.setTitulo(rs.getString("titulo"));
				filme.setGenero(rs.getString("genero"));
				filme.setAnoLancamento(rs.getInt("anoLancamento"));
				filme.setId(rs.getLong("id"));

				filmes.add(filme);
			}
			rs.close();
			stmt.close();
			return filmes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Filme l) {
		String sql = "update filmes set titulo=?, genero=?, anoLancamento=?, where id=?;";
		try {
			PreparedStatement stmt = connec.prepareStatement(sql);
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getGenero());
			stmt.setInt(3, l.getAnoLancamento());
			stmt.setLong(4, l.getId());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Filme l) {
		try {
			PreparedStatement stmt = connec.prepareStatement("delete from filmes where id=?;");
			stmt.setLong(1, l.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Filme getFilmeByID(Long id) {
		try {

			Filme filme = null;
			PreparedStatement stmt = this.connec.prepareStatement("select * from filmes where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filme = new Filme();
				filme.setId(rs.getLong("id"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setGenero(rs.getString("genero"));
				filme.setAnoLancamento(rs.getInt("anoLancamento"));
				
			}
			rs.close();
			stmt.close();
			return filme;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public Filme getFilmeByTitulo(String titulo) {
		try {

			Filme filme = null;
			PreparedStatement stmt = this.connec.prepareStatement("select * from filmes where titulo=?;");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filme = new Filme();
				filme.setId(rs.getLong("id"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setGenero(rs.getString("genero"));
				filme.setAnoLancamento(rs.getInt("anoLancamento"));
				
			}
			rs.close();
			stmt.close();
			return filme;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}