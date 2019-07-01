package myserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.nio.cs.StreamDecoder;

public class myServerJ extends javax.swing.JFrame {

    static Socket s;
    static ServerSocket ss;
    static InputStreamReader isr;

    private static void setLocalAddress() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(Arrays.toString(ip.getAddress()) + "\n" + ip.getHostAddress() + "\n" + ip.getHostName() + "\n" + ip.getCanonicalHostName());
            TimeUnit.SECONDS.sleep(1);
            TextField_public_adress1.setText(ip + "");
        } catch (UnknownHostException | InterruptedException ex) {
            Logger.getLogger(myServerJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void setPublicAdress() throws MalformedURLException, IOException {
        try {
            TextField_public_adress.setText(getIp() + "");
        } catch (Exception ex) {
            Logger.getLogger(myServerJ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public myServerJ() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextField_public_adress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        TextField_public_adress1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Server");

        jLabel1.setText("Local Address :");

        TextField_public_adress.setEditable(false);
        TextField_public_adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_public_adressActionPerformed(evt);
            }
        });

        jLabel2.setText("Public Address :");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        TextField_public_adress1.setEditable(false);
        TextField_public_adress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_public_adress1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextField_public_adress1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TextField_public_adress, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextField_public_adress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_public_adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_public_adressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_public_adressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_public_adressActionPerformed

    private void TextField_public_adress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_public_adress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_public_adress1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myServerJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new myServerJ().setVisible(true);
            }
        });

        //createDirectoryIfDoesnExist();
        try {
            setLocalAddress();
            setPublicAdress();

        } catch (UnknownHostException ex) {
            Logger.getLogger(myServerJ.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(myServerJ.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ss = new ServerSocket(6900);
            while (true) {
                // reçoit name
                s = ss.accept();
                jTextArea1.append("Client Connected...\n");
                jTextArea1.append("receive name\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength() - 1);
                String nameFile = "";
                try (BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"))) {
                    nameFile = br.readLine();
                    s.close();
                    String str = nameFile;
                    str = str.substring(0, str.lastIndexOf("/"));
                    str = str.substring(str.indexOf("/0/") + 3, str.length());
                    str = str.replaceAll("/", "\\\\");
                    boolean mkdirs = new File("output\\"+str).mkdirs();
                    System.out.println("mkdir: "+mkdirs);
                    
                    
                    str = nameFile;
                    str = str.substring(str.indexOf("/0/") + 3, str.length());
                    nameFile = str.replaceAll("/", "\\\\");
                    
                    jTextArea1.append("name file has been received...\n");
                    jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength() - 1);
                }

                s = ss.accept();
                
                if (new File("output\\" + nameFile).exists()) {
                    int i = 0;
                    while (new File("output\\" + nameFile.substring(0, nameFile.indexOf(".")) + (++i)
                            + nameFile.substring(nameFile.indexOf("."))).exists());
                    nameFile = nameFile.substring(0, nameFile.indexOf(".")) + (i)
                            + nameFile.substring(nameFile.indexOf("."));
                }
                //i++;
                jTextArea1.append("Client Connected...\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength() - 1);
                //FileOutputStream fos = new FileOutputStream(new File("output\\image" + i + ".jpg"));
                FileOutputStream fos = new FileOutputStream(new File("output\\" + nameFile));
                jTextArea1.append("receive file\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength() - 1);
                try (InputStream in_binary = s.getInputStream()) {
                    byte[] bindata = new byte[16 * 1024];
                    int count = in_binary.read(bindata);
                    while (count > 0) {
                        fos.write(bindata, 0, count);
                        count = in_binary.read(bindata);
                    }
                    fos.close();
                    s.close();
                    jTextArea1.append("done...\n");
                    jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength() - 1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(myServerJ.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField TextField_public_adress;
    public static javax.swing.JTextField TextField_public_adress1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
