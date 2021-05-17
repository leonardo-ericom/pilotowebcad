package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexao;
import model.Piloto;
import static util.Conexao.conectar;

//import sun.tools.jar.resources.jar;

public class DaoPiloto {
    
    private Connection con;
    
    public DaoPiloto(){
        con = Conexao.conectar();
        
    }
    
	/** modulo de conexao **/
	// parametros de conexao
	
	
	public void inserirCadastro(Piloto piloto) {
		String create = "insert into piloto(nome,pais,idade,equipe,fabricante,pontos) values(?,?,?,?,?,?)";
		try {
			// abrir a conexao com o banco

			//Connection con = conectar();

			// preparar a query para execu��o on banco de dados

			PreparedStatement pst = con.prepareStatement(create);

			// substituir os parametros pelo conteudo das variaveis javabeans

			pst.setString(1, piloto.getNome());
			pst.setString(2, piloto.getPais());
			pst.setInt(3, piloto.getIdade());
			pst.setString(4, piloto.getEquipe());
			pst.setString(5, piloto.getFabricante());
			pst.setInt(6, piloto.getPontos());

			// executar
			pst.executeUpdate();
			// encerrar a conexao com banco de dados

			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// teste de conexao

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// crud read-leitura
	public ArrayList<Piloto> listarCadastros() {
		// criando um objeto para acessar Piloto
		ArrayList<Piloto> cadastros = new ArrayList<>();
		String read = "select * from piloto order by nome";
		try {
			// abrindo a conexao
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// la�o abaixo sera executado enquanto houver piloto

			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				int matricula = rs.getInt(1);
				String nome = rs.getString(2);
				String pais = rs.getString(3);
				int idade = rs.getInt(4);
				String equipe = rs.getString(5);
				String fabricante = rs.getString(6);
				int pontos = rs.getInt(7);


				// populando o array list- armazenar tudo do banco no vetor dinamico

				cadastros.add(new Piloto(matricula, nome, pais, idade,equipe,fabricante,pontos));
			}
			con.close();
			return cadastros;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	// crud update

	// selecionar o contato
	public void selecionarCadastro(Piloto cadastroPiloto) {
		String read2 = "select * from piloto where matricula=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			
			
			pst.setInt(1, cadastroPiloto.getMatricula());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				//setar as variaveis da entidade piloto
				cadastroPiloto.setMatricula(rs.getInt(1));
				cadastroPiloto.setNome(rs.getString(2));
				cadastroPiloto.setPais(rs.getString(3));
				cadastroPiloto.setIdade(rs.getInt(4));
				cadastroPiloto.setEquipe(rs.getString(5));
				cadastroPiloto.setFabricante(rs.getString(6));
				cadastroPiloto.setPontos(rs.getInt(7));
				

			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
        
        public Piloto ConsultarCadastro(int matricula) {
		String read2 = "select * from piloto where matricula=?";
                Piloto p = new Piloto();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			
			
			pst.setInt(1, matricula);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				//setar as variaveis da entidade piloto
				
                                
                                p.setMatricula(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setPais(rs.getString(3));
				p.setIdade(rs.getInt(4));
				p.setEquipe(rs.getString(5));
				p.setFabricante(rs.getString(6));
				p.setPontos(rs.getInt(7));
				

			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
        return p;
	}
        
        
	// editar contato

	public void alterarCadastro(Piloto cadastro) {

		String create = "update piloto set nome=?, pais=?, idade=?, equipe=?, fabricante=?, pontos=? where matricula = ?";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getPais());
			pst.setInt(3, cadastro.getIdade());
			pst.setString(4, cadastro.getEquipe());
			pst.setString(5, cadastro.getFabricante());
			pst.setInt(6, cadastro.getPontos());
			pst.setInt(7, cadastro.getMatricula());
			
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//crud delete
	
	public void deletarCadastro(Piloto cadastro) {
		String delete = "delete from piloto where matricula=?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setInt(1,cadastro.getMatricula());
					pst.executeUpdate();
					con.close();
					
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
		
	}

}
