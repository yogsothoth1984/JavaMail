package javamail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;



public class VentAsunMens extends javax.swing.JFrame {
    
    public static String username="";
    public static String password="";
    String mensaje;
    String to="";
    String subject="";
    
    public VentAsunMens() {
        initComponents();
        textoArea.setLineWrap(true);//Se logra que haya saltos de linea en el textArea.
        textoArea.setWrapStyleWord(true);//Se impide la divicion de palabras en el textArea.
    }
    public void SendMail(){
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.starttls.enable","true");
        prop.setProperty("mail.smtp.host","smtp.gmail.com");
        prop.setProperty("mail.smtp.port","587");
        
        Session session =Session.getInstance(prop,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try{
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            /*El correo hacia donde vamos a enviar el mensaje*/
            message.setSubject(subject);
            /*Asunto del correo*/
            message.setText(mensaje);
            /*El mensaje*/
            
           Transport.send(message);
            /*variable del tipo transport para poder ejecutar lo anterior*/
            JOptionPane.showMessageDialog(this,"Su mensaje ha sido enviado");
            
        } catch(MessagingException mex){
            System.out.println("send failed, exception: "+ mex);
            throw new RuntimeException(mex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labPara = new javax.swing.JLabel();
        LabAsu = new javax.swing.JLabel();
        labMens = new javax.swing.JLabel();
        textoPara = new javax.swing.JTextField();
        textoAsunto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoArea = new javax.swing.JTextArea();
        botEnviar = new javax.swing.JButton();
        botCancelar2 = new javax.swing.JButton();
        botLimpiarC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labPara.setText("Para");

        LabAsu.setText("Asunto");

        labMens.setText("Mensaje");

        textoArea.setColumns(20);
        textoArea.setRows(5);
        jScrollPane1.setViewportView(textoArea);

        botEnviar.setText("Enviar");
        botEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botEnviarActionPerformed(evt);
            }
        });

        botCancelar2.setText("Cancelar");
        botCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelar2ActionPerformed(evt);
            }
        });

        botLimpiarC.setText("Limpiar Campos");
        botLimpiarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLimpiarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labPara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labMens, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(LabAsu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoPara)
                                    .addComponent(textoAsunto)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(botEnviar)
                        .addGap(18, 18, 18)
                        .addComponent(botCancelar2)
                        .addGap(26, 26, 26)
                        .addComponent(botLimpiarC)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPara)
                    .addComponent(textoPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabAsu)
                    .addComponent(textoAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labMens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botEnviar)
                    .addComponent(botCancelar2)
                    .addComponent(botLimpiarC))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botEnviarActionPerformed
        //Se recoge la informacion y se envia el mail
        mensaje=textoArea.getText();
        to=textoPara.getText();
        subject=textoAsunto.getText();
        
        SendMail();
    }//GEN-LAST:event_botEnviarActionPerformed

    private void botCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelar2ActionPerformed
        System.exit(0);//Cierra la ventana
    }//GEN-LAST:event_botCancelar2ActionPerformed

    private void botLimpiarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimpiarCActionPerformed
        //Se limpian los campos de texto
        textoPara.setText("");
        textoAsunto.setText("");
        textoArea.setText("");
    }//GEN-LAST:event_botLimpiarCActionPerformed

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
            java.util.logging.Logger.getLogger(VentAsunMens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentAsunMens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentAsunMens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentAsunMens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentAsunMens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabAsu;
    private javax.swing.JButton botCancelar2;
    private javax.swing.JButton botEnviar;
    private javax.swing.JButton botLimpiarC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labMens;
    private javax.swing.JLabel labPara;
    private javax.swing.JTextArea textoArea;
    private javax.swing.JTextField textoAsunto;
    private javax.swing.JTextField textoPara;
    // End of variables declaration//GEN-END:variables
}
