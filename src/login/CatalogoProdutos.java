
package login;

import BancoDeDados.MySQL;
import Objeto.produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CatalogoProdutos extends javax.swing.JFrame {
        MySQL conectar = new MySQL(); //acessar os métodos de conexao com o banco
        produto Produtos = new produto(); //acessar os atributos da classe produto
        
    public CatalogoProdutos() {
        initComponents();
        
    }

        private void listarProdutos(produto Produtos){
        this.conectar.conectaBanco();
        
        String pesquisa = this.pesquisa.getText();
        int consultaProdutos = this.filtro.getSelectedIndex();
        switch(consultaProdutos){
            case 0://Tamanho
        try {
            this.conectar.executarSQL(
                   "SELECT "       
                    + "codigo,"                 
                    + "modelo,"                 
                    + "marca,"                 
                    + "tamanho,"                 
                    + "cor,"                 
                    + "quantidade,"                 
                    + "preco"                 
                 + " FROM"
                     + " produtos "
                 + " WHERE"
                     + " tamanho = '" + pesquisa + "'"
                + ";"
            );
            
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            modelo.setNumRows(0);
            
            while(this.conectar.getResultSet().next()){
                modelo.addRow(new Object[]{this.conectar.getResultSet().getString("codigo"),
                                           this.conectar.getResultSet().getString("modelo"),
                                           this.conectar.getResultSet().getString("marca"),
                                           this.conectar.getResultSet().getString("tamanho"),
                                           this.conectar.getResultSet().getString("cor"),
                                           this.conectar.getResultSet().getString("quantidade"),
                                           this.conectar.getResultSet().getString("preco")
              });                          
           }
       //     System.out.println(this.conectar.getResultSet());
       //   if(this.conectar.getResultSet() == null){
       //   JOptionPane.showMessageDialog(null, "Produto não encontrado!");
       //  }
           
        } catch (Exception e) {            
            System.out.println("Erro ao consultar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto");
            
        }finally{      
            this.conectar.fechaBanco();  
            System.out.println("Banco Fechado");
        }     
        break;
        
            case 1: // Modelo
                try {
            this.conectar.executarSQL(
                   "SELECT "       
                    + "codigo,"                 
                    + "modelo,"                 
                    + "marca,"                 
                    + "tamanho,"                 
                    + "cor,"                 
                    + "quantidade,"                 
                    + "preco"                 
                 + " FROM"
                     + " produtos "
                 + " WHERE"
                     + " modelo = '" + pesquisa + "'"
                + ";"
            );
            
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            modelo.setNumRows(0);
            
            while(this.conectar.getResultSet().next()){
                modelo.addRow(new Object[]{this.conectar.getResultSet().getString("codigo"),
                                           this.conectar.getResultSet().getString("modelo"),
                                           this.conectar.getResultSet().getString("marca"),
                                           this.conectar.getResultSet().getString("tamanho"),
                                           this.conectar.getResultSet().getString("cor"),
                                           this.conectar.getResultSet().getString("quantidade"),
                                           this.conectar.getResultSet().getString("preco")
              });                          
           }
       //     System.out.println(this.conectar.getResultSet());
       //   if(this.conectar.getResultSet() == null){
       //   JOptionPane.showMessageDialog(null, "Produto não encontrado!");
       //  }
           
        } catch (Exception e) {            
            System.out.println("Erro ao consultar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto");
            
        }finally{      
            this.conectar.fechaBanco();  
            System.out.println("Banco Fechado");
        }break;
        
            case 2: // Marca
                try {
            this.conectar.executarSQL(
                   "SELECT "       
                    + "codigo,"                 
                    + "modelo,"                 
                    + "marca,"                 
                    + "tamanho,"                 
                    + "cor,"                 
                    + "quantidade,"                 
                    + "preco"                 
                 + " FROM"
                     + " produtos "
                 + " WHERE"
                     + " marca = '" + pesquisa + "'"
                + ";"
            );
            
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            modelo.setNumRows(0);
            
            while(this.conectar.getResultSet().next()){
                modelo.addRow(new Object[]{this.conectar.getResultSet().getString("codigo"),
                                           this.conectar.getResultSet().getString("modelo"),
                                           this.conectar.getResultSet().getString("marca"),
                                           this.conectar.getResultSet().getString("tamanho"),
                                           this.conectar.getResultSet().getString("cor"),
                                           this.conectar.getResultSet().getString("quantidade"),
                                           this.conectar.getResultSet().getString("preco")
              });                          
           }
       //     System.out.println(this.conectar.getResultSet());
       //   if(this.conectar.getResultSet() == null){
       //   JOptionPane.showMessageDialog(null, "Produto não encontrado!");
       //  }
           
        } catch (Exception e) {            
            System.out.println("Erro ao consultar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto");
            
        }finally{      
            this.conectar.fechaBanco();  
            System.out.println("Banco Fechado");
        }    break;
        
            case 3: // Cor
                try {
            this.conectar.executarSQL(
                   "SELECT "       
                    + "codigo,"                 
                    + "modelo,"                 
                    + "marca,"                 
                    + "tamanho,"                 
                    + "cor,"                 
                    + "quantidade,"                 
                    + "preco"                 
                 + " FROM"
                     + " produtos "
                 + " WHERE"
                     + " cor = '" + pesquisa + "'"
                + ";"
            );
            
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            modelo.setNumRows(0);
            
            while(this.conectar.getResultSet().next()){
                modelo.addRow(new Object[]{this.conectar.getResultSet().getString("codigo"),
                                           this.conectar.getResultSet().getString("modelo"),
                                           this.conectar.getResultSet().getString("marca"),
                                           this.conectar.getResultSet().getString("tamanho"),
                                           this.conectar.getResultSet().getString("cor"),
                                           this.conectar.getResultSet().getString("quantidade"),
                                           this.conectar.getResultSet().getString("preco")
              });                          
           }
       //     System.out.println(this.conectar.getResultSet());
       //   if(this.conectar.getResultSet() == null){
       //   JOptionPane.showMessageDialog(null, "Produto não encontrado!");
       //  }
           
        } catch (Exception e) {            
            System.out.println("Erro ao consultar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto");
            
        }finally{      
            this.conectar.fechaBanco();  
            System.out.println("Banco Fechado");
        }    
                
    } 
        
        
}
            private void limpar(){
        
                pesquisa.setText("");
        
        }
            MENU menu = new MENU();
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        listar = new javax.swing.JButton();
        filtro = new javax.swing.JComboBox<>();
        pesquisa = new javax.swing.JTextField();
        limpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        listar.setBackground(new java.awt.Color(102, 255, 255));
        listar.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        listar.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\list.png")); // NOI18N
        listar.setText("Listar");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        filtro.setBackground(new java.awt.Color(102, 255, 102));
        filtro.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        filtro.setForeground(new java.awt.Color(0, 0, 0));
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TAMANHO", "MODELO", "MARCA", "COR" }));

        pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaActionPerformed(evt);
            }
        });

        limpar.setBackground(new java.awt.Color(204, 204, 204));
        limpar.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        limpar.setText("X");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "modelo", "marca", "tamanho", "cor", "quantidade", "preco"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Filtro:");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\back.png")); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(listar)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpar)
                    .addComponent(listar)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CATÁLAGO PRODUTOS");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("______________________________________________________________________________________");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("-----------------------------------------------------------------------------------------------------------------------------------------------------");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(58, 58, 58))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        listarProdutos(Produtos);
        
        
    }//GEN-LAST:event_listarActionPerformed

    private void pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisaActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
            limpar();
    }//GEN-LAST:event_limparActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CatalogoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogoProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogoProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JButton listar;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
