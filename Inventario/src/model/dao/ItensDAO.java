/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.ResultSet;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Itens;

/**
 *
 * @author lyand
 */
public class ItensDAO {

    public void create(Itens i) {//Salva os dados de cada item na base de dados.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("INSERT INTO tbl_itens (nome, quantidade, dataEntrada, aquisicao, recurso, tipo, situacao)Values(?,?,?,?,?,?,?)");
            stmt.setString(1, i.getNome());
            stmt.setInt(2, i.getQuantidade());
            stmt.setString(3, i.getData());
            stmt.setString(4, i.getAquisicao());
            stmt.setString(5, i.getRecurso());
            stmt.setString(6, i.getTipo());
            stmt.setString(7, i.getSituacao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Itens> read() {//Pesquisa todos os itens da base de dados para exibir na tabela da janela de registro.

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Itens> itensCadastrados = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_itens");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Itens item = new Itens();

                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setData(rs.getString("dataEntrada"));
                item.setAquisicao(rs.getString("aquisicao"));
                item.setRecurso(rs.getString("recurso"));
                item.setTipo(rs.getString("tipo"));
                item.setSituacao(rs.getString("situacao"));

                itensCadastrados.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir dados em tabela: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return itensCadastrados;
    }

    public void update(Itens i) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE tbl_itens SET nome=?, quantidade=?, dataEntrada=?, aquisicao=?, recurso=?, tipo=?, situacao=? WHERE id=?");
            stmt.setString(1, i.getNome());
            stmt.setInt(2, i.getQuantidade());
            stmt.setString(3, i.getData());
            stmt.setString(4, i.getAquisicao());
            stmt.setString(5, i.getRecurso());
            stmt.setString(6, i.getTipo());
            stmt.setString(7, i.getSituacao());
            stmt.setInt(8, i.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Item Editado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Item:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
