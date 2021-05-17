package model;



public class Veiculo {
	
	private int renavam;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private int anoFabricacao;
	private String categoria;
	private String combustivel;
	private double kilometragem;
	public int getRenavam() {
		return renavam;
	}
	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Veiculo(int renavam, String marca, String modelo, String cor, String placa, int anoFabricacao,
			String categoria, String combustivel, double kilometragem) {
		super();
		this.renavam = renavam;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.anoFabricacao = anoFabricacao;
		this.categoria = categoria;
		this.combustivel = combustivel;
		this.kilometragem = kilometragem;
	}
	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getanoFabricacao() {
		return anoFabricacao;
	}
	public void setanoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public double getKilometragem() {
		return kilometragem;
	}
	public void setKilometragem(double kilometragem) {
		this.kilometragem = kilometragem;
	}

}
