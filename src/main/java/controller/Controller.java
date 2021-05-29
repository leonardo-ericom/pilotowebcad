package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dal.DaoCorrida;

import dal.DaoPiloto;
import dal.DaoVeiculo;
import dal.DaoParticipante;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Corrida;

/*import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;*/
import model.Piloto;
import model.Veiculo;
import model.*;

@WebServlet(urlPatterns = {"/Controller", "/mainPiloto", "/insertPiloto", "/selectPiloto", "/updatePiloto", "/deletePiloto", "/reportPiloto",
    "/mainVeiculo", "/insertVeiculo", "/selectVeiculo", "/updateVeiculo", "/deleteVeiculo", "/reportVeiculo",
    "/mainCorrida", "/insertCorrida", "/selectCorrida", "/updateCorrida", "/deleteCorrida", "/reportCorrida",
    "/mainParticipante","/insertParticipante","/updateParticipante"})
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Piloto cadastroPiloto = new Piloto();
    dal.DaoPiloto daopiloto = new DaoPiloto();

    Veiculo cadastroVeiculo = new Veiculo();
    dal.DaoVeiculo daoVeiculo = new DaoVeiculo();

    Corrida cadastrocorrida = new Corrida();
    dal.DaoCorrida dc = new DaoCorrida();

    Participante cadastroparticipante = new Participante();
    dal.DaoParticipante daoparticipante = new DaoParticipante();

    public Controller() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();
        System.out.println(action);

        switch (action) {
            case "/mainPiloto":
                cadastrosPiloto(request, response);
                break;
            case "/mainVeiculo":
                cadastrosVeiculo(request, response);
                break;
            case "/mainCorrida":
                cadastrosCorrida(request, response);
                break;

            case "/mainParticipante":
                cadastrosParticipante(request, response);
                break;

            case "/insertPiloto":
                novoCadastroPiloto(request, response);
                break;
            case "/insertVeiculo":
                novoCadastroVeiculo(request, response);
                break;
            case "/insertCorrida":
                novoCadastroCorrida(request, response);
                break;
            case "/insertParticipante":
                novoParticipante(request, response);
                break;
            case "/selectPiloto":
                listarCadastroPiloto(request, response);
                break;
            case "/selectVeiculo":
                listarCadastroVeiculo(request, response);
                break;
            case "/selectCorrida":
                listarCadastroCorrida(request, response);
                break;
            case "/selectParticipante":
                listarCadastroParticipante(request, response);
                break;
            case "/updatePiloto":
                editarCadastroPiloto(request, response);
                break;
            case "/updateVeiculo":
                editarCadastroVeiculo(request, response);
                break;
            case "/updateCorrida":
                editarCadastroCorrida(request, response);
                break;
                case "/updateParticipante":
                editarCadastroParticipante(request, response);
                break;
            case "/deletePiloto":
                removerCadastroPiloto(request, response);
                break;
            case "/deleteVeiculo":
                removerCadastroVeiculo(request, response);
                break;
            case "/deleteCorrida":
                removerCadastroCorrida(request, response);
                break;
            case "/reportPiloto":
                gerarRelatorioPiloto(request, response);
                break;
            case "/reportVeiculo":
                gerarRelatorioVeiculo(request, response);
                break;

            default:
                response.sendRedirect("index.jsp");
                break;
        }

    }

//listar contatos
    protected void cadastrosPiloto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.sendRedirect("cadastro.jsp");
        // criando objeto que ira receber os dados Piloto

        ArrayList<Piloto> lista = daopiloto.listarCadastros();
        // for (int i = 0; i < lista.size(); i++) {
        // System.out.println(lista.get(i).getIdcon());
        // System.out.println(lista.get(i).getNome());
        // System.out.println(lista.get(i).getFone());
        // System.out.println(lista.get(i).getEmail());

        request.setAttribute("cadastrosPiloto", lista);
        RequestDispatcher rd = request.getRequestDispatcher("cadastroPiloto.jsp");
        // RequestDispatcher  rd = request.getRequestDispatcher("addParticipante.jsp");

        rd.forward(request, response);
    }

//novo contato
    protected void novoCadastroPiloto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // System.out.println(request.getParameter("nome"));
