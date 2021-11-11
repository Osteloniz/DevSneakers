package login;

import BancoDeDados.MySQL;
import javax.swing.JOptionPane;
import Objeto.produto;

public class cadastroprodutos extends javax.swing.JFrame {
        MySQL conectar = new MySQL(); //acessar os métodos de conexao com o banco
        produto novoProduto = new produto(); //acessar os atributos da classe cliente
  
    public cadastroprodutos() {
        initComponents();
    }
        private void cadastraProduto(produto novoProduto){
        this.conectar.conectaBanco(); 
        
        novoProduto.setcodigo(codigo.getText());
        novoProduto.setmodelo(modelo.getText());
        novoProduto.setmarca(marca.getText());
        novoProduto.settamanho(tamanho.getText());
        novoProduto.setcor(cor.getText());
        novoProduto.setquantidade(quantidade.getText());
        novoProduto.setpreco(preco.getText());
        
        try {
                        
            this.conectar.insertSQL("INSERT INTO produtos ("
                    + "codigo,"
                    + "modelo,"
                    + "marca,"
                    + "tamanho,"
                    + "cor,"
                    + "quantidade,"
                    + "preco"
                + ") VALUES ("
                    + "'" + novoProduto.getcodigo() + "',"
                    + "'" + novoProduto.getmodelo() + "',"
                    + "'" + novoProduto.getmarca() + "',"
                    + "'" + novoProduto.gettamanho() + "',"
                    + "'" + novoProduto.getcor() + "',"
                    + "'" + novoProduto.getquantidade() + "',"
                    + "'" + novoProduto.getpreco() + "'"

                + ");");
           
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Produto");
            
        } finally{            
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
            //JOptionPane.showConfirmDialog(null, "Cliente cadastrado com sucesso");
            //novoProduto.limpaProduto();
            limparCamposCadastro();
        }                
    }
        
