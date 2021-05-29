/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Participante;

/**
 *
 * @author leonardo
 */
@WebServlet(name = "PartipanteController", urlPatterns = {"/ParticipanteController"})
public class ParticipanteController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        novoParticipante(request, response);

    }

    protected void novoParticipante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valorPiloto = request.getParameter("comboPiloto");
        String valorVeiculo = request.getParameter("comboVeiculo");
        String valorCorrida = request.getParameter("comboCorrida");
        
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
        RequestDispatcher rd = request.getRequestDispatcher("addParticipante.jsp");
        rd.forward(request, response);

       response.sendRedirect("cadastro.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