//setar as variaveis Piloto
        cadastroPiloto.setNome(request.getParameter("nome"));
        cadastroPiloto.setPais(request.getParameter("pais"));
        cadastroPiloto.setIdade(Integer.parseInt(request.getParameter("idade")));
        cadastroPiloto.setEquipe(request.getParameter("equipe"));
        cadastroPiloto.setFabricante(request.getParameter("fabricante"));
        cadastroPiloto.setPontos(Integer.parseInt(request.getParameter("pontos")));
        // invocar o metodo inserir contato passando o objeto contato

        daopiloto.inserirCadastro(cadastroPiloto);

        // redirecionar para o documento cadastro.jsp
        response.sendRedirect("mainPiloto");

    }

    // editar contato
    protected void listarCadastroPiloto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recebimento do id do contato que sera editado
        String matricula = request.getParameter("matricula");
        System.out.println("matricula");
        // setor a variavel java beans
        cadastroPiloto.setMatricula(Integer.parseInt(matricula));
        // executar o metodo selecionar contato classe dao
        daopiloto.selecionarCadastro(cadastroPiloto);

        // teste de recebimento
        System.out.println(cadastroPiloto.getMatricula());
        System.out.println(cadastroPiloto.getNome());
        System.out.println(cadastroPiloto.getPais());
        System.out.println(cadastroPiloto.getIdade());
        System.out.println(cadastroPiloto.getEquipe());
        System.out.println(cadastroPiloto.getFabricante());
        System.out.println(cadastroPiloto.getPontos());

        // seytar os atributor do formulario com Piloto
        request.setAttribute("matricula", cadastroPiloto.getMatricula());
        request.setAttribute("nome", cadastroPiloto.getNome());
        request.setAttribute("pais", cadastroPiloto.getPais());
        request.setAttribute("idade", cadastroPiloto.getIdade());
        request.setAttribute("equipe", cadastroPiloto.getEquipe());
        request.setAttribute("fabricante", cadastroPiloto.getFabricante());
        request.setAttribute("pontos", cadastroPiloto.getPontos());
        // encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editarPiloto.jsp");
        rd.forward(request, response);
    }

    // metodo de edicao
    protected void editarCadastroPiloto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // teste de recebimento
        // System.out.println(request.getParameter("matricula"));
        // System.out.println(request.getParameter("nome"));

        // setar as variaveis Piloto
        cadastroPiloto.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        cadastroPiloto.setNome(request.getParameter("nome"));
        cadastroPiloto.setPais(request.getParameter("pais"));
        cadastroPiloto.setIdade(Integer.parseInt(request.getParameter("idade")));
        cadastroPiloto.setEquipe(request.getParameter("equipe"));
        cadastroPiloto.setFabricante(request.getParameter("fabricante"));
        cadastroPiloto.setPontos(Integer.parseInt(request.getParameter("pontos")));

        daopiloto.alterarCadastro(cadastroPiloto);
        // redirecionar para o ducumento cadastro

        response.sendRedirect("mainPiloto");

    }

    protected void removerCadastroPiloto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // remover contato

        String matricula = request.getParameter("matricula");
        System.out.println(matricula);
        // recebimento do id do contato a ser excluido validador.js
        cadastroPiloto.setMatricula(Integer.parseInt(matricula));

        // executa rum metodo deletar contato
        daopiloto.deletarCadastro(cadastroPiloto);

        // redirecionar para o documento cadastro.jsp
        response.sendRedirect("mainPiloto");
    }

    // gerar relarotio em pdf
    protected void gerarRelatorioPiloto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document documento = new Document();

        try {

            // tipo de conteudo
            response.setContentType("apllication/pdf");
            // nome do documento
            response.addHeader("Content-Disposition", "inline; filename=" + "Lista de Pilotos.pdf");
            PdfWriter.getInstance(documento, response.getOutputStream());
            // abrir para gerar o conteudo

            documento.open();
            documento.add(new Paragraph("Lista de Pilotos"));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            // criar uma tabela

            PdfPTable tabela = new PdfPTable(6);

            PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Pais"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Idade"));
            PdfPCell col4 = new PdfPCell(new Paragraph("Equipe"));
            PdfPCell col5 = new PdfPCell(new Paragraph("Fabricante"));
            PdfPCell col6 = new PdfPCell(new Paragraph("Pontos"));

            tabela.addCell(col1);
            tabela.addCell(col2);
            tabela.addCell(col3);
            tabela.addCell(col4);
            tabela.addCell(col5);
            tabela.addCell(col6);

            // popular tabela
            ArrayList<Piloto> lista = daopiloto.listarCadastros();

            for (int i = 0; i < lista.size(); i++) {
                tabela.addCell(lista.get(i).getNome());
                tabela.addCell(lista.get(i).getPais());
                tabela.addCell(String.valueOf(lista.get(i).getIdade()));
                tabela.addCell(lista.get(i).getEquipe());
                tabela.addCell(lista.get(i).getFabricante());
                tabela.addCell(String.valueOf(lista.get(i).getPontos()));

            }

            documento.add(tabela);
            documento.close();

        } catch (DocumentException | IOException e) {
            // TODO: handle exception
        }

    }

