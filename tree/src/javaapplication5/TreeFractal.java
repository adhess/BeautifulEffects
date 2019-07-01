/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author adhess
 */
public class TreeFractal extends javax.swing.JFrame {

    private static int alpha = 15;
    private static int longueur = 200;
    final static Color finalColor = new Color(10, 125, 0);
    final static Color startColor = new Color(125, 50, 0);
    private static int w = 1000;
    private static int h = 700;
    private static Graphics graphics;
    final static TreeFractal frame = new TreeFractal();
    public static int  signe = 1;

    /**
     * Creates new form NewJFrame
     */
    public TreeFractal() {
        initComponents();
    }

    public static void draw(int l, int ang, double x, double y, Graphics g, Color c) throws InterruptedException {
        if (l > 1) {
            int red = c.getRed() + (finalColor.getRed() - startColor.getRed()) / 12;
            int green = c.getGreen() + (finalColor.getGreen() - startColor.getGreen()) / 12;
            int blue = c.getBlue() + (finalColor.getBlue() - startColor.getBlue()) / 12;
            c = new Color(red, green, blue);
            g.setColor(c);
            g.drawLine((int) (w - x), (int) (h - y), (int) (w - x - l * Math.cos(Math.toRadians(ang))), (int) (h - y - l * Math.sin(Math.toRadians(ang))));

            draw(2 * l / 3, ang - alpha, (x + l * Math.cos(Math.toRadians(ang))), (y + l * Math.sin(Math.toRadians(ang))), g,
                    c);

            draw(2 * l / 3, ang + alpha, (x + l * Math.cos(Math.toRadians(ang))), (y + l * Math.sin(Math.toRadians(ang))), g,
                    c);

        } else {
            //TimeUnit.MILLISECONDS.sleep(5);
            g.setColor(Color.RED);
            g.fillOval(w - (int) (x + l * Math.cos(Math.toRadians(ang))), h - (int) (y + l * Math.sin(Math.toRadians(ang))), 1, 1);
            //g.fillOval((int)(x + l * Math.cos(Math.toRadians(ang))), h - (int) (y + l * Math.sin(Math.toRadians(ang))), 2, 4);
        }
    }
    public static long mer = 0;
    public static void draw_random(int l, int ang, double x, double y, Graphics g, Color c) throws InterruptedException {
        
            if( l <= 1 || (int)x < 0 || (int)x > w
                    || (int)y < 0 || (int)y > h) return;
        
        
        
        
        
        
        if ( l >= 1 && (int) (w - x) <= w && (int) (h - y) <= h) {mer++;
        
            int pas = 150;
            int red = c.getRed() + signe * (finalColor.getRed() - startColor.getRed()) / pas;
            int green = c.getGreen() + signe * (finalColor.getGreen() - startColor.getGreen()) / pas;
            int blue = c.getBlue() + signe * (finalColor.getBlue() - startColor.getBlue()) / pas;
            /*if(c.getRed() + signe * (finalColor.getRed() - startColor.getRed()) / pas < 0
                    || c.getGreen() + signe * (finalColor.getGreen() - startColor.getGreen()) / pas < 0
                    || c.getBlue() + signe * (finalColor.getBlue() - startColor.getBlue()) / pas < 0) 
                signe = -signe;
            else if(c.getRed() + signe * (finalColor.getRed() - startColor.getRed()) / pas > 255
                    || c.getGreen() + signe * (finalColor.getGreen() - startColor.getGreen()) / pas > 255
                    || c.getBlue() + signe * (finalColor.getBlue() - startColor.getBlue()) / pas > 255) 
                signe = -signe;*/
            c = new Color(red, green, blue);
            g.setColor(c);
            g.drawLine((int) (w - x), (int) (h - y), (int) (w - x - l * Math.cos(Math.toRadians(ang))), (int) (h - y - l * Math.sin(Math.toRadians(ang))));
            int la = l - (int) (Math.random() * l );
            la = la>0?la:0;
            int pha = (int) (Math.random() * 45);
            draw_random(la,  - pha, (x + l * Math.cos(Math.toRadians(ang))), (y + l * Math.sin(Math.toRadians(ang))), g,
                    c);

            draw_random(la,  + pha, (x + l * Math.cos(Math.toRadians(ang))), (y + l * Math.sin(Math.toRadians(ang))), g,
                    c);

        } else {
            mer = 0;
            //TimeUnit.MILLISECONDS.sleep(5);
            g.setColor(Color.RED);
            g.fillOval(w - (int) (x + l * Math.cos(Math.toRadians(ang))), h - (int) (y + l * Math.sin(Math.toRadians(ang))), 1, 1);
            //g.fillOval((int)(x + l * Math.cos(Math.toRadians(ang))), h - (int) (y + l * Math.sin(Math.toRadians(ang))), 2, 4);
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

        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("A");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 345, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        alpha += 15;
        alpha = (alpha / 15) * 15;
        alpha = alpha >= 150 ? 15 : alpha;
        Graphics g = this.frame.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, w - 80, h);
        g.setColor(Color.white);
        try {
            draw(longueur, 90, w / 2, 0, g, startColor);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TreeFractal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Graphics g = this.frame.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, w - 80, h);
        g.setColor(Color.white);
        try {
            draw_random(longueur, 90, w / 2, 0, g, startColor);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(TreeFractal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public void paint(Graphics g) {
        try {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, w, h);
            g.setColor(Color.white);
            draw(longueur, 90, w / 2, 0, g, startColor);
        } catch (InterruptedException ex) {
            Logger.getLogger(TreeFractal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(TreeFractal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreeFractal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreeFractal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreeFractal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                frame.setSize(w, h);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setTitle("Fractal Tree");
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("tree.jpg")));
                jSlider1.addChangeListener(new ChangeListener() {

                    @Override
                    public void stateChanged(ChangeEvent ce) {
                        alpha = jSlider1.getValue() * 180 / 100;
                        Graphics g = frame.getGraphics();
                        g.setColor(Color.black);
                        g.fillRect(0, 0, w - 80, h);
                        g.setColor(Color.white);
                        try {
                            draw(longueur, 90, w / 2, 0, g, startColor);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TreeFractal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        g.dispose();

                    }
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private static javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
