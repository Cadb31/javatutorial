/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agsnasoft.java;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.agsnasoft.java.dao.PersonaDao;
import com.agsnasoft.java.dao.PersonaDaoImpl;
import com.agsnasoft.java.model.Persona;

public class MainPersonaGUI extends javax.swing.JFrame {

    /**
     * Creates new form PersonaGUI
     */
    public MainPersonaGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFramePersona = new javax.swing.JFrame();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTablePersona = new javax.swing.JTable();
        jMenuBarPersona = new javax.swing.JMenuBar();
        jMenuFilePersona = new javax.swing.JMenu();
        jMenuItemInsertar = new javax.swing.JMenuItem();
        jMenuItemConsultar = new javax.swing.JMenuItem();
        jMenuItemConsultarTodos = new javax.swing.JMenuItem();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jSeparatorExit = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jDialogInsertar = new javax.swing.JDialog();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellidos = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldEdad = new javax.swing.JTextField();
        jLabelEdad = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemFile = new javax.swing.JMenuItem();
        jMenuItemBD = new javax.swing.JMenuItem();
        jMenuItemClose = new javax.swing.JMenuItem();

        jFramePersona.setTitle("Personas");

        jTablePersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTablePersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellidos", "Direcci�n", "Edad", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePersona.setColumnSelectionAllowed(true);
        jScrollPaneTable.setViewportView(jTablePersona);
        jTablePersona.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jMenuFilePersona.setText("File");

        jMenuItemInsertar.setText("Insertar");
        jMenuItemInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsertarActionPerformed(evt);
            }
        });
        jMenuFilePersona.add(jMenuItemInsertar);

        jMenuItemConsultar.setText("Consultar");
        jMenuItemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarActionPerformed(evt);
            }
        });
        jMenuFilePersona.add(jMenuItemConsultar);

        jMenuItemConsultarTodos.setText("Consultar Todos");
        jMenuItemConsultarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarTodosActionPerformed(evt);
            }
        });
        jMenuFilePersona.add(jMenuItemConsultarTodos);

        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jMenuFilePersona.add(jMenuItemModificar);

        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jMenuFilePersona.add(jMenuItemEliminar);
        jMenuFilePersona.add(jSeparatorExit);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuFilePersona.add(jMenuItemSalir);

        jMenuBarPersona.add(jMenuFilePersona);

        jFramePersona.setJMenuBar(jMenuBarPersona);

        javax.swing.GroupLayout jFramePersonaLayout = new javax.swing.GroupLayout(jFramePersona.getContentPane());
        jFramePersona.getContentPane().setLayout(jFramePersonaLayout);
        jFramePersonaLayout.setHorizontalGroup(
            jFramePersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramePersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        jFramePersonaLayout.setVerticalGroup(
            jFramePersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFramePersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogInsertar.setTitle("Insertar Persona");

        jLabelNombre.setText("Nombre:");

        jLabelApellidos.setText("Apellidos:");

        jLabelDireccion.setText("Direcci�n:");

        jLabelEdad.setText("Edad:");

        jLabelEmail.setText("Email:");

        jButtonAceptar.setText("Aceptar");

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogInsertarLayout = new javax.swing.GroupLayout(jDialogInsertar.getContentPane());
        jDialogInsertar.getContentPane().setLayout(jDialogInsertarLayout);
        jDialogInsertarLayout.setHorizontalGroup(
            jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInsertarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jDialogInsertarLayout.createSequentialGroup()
                            .addComponent(jLabelApellidos)
                            .addGap(26, 26, 26)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDialogInsertarLayout.createSequentialGroup()
                            .addComponent(jLabelNombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDialogInsertarLayout.createSequentialGroup()
                            .addComponent(jButtonLimpiar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAceptar))
                        .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jDialogInsertarLayout.createSequentialGroup()
                                .addComponent(jLabelEdad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogInsertarLayout.createSequentialGroup()
                                .addComponent(jLabelDireccion)
                                .addGap(26, 26, 26)
                                .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogInsertarLayout.createSequentialGroup()
                                .addComponent(jLabelEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogInsertarLayout.setVerticalGroup(
            jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInsertarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEdad)
                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDialogInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Personas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("jFrameMain"); // NOI18N
        setType(java.awt.Window.Type.UTILITY);

        jMenuFile.setText("File");

        jMenuItemFile.setText("Persona File");
        jMenuItemFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemFile);

        jMenuItemBD.setText("Persona BD");
        jMenuItemBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBDActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemBD);

        jMenuItemClose.setText("Salir");
        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemClose);

        jMenuBarMain.add(jMenuFile);

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 954, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        personaDao = new PersonaDaoImpl("jdbc:mysql://localhost:3306/personas", "root", "root");
        
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>                        

    private void jMenuItemFileActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //JOptionPane.showMessageDialog(this, "Menu File ");
    }                                             

    private void jMenuItemBDActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //this.add(jFramePersona);
        jFramePersona.setSize(700, 450);
        jFramePersona.setVisible(true);
    }                                           

    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {                                               
        System.exit(0);
    }                                              

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldEdad.setText("");
        jTextFieldEmail.setText("");
    }                                              

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        jDialogInsertar.setVisible(false);
    }                                               

    private void jMenuItemInsertarActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        jDialogInsertar.setSize(340,300);
        jDialogInsertar.setVisible(true);
    }                                                 

    private void jMenuItemConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int id = Integer.valueOf(JOptionPane.showInputDialog(this, "Insertar el Id de persona:", "Consultar Persona", JOptionPane.QUESTION_MESSAGE));
    }                                                  

    private void jMenuItemConsultarTodosActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        Object cabecera [] = new Object[]{"Id", "Nombre", "Apellidos", "Direcci�n", "Edad", "Email"};        
        DefaultTableModel model = new DefaultTableModel(cabecera, 0);    
        List<Persona> personas = personaDao.consultarPersonas();
        for (Persona persona : personas) {
        	model.addRow(new Object[]{persona.getId(),persona.getNombre(),persona.getApellidos(),persona.getDireccion(),persona.getEdad(),persona.getEmail()});	
		}        
        jTablePersona.setModel(model);
    }                                                       

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {                                               
       jFramePersona.setVisible(false);
    }                                              

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {                                                   
       int id = Integer.valueOf(JOptionPane.showInputDialog(this, "Insertar el Id de persona:", "Modificar Persona", JOptionPane.QUESTION_MESSAGE));
    }                                                  

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        int id = Integer.valueOf(JOptionPane.showInputDialog(this, "Insertar el Id de persona:", "Eliminar Persona", JOptionPane.QUESTION_MESSAGE));
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
            java.util.logging.Logger.getLogger(MainPersonaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPersonaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPersonaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPersonaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPersonaGUI().setVisible(true);
            }
        });
    }

    private PersonaDao personaDao;
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JDialog jDialogInsertar;
    private javax.swing.JFrame jFramePersona;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenuBar jMenuBarPersona;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuFilePersona;
    private javax.swing.JMenuItem jMenuItemBD;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemConsultar;
    private javax.swing.JMenuItem jMenuItemConsultarTodos;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemFile;
    private javax.swing.JMenuItem jMenuItemInsertar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JPopupMenu.Separator jSeparatorExit;
    private javax.swing.JTable jTablePersona;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration                   
}