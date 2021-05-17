<%@page import="model.Piloto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Piloto"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Piloto>lista = (ArrayList<Piloto>) request.getAttribute("cadastrosPiloto");
//for(int i = 0; i < lista.size();i++){
	
	//out.println(lista.get(i).getIdcon());
	//out.println(lista.get(i).getNome());
	//out.println(lista.get(i).getFone());
	//out.println(lista.get(i).getEmail());
		
//}
%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Pilotos</title>
<link rel="icon" href="imagens/f1.png">
<link rel="stylesheet" href="style.css">


</head>

<body >
	<a href="index.jsp"><img src="imagens/volta.png" ></a>
	<h1><img src="imagens/f1.png">Cadastro de Pilotos</h1>
	
	<a href="novoPiloto.jsp" class="Botao1">Novo Cadastro</a>
	<a href="reportPiloto" class="Botao3">Relatório</a>
  	
		
		<table id="tabela" >
		
		
		
		
<thead>
	<tr>
		<th>Matricula</th>
		<th>Nome</th>
		<th>Pais</th>
		<th>Idade</th>
		<th>Equipe</th>
		<th>fabricante</th>
		<th>Pontos</th>
		<th>Opções</th>
	</tr>
</thead>
<tbody>
	<%for (int i =0; i<lista.size(); i++){ %>
	
	<tr>
		
		
				
		<td><%=lista.get(i).getMatricula()%></td>
		<td><%=lista.get(i).getNome()%></td>
		<td><%=lista.get(i).getPais() %></td>
		<td><%=lista.get(i).getIdade() %></td>
		<td><%=lista.get(i).getEquipe() %></td>
		<td><%=lista.get(i).getFabricante() %></td>
		<td><%=lista.get(i).getPontos() %></td>
		
				
		<td><a href= "selectPiloto?matricula=<%=lista.get(i).getMatricula()%>" class="Botao1">Editar</a>
		    <a href="javascript:confirmar(<%=lista.get(i).getMatricula()%>)" 
		    class= "Botao2">Excluir</a>
		</td>		
	
	</tr>
	
	<%} %>
	
</tbody>

	<script src="scripts/confirmadorPiloto.js"></script>
	
	</body>
</html>