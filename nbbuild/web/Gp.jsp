<%@page import="java.util.List"%>
<%@page import="dal.DaoParticipante"%>
<%@page import="dal.DaoPiloto"%>
<%@page import="model.Participante"%>
<%@page import="model.Corrida"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="model.Corrida"%>
<%@ page import="java.util.ArrayList"%>
<%
    DaoParticipante daoParticipante = new DaoParticipante();
    List<Participante> participantelist = daoParticipante.selecionarCadastroByCorridaId(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("participante", participantelist);

%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Adicionar Participantes</title>
        <link rel="icon" href="imagens/f1.png">
        <link rel="stylesheet" href="style.css">


    </head>

    <body>


        <a href="mainCorrida" ><img src="imagens/volta.png" ></a>
        <h1><img src="imagens/f1.png">GrandPRix</h1>


        <a href="addParticipante.jsp?id=<%=request.getParameter("id")%>" class="Botao1">Novo Participante</a>
        <a href="reportCorrida" class="Botao3">Relatório</a>


        <table id="tabela" >




            <thead>
                <tr>
                    <th>id</th>
                    <th>Corrida</th>
                    <th>Piloto</th>
                    <th>Carro</th>
                   
            

                </tr>


            </thead>
            <tbody>
                <%for (int i = 0; i < participantelist.size(); i++) {%>

                <tr>
                    <td><%=participantelist.get(i).getId()%></td>
                    <td><%=participantelist.get(i).getCorrida().getNome()%></td>
                    <td><%=participantelist.get(i).getPiloto().getNome()%></td>
                    <td><%=participantelist.get(i).getVeiculo().getMarca()%></td>
                   <td><a href= "editarParticipante.jsp?id=<%=participantelist.get(i).getId()%>" class="Botao1">Editar Participante</a>
                   
                </tr>

                <%}%>

            </tbody>
        </table>

    </form>				

</tbody>


</html>