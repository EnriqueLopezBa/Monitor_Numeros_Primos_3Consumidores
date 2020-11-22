

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class vtnPrincipal extends javax.swing.JFrame {

    DefaultTableModel a, b, c, d;
    public boolean ejecutando = false;

    static Contenedor contenedor;
    static Thread[] consumidor;
    public Thread[] generador;
   boolean ejec = false;

    public vtnPrincipal() {
        initComponents();
        getContentPane().setBackground(Color.white);
        for (Component com : super.getContentPane().getComponents()) {
            if (com instanceof JPanel) {
                for (Component pan : ((JPanel) com).getComponents()) {
                    if (pan instanceof JScrollPane) {
                        personalizar(((JScrollPane) pan), null);
                    }
                    if (pan instanceof JTable) {
                        personalizar(null, ((JTable) pan));
                    }
                }
            }
        }

        a = (DefaultTableModel) tbl1.getModel();
        b = (DefaultTableModel) tbl2.getModel();
        c = (DefaultTableModel) tbl3.getModel();
        d = (DefaultTableModel) tbl4.getModel();
        setLocationRelativeTo(null);

    }

    private void personalizar(JScrollPane pane, JTable tabla) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        if (pane != null) {
            pane.getViewport().setBackground(Color.WHITE);
        }
        if (tabla != null) {
            tabla.setBackground(Color.WHITE);
            ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(centerRenderer.getHorizontalAlignment());
            for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        scroll2 = new javax.swing.JScrollPane();
        tbl4 = new javax.swing.JTable();
        scroll3 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        scroll4 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(810, 75));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Ejecutar");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(150, 19));
        jButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButton1MouseDragged(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.WEST);

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Guardar");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDefaultCapable(false);
        jButton2.setPreferredSize(new java.awt.Dimension(100, 21));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, java.awt.BorderLayout.CENTER);

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Carpeta Contenedora");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setDefaultCapable(false);
        jButton3.setPreferredSize(new java.awt.Dimension(150, 19));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        scroll1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll1.setName("scroll2"); // NOI18N
        scroll1.setPreferredSize(new java.awt.Dimension(250, 402));

        tbl2.setAutoCreateRowSorter(true);
        tbl2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numeros generados", "Es primo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setGridColor(new java.awt.Color(255, 255, 255));
        tbl2.setName("tbl2"); // NOI18N
        tbl2.setRowHeight(30);
        tbl2.setSelectionBackground(new java.awt.Color(204, 204, 255));
        scroll1.setViewportView(tbl2);
        if (tbl2.getColumnModel().getColumnCount() > 0) {
            tbl2.getColumnModel().getColumn(1).setHeaderValue("Es primo");
        }

        jPanel2.add(scroll1, java.awt.BorderLayout.WEST);

        scroll2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll2.setName("scroll4"); // NOI18N
        scroll2.setPreferredSize(new java.awt.Dimension(250, 402));

        tbl4.setAutoCreateRowSorter(true);
        tbl4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tbl4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numeros generados", "Es primo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl4.setGridColor(new java.awt.Color(255, 255, 255));
        tbl4.setName("tbl4"); // NOI18N
        tbl4.setRowHeight(30);
        tbl4.setSelectionBackground(new java.awt.Color(204, 204, 255));
        scroll2.setViewportView(tbl4);
        if (tbl4.getColumnModel().getColumnCount() > 0) {
            tbl4.getColumnModel().getColumn(1).setHeaderValue("Es primo");
        }

        jPanel2.add(scroll2, java.awt.BorderLayout.EAST);

        scroll3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll3.setName("scroll3"); // NOI18N
        scroll3.setPreferredSize(new java.awt.Dimension(250, 402));

        tbl3.setAutoCreateRowSorter(true);
        tbl3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numeros generados", "Es primo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl3.setGridColor(new java.awt.Color(255, 255, 255));
        tbl3.setName("tbl3"); // NOI18N
        tbl3.setRowHeight(30);
        tbl3.setSelectionBackground(new java.awt.Color(204, 204, 255));
        scroll3.setViewportView(tbl3);
        if (tbl3.getColumnModel().getColumnCount() > 0) {
            tbl3.getColumnModel().getColumn(1).setHeaderValue("Es primo");
        }

        jPanel2.add(scroll3, java.awt.BorderLayout.CENTER);

        scroll4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll4.setName("scroll1"); // NOI18N
        scroll4.setPreferredSize(new java.awt.Dimension(250, 200));

        tbl1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numeros generados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setGridColor(new java.awt.Color(255, 255, 255));
        tbl1.setName("tbl1"); // NOI18N
        tbl1.setRowHeight(30);
        tbl1.setSelectionBackground(new java.awt.Color(204, 204, 255));
        scroll4.setViewportView(tbl1);

        jPanel2.add(scroll4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INFORMACION");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        lbl.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl, java.awt.BorderLayout.WEST);

        lbl1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl1, java.awt.BorderLayout.CENTER);

        lbl2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbl2, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    public static boolean consumidoresActivos() {
        if (!consumidor[0].isAlive() && !consumidor[1].isAlive() && !consumidor[2].isAlive()) {
            return false;
        }
        return true;
    }
    static Generador gen1, gen2;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (contenedor != null) {
            if (!consumidoresActivos()) {
                a.setRowCount(0);
                c.setRowCount(0);
                d.setRowCount(0);
                b.setRowCount(0);
            }
        }
        if (!ejec) {
            ejec = true;
            contenedor = new Contenedor();
            consumidor = new Thread[3];
            generador = new Thread[2];
            DefaultTableModel name_tables[] = new DefaultTableModel[]{b, c, d};
            JLabel label[] = new JLabel[]{lbl, lbl1, lbl2};
            for (int i = 0; i < 3; i++) {
                consumidor[i] = new Thread(new Consumidor(contenedor, this, name_tables[i], label[i]));
                consumidor[i].start();
            }
            gen1 = new Generador(contenedor, this);
            gen2 = new Generador(contenedor, this);
            generador[0] = new Thread(gen1);
            generador[1] = new Thread(gen2);
            generador[0].start();
            generador[1].start();

        } else
            showMessageDialog(null, "Los hilos ya se encuentran en ejecucion");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//         try {
//            if(con !=null && con.lista.size() == 20){
//            BufferedWriter bfw = new BufferedWriter(new FileWriter("Datos.txt"));
//            for(int x : con.lista){
//                bfw.write(x+"");
//                bfw.newLine();
//            }
//            bfw.close();
//                showMessageDialog(null, "Se guardaron los numeros primos encontrados");
//            }else
//                 showMessageDialog(null, "Todavia no se encuentran los 20 numeros primos");
//        } catch (IOException ex) {
//             System.out.println(ex.getMessage());
//        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Desktop.getDesktop().open(new File(vtnPrincipal.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile().getParentFile());
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(vtnPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseDragged

    }//GEN-LAST:event_jButton1MouseDragged

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
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lbl;
    public javax.swing.JLabel lbl1;
    public javax.swing.JLabel lbl2;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JScrollPane scroll4;
    public javax.swing.JTable tbl1;
    public javax.swing.JTable tbl2;
    public javax.swing.JTable tbl3;
    public javax.swing.JTable tbl4;
    // End of variables declaration//GEN-END:variables
}
