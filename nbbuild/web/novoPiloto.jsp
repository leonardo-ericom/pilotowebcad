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
<a href="mainPiloto"><img src="imagens/volta.png" ></a>
<h1><img src="imagens/f1.png">Criar Novo Cadastro</h1>

<form name="frmCadastro" action="insertPiloto">

<table>
	<tr>
		<td><input type="text" name= "nome" placeholder="Nome" class="Caixa1" ></td>
	</tr>
	<tr>
		<td><input type="text" name= "pais" placeholder="Pais" class="Caixa1"></td>
	<tr>
		<td><input type="text" name= "idade" placeholder="Idade" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "equipe" placeholder="Equipe" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "fabricante" placeholder="Fabricante" class="Caixa1"></td>
	</tr>
	<tr>
		<td><input type="text" name= "pontos" placeholder="Pontos" class="Caixa1"></td>
	</tr>

</table>
<br>
<input type="button" value="Adicionar" class="Botao1" onclick="validar()">


</form>
<script src="scripts/validadorPiloto.js"></script>



</body>
</html>