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
<a href="mainCorrida"><img src="imagens/volta.png" ></a>
	<h1><img src="imagens/f1.png">Editar Corrida</h1>

	<form name="frmCadastro" action="updateCorrida">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nomecorrida" class="Caixa1" 
				value="<%out.print(request.getAttribute("nomecorrida"));%>"></td>
			</tr>
			<tr>
                            <td><input type="date" name="data" class="Caixa1" 
				value="<%out.print(request.getAttribute("data"));%>"></td>
			<tr>
				<td><input type="text" name="hora" class="Caixa1"
				value="<%out.print(request.getAttribute("hora"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="circuito" class="Caixa1"
				value="<%out.print(request.getAttribute("circuito"));%>"></td>
			</tr>
			
			
		</table>
		<br>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		
	</form>
	<script src="scripts/validadorCorrida.js"></script>

</body>
</html>