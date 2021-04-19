package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbconteiner?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// metodo de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}

	/** CRUD CREATE **/
	public void inserirConteiner(JavaBeans conteiner) {
		String create = "insert into conteiners (cliente,numcont,tipo,statu,categoria) values(?,?,?,?,?)";
		try {
			// abrir conexão
			Connection con = conectar();
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis javabeans
			pst.setString(1, conteiner.getCliente());
			pst.setString(2, conteiner.getNumcont());
			pst.setString(3, conteiner.getTipo());
			pst.setString(4, conteiner.getStatu());
			pst.setString(5, conteiner.getCategoria());
			// executar a query
			pst.executeUpdate();
			// encerrar conexao com o banco de dados
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarConteiners() {
		// criando objeto para acessar a clase javabeans
		ArrayList<JavaBeans> conteiners = new ArrayList<>();
		String read = "select * from conteiners order by cliente";
		try {
			Connection con = conectar();
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo sera executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String cliente = rs.getString(2);
				String numcont = rs.getString(3);
				String tipo = rs.getString(4);
				String statu = rs.getString(5);
				String categoria = rs.getString(6);
				// populando arrays
				conteiners.add(new JavaBeans(idcon, cliente, numcont, tipo, statu, categoria));
			}
			con.close();
			return conteiners;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD Update **/
	// selecionar o contado
	public void selecionarConteiner(JavaBeans conteiner) {
		String read2 = "select * from conteiners where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, conteiner.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variaveis javabeans
				conteiner.setIdcon(rs.getString(1));
				conteiner.setCliente(rs.getString(2));
				conteiner.setNumcont(rs.getString(3));
				conteiner.setTipo(rs.getString(4));
				conteiner.setStatu(rs.getString(5));
				conteiner.setCategoria(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar conteiner
	public void alterarConteiner(JavaBeans conteiner) {
		String update = "update conteiners set cliente=?, numcont=?, tipo=?, statu=?, categoria=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, conteiner.getCliente());
			pst.setString(2, conteiner.getNumcont());
			pst.setString(3, conteiner.getTipo());
			pst.setString(4, conteiner.getStatu());
			pst.setString(5, conteiner.getCategoria());
			pst.setString(6, conteiner.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE **/
	public void deletarConteiner(JavaBeans conteiner) {
		String delete = "delete from conteiners where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, conteiner.getIdcon());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
