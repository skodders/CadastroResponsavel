/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrousuario.controller;

import cadastroresponsavel.infra.UsuarioDAO;
import cadastroresponsavel.model.Usuario;
import java.util.List;

/**
 *
 * @author Sabrina Soares
 */
public class UsuarioController {
    
    private UsuarioDAO uDAO = new UsuarioDAO();

    public UsuarioController() {
    }
    public void cadastrar(Usuario u) {
        uDAO.inserir(u);
    }


    public void alterarSenha(Usuario u) {   
        uDAO.alterarSenha(u);
    }

    public String obterNome(Usuario u) {
        return uDAO.exibirUsuario(u);
    }

    public boolean ConsultaLogin(int prontuario, String senha){
        return uDAO.consultar(prontuario, senha);
    }
}
