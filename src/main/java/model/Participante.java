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
public class Participante {

    private Integer id;
    private Piloto piloto;
    private Veiculo veiculo;
    private Corrida corrida;

    public Participante() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Participante(int id, Piloto piloto, Veiculo veiculo, Corrida corrida) {
        super();
        this.id = id;
        this.piloto = piloto;
        this.veiculo = veiculo;
        this.corrida = corrida;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Corrida getCorrida() {
        return this.corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }
}
