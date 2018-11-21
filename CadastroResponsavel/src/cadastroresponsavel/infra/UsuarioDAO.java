/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroresponsavel.infra;

import cadastroresponsavel.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sabrina Soares
 */
public class UsuarioDAO {
    private ConnectionFactory cn;
    private Connection con;
    private PreparedStatement stm;
    
    public UsuarioDAO() {
    }
    
    public void inserir(Usuario u) {
        try {
            cn = new ConnectionFactory();
            con = cn.obterConexao();
            stm = con.prepareStatement("INSERT INTO usuario(nome,prontuario,senha) VALUES(?,?,?)");
            stm.setString(1, u.getNome());
            stm.setInt(2, u.getProntuario());
            stm.setString(3, u.getSenha());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    } 
    
    public void alterarSenha(Usuario u) {
        try {
            cn = new ConnectionFactory();
            con = cn.obterConexao();
            stm = con.prepareStatement("UPDATE usuario SET senha = ? WHERE prontuario = ?");
            stm.setString(1, u.getSenha());
            stm.setInt(2, u.getProntuario());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

//    public List<Usuario> exibirSenha(Usuario u){
//        List<Usuario> usuario = new ArrayList();
//        try {
//            cn = new ConnectionFactory();
//            con = cn.obterConexao();
//            stm = con.prepareStatement("SELECT senha FROM usuario WHERE prontuario = ?");
//            stm.setInt(1, u.getProntuario());
//            
//            ResultSet rs = stm.executeQuery();
//            
//            while(rs.next()){
//                Usuario us = new Usuario();
//                us.setSenha(rs.getString("senha"));
//                
//                usuario.add(us);    
//            }
//        } catch (SQLException ex) {
//            System.out.println("Exceção de conexão ao banco.");
//            ex.printStackTrace();
//        }
//    return usuario;      
//    }
//
    public String exibirUsuario(Usuario u){
        String nome =null;
        try {
            cn = new ConnectionFactory();
            con = cn.obterConexao();
            stm = con.prepareStatement("SELECT nome FROM usuario WHERE prontuario = ?");
            stm.setInt(1, u.getProntuario());
            
             ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                nome= rs.getString("nome");
            }
        } catch (SQLException ex) {
            System.out.println("Exceção de conexão ao banco.");
            ex.printStackTrace();
        }
    return nome;      
    }
    
    public boolean consultar (int prontuario, String senha){
    // Manda como parametro para ele duas variaveis para ele procurar no banco de dados!
    boolean autenticado = false;    
    try{            
            String sql;
            cn = new ConnectionFactory();
            con = cn.obterConexao();
            sql = "select prontuario, senha from usuario where prontuario = ? and senha = ?";
 
            stm = con.prepareStatement(sql);
            stm.setInt(1, prontuario);
            stm.setString(2, senha);
 
            ResultSet rs = stm.executeQuery();
 
            if (rs.next()) {
                Usuario us = new Usuario();
                us.setProntuario(rs.getInt("Prontuario"));
                us.setSenha(rs.getString("senha"));
            autenticado = true;
            }
 
            stm.close();
   
 
            
 
        } catch (SQLException ex) {
            System.out.println("Exceção de conexão ao banco.");
            ex.printStackTrace();
        }
    return autenticado;
    }
}
