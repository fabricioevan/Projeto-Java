package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans conteiner = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			conteiners(request, response);
		} else if (action.equals("/insert")) {
			novoConteiner(request, response);
		} else if (action.equals("/select")) {
			listarConteiner(request, response);
		} else if (action.equals("/update")) {
			editarConteiner(request, response);
		} else if (action.equals("/delete")) {
			removerConteiner(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	// Lista conteiners
	protected void conteiners(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira os dados javabeans
		ArrayList<JavaBeans> lista = dao.listarConteiners();
		// encaminhar a lista ao documento conteiner.jsp
		request.setAttribute("conteiners", lista);
		RequestDispatcher rd = request.getRequestDispatcher("conteiner.jsp");
		rd.forward(request, response);
		// teste de recebimento da lista
		// for (int i =0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getIdcon());
		// }

	}

	// Novo conteiner
	protected void novoConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimentpo
		/*
		 * System.out.println(request.getParameter("cliente"));
		 * System.out.println(request.getParameter("numero"));
		 * System.out.println(request.getParameter("tipo"));
		 * System.out.println(request.getParameter("status"));
		 * System.out.println(request.getParameter("categoria"));
		 */
		// setar as variaveis java beans
		conteiner.setCliente(request.getParameter("cliente"));
		conteiner.setNumcont(request.getParameter("numero"));
		conteiner.setTipo(request.getParameter("tipo"));
		conteiner.setStatu(request.getParameter("status"));
		conteiner.setCategoria(request.getParameter("categoria"));
		// invocar o metodo inserirConteiner
		dao.inserirConteiner(conteiner);
		// redirecionar para o documento conteiner.jsp
		response.sendRedirect("main");

	}

	// Listar conteiner
	protected void listarConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do conteiner que sera editado
		String idcon = request.getParameter("idcon");
		// setar a variavel javabeans
		conteiner.setIdcon(idcon);
		// executar o metodo selecionar conteiner (DAO)
		dao.selecionarConteiner(conteiner);
		// setar os atributos do formulario com o conteudo javabeans
		request.setAttribute("idcon", conteiner.getIdcon());
		request.setAttribute("cliente", conteiner.getCliente());
		request.setAttribute("numcont", conteiner.getNumcont());
		request.setAttribute("tipo", conteiner.getTipo());
		request.setAttribute("statu", conteiner.getStatu());
		request.setAttribute("categoria", conteiner.getCategoria());
		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	// Editar conteiner
	protected void editarConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis javabeans
		conteiner.setIdcon(request.getParameter("idcon"));
		conteiner.setCliente(request.getParameter("cliente"));
		conteiner.setNumcont(request.getParameter("numero"));
		conteiner.setTipo(request.getParameter("tipo"));
		conteiner.setStatu(request.getParameter("status"));
		conteiner.setCategoria(request.getParameter("categoria"));
		// executar o metodo alterarConteiner
		dao.alterarConteiner(conteiner);
		// redirecionar para o documento conteiner.jsp atualizando as alterações
		response.sendRedirect("main");
	}

	// Remover conteiner
	protected void removerConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do conteiner a ser excluido
		String idcon = request.getParameter("idcon");
		// setar a variavel idcon javabeans
		conteiner.setIdcon(idcon);
		// executar deletarConteiner
		dao.deletarConteiner(conteiner);
		// redirecionar para o documento conteiner.jsp atualizando as alterações
		response.sendRedirect("main");

	}

}
