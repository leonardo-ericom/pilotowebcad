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
					.prepareStatement("insert into participante(cadpiloto, codveiculo, codcorrida) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, pi.getPiloto().getMatricula());
                        preparedStatement.setInt(2, pi.getVeiculo().getRenavam());
                        preparedStatement.setInt(3, pi.getId());
                       
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
					.prepareStatement("update participante set cadpiloto=?, codveiculo=? where codpedido=? and coditem=?");
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
                                DaoVeiculo  dali = new DaoVeiculo ();
				DaoCorrida pi = new DaoCorrida();
                                Participante pp = new Participante();
                                
                                pp.setPiloto(dalp.ConsultarCadastro(rs.getInt("cadpiloto")));
                                pp.setVeiculo(dali.ConsultarCadastro(rs.getInt("codveiculo")));
                                pp.setCorrida(pi.ConsultarCadastro(rs.getInt("cadcorrida")));
                                
				pis.add(pp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pis;
	}
	                
       
	}

