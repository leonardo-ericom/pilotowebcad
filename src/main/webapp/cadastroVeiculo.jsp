
<%@page import="model.Veiculo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Veiculo>lista = (ArrayList<Veiculo>) request.getAttribute("cadastrosVeiculo");
 
%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Veiculos</title>
<link rel="icon" href="imagens/f1.png">
<link rel="stylesheet" href="style.css">
</head>
<body bgcolor=#4682B4>
    <a href="index.jsp"><img src="imagens/volta.png" ></a>
	<h1><img src="imagens/f1.png">Cadastro de Veiculos</h1>
	
	<a href="novoVeiculo.jsp" class="Botao1">Novo Cadastro</a>
	<a href="reportVeiculo" class="Botao3">Relatório</a>

		
		<table id="tabela" >
		
<thead>
	<tr>
		<th>Renavam</th>
		<th>Marca</th>
		<th>Modelo</th>
		<th>cor</th>
		<th>Placa</th>
		<th>Ano Fabricação</th>
		<th>Categoria</th>
		<th>Combustivel</th>
		<th>Kilometragem</th>
		<th>Opções</th>
		
	</tr>
</thead>
<tbody>
	<%for (int i =0; i<lista.size(); i++){ %>
	
	<tr>
		
				
		<td><%=lista.get(i).getRenavam()%></td>
		<td><%=lista.get(i).getMarca()%></td>
		<td><%=lista.get(i).getModelo() %></td>
		<td><%=lista.get(i).getCor() %></td>
		<td><%=lista.get(i).getPlaca() %></td>
		<td><%=lista.get(i).getanoFabricacao() %></td>
		<td><%=lista.get(i).getCategoria() %></td>
		<td><%=lista.get(i).getCombustivel() %></td>
		<td><%=lista.get(i).getKilometragem() %></td>
		
				
		<td><a href="selectVeiculo?renavam=<%=lista.get(i).getRenavam()%>" class="Botao1">Editar</a>
		    <a href="javascript:confirmar (<%=lista.get(i).getRenavam()%>)"  class= "Botao2">Excluir</a>
		</td>		
	
	</tr>
	
	<%} %>
</tbody>
</table>
	<script src="scripts/confirmadorVeiculo.js"></script>
	
</body>
</html>