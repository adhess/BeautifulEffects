package perlinnoise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class perlin extends javax.swing.JFrame {

    public final static int echel = 25;
    public final static int w = 600;
    public final static int h = 600;
    public static Graphics g;
    public static double[][] VNoise = new double[w / echel][h / echel];

    public perlin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(perlin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                perlin frame = new perlin();
                frame.setSize(w, h);
                g = frame.getGraphics();
                frame.setVisible(true);
                frame.setTitle("555555");
                //new noiseThread().start();
                g.setColor(new Color(0, 220, 135));
                g.fillRect(0, 0, w, h);
                g.setColor(Color.BLACK);g.drawLine(0, 0, w, h);
                /*for (int i = echel; i < w; i += echel) {
                    g.drawLine(i, 0, i, h);
                    System.out.println(i+" " + 0+" " + i+" " + h);
                }
                for (int j = echel; j < h; j += echel) {
                    g.drawLine(0, j, w, j);
                }*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public static class noiseThread extends Thread {

        double z = Math.random() * 10;

        @Override
        public void run() {
            int i = 0;
            while (i++ < 1) {
                // noise();
            }
        }

        private void noise() {
            //ImprovedNoise in = new ImprovedNoise();

            //BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
            g.setColor(new Color(220, 220, 220));
            g.fillRect(0, 0, w, h);
            g.setColor(new Color(20, 20, 20));
            for (int i = echel; i < w; i += echel) {
                g.drawLine(i, 0, i, h);
            }
            for (int j = echel; j < h; j += echel) {
                g.drawLine(0, j, w, j);
            }/*
             z += 0.005;
             for (int i = 0; i < w / echel; i++) {
             for (int j = 0; j < h / echel; j++) {
             VNoise[i][j] = (int) (ImprovedNoise.noise(9 * (double) i / w, 9 * (double) j / h, z) * 360);
             }
             }
             for (int i = echel / 2; i < w / echel; i += echel) {
             for (int j = echel / 2; j < h / echel; j += echel) {

             }
             }
             /*
             int x1 = (int) (echel * (i + (double) 1 / 2));
             int y1 = (int) (echel * (j + (double) 1 / 2));
             int x2 = (int) (echel * (i + (double) 1 / 2));
             int y2 = (int) (echel * (j + (double) 1 / 2));
             g.setColor(Color.red);
             g.drawLine(x1, y1, x2, y2);*/


        }
    }

}