        private void limparCamposCadastro(){
        codigo.setText("");
        modelo.setText("");
        marca.setText("");
        tamanho.setText("");
        cor.setText("");
        quantidade.setText("");
        preco.setText("");
        
        }
        private void buscarProduto(produto novoProduto){
        this.conectar.conectaBanco();
        
        String consultaProduto = this.consultaCod.getText(); 
                
                novoProduto.setmodelo("");
                novoProduto.setmarca("");
                novoProduto.settamanho("");
                novoProduto.setcor("");
                novoProduto.setquantidade("");
                novoProduto.setpreco("");
               
        try {
            this.conectar.executarSQL(
                   "SELECT "       
                    + "modelo,"       
                    + "marca,"
                    + "tamanho,"
                    + "cor,"
                    + "quantidade,"
                    + "preco"
                         
                 + " FROM"
                     + " produtos "
                 + " WHERE"
                     + " codigo = '" + consultaProduto + "'"
                + ";"
            );
            
            while(this.conectar.getResultSet().next()){
                novoProduto.setmodelo(this.conectar.getResultSet().getString(1));
                novoProduto.setmarca(this.conectar.getResultSet().getString(2));
                novoProduto.settamanho(this.conectar.getResultSet().getString(3));
                novoProduto.setcor(this.conectar.getResultSet().getString(4));
                novoProduto.setquantidade(this.conectar.getResultSet().getString(5));
                novoProduto.setpreco(this.conectar.getResultSet().getString(6));
                                         
           }
            
           if(novoProduto.getmarca()== ""){
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
           }
           
        } catch (Exception e) {            
            System.out.println("Erro ao consultar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto");
            
        }finally{
            consultamodelo.setText(novoProduto.getmodelo());
            consultamarca.setText(novoProduto.getmarca());
            consultatamanho.setText(novoProduto.gettamanho());
            consultacor.setText(novoProduto.getcor());
            consultaQtd.setText(novoProduto.getquantidade());
            consultapreco.setText(novoProduto.getpreco());
            
            this.conectar.fechaBanco();   
        }               
    }
   private void deletarProduto(produto novoProduto){
        this.conectar.conectaBanco();
        
        String consultaProduto = this.consultaCod.getText(); 
        
        try {            
            this.conectar.updateSQL(
                "DELETE FROM produtos "
                + " WHERE "
                    + "codigo = '" + consultaProduto + "'"
                + ";"            
            );
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar Produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar Produto");
        }finally{
            this.conectar.fechaBanco();
            limparCamposBusca();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");            
        }     
        
    }
   public void atualizarProduto(produto novoProduto){
        this.conectar.conectaBanco();
        
        String consultaProduto = this.consultaCod.getText();
        
        try {
            this.conectar.updateSQL(
                "UPDATE produtos SET "                    
                    + "modelo = '" + consultamodelo.getText() + "',"
                    + "marca = '" + consultamarca.getText() + "',"
                    + "tamanho = '" + consultatamanho.getText() + "',"
                    + "cor = '" + consultacor.getText() + "',"
                    + "quantidade = '" + consultaQtd.getText() + "',"                   
                    + "preco = '" + consultapreco.getText() + "'"                   
                    
                + " WHERE "
                    + "codigo = '" + consultaProduto + "'"
                + ";"
            );
        }catch(Exception e){
            System.out.println("Erro ao atualizar produto " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto");
        }finally{
            this.conectar.fechaBanco();
            limparCamposBusca();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
        }
   }
   MENU menu = new MENU();
   
   private void limparCamposBusca(){
        consultaCod.setText("");
        consultamodelo.setText("");
        consultamarca.setText("");
        consultatamanho.setText("");
        consultacor.setText("");
        consultaQtd.setText("");
        consultapreco.setText("");
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        modelo = new javax.swing.JTextField();
        tamanho = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        cadastrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        limpacadastro = new javax.swing.JButton();
        preco = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textfild000 = new javax.swing.JLabel();
        consultaCod = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        consultamodelo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        consultamarca = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        consultatamanho = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        consultacor = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        limparcampobusca = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        consultaQtd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        consultapreco = new javax.swing.JFormattedTextField();
        deletar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Courier New", 3, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel3.setText("Tamanho");

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel4.setText("Modelo");

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel5.setText("Marca");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        tamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo)
                    .addComponent(modelo)
                    .addComponent(marca)
                    .addComponent(tamanho)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cadastrar.setBackground(new java.awt.Color(153, 255, 255));
        cadastrar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        cadastrar.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\cadastro.png")); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel6.setText("Cor");

        cor.setText(" ");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel7.setText("Quantidade");

        quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel15.setText("Preço:");

        limpacadastro.setBackground(new java.awt.Color(255, 255, 102));
        limpacadastro.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        limpacadastro.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\clean.png")); // NOI18N
        limpacadastro.setText("Limpar");
        limpacadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpacadastroActionPerformed(evt);
            }
        });

        preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(limpacadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(preco, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantidade, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cor))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpacadastro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Imagens/O TÊNIS PROGRAMADO Cadastro.gif"))); // NOI18N

        voltar.setBackground(new java.awt.Color(255, 51, 51));
        voltar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        voltar.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\back.png")); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(voltar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\consutlar produtos.png")); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        textfild000.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        textfild000.setText("Codigo:");

        jLabel10.setText("Modelo:");

        jLabel11.setText("Marca:");

        jLabel12.setText("Tamanho:");

        jLabel13.setText("Cor:");

        buscar.setBackground(new java.awt.Color(51, 255, 255));
        buscar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\lupa.png")); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        limparcampobusca.setBackground(new java.awt.Color(204, 204, 204));
        limparcampobusca.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        limparcampobusca.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\clean.png")); // NOI18N
        limparcampobusca.setText("Limpar");
        limparcampobusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparcampobuscaActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantidade:");

        jLabel14.setText("Preço");

        consultapreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        consultapreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaprecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(consultatamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(consultamarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(consultamodelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))))
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultapreco, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultaQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel9)
                    .addComponent(consultacor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limparcampobusca))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(textfild000)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consultaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfild000)
                    .addComponent(consultaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(limparcampobusca))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultacor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultamodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultaQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultamarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultatamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultapreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        deletar.setBackground(new java.awt.Color(255, 51, 51));
        deletar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        deletar.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\delete.png")); // NOI18N
        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        atualizar.setBackground(new java.awt.Color(102, 255, 102));
        atualizar.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        atualizar.setIcon(new javax.swing.ImageIcon("D:\\João Murat\\Projeto NetBeans\\DevSneakears\\src\\login\\Imagens\\sync.png")); // NOI18N
        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizar)
                    .addComponent(deletar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamanhoActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void limpacadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpacadastroActionPerformed
            limparCamposCadastro();
    }//GEN-LAST:event_limpacadastroActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
            cadastraProduto(novoProduto);
    }//GEN-LAST:event_cadastrarActionPerformed

    private void quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        buscarProduto(novoProduto);
    }//GEN-LAST:event_buscarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        atualizarProduto(novoProduto);
    }//GEN-LAST:event_atualizarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        deletarProduto(novoProduto);
    }//GEN-LAST:event_deletarActionPerformed

    private void limparcampobuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparcampobuscaActionPerformed
        limparCamposBusca();
    }//GEN-LAST:event_limparcampobuscaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
       menu.setVisible(true);
       dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void consultaprecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaprecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultaprecoActionPerformed

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
            java.util.logging.Logger.getLogger(cadastroprodutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroprodutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroprodutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroprodutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroprodutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField consultaCod;
    private javax.swing.JTextField consultaQtd;
    private javax.swing.JTextField consultacor;
    private javax.swing.JTextField consultamarca;
    private javax.swing.JTextField consultamodelo;
    private javax.swing.JFormattedTextField consultapreco;
    private javax.swing.JTextField consultatamanho;
    private javax.swing.JTextField cor;
    private javax.swing.JButton deletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limpacadastro;
    private javax.swing.JButton limparcampobusca;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JFormattedTextField preco;
    private javax.swing.JTextField quantidade;
    private javax.swing.JTextField tamanho;
    private javax.swing.JLabel textfild000;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
