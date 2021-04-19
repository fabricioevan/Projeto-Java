<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Controle de Contêiner</title>
<link rel="icon" href="imagens/conteinerico.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar conteiner</h1>
	<form name="frmConteiner" action="update">
		<table>
			<tr>
				<td><input type="text" name="idcon" class="caixa1"
					value="<%out.println(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cliente" class="caixa1"
					value="<%out.println(request.getAttribute("cliente"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="numero" class="caixa1"
					value="<%out.println(request.getAttribute("numcont"));%>"></td>
			</tr>
			<tr>
				<td><select name="tipo" class="caixa1">
						<option selected disabled value="tipo">Tipo</option>
						<option>20</option>
						<option>40</option>
				</select></td>
			</tr>
			<tr>
				<td><select name="status" class="caixa1">
						<option selected disabled value="">Status</option>
						<option>Cheio</option>
						<option>Vazio</option>
				</select></td>
			</tr>
			<tr>
				<td><select name="categoria" class="caixa1">
						<option selected disabled value="">Categoria</option>
						<option>Importação</option>
						<option>Exportação</option>
				</select></td>
			</tr>

		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>

</body>
</html>