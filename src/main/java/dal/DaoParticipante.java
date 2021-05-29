/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Corrida;
import model.Participante;
import model.Piloto;

import model.Veiculo;
import util.Conexao;
import static util.Conexao.conectar;

/**
 *
 * @author leonardo
 */
public class DaoParticipante {

    private Connection connection;

    public DaoParticipante() {
        connection = Conexao.conectar();
    }

    public void Inserir(Participante pi) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into participante(codpiloto, cadveiculo, cadcorrida) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, pi.getPiloto().getMatricula());
            preparedStatement.setInt(2, pi.getVeiculo().getRenavam());
            preparedStatement.setInt(3, pi.getCorrida().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Remover(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from pedidoitem where id=? ");
            // Parameters start with 1
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Alterar(Participante pi) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update participante set codpiloto=?, cadveiculo=?, cadcorrida=?  where id =?");
            // Parameters start with 1
            preparedStatement.setInt(1, pi.getPiloto().getMatricula());
            preparedStatement.setDouble(2, pi.getVeiculo().getRenavam());
            preparedStatement.setInt(3, pi.getCorrida().getId());
            preparedStatement.setInt(4, pi.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Participante> ConsultarTodos() {
        List<Participante> pis = new ArrayList<Participante>();
        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from participante order by id");
            while (rs.next()) {
                DaoPiloto dalp = new DaoPiloto();
                DaoVeiculo dali = new DaoVeiculo();
                DaoCorrida pi = new DaoCorrida();
                Participante pp = new Participante();

                pp.setId(rs.getInt("id"));
                pp.setPiloto(dalp.ConsultarCadastro(rs.getInt("codpiloto")));
                pp.setVeiculo(dali.ConsultarCadastro(rs.getInt("cadveiculo")));
                pp.setCorrida(pi.ConsultarCadastro(rs.getInt("cadcorrida")));

                pis.add(pp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pis;
    }

    public void selecionarCadastro(Participante p) {

        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from participante where id=?");

            while (rs.next()) {
                //setar as variaveis da entidade piloto
                DaoPiloto dalp = new DaoPiloto();
                DaoVeiculo dali = new DaoVeiculo();
                DaoCorrida pi = new DaoCorrida();
                Participante pp = new Participante();

                p.setId(rs.getInt("id"));
                p.setPiloto(dalp.ConsultarCadastro(rs.getInt("codpiloto")));
                p.setVeiculo(dali.ConsultarCadastro(rs.getInt("cadveiculo")));
                p.setCorrida(pi.ConsultarCadastro(rs.getInt("cadcorrida")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public Participante selecionarCadastroById(int id) {

        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from participante where id=" + id);

            final DaoPiloto daoPiloto = new DaoPiloto();
            final DaoVeiculo daoVeiculo = new DaoVeiculo();
            final DaoCorrida daoCorrida = new DaoCorrida();
           Participante participante = null;
            while (rs.next()) {
              participante = new Participante();
                
             
                participante.setId(rs.getInt("id"));
        

                //pegando codpiloto
                int codpiloto = rs.getInt("codpiloto");
                Piloto piloto = daoPiloto.ConsultarCadastro(codpiloto);
                participante.setPiloto(piloto);
            
                //  participante.setPiloto(daoPiloto.ConsultarCadastro(rs.getInt("codpiloto")));

                //pegando codveiculo
                int cadveiculo = rs.getInt("cadveiculo");
                Veiculo veiculo = daoVeiculo.ConsultarCadastro(cadveiculo);
                participante.setVeiculo(veiculo);

                //pegando cadcorrida
                int cadcorrida = rs.getInt("cadcorrida");
                Corrida corrida = daoCorrida.ConsultarCadastro(cadcorrida);
                participante.setCorrida(corrida);

          
            

            }
            
      
                return participante;

        } catch (SQLException ex) {
            Logger.getLogger(DaoParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Participante> selecionarCadastroByCorridaId(int id) {

        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from participante where cadcorrida=" + id);

            final DaoPiloto daoPiloto = new DaoPiloto();
            final DaoVeiculo daoVeiculo = new DaoVeiculo();
            final DaoCorrida daoCorrida = new DaoCorrida();
            List<Participante> listParticipante = new ArrayList<>();
            while (rs.next()) {
                Participante participante = new Participante();
                
                
                participante.setId(rs.getInt("id"));
        

                //pegando codpiloto
                int codpiloto = rs.getInt("codpiloto");
                Piloto piloto = daoPiloto.ConsultarCadastro(codpiloto);
                participante.setPiloto(piloto);
            
                //  participante.setPiloto(daoPiloto.ConsultarCadastro(rs.getInt("codpiloto")));

                //pegando codveiculo
                int cadveiculo = rs.getInt("cadveiculo");
                Veiculo veiculo = daoVeiculo.ConsultarCadastro(cadveiculo);
                participante.setVeiculo(veiculo);

                //pegando cadcorrida
                int cadcorrida = rs.getInt("cadcorrida");
                Corrida corrida = daoCorrida.ConsultarCadastro(cadcorrida);
                participante.setCorrida(corrida);

                listParticipante.add(participante);
            

            }
            
                System.out.println("----------participante da corrida by id:" + listParticipante);
                return listParticipante;

        } catch (SQLException ex) {
            Logger.getLogger(DaoParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
