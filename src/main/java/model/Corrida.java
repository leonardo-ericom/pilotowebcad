/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author leonardo
 */
public class Corrida {
    
    private Integer id;
    private String nome;
    private Date data;
    private String hora;
    private String circuito;
    


				
		
		public Corrida() {
			super();
			// TODO Auto-generated constructor stub
		}
public Corrida(int id, String nomeCorrida,Date data, String hora, String circuito
				) {
			super();
			this.id = id;
			this.nome = nomeCorrida;
			this.data = data;
			this.hora = hora;
			this.circuito = circuito;
			
}

   
    

		
		
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the circuito
     */
    public String getCircuito() {
        return circuito;
    }

    /**
     * @param circuito the circuito to set
     */
    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    /**
     * @return the piloto
     */
    
}