//listar contatos
    protected void cadastrosVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.sendRedirect("cadastro.jsp");
        // criando objeto que ira receber os dados Piloto

        ArrayList<Veiculo> lista = daoVeiculo.listarCadastros();

        // for (int i = 0; i < lista.size(); i++) {
        // System.out.println(lista.get(i).getIdcon());
        // System.out.println(lista.get(i).getNome());
        // System.out.println(lista.get(i).getFone());
        // System.out.println(lista.get(i).getEmail());
        request.setAttribute("cadastrosVeiculo", lista);
        RequestDispatcher rd = request.getRequestDispatcher("cadastroVeiculo.jsp");
        rd.forward(request, response);
    }

//novo contato
    protected void novoCadastroVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getParameter("renavam"));

//setar as variaveis Piloto
        cadastroVeiculo.setRenavam(Integer.parseInt(request.getParameter("renavam")));
        cadastroVeiculo.setMarca(request.getParameter("marca"));
        cadastroVeiculo.setModelo(request.getParameter("modelo"));
        cadastroVeiculo.setCor(request.getParameter("cor"));
        cadastroVeiculo.setPlaca(request.getParameter("placa"));
        cadastroVeiculo.setanoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
        cadastroVeiculo.setCategoria(request.getParameter("categoria"));
        cadastroVeiculo.setCombustivel(request.getParameter("combustivel"));
        cadastroVeiculo.setKilometragem(Double.parseDouble(request.getParameter("kilometragem")));

        // invocar o metodo inserir contato passando o objeto contato
        daoVeiculo.inserirCadastro(cadastroVeiculo);
        // redirecionar para o documento cadastro.jsp
        response.sendRedirect("mainVeiculo");

    }

    // editar contato
    protected void listarCadastroVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recebimento do id do contato que sera editado

        String renavam = request.getParameter("renavam");

        System.out.println("renavam");
        // setor a variavel java beans
        cadastroVeiculo.setRenavam(Integer.parseInt(renavam));
        //cadastroVeiculo.setRenavam(Integer.parseInt(request.getParameter("renavam")));

        //cadastroPiloto.setMatricula(Integer.parseInt(matricula));
        // executar o metodo selecionar contato classe dao
        daoVeiculo.selecionarCadastro(cadastroVeiculo);

        // teste de recebimento
        System.out.println(cadastroVeiculo.getRenavam());
        System.out.println(cadastroVeiculo.getMarca());
        System.out.println(cadastroVeiculo.getModelo());
        System.out.println(cadastroVeiculo.getCor());
        System.out.println(cadastroVeiculo.getPlaca());
        System.out.println(cadastroVeiculo.getanoFabricacao());
        System.out.println(cadastroVeiculo.getCategoria());
        System.out.println(cadastroVeiculo.getCombustivel());
        System.out.println(cadastroVeiculo.getKilometragem());

        // seytar os atributor do formulario com Piloto
        request.setAttribute("renavam", cadastroVeiculo.getRenavam());
        request.setAttribute("marca", cadastroVeiculo.getMarca());
        request.setAttribute("modelo", cadastroVeiculo.getModelo());
        request.setAttribute("cor", cadastroVeiculo.getCor());
        request.setAttribute("placa", cadastroVeiculo.getPlaca());
        request.setAttribute("anoFabricacao", cadastroVeiculo.getanoFabricacao());
        request.setAttribute("categoria", cadastroVeiculo.getCategoria());
        request.setAttribute("combustivel", cadastroVeiculo.getCombustivel());
        request.setAttribute("kilometragem", cadastroVeiculo.getKilometragem());

        // encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editarVeiculo.jsp");
        rd.forward(request, response);
    }

    // metodo de edicao
    protected void editarCadastroVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // teste de recebimento
        System.out.println(request.getParameter("renavam"));
        // System.out.println(request.getParameter("nome"));

        // setar as variaveis veiculo
        cadastroVeiculo.setRenavam(Integer.parseInt(request.getParameter("renavam")));
        cadastroVeiculo.setMarca(request.getParameter("marca"));
        cadastroVeiculo.setModelo(request.getParameter("modelo"));
        cadastroVeiculo.setCor(request.getParameter("cor"));
        cadastroVeiculo.setPlaca(request.getParameter("placa"));
        cadastroVeiculo.setanoFabricacao(Integer.parseInt(request.getParameter("anoFabricacao")));
        cadastroVeiculo.setCategoria(request.getParameter("categoria"));
        cadastroVeiculo.setCombustivel(request.getParameter("combustivel"));
        cadastroVeiculo.setKilometragem(Double.parseDouble(request.getParameter("kilometragem")));

        daoVeiculo.alterarCadastro(cadastroVeiculo);

        // redirecionar para o ducumento cadastro
        response.sendRedirect("mainVeiculo");

    }

    protected void removerCadastroVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // remover contato

        String renavam = request.getParameter("renavam");
        System.out.println(renavam);
        // recebimento do id do contato a ser excluido validador.js
        cadastroVeiculo.setRenavam(Integer.parseInt(renavam));

        // executa rum metodo deletar contato
        daoVeiculo.deletarCadastro(cadastroVeiculo);

        // redirecionar para o documento cadastro.jsp
        response.sendRedirect("mainVeiculo");
    }

    // gerar relarotio em pdf
    protected void gerarRelatorioVeiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document documento = new Document();

        try {

            // tipo de conteudo
            response.setContentType("apllication/pdf");
            // nome do documento
            response.addHeader("Content-Disposition", "inline; filename=" + "Lista de Veículos.pdf");
            PdfWriter.getInstance(documento, response.getOutputStream());
            // abrir para gerar o conteudo

            documento.open();
            documento.add(new Paragraph("Lista de Veículos"));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));

            // criar uma tabela
            PdfPTable tabela = new PdfPTable(9);

            PdfPCell col1 = new PdfPCell(new Paragraph("Renavam"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Marca"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Modelo"));
            PdfPCell col4 = new PdfPCell(new Paragraph("Cor"));
            PdfPCell col5 = new PdfPCell(new Paragraph("Placa"));
            PdfPCell col6 = new PdfPCell(new Paragraph("Ano Fabricação"));
            PdfPCell col7 = new PdfPCell(new Paragraph("Categoria"));
            PdfPCell col8 = new PdfPCell(new Paragraph("Combustível"));
            PdfPCell col9 = new PdfPCell(new Paragraph("Kilometragem"));

            tabela.addCell(col1);
            tabela.addCell(col2);
            tabela.addCell(col3);
            tabela.addCell(col4);
            tabela.addCell(col5);
            tabela.addCell(col6);
            tabela.addCell(col7);
            tabela.addCell(col8);
            tabela.addCell(col9);

            // popular tabela
            ArrayList<Veiculo> lista = daoVeiculo.listarCadastros();

            for (int i = 0; i < lista.size(); i++) {
                tabela.addCell(String.valueOf(lista.get(i).getRenavam()));
                tabela.addCell(lista.get(i).getMarca());
                tabela.addCell(lista.get(i).getModelo());
                tabela.addCell(lista.get(i).getCor());
                tabela.addCell(lista.get(i).getPlaca());
                tabela.addCell(String.valueOf(lista.get(i).getanoFabricacao()));
                tabela.addCell(lista.get(i).getCategoria());
                tabela.addCell(lista.get(i).getCombustivel());
                tabela.addCell(String.valueOf(lista.get(i).getKilometragem()));

            }

            documento.add(tabela);
            documento.close();

        } catch (DocumentException | IOException e) {
            // TODO: handle exception
        }
    }

    protected void cadastrosCorrida(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.sendRedirect("cadastro.jsp");
        // criando objeto que ira receber os dados Piloto

        ArrayList<Corrida> lista = dc.listarCadastros();
        // for (int i = 0; i < lista.size(); i++) {
        // System.out.println(lista.get(i).getIdcon());
        // System.out.println(lista.get(i).getNome());
        // System.out.println(lista.get(i).getFone());
        // System.out.println(lista.get(i).getEmail());

        request.setAttribute("cadastrosCorrida", lista);
        RequestDispatcher rd = request.getRequestDispatcher("cadastroCorrida.jsp");
        rd.forward(request, response);

    }

    protected void novoCadastroCorrida(HttpServletRequest request, HttpServletResponse response) {

        cadastrocorrida.setNome(request.getParameter("nomecorrida"));

        try {
            // System.out.println(request.getParameter("nome"));
//setar as variaveis Piloto
            cadastrocorrida.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cadastrocorrida.setData(request.getParameter("data")));
        cadastrocorrida.setHora(request.getParameter("hora"));

        cadastrocorrida.setCircuito(request.getParameter("circuito"));

        // invocar o metodo inserir contato passando o objeto contato
        dc.inserirCorrida(cadastrocorrida);

        try {
            // redirecionar para o documento cadastro.jsp
            response.sendRedirect("mainCorrida");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void listarCadastroCorrida(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recebimento do id do contato que sera editado

        String id = request.getParameter("id");

        System.out.println("id");
        // setor a variavel java beans
        cadastrocorrida.setId(Integer.parseInt(id));
        //cadastroVeiculo.setRenavam(Integer.parseInt(request.getParameter("renavam")));

        //cadastroPiloto.setMatricula(Integer.parseInt(matricula));
        // executar o metodo selecionar contato classe dao
        dc.selecionarCadastro(cadastrocorrida);
        System.out.println(cadastrocorrida.getNome());
        // teste de recebimento
        /*System.out.println(cadastroVeiculo.getRenavam());
        System.out.println(cadastroVeiculo.getMarca());
        System.out.println(cadastroVeiculo.getModelo());
        System.out.println(cadastroVeiculo.getCor());
        System.out.println(cadastroVeiculo.getPlaca());
        System.out.println(cadastroVeiculo.getanoFabricacao());
        System.out.println(cadastroVeiculo.getCategoria());
        System.out.println(cadastroVeiculo.getCombustivel());
        System.out.println(cadastroVeiculo.getKilometragem());
         */
        // seytar os atributor do formulario com Piloto
        request.setAttribute("id", cadastrocorrida.getId());
        request.setAttribute("nomecorrida", cadastrocorrida.getNome());
        request.setAttribute("data", cadastrocorrida.getData());
        request.setAttribute("hora", cadastrocorrida.getHora());
        request.setAttribute("circuito", cadastrocorrida.getCircuito());

        // encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editarCorrida.jsp");
        rd.forward(request, response);
    }

    protected void editarCadastroCorrida(HttpServletRequest request, HttpServletResponse response) {
        // teste de recebimento
        System.out.println(request.getParameter("nomecorrida"));
        // System.out.println(request.getParameter("nome"));

        // setar as variaveis Piloto
        cadastrocorrida.setId(Integer.parseInt(request.getParameter("id")));
        cadastrocorrida.setNome(request.getParameter("nomecorrida"));
        try {
            cadastrocorrida.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        cadastrocorrida.setHora((request.getParameter("hora")));
        cadastrocorrida.setCircuito(request.getParameter("circuito"));

        dc.alterarCadastro(cadastrocorrida);
        // redirecionar para o ducumento cadastro
        try {
            response.sendRedirect("mainCorrida");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void cadastrosParticipante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.sendRedirect("cadastro.jsp");
        // criando objeto que ira receber os dados Piloto

        ArrayList<Participante> lista = (ArrayList<Participante>) daoparticipante.ConsultarTodos();
        // for (int i = 0; i < lista.size(); i++) {
        // System.out.println(lista.get(i).getIdcon());
        // System.out.println(lista.get(i).getNome());
        // System.out.println(lista.get(i).getFone());
        // System.out.println(lista.get(i).getEmail());

        request.setAttribute("cadastrosParticipante", lista);
        RequestDispatcher rd = request.getRequestDispatcher("addParticipante.jsp");
        // RequestDispatcher  rd = request.getRequestDispatcher("addParticipante.jsp");

        rd.forward(request, response);

    }

    protected void removerCadastroCorrida(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // remover contato

        String id = request.getParameter("id");
        System.out.println(id);
        // recebimento do id do contato a ser excluido validador.js
        cadastrocorrida.setId(Integer.parseInt(id));

        // executa rum metodo deletar contato
        dc.deletarCadastro(cadastrocorrida);

        // redirecionar para o documento cadastro.jsp
        response.sendRedirect("mainCorrida");
    }

    protected void novoParticipante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valorPiloto = request.getParameter("comboPiloto");
        String valorVeiculo = request.getParameter("comboVeiculo");
        String valorCorrida = request.getParameter("id");


        DaoPiloto dp = new DaoPiloto();
        DaoVeiculo dv = new DaoVeiculo();
        DaoCorrida dc = new DaoCorrida();
        DaoParticipante dpart = new DaoParticipante();

        Participante part = new Participante();
        part.setPiloto(dp.ConsultarCadastro(Integer.parseInt(valorPiloto)));
        part.setVeiculo(dv.ConsultarCadastro(Integer.parseInt(valorVeiculo)));
        part.setCorrida(dc.ConsultarCadastro(Integer.parseInt(valorCorrida)));


        /*request.setAttribute("codpiloto", part.getPiloto().getNome());
        request.setAttribute("cadveiculo", part.getVeiculo().getRenavam());

        request.setAttribute("cadcorrida", part.getCorrida().getId());

         */
        // cadastroPiloto.setNome(request.getParameter("nome"));
        dpart.Inserir(part);
        System.out.println(valorPiloto);

        // encaminhar ao documento editar.jsp
        //RequestDispatcher rd = request.getRequestDispatcher("addParticipante.jsp");
        //rd.forward(request, response);
        response.sendRedirect("Gp.jsp?id="+ valorCorrida);

    }

    protected void listarCadastroParticipante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recebimento do id do contato que sera editado
        String id = request.getParameter("id");
        System.out.println("id");
        // setor a variavel java beans

        cadastroparticipante.setId(Integer.parseInt(id));
        // executar o metodo selecionar contato classe dao
        daoparticipante.selecionarCadastro(cadastroparticipante);

        // teste de recebimento
        // seytar os atributor do formulario com Piloto
        request.setAttribute("id", cadastroparticipante.getId());
        request.setAttribute("codpiloto", cadastroparticipante.getPiloto());
        request.setAttribute("cadveiculo", cadastroparticipante.getVeiculo());
        request.setAttribute("cadcorrida", cadastroparticipante.getCorrida());

        // encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editarParticipante.jsp");
        rd.forward(request, response);
    }
/*
protected void cadastrosParticipante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.sendRedirect("cadastro.jsp");
        // criando objeto que ira receber os dados Piloto

        ArrayList<Participante> lista =  daoparticipante.selecionarCadastro(Participante p);
        // for (int i = 0; i < lista.size(); i++) {
        // System.out.println(lista.get(i).getIdcon());
        // System.out.println(lista.get(i).getNome());
        // System.out.println(lista.get(i).getFone());
        // System.out.println(lista.get(i).getEmail());

        request.setAttribute("cadastrosParticipante", lista);
        RequestDispatcher rd = request.getRequestDispatcher("cadastroParticipante.jsp");
        // RequestDispatcher  rd = request.getRequestDispatcher("addParticipante.jsp");

        rd.forward(request, response);

*/

    protected void editarCadastroParticipante(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
         String valorPiloto = request.getParameter("comboPiloto");
        String valorVeiculo = request.getParameter("comboVeiculo");
        String valorCorrida = request.getParameter("id");


        DaoPiloto dp = new DaoPiloto();
        DaoVeiculo dv = new DaoVeiculo();
        DaoCorrida dc = new DaoCorrida();
        DaoParticipante dpart = new DaoParticipante();

        Participante part = new Participante();
        part.setPiloto(dp.ConsultarCadastro(Integer.parseInt(valorPiloto)));
        part.setVeiculo(dv.ConsultarCadastro(Integer.parseInt(valorVeiculo)));
        part.setCorrida(dc.ConsultarCadastro(Integer.parseInt(valorCorrida)));

       
        dpart.Alterar(part);
        System.out.println(valorPiloto);

        // encaminhar ao documento editar.jsp
        //RequestDispatcher rd = request.getRequestDispatcher("addParticipante.jsp");
        //rd.forward(request, response);
        response.sendRedirect("Gp.jsp?id="+ valorCorrida);
    }
}

