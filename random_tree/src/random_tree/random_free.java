/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random_tree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author adhess
 */
public class random_free extends javax.swing.JFrame {

    final static Color finalColor = new Color(10, 125, 0);
    final static Color startColor = new Color(125, 50, 0);
    public static int sign = 1;
    public static int w = 1100;
    public static int h = w * 9 / 16;
    public static long count = 0;
    public static ArrayList<data> d1 = new ArrayList<data>();
    static int capacity = 10;
    public static random_free frame = new random_free();
    private static int alpha = 15;
    private static int longueur = 200;

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
            g.fillOval(w - (int) (x + l * Math.cos(Math.toRadians(ang))), h - (int) (y + l * Math.sin(Math.toRadians(ang))), 1, 2);
            //g.fillOval((int)(x + l * Math.cos(Math.toRadians(ang))), h - (int) (y + l * Math.sin(Math.toRadians(ang))), 2, 4);
        }
    }

    public static void _draw_(Graphics2D g) throws InterruptedException {

        if (d1.size() > capacity) {
            Collections.sort(d1, data.dataLenght);
            for (int i = capacity + 1; i < d1.size(); i++) {
                d1.remove(i);
            }
        }

        //System.out.println(d1.toString());
        int siz = d1.size();
        for (int i = 0; i < siz; i++) {
            if (d1.get(i).l > 3) {
                Color c = g.getColor();
                int red = c.getRed();// (int)Math.pow(-1,Math.random()*2)*2;
                int blue = c.getBlue();//+ (int)Math.pow(-1,Math.random()*2)*2;
                int green = c.getGreen();//+ (int)Math.pow(-1,Math.random()*2)*2;
                //red = red > 255 ? red-20: red < 0? red + 20: red;
                //blue = red > 255 ? blue-20: red < 0? blue + 20: blue;
                //green = red > 255 ? green-20: green < 0? green + 20: green;

                double x1 = (d1.get(i).x + d1.get(i).l * Math.cos(Math.toRadians(d1.get(i).ang)));
                double y1 = (d1.get(i).y + d1.get(i).l * Math.sin(Math.toRadians(d1.get(i).ang)));
                //d1.get(i).c = new Color(red,blue,green);
                g.setColor(d1.get(i).c);
                g.drawLine((int) (w - d1.get(i).x), (int) (h - d1.get(i).y),
                        (int) (w - x1), (int) (h - y1));

                double la = d1.get(i).l - (int) (Math.random() * d1.get(i).l * 1 / 3);
                la = la > 0 ? la : 0;
                int pha = (int) (Math.random() * 45 + 45);
//
//                double la = d1.get(i).l/2;
//                int pha = d1.get(i).ang;

                data data1 = new data(la, pha - 45, x1, y1, g, d1.get(i).c);
                data data2 = new data(la, pha + 45, x1, y1, g, d1.get(i).c);
                d1.add(data1);
                d1.add(data2);

            } else {
                g.setColor(new Color(120, 175, 210));
                g.fillOval(w - (int) (d1.get(i).x + d1.get(i).l * Math.cos(Math.toRadians(d1.get(i).ang))), h
                        - (int) (d1.get(i).y + d1.get(i).l * Math.sin(Math.toRadians(d1.get(i).ang))), 2, 2);

            }
        }
        //System.out.println(d1.toString());
        for (int j = 0; j < siz; j++) {
            d1.remove(0);
        }

//        System.out.println(count++);
        for (int i = 0; i < d1.size(); i++) {
            if ((int) d1.get(i).l <= 0 || (int) d1.get(i).x < 0 || (int) d1.get(i).x > w
                    || (int) d1.get(i).y < 0 || (int) d1.get(i).y > h) {
                d1.remove(i);
            }
        }

//        System.out.println(d1.toString());
        if (!d1.isEmpty()) {
            _draw_(g);
        }
    }

    /**
     * Creates new form random_free
     */
    public random_free() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Random");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+15°");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 329, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 248, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Dimension imgDim = new Dimension(w, h);
            BufferedImage mazeImage = new BufferedImage(imgDim.width, imgDim.height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = mazeImage.createGraphics();
            g2d.setColor(new Color(20, 20, 20));
            g2d.fillRect(0, 0, imgDim.width, imgDim.height);
            g2d.setColor(startColor);

            BasicStroke bs = new BasicStroke(1);
            g2d.setStroke(bs);

            d1.add(new data(50, 90, w / 2, 0, g2d, startColor));

            _draw_(g2d);

            ImageIcon ii = new ImageIcon(mazeImage);

            Graphics g = frame.getGraphics();
            g.drawImage(mazeImage, 0, 0, null);
            //JOptionPane.showMessageDialog(null, ii);
        } catch (InterruptedException ex) {
            Logger.getLogger(random_free.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            alpha += 15;
            alpha = (alpha / 15) * 15;
            alpha = alpha >= 150 ? 15 : alpha;
            
            Dimension imgDim = new Dimension(w, h);
            BufferedImage mazeImage = new BufferedImage(imgDim.width, imgDim.height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = mazeImage.createGraphics();
            g2d.setColor(new Color(20, 20, 20));
            g2d.fillRect(0, 0, imgDim.width, imgDim.height);
            g2d.setColor(startColor);

            BasicStroke bs = new BasicStroke(1);
            g2d.setStroke(bs);

            d1.add(new data(50, 90, w / 2, 0, g2d, startColor));

            draw(longueur, 90, w / 2, 0, g2d, startColor);

            ImageIcon ii = new ImageIcon(mazeImage);

            Graphics g = frame.getGraphics();
            g.drawImage(mazeImage, 0, 0, null);
            //JOptionPane.showMessageDialog(null, ii);
        } catch (InterruptedException ex) {
            Logger.getLogger(random_free.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(random_free.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(random_free.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(random_free.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(random_free.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                frame.setVisible(true);
                frame.setSize(w + 100, h);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
