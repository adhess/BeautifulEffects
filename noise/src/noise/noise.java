package noise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.TIMEOUT;

public class noise extends javax.swing.JFrame {

    public static Graphics g;
    public static Graphics2D g2d;
    public final static int w = 500;
    public final static int h = 500;

    public noise() {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(noise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(noise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(noise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(noise.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                noise frame = new noise();
                frame.setTitle("noise");
                frame.setSize(w, h);
                g = frame.getGraphics();
                frame.setVisible(true);
                new gnoise().start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public static Point points[];
    public static Point ppts[];
    public static class gnoise extends Thread {

        public int echel = 20;
        public double[][] VNoise = new double[w / echel][h / echel];
        public double z = Math.random() * 10;
        public Color[] pcs;

        public gnoise() {
            int nbrParticule = 500;
            points = new Point[nbrParticule];
            ppts = new Point[nbrParticule];
            Point p = new Point((int) (w * Math.random()), (int) (h * Math.random()));
            this.pcs = new Color[nbrParticule];
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point(p);
                ppts[i] = new Point(p);
                this.pcs[i] = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), 150);
            }
        }

        @Override
        public void run() {
            BufferedImage mazeImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

            g2d = mazeImage.createGraphics();
                g2d.setColor(new Color(220, 220, 220));
                g2d.fillRect(0, 0, w, h);
                g2d.setColor(new Color(20, 20, 20));
            while (true) {

                //fillGrid();
                updatePerlinNoise();
                //markCenterBlock();
                displayPoints();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(noise.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.drawImage(mazeImage, 0, 0, null);
            }
        }

        private void fillGrid() {
            g2d.setColor(new Color(20, 20, 20));
            for (int i = echel; i < w; i += echel) {
                g2d.drawLine(i, 0, i, h);
            }
            for (int j = echel; j < h; j += echel) {
                g2d.drawLine(0, j, w, j);
            }
        }

        private void markCenterBlock() {
            g2d.setColor(Color.DARK_GRAY);
            for (int i = echel / 2; i < w; i += echel) {
                for (int j = echel / 2; j < h; j += echel) {
                    double noise = VNoise[i / echel][j / echel];
                    int x1 = (int) (i + 10 * Math.cos(Math.toRadians(noise)));
                    int y1 = (int) (j - 10 * Math.sin(Math.toRadians(noise)));
                    int x2 = (int) (i - 10 * Math.cos(Math.toRadians(noise)));
                    int y2 = (int) (j + 10 * Math.sin(Math.toRadians(noise)));
                    g2d.drawLine(x1, y1, x2, y2);

                }
            }
        }

        private void updatePerlinNoise() {
            z += 0.0005;
            int pas = 10;
            for (int i = 0; i < w / echel; i++) {
                for (int j = 0; j < h / echel; j++) {
                    
                    VNoise[i][j] = (int) (ImprovedNoise.noise(pas * (double) i / w, pas * (double) j / h, z) * 360);
                }
            }
        }

        private void displayPoints() {
            for (int i = 0; i < points.length; i++) {
                Point p = points[i];
                double n = 0;
                int a = (int) (p.getX() / echel);
                int b = (int) (p.getY() / echel);
                try {
                    n = VNoise[a][b];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(p.toString());
                }
                int c = 2;
                int x1 = (int) (c * Math.cos(Math.toRadians(n)));
                int y1 = (int) (-c * Math.sin(Math.toRadians(n)));
                int x2 = (int) (-c * Math.cos(Math.toRadians(n)));
                int y2 = (int) (+c * Math.sin(Math.toRadians(n)));
                
                int d = 18;
                
                p.setLocation(p.getX() + ((x2 - x1)+(a*echel+echel/2-p.getX())/d)*Math.random(),
                        p.getY() + ((y2 - y1)+(b*echel+echel/2-p.getY())/d)*Math.random());

                if (p.getX() >= w) {
                    p.setLocation(10, p.getY());
                    ppts[i].setLocation(p);
                }
                if (p.getX() < 0) {
                    p.setLocation(w - 10, p.getY());
                    ppts[i].setLocation(p);
                }

                if (p.getY() >= h) {
                    p.setLocation(p.getX(), 10);
                    ppts[i].setLocation(p);
                }
                if (p.getY() < 0) {
                    p.setLocation(p.getX(), h - 10);
                    ppts[i].setLocation(p);
                }
                g2d.setColor(new Color(20,20,20,1));
                g2d.drawLine((int) (ppts[i].getX()), (int) (ppts[i].getY()), (int) (p.getX()), (int) (p.getY()));
                ppts[i].setLocation(p);
                //g2d.setColor(pcs[i]);
                //g2d.fillOval((int) p.getX(), (int) p.getY(), 8, 8);
            }
        }

    }

}
