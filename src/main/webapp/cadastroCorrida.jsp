<%@page import="model.Corrida"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="model.Corrida"%>
<%@ page import="java.util.ArrayList"%>
<%
    ArrayList<Corrida> lista = (ArrayList<Corrida>) request.getAttribute("cadastrosCorrida");
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
        <title>Cadastro de Corrida</title>
        <link rel="icon" href="imagens/f1.png">
        <link rel="stylesheet" href="style.css">


    </head>

    <body >
         
        <a href="index.jsp"><img src="imagens/volta.png" ></a>
        <h1><img src="imagens/f1.png">Corridas Cadastradas</h1>

            
        <a href="novaCorrida.jsp" class="Botao1">Novo Cadastro Corrida</a>
       
        <a href="listaCompetidores.jsp" class="Botao1">Participantes por Corrida</a>
        
        <a href="reportCorrida" class="Botao3">Relatório</a>
    

        <table id="tabela" />


            <thead>
            
            <tr>
                <th>ID</th>
                <th>Nome Corrida</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Circuito</th>
                <th>Opções</th>

            </tr>
        </thead>
        <tbody>
            <%for (int i = 0; i < lista.size(); i++) {%>

            <tr>



                <td><%=lista.get(i).getId()%></td>
                <td><%=lista.get(i).getNome()%></td>
                <td><%=lista.get(i).getData()%></td>
                <td><%=lista.get(i).getHora()%></td>
                <td><%=lista.get(i).getCircuito()%></td>




                <td><a href= "selectCorrida?id=<%=lista.get(i).getId()%>" class="Botao1">Editar Corrida</a>
                    
                    <a href= "Gp.jsp?id=<%=lista.get(i).getId()%>" class="Botao1">Adicionar Participante</a>
                <a href="javascript:confirmar(<%=lista.get(i).getId()%>)" 
                       class= "Botao2">Excluir</a>
                
                </td>		

            </tr>

            <%}%>

        </tbody>

        <script src="scripts/confirmadorCorrida.js"></script>
       
</body>
</html>