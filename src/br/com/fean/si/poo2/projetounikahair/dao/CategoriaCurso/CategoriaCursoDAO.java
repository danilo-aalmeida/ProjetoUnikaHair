/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.projetounikahair.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.fean.si.poo2.projetounikahair.util.JDBC;
import br.com.fean.si.poo2.projetounikahair.model.CategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.view.PainelCRUDCategoriaCurso;

/**
 *
 * @author Lucas
 */
public class CategoriaCursoDao {

    JDBC jdbc = new JDBC();

    public String inserir(CategoriaCurso cc) {
        String retorno = "Categoria Curso inserida";
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO categoriacurso (nomecc, descricao) VALUES (?,?)");
            ps.setString(1, cc.getNomeCC());
            ps.setString(2, cc.getDescricao());
            ps.executeUpdate();

        } catch (SQLException ex) {
            retorno = "Erro ao inserir " + ex;
        } finally {
            jdbc.closeConnection(con, ps);
        }
        return retorno;
    }

    public String editar(CategoriaCurso cc) {
        String retorno = "Categoria Curso atualizada";
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE categoriacurso SET nomecc = ?, descricao = ? where id = ?");
            ps.setString(1, cc.getNomeCC());
            ps.setString(2, cc.getDescricao());
            ps.setInt(3, cc.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            retorno = "Erro ao atualizar " + ex;
        } finally {
            jdbc.closeConnection(con, ps);
        }
        return retorno;
    }

    public String excluir(CategoriaCurso categoriaCurso) {
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        String retorno = "Categoria excluida";
        try {
             ps = con.prepareStatement("delete from categoriacurso where id = ?");
                ps.setInt(1, categoriaCurso.getId());
                ps.executeUpdate();
        
        } catch (SQLException ex) {
            retorno = "Erro ao excluir " + ex;
        } finally {
            jdbc.closeConnection(con, ps);

        }
        return retorno;
    }

    public ArrayList<CategoriaCurso> listar(String palavraChave) {
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
   
        ArrayList<CategoriaCurso> lista = new ArrayList<CategoriaCurso>();
        try {

            String sql  = "select * from categoriacurso";
            if (palavraChave.length() > 0) {
                sql += " where nomecc like '%" + palavraChave + "%'";
            }
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaCurso cc = new CategoriaCurso(rs.getInt("id"), rs.getString("nomecc"), rs.getString("descricao"));
                lista.add(cc);
            }

        } catch (Exception e) {
            lista = null;
        } finally {
            jdbc.closeConnection(con, ps, rs);

        }
        return lista;

    }

 }
