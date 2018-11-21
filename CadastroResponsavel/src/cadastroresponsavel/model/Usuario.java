/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroresponsavel.model;

import java.util.Observable;

/**
 *
 * @author Sabrina Soares
 */
public class Usuario {
    private String nome;
    private int prontuario;
    private String senha;
    
    public Usuario() {
        
    }

    public String getNome() {
        return nome;
    }

    public int getProntuario() {
        return prontuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProntuario(int prontuario) {
        this.prontuario = prontuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
