<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Piloto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
List<Piloto> listaDoInferno  = (List)request.getAttribute("cadastrosPiloto");
%>
<!DOCTYPE html>
<html lang="pt.br">
    <head>
        <meta charset="utf-8">
        <title>Adicionar Participante</title>
        <link rel="icon" href="imagens/f1.png">
        <link rel="stylesheet" href="style.css">
    </head>

    <body >
        <a href="mainCorrida"><img src="imagens/volta.png" ></a>
        <h1><img src="imagens/f1.png">Novo Participante</h1>

        <form name="frmCadastro" action="insertParticipante">
            <input type="hidden" name="objeto" value="<%= request.getAttribute("id") %>">

            <table>
                <tr>
                    <td><input type="" name= "nomeCorrida" placeholder="Nome da Corrida" class="Caixa1"></td>
                <tr>
                <tr>
                    <td><input type="text" name= "codpiloto" placeholder="Piloto" class="Caixa1" ></td>
                </tr>
                <tr>
                    <td><input type="text" name= "cadveiculo" placeholder="Veiculo" class="Caixa1"></td>
                </tr>
             


            </table>
            <br>
            <select name="comboPilotos">
                <option value="">..</option>
                <c:forEach var="listaDoInferno" items="${listaDoInferno}">
                        <option value="${listaDoInferno.id}">
                        ${listaDoInferno.nome}
                        </option>
                </c:forEach>
            </select>
            <input type="button" value="Adicionar" class="Botao1">


        </form>
 



    </body>
</html>