<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt.br">
    <head>
        <meta charset="utf-8">
        <title>Cadastro de Corrida</title>
        <link rel="icon" href="imagens/f1.png">
        <link rel="stylesheet" href="style.css">
    </head>

    <body >
        <a href="mainCorrida"><img src="imagens/volta.png" ></a>
        <h1><img src="imagens/f1.png">Criar Nova Corrida</h1>

        <form name="frmCadastro" action="insertCorrida">

            <table>
                <tr>
                    <td><input type="text" name= "nomecorrida" placeholder="Nome da Corrida" class="Caixa1"></td>
                </tr>
                <tr>
                    <td><input type="date" name= "data" placeholder="data" class="Caixa1" ></td>
                </tr>
                <tr>
                    <td><input type="text" name= "hora" placeholder="Hora" class="Caixa1"></td>
                </tr>

                <tr>
                <td><input type="text" name= "circuito" placeholder="Circuito" class="Caixa1"></td>
                </tr>



            </table>
            <br>
            <input type="button" value="Adicionar" class="Botao1" onclick="validar()">


        </form>
        <script src="scripts/validadorCorrida.js"></script>



    </body>
</html>