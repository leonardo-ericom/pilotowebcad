package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Piloto;

import model.Veiculo;
import static util.Conexao.conectar;

public class DaoVeiculo {
	/** modulo de conexao
     * @param veiculo **/
	// parametros de conexao
	
	public void inserirCadastro(Veiculo veiculo) {
		String create = "insert into veiculo(renavam,marca,modelo,cor,placa,anoFabricacao,categoria,combustivel,kilometragem) values(?,?,?,?,?,?,?,?,?)";
		try {
			// abrir a conexao com o banco

			Connection con = conectar();

                    // substituir os parametros pelo conteudo das variaveis controller
                    try ( // preparar a query para execu��o on banco de dados
                            PreparedStatement pst = con.prepareStatement(create)) {
                        // substituir os parametros pelo conteudo das variaveis controller
                        pst.setInt(1, veiculo.getRenavam());
                        pst.setString(2, veiculo.getMarca());
                        pst.setString(3, veiculo.getModelo());
                        pst.setString(4, veiculo.getCor());
                        pst.setString(5, veiculo.getPlaca());
                        pst.setInt(6, veiculo.getanoFabricacao());
                        pst.setString(7, veiculo.getCategoria());
                        pst.setString(8, veiculo.getCombustivel());
                        pst.setDouble(9, veiculo.getKilometragem());
                        
                        
                        // executar
                        pst.executeUpdate();
                        // encerrar a conexao com banco de dados
                    }
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	// teste de conexao

	public void testeConexao() {
		try {
                    try (Connection con = conectar()) {
                        System.out.println(con);
                    }

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	// crud read-leitura
	public ArrayList<Veiculo> listarCadastros() {
		
		String read = "select * from veiculo order by marca";
		// criando um objeto para acessar veiculo
		ArrayList<Veiculo> cadastros = new ArrayList<>();
		
		try {
                    try ( // abrindo a conexao
                            Connection con = conectar()) {
                        PreparedStatement pst = con.prepareStatement(read);
                        ResultSet rs = pst.executeQuery();
                        // la�o abaixo sera executado enquanto houver piloto
                        
                        while (rs.next()) {
                            // variaveis de apoio que recebem os dados do banco
                            int renavam = rs.getInt(1);
                            String marca = rs.getString(2);
                            String modelo = rs.getString(3);
                            String cor = rs.getString(4);
                            String placa = rs.getString(5);
                            int anoFabricacao = rs.getInt(6);
                            String categoria = rs.getString(7);
                            String combustivel = rs.getString(8);
                            double kilometragem = rs.getDouble(9);
                            
                            
                            // populando o array list- armazenar tudo do banco no vetor dinamico
                            
                            cadastros.add(new Veiculo(renavam,marca,modelo,cor,placa,anoFabricacao,categoria,combustivel,kilometragem));
                        }
                    }
			return cadastros;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}

	}
	// crud update

	// selecionar o contato
	public void selecionarCadastro(Veiculo cadastroVeiculo) {
		String read2 = "select * from veiculo where renavam=?";
		try {
                    try (Connection con = conectar()) {
                        PreparedStatement pst = con.prepareStatement(read2);
                        
                        pst.setInt(1, cadastroVeiculo.getRenavam());
                        ResultSet rs = pst.executeQuery();
                        
                        while (rs.next()) {
                            //setar as variaveis da entidade piloto
                            cadastroVeiculo.setRenavam(rs.getInt(1));
                            cadastroVeiculo.setMarca(rs.getString(2));
                            cadastroVeiculo.setModelo(rs.getString(3));
                            cadastroVeiculo.setCor(rs.getString(4));
                            cadastroVeiculo.setPlaca(rs.getString(5));
                            cadastroVeiculo.setanoFabricacao(rs.getInt(6));
                            cadastroVeiculo.setCategoria(rs.getString(7));
                            cadastroVeiculo.setCombustivel(rs.getString(8));
                            cadastroVeiculo.setKilometragem(rs.getDouble(9));
                            
                            
                        }
                    }

		} catch (SQLException e) {
			System.out.println(e);

		}
	}
    
	
        
        public Veiculo ConsultarCadastro(int renavam) {
		String read2 = "select * from veiculo where renavam=?";
                Veiculo v = new Veiculo();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			
			
			pst.setInt(1, renavam);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				//setar as variaveis da entidade piloto
				
                                
                            v.setRenavam(rs.getInt(1));
                            v.setMarca(rs.getString(2));
                            v.setModelo(rs.getString(3));
                            v.setCor(rs.getString(4));
                            v.setPlaca(rs.getString(5));
                            v.setanoFabricacao(rs.getInt(6));
                            v.setCategoria(rs.getString(7));
                            v.setCombustivel(rs.getString(8));
                            v.setKilometragem(rs.getDouble(9));
                                
                                
                                
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
        return v;
        }
	// editar contato

	public void alterarCadastro(Veiculo alterar) {

		String create = "update veiculo set marca=?, modelo=?, cor=?, placa=?, anoFabricacao=?, categoria=?, combustivel=?, kilometragem=? where renavam = ?";

		try {

                    try (Connection con = conectar()) {
                        PreparedStatement pst = con.prepareStatement(create);
                        
                        pst.setString(1, alterar.getMarca());
                        pst.setString(2, alterar.getModelo());
                        pst.setString(3, alterar.getCor());
                        pst.setString(4, alterar.getPlaca());
                        pst.setInt(5, alterar.getanoFabricacao());
                        pst.setString(6, alterar.getCategoria());
                        pst.setString(7, alterar.getCombustivel());
                        pst.setDouble(8, alterar.getKilometragem());
                        pst.setInt(9, alterar.getRenavam());
                        
                        pst.executeUpdate();
                    }

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//crud delete
	
	public void deletarCadastro(Veiculo cadastro) {
		String deletar = "delete from veiculo where renavam=?";
				
		
		try {
					
                    try (Connection con = conectar()) {
                        PreparedStatement pst = con.prepareStatement(deletar);
                        pst.setInt(1,cadastro.getRenavam());
                        pst.executeUpdate();
                    }
					
					
					
				} catch (SQLException e) {
					System.out.println(e);
				}
		
	}

}


