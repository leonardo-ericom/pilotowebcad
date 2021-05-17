package model;

public class Piloto {

	 private int matricula;
	    private String nome;
	    private String pais;
	    private int idade;
	    private String equipe;
	    private String fabricante;
	    private int pontos;
		public int getMatricula() {
			return matricula;
		}
				
		
		public Piloto() {
			super();
			// TODO Auto-generated constructor stub
		}



		public Piloto(int matricula, String nome, String pais, int idade, String equipe, String fabricante,
				int pontos) {
			super();
			this.matricula = matricula;
			this.nome = nome;
			this.pais = pais;
			this.idade = idade;
			this.equipe = equipe;
			this.fabricante = fabricante;
			this.pontos = pontos;
		}



		public void setMatricula(int matricula) {
			this.matricula = matricula;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		public String getEquipe() {
			return equipe;
		}
		public void setEquipe(String equipe) {
			this.equipe = equipe;
		}
		public String getFabricante() {
			return fabricante;
		}
		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}
		public int getPontos() {
			return pontos;
		}
		public void setPontos(int pontos) {
			this.pontos = pontos;
		}

	
}
