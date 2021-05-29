<%@page import="model.Veiculo"%>
<%@page import="model.Corrida"%>
<%@page import="dal.DaoVeiculo"%>
<%@page import="dal.DaoCorrida"%>
<%@page import="dal.DaoPiloto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Piloto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    DaoPiloto dao = new DaoPiloto();
    List<Piloto> listaDePiloto = dao.listarCadastros();
    request.setAttribute("list", listaDePiloto);
    DaoCorrida daoCorrida = new DaoCorrida();
    List<Corrida> listaDeCorrida = daoCorrida.listarCadastros();
    request.setAttribute("listCorrida", listaDeCorrida);
    DaoVeiculo daoVeiculo = new DaoVeiculo();
    List<Veiculo> listaDeVeiculo = daoVeiculo.listarCadastros();
    request.setAttribute("listVeiculo", listaDeVeiculo);

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
            

            <table>
                <td><input type="text" name="id" id="caixa3" readonly
					value=<%=request.getParameter("id")%>></td>
		

                <tr>
                    <td >Piloto: 
                        <select name="comboPiloto" >

                            <c:forEach var="listaDePiloto" items="${list}" >
                                <option value="${listaDePiloto.matricula}" >
                                    ${listaDePiloto.nome}
                                </option>
                            </c:forEach>


                        </select>
                    </td>
                </tr>
                <tr>

                    <td colspan="5">Veiculo:
                        <select name="comboVeiculo">
                            <c:forEach var="item" items="${listVeiculo}">
                                <option value="${item.renavam}">
                                    ${item.marca}
                                </option>
                            </c:forEach>
                        </select></td>

                </tr>
                

                <tr>
                
                    <!--  <td>Corrida:
                    <select name="comboCorrida">
                        <c:forEach var="item" items="${listCorrida}">
                            <option value="${item.id}">
                                ${item.nome}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                </tr>
               -->


               
               
               
            </table>
            <br>
        <input type="submit" value="Adicionar" class="Botao1">
    
            
          
            <br>


        </form>
           



    </body>
</html>