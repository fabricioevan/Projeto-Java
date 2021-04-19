<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("conteiners");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Conteiner</title>
<link rel="icon" href="imagens/conteinerico.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Conteiner</h1>
	<a href="novo.html" class="Botao1">Novo Conteiner</a>
	<table class="tabela">
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Número</th>
				<th>Tipo</th>
				<th>Status</th>
				<th>Categoria</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getCliente()%></td>
				<td><%=lista.get(i).getNumcont()%></td>
				<td><%=lista.get(i).getTipo()%></td>
				<td><%=lista.get(i).getStatu()%></td>
				<td><%=lista.get(i).getCategoria()%></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="Botao3">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
					class="Botao2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>