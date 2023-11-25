package com.piiv.piiv.entities;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "descricao", length = 50)
    private String descricao;

    @Column(name = "anoDeFabricacao")
    private int anoDeFabricacao;

    @Column(name = "anoDoModelo")
    private int anoDoModelo;

    @Column(name = "valor")
    private double valor;

    // Constructors, getters, setters, etc.

    public Car() {
    }

    public Car(String marca, String modelo, String descricao, int anoDeFabricacao, int anoDoModelo, double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.anoDeFabricacao = anoDeFabricacao;
        this.anoDoModelo = anoDoModelo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public int getAnoDoModelo() {
        return anoDoModelo;
    }

    public void setAnoDoModelo(int anoDoModelo) {
        this.anoDoModelo = anoDoModelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
