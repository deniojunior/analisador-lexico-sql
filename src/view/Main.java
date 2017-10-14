package view;

import roles.Language;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author deniojunior
 */
public class Main extends javax.swing.JFrame {

    private ArrayList<String[]> palavrasReservadas;
    
    /** Creates new form Main **/
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        palavrasReservadas = Language.getInstance().initSQLTokensLexems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbSQL = new javax.swing.JLabel();
        jbtAnalisar = new javax.swing.JButton();
        jbtLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTabela = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtpSql = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbSQL.setText("Insira o código SQL:");

        jbtAnalisar.setText("Analisar");
        jbtAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAnalisarActionPerformed(evt);
            }
        });

        jbtLimpar.setText("Limpar");
        jbtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimparActionPerformed(evt);
            }
        });

        jtbTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbTabela);

        jScrollPane3.setViewportView(jtpSql);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            .addComponent(jlbSQL, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jbtAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSQL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAnalisar)
                    .addComponent(jbtLimpar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String formataSql(String sql){
        String caracteres = "*();',."; 
        String pt1 = "", pt2 = "";
        String carac = "";
        
        for(int i = 0; i < sql.length(); i++){
            carac = "" + sql.charAt(i);
            System.out.println("Carac: " + carac);
            if(caracteres.contains(carac)){
                pt1 = (String)sql.subSequence(0, i);
                pt2 = (String)sql.subSequence((i+1), sql.length());
                sql = pt1 + " " + carac + " " + pt2;
                i++;
            }
        }
        
        System.out.println("SQL Formatada: " + sql);
        
        return(sql);
    }
    
    private void jbtAnalisarActionPerformed(java.awt.event.ActionEvent evt) {
        String sql = formataSql(jtpSql.getText());
        
        int controlTabela = 0;
        String tabela[][] = new String[50][2];
        
        for(int i = 0; i < 50; i++){
            tabela[i][0] = "";
            tabela[i][1] = "";
        }
        
        String comando[] = sql.split(" ");
        
        boolean palavraReservada = false;
        boolean aspasAbertas = false;
        for(int i = 0; i < comando.length; i++){
       
            System.out.println("Comando[" + i + "]: " + comando[i]);
            
            palavraReservada = false;
            for(int j = 0; j < palavrasReservadas.size(); j++){
                
                if(comando[i].equalsIgnoreCase(palavrasReservadas.get(j)[0])){
                    
                    if(comando[i].contains("'")){
                        if(!aspasAbertas){
                            tabela[controlTabela][0] = "<ASPAS_ABRE>";
                            aspasAbertas = true;
                        }else{
                            tabela[controlTabela][0] = "<ASPAS_FECHA>";
                            aspasAbertas = false;
                        }
                    }else{
                        tabela[controlTabela][0] = palavrasReservadas.get(j)[1];
                    }
                    
                    tabela[controlTabela][1] = comando[i];
                    controlTabela++;
                    palavraReservada = true;
                    break;
                }
            }
            
            if(!palavraReservada){
                try{
                    float num = Float.parseFloat(comando[i]);
                    tabela[controlTabela][0] = "<VALOR_NUMERICO>";
                    tabela[controlTabela][1] = comando[i];
                    controlTabela++;
                    
                }catch(NumberFormatException ex){
                    if(!comando[i].isEmpty()){
                        
                        if(comando[i-1].contains("'") || comando[i-2].contains("'")){
                            tabela[controlTabela][0] = "<STRING>";
                            tabela[controlTabela][1] = comando[i];
                            controlTabela++;
                        }else{
                            tabela[controlTabela][0] = "<ID>";
                            tabela[controlTabela][1] = comando[i];
                            controlTabela++;
                        }
                    }
                }
            }
        }
        
        String[] colunas = {"Token", "Lexema"}; 
        
        DefaultTableModel modelo = (DefaultTableModel) jtbTabela.getModel();
        modelo.setColumnIdentifiers(colunas);
        
        for(int i = 0; i < 50; i++){
            if(!tabela[i][0].isEmpty()){
                Object[] objetos = new Object[2];

                objetos[0] = tabela[i][0];
                objetos[1] = tabela[i][1];

                modelo.addRow(objetos);
            }
        }

        jtbTabela.setModel(modelo);
        organizaCelulas();
        jbtAnalisar.setEnabled(false);
    }

    private void jbtLimparActionPerformed(java.awt.event.ActionEvent evt) {
        
        DefaultTableModel modelo = (DefaultTableModel) jtbTabela.getModel();
        
        int tamanhoTabela = jtbTabela.getRowCount();
        for(int i = 0; i < tamanhoTabela; i++){
            modelo.removeRow(0);
        }

        jtbTabela.setModel(modelo);
        
        jtpSql.setText("");
        jbtAnalisar.setEnabled(true);
    }

    public void organizaCelulas(){
        DefaultTableCellRenderer cellRenderCod = new DefaultTableCellRenderer();
        
        cellRenderCod.setHorizontalAlignment(SwingConstants.CENTER);    
        jtbTabela.getColumnModel().getColumn(0).setCellRenderer(cellRenderCod);
        jtbTabela.getColumnModel().getColumn(1).setCellRenderer(cellRenderCod);
    }
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtAnalisar;
    private javax.swing.JButton jbtLimpar;
    private javax.swing.JLabel jlbSQL;
    private javax.swing.JTable jtbTabela;
    private javax.swing.JTextPane jtpSql;
}