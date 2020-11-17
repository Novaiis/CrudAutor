/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import controle.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucas Novais
 */
public class AutorDAO extends Conexao{
    
  public void inserir(Autor a) throws Exception {
     abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "INSERT INTO TB_AUTOR (nome,email,gen,num) values(?,?,?,null)";
        ps=(PreparedStatement) con.prepareStatement(query);
        ps.setString(1, a.getNome());
        ps.setString(2, a.getEmail());
        ps.setString(3, a.getGen());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Autor Inserido com sucesso!");
        fecharBanco();
        }    
  
  
  
  
  
  
 public void deletarAutor(Autor a) throws Exception{
         abrirBanco();
         String query = "delete from TB_AUTOR where num=?";
         ps=(PreparedStatement) con.prepareStatement(query);
         ps.setInt(1, a.getNum());
         ps.execute();
        JOptionPane.showMessageDialog(null, "Autor deletado com sucesso!");
        fecharBanco();
     }
 
 
 
 
 
 
public void PesquisarRegistro (Autor a) throws Exception {
        try{
         abrirBanco();  
         String query = "select nome, email, gen, num FROM TB_AUTOR where num=?";
         ps = (PreparedStatement) con.prepareStatement(query);
         ps.setInt(1, a.getNum());
         ResultSet tr = ps.executeQuery();
         if (tr.next()){  
           a.setNome(tr.getString("nome"));
           a.setEmail(tr.getString("email"));
           a.setGen(tr.getString("Genero"));
           a.setNum(tr.getInt("num"));
         } else{
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado! ");
         }
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
     }
 
 public ArrayList<Autor> PesquisarTudo () throws Exception {
       ArrayList<Autor> autor = new ArrayList<Autor>();
         try{
         abrirBanco();  
         String query = "select num, nome FROM TB_AUTOR";
         ps = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = ps.executeQuery();
         Autor a ;
         while (tr.next()){               
           a = new Autor();
           a.setNum(tr.getInt("num"));
           a.setNome(tr.getString("nome"));
           autor.add(a);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
     } 
       return autor;
     }
 
 public void editarAutor(Autor a) throws Exception {
     abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE TB_AUTOR set nome = ?, email = ?, gen = ? where num = ?";
        ps=(PreparedStatement) con.prepareStatement(query);
        ps.setString(1, a.getNome());
        ps.setString(2, a.getEmail());
        ps.setString(3, a.getGen());
        ps.setInt(4, a.getNum());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Autor Alterado com sucesso!");
        fecharBanco();
        }

}
