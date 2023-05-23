/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.bean.Itens;
import model.dao.ItensDAO;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author lyand
 */
public class ConsultarCadastro extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarCadastro
     */
    public ConsultarCadastro() {
        initComponents();
        readJTable();
    }

    public void readJTable() {
        DefaultTableModel tabelaItens = (DefaultTableModel) tblItens.getModel();
        tabelaItens.setNumRows(0);

        ItensDAO item_dao = new ItensDAO();
        for (Itens i : item_dao.read()) {
            tabelaItens.addRow(new Object[]{
                i.getId(),
                i.getNome(),
                i.getQuantidade(),
                i.getData(),
                i.getAquisicao(),
                i.getRecurso(),
                i.getTipo(),
                i.getSituacao()
            });
        }
    }
    
    public void pesquisaItemNome() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_itens WHERE nome LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + pesquisarItem.getText() + "%");
            rs = stmt.executeQuery();

            tblItens.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar item por nome: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void pesquisaItemAquisicao() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_itens WHERE aquisicao LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + filtroAquisicao.getSelectedItem().toString() + "%");
            rs = stmt.executeQuery();

            tblItens.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar item por forma de aquisição: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void pesquisaItemRecurso() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_itens WHERE recurso LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + filtroRecurso.getSelectedItem().toString() + "%");
            rs = stmt.executeQuery();

            tblItens.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar item por recurso: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void pesquisaItemTipo() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_itens WHERE tipo LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + filtroTipo.getSelectedItem().toString() + "%");
            rs = stmt.executeQuery();

            tblItens.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar item por tipo: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public void pesquisaItemSituacao() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_itens WHERE situacao LIKE ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + filtroSituacao.getSelectedItem().toString() + "%");
            rs = stmt.executeQuery();

            tblItens.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar item por situação: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        pesquisarItem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        filtroAquisicao = new javax.swing.JComboBox<>();
        filtroRecurso = new javax.swing.JComboBox<>();
        filtroTipo = new javax.swing.JComboBox<>();
        filtroSituacao = new javax.swing.JComboBox<>();
        btnConsultarCad = new javax.swing.JButton();
        btnEditarItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Data de Entrada", "Aquisicao", "Recurso", "Tipo", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblItens);

        pesquisarItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pesquisarItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        pesquisarItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisarItemKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filtros de Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        filtroAquisicao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        filtroAquisicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Compra", "Doação SEDUC", "Doação terceiros" }));
        filtroAquisicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de Aquisição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        filtroAquisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroAquisicaoActionPerformed(evt);
            }
        });

        filtroRecurso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        filtroRecurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PRO-ESCOLA", "PDDE", "EQUIPAR", "Não se Aplica" }));
        filtroRecurso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recurso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        filtroRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroRecursoActionPerformed(evt);
            }
        });

        filtroTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        filtroTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Eletrodoméstico", "Eletroeletrônico", "Cozinha" }));
        filtroTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        filtroTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroTipoActionPerformed(evt);
            }
        });

        filtroSituacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        filtroSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Em uso", "Sucateado" }));
        filtroSituacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Situação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        filtroSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroSituacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtroRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(filtroAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(filtroRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(filtroTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(filtroSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnConsultarCad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConsultarCad.setText("Cadastrar Item");
        btnConsultarCad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCadActionPerformed(evt);
            }
        });

        btnEditarItem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarItem.setText("Editar Item");
        btnEditarItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(pesquisarItem))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(btnConsultarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarCad)
                    .addComponent(btnEditarItem))
                .addGap(6, 6, 6))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Consulta de Itens Cadastrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(725, 592));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void filtroSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroSituacaoActionPerformed
        // TODO add your handling code here:
        pesquisaItemSituacao();
    }//GEN-LAST:event_filtroSituacaoActionPerformed

    private void btnConsultarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCadActionPerformed
        // TODO add your handling code here:
        CadastroBens cadBens = new CadastroBens();
        cadBens.setVisible(true);
        cadBens.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_btnConsultarCadActionPerformed

    private void pesquisarItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarItemKeyReleased
        // TODO add your handling code here:
        pesquisaItemNome();
    }//GEN-LAST:event_pesquisarItemKeyReleased

    private void filtroTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroTipoActionPerformed
        // TODO add your handling code here:
        pesquisaItemTipo();
    }//GEN-LAST:event_filtroTipoActionPerformed

    private void filtroRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroRecursoActionPerformed
        // TODO add your handling code here:
        pesquisaItemRecurso();
    }//GEN-LAST:event_filtroRecursoActionPerformed

    private void filtroAquisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroAquisicaoActionPerformed
        // TODO add your handling code here:
        pesquisaItemAquisicao();
    }//GEN-LAST:event_filtroAquisicaoActionPerformed

    private void btnEditarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarItemActionPerformed
        // TODO add your handling code here:
        EditarBens edit = new EditarBens();
        edit.setVisible(true);
    }//GEN-LAST:event_btnEditarItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarCad;
    private javax.swing.JButton btnEditarItem;
    private javax.swing.JComboBox<String> filtroAquisicao;
    private javax.swing.JComboBox<String> filtroRecurso;
    private javax.swing.JComboBox<String> filtroSituacao;
    private javax.swing.JComboBox<String> filtroTipo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pesquisarItem;
    private javax.swing.JTable tblItens;
    // End of variables declaration//GEN-END:variables
}
