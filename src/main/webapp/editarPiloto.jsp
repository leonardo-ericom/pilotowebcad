<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Cadastro</title>
<link rel="icon" href="imagens/f1.png">
<link rel="stylesheet" href="style.css">
</head>

<body>
<a href="mainPiloto"><img src="imagens/volta.png" ></a>
	<h1><img src="imagens/f1.png">Editar Cadastro</h1>

	<form name="frmCadastro" action="updatePiloto">
		<table>
			<tr>
				<td><input type="text" name="matricula" id="caixa3" readonly
					value="<%out.print(request.getAttribute("matricula"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" 
				value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="pais" class="Caixa1" 
				value="<%out.print(request.getAttribute("pais"));%>"></td>
			<tr>
				<td><input type="text" name="idade" class="Caixa1"
				value="<%out.print(request.getAttribute("idade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="equipe" class="Caixa1"
				value="<%out.print(request.getAttribute("equipe"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fabricante" class="Caixa1"
				value="<%out.print(request.getAttribute("fabricante"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="pontos" class="Caixa1"
				value="<%out.print(request.getAttribute("pontos"));%>"></td>
			</tr>
			
		</table>
		<br>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		
	</form>
	<script src="scripts/validadorPiloto.js"></script>

</body>
</html>