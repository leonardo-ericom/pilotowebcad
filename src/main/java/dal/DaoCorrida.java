package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Corrida;
import util.Conexao;
import model.Piloto;
import model.Veiculo;
import static util.Conexao.conectar;

//import sun.tools.jar.resources.jar;
public class DaoCorrida {

    private Connection con;

    public DaoCorrida() {
        con = Conexao.conectar();

    }

    /**
     * modulo de conexao *
     */
    // parametros de conexao
    public void inserirCorrida(Corrida corrida) {
        String create = "insert into corrida(nomecorrida,data,hora,circuito) values(?,?,?,?)";
        try {
            // abrir a conexao com o banco

            //Connection con = conectar();
            // preparar a query para execu��o on banco de dados
            PreparedStatement pst = con.prepareStatement(create);

            // substituir os parametros pelo conteudo das variaveis javabeans
            pst.setString(1, corrida.getNome());
            pst.setDate(2, new java.sql.Date(corrida.getData().getTime()));
            pst.setString(3, corrida.getHora());
            pst.setString(4, corrida.getCircuito());

            // executar
            pst.executeUpdate();
            // encerrar a conexao com banco de dados

            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // crud read-leitura

    public ArrayList<Corrida> listarCadastros() {
        // criando um objeto para acessar Piloto
        ArrayList<Corrida> cadastros = new ArrayList<>();
        DaoPiloto dp = new DaoPiloto();
        DaoVeiculo dv = new DaoVeiculo();

        String read = "select * from corrida order by id";
        try {
            // abrindo a conexao
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            // la�o abaixo sera executado enquanto houver piloto

            while (rs.next()) {

                Corrida c = new Corrida();

// variaveis de apoio que recebem os dados do banco para corrida
                int id = rs.getInt(1);
                String nomecorrida = rs.getString(2);
                Date data = rs.getDate(3);
                String hora = rs.getString(4);
                String circuito = rs.getString(5);

                //
                //    int cadpiloto = rs.getInt(6);
                //  c.setPiloto(dp.ConsultarCadastro(cadpiloto));
                //int cadveiculo = rs.getInt(7);
                //c.setVeiculo(dv.ConsultarCadastro(cadveiculo));
                // populando o array list- armazenar tudo do banco no vetor dinamico
                cadastros.add(new Corrida(id, nomecorrida, data, hora, circuito));
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
    public void selecionarCadastro(Corrida cc) {
        String read2 = "select * from corrida where id=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);

            pst.setInt(1, cc.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //setar as variaveis da entidade piloto
                cc.setId(rs.getInt(1));
                cc.setNome(rs.getString(2));
                cc.setData(rs.getDate(3));
                cc.setHora(rs.getString(4));
                cc.setCircuito(rs.getString(5));

            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
         

    public Corrida ConsultarCadastro(Integer id) {
        String read2 = "select * from corrida where id=?";
        Corrida co = new Corrida();
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //setar as variaveis da entidade piloto

                co.setId(rs.getInt(1));
                co.setNome(rs.getString(2));
                co.setData(rs.getDate(3));
                co.setHora(rs.getString(4));
                co.setCircuito(rs.getString(5));
               
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return co;

    }

    public void alterarCadastro(Corrida cadastro) {

        String create = "update corrida set nomecorrida=?, data=?, hora=?, circuito=? where id = ?";

        try {

            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);

            pst.setString(1, cadastro.getNome());
            pst.setDate(2, new java.sql.Date(cadastro.getData().getTime()));
            pst.setString(3, cadastro.getHora());
            pst.setString(4, cadastro.getCircuito());
            pst.setInt(5, cadastro.getId());
            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletarCadastro(Corrida cadastro) {
        String delete = "delete from corrida where id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, cadastro.getId());
            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

  
}
