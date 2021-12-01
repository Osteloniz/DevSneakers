package login;

import BancoDeDados.MySQL;
import Objeto.cliente;
import Objeto.produto;
import javax.swing.JOptionPane;

public class Vendas extends javax.swing.JFrame {
    MySQL conectar = new MySQL(); //acessar os métodos de conexao com o banco
    cliente novoCliente = new cliente(); //acessar os atributos da classe cliente
        
        private boolean validarVenda(){
            //pesquisa para validar informações no banco (codigo)
            
            
            return true;}
        
        private void venda(){
            
        produto novoProduto = new produto();
                
        this.conectar.conectaBanco();
        
        String consultaProduto = this.codigoInput.getText(); 
        
        try {
             
           if( validarVenda()){
            
            //buscando no banco a quantidade produto
            this.conectar.executarSQL(
                   "SELECT "  
                    + "id,"
                    + "codigo,"       
                    + "quantidade"              
                 + " FROM"
                     + " produtos "
                 + " WHERE"
                     + " codigo = '" + consultaProduto + "'"
                + ";"
            );
                System.out.println("teste");
                
             // novoProduto.setid(this.conectar.getResultSet().getString(1));
                int id_produto = (this.conectar.getResultSet().getInt(1));
                novoProduto.setcodigo(this.conectar.getResultSet().getString(2));
                novoProduto.setquantidade(this.conectar.getResultSet().getString(3));
                
           // alterando a quantidade do produto no banco
                int quantidadeBanco = Integer.parseInt(novoProduto.getquantidade());
                int resultado = quantidadeBanco - Integer.parseInt(quantidadeInput.getText());
                this.conectar.updateSQL(
                "UPDATE produtos SET "                    
                    + "quantidade = '" + Integer.toString(resultado) + 
                        "'WHERE codigo = '" + novoProduto.getcodigo() + "'"  
                        );
            //busca cliente
            
              String consultaCliente = this.InputCpf.getText(); 
              this.conectar.executarSQL(
                   "SELECT "
                    + "id"       
                 + " FROM"
                     + " clientes"
                 + " WHERE"
                     + " cpf = '" + consultaCliente + "'"
                + ";"
            );
              int idCliente = Integer.parseInt(this.conectar.getResultSet().getString(0));
               System.out.println(idCliente + "IdCliente");
              //insert na tabela Venda
              this.conectar.insertSQL("INSERT INTO venda ("
                    + "cod_cliente"
                + ") VALUES ("
                    + idCliente 
                + ");");
              this.conectar.executarSQL("SELECT LAST_INSERT_ID();");
              
              int codVendaInserido = Integer.parseInt(this.conectar.getResultSet().getString(0));
              
              //insert na tabela venda detalhe
              this.conectar.insertSQL("INSERT INTO venda_detalhe ("
                    + "cod_venda,"
                    + "cod_produto,"
                    + "quantidade_vendida"  
                + ") VALUES ("
                    + codVendaInserido + ","
                    + id_produto + ","
                    + quantidadeInput    
                + ");");
           }else{
           
               //mensagem de erro
               JOptionPane.showMessageDialog(null, "Produto não encontrado!"); 
           }   
        } catch (Exception e) {            
            System.out.println("Erro ao realizar venda " +  e);
            JOptionPane.showMessageDialog(null, "Erro ao realizar a Venda");
   
        }finally{
            this.conectar.fechaBanco();   
        }               
    }    
    

    public Vendas() {
        initComponents();
    }private void limparCamposBusca(){
    InputCpf.setText("");
    codigoInput.setText("");
    quantidadeInput.setText("");
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoInput = new javax.swing.JTextField();
        confirmar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        quantidadeInput = new javax.swing.JTextField();
        InputCpf = new javax.swing.JFormattedTextField();
        voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cpf Cliente:");

        jLabel2.setText("Codigo Produto:");

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        try {
            InputCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputCpf)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(confirmar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codigoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quantidadeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidadeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar)
                    .addComponent(voltar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vendas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        venda();
    }//GEN-LAST:event_confirmarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        MENU menu = new MENU();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField InputCpf;
    private javax.swing.JTextField codigoInput;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField quantidadeInput;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
