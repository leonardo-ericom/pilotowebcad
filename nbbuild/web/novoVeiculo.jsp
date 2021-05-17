<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt.br">
<head>
<meta charset="utf-8">
<title>Cadastro de Pilotos</title>
<link rel="icon" href="imagens/f1.png">
<link rel="stylesheet" href="style.css">
</head>

<body bgcolor=#4682B4>
<a href="mainVeiculo"><img src="imagens/volta.png" ></a>
<h1><img src="imagens/f1.png">Criar Novo Cadastro Veiculo</h1>


<form name="frmCadastro" action="insertVeiculo">
<table>
	<tr>
		<td><input type="text" name= "renavam" placeholder="renavam" class="Caixa1" ></td>
	</tr>
	<tr>
		<td><input type="text" name= "marca" placeholder="marca" class="Caixa1"></td>
	<tr>
		<td><input type="text" name= "modelo" placeholder="modelo" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "cor" placeholder="cor" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "placa" placeholder="placa" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "anoFabricacao" placeholder="anoFabricacao" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "categoria" placeholder="categoria" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "combustivel" placeholder="combustivel" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "kilometragem" placeholder="kilometragem" class="Caixa1"></td>
	</tr>

</table>
<p><input type="button" value="Adicionar" class="Botao1" onclick="validar()"></p>
</form>
<script src="scripts/validadorVeiculo.js"></script>

</body>
</html>