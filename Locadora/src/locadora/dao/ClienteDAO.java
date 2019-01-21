package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import locadora.dao.ConnectionFactory;
import locadora.models.Cliente;

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Cliente cliente) {

		String sql = "insert into clientes (nome, email, rg, endereco, dataNascimento) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getEndereco());
			stmt.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
			

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Cliente> getLista() {
		try {

			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = connection.prepareStatement("select * from clientes;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setRg(rs.getString("rg"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setId(rs.getLong("id"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);

				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Cliente a) {
		String sql = "update clientes set nome=?, email=?, rg=?, endereco=?, dataNascimento=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getEmail());
			stmt.setString(3, a.getRg());
			stmt.setString(4, a.getEndereco());
			stmt.setDate(5, new java.sql.Date(a.getDataNascimento().getTimeInMillis()));
			stmt.setLong(6, a.getId());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clientes where id=?;");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Cliente getClienteByID(Long id) {
		try {

			Cliente cliente = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setRg(rs.getString("rg"));
				cliente.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Cliente getClienteByMatricula(String matricula) {
		try {

			Cliente cliente = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where matricula=?;");
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setRg(rs.getString("rg"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}