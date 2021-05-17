<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Cadastro de Veiculo</title>
<link rel="icon" href="imagens/f1.png">
<link rel="stylesheet" href="style.css">
</head>

<body bgcolor=#4682B4>
	<a href="mainVeiculo"><img src="imagens/volta.png" ></a>
	<h1><img src="imagens/f1.png">Editar Cadastro de Veiculo</h1>

	<form name="frmCadastro" action="updateVeiculo">
		<table>
			<tr>
				<td><input type="text" name="renavam" id="caixa3" readonly
					value="<%out.print(request.getAttribute("renavam"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="marca" class="Caixa1" 
				value="<%out.print(request.getAttribute("marca"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="modelo" class="Caixa1" 
				value="<%out.print(request.getAttribute("modelo"));%>"></td>
			<tr>
				<td><input type="text" name="cor" class="Caixa1"
				value="<%out.print(request.getAttribute("cor"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="placa" class="Caixa1"
				value="<%out.print(request.getAttribute("placa"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="anoFabricacao" class="Caixa1"
				value="<%out.print(request.getAttribute("anoFabricacao"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="categoria" class="Caixa1"
				value="<%out.print(request.getAttribute("categoria"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="combustivel" class="Caixa1"
				value="<%out.print(request.getAttribute("combustivel"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="kilometragem" class="Caixa1"
				value="<%out.print(request.getAttribute("kilometragem"));%>"></td>
			</tr>
			
		</table>
		
		<p><input type="button" value="Salvar" class="Botao1" onclick="validar()"></p>
	</form>
	<script src="scripts/validadorVeiculo.js"></script>

</body>
</html>