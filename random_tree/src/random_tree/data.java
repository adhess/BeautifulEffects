/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random_tree;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Comparator;

/**
 *
 * @author adhess
 */
class data {
    double l;
        int ang;
        double x;
        double y;
        Graphics2D g;
        Color c;

        public data(double l, int ang, double x, double y, Graphics2D g, Color c) {
            this.l = l;
            this.ang = ang;
            this.x = x;
            this.y = y;
            this.g = g;
            this.c = c;
        }

        @Override
        public String toString() {
            return "data{" +
                    "l=" + l +
                    ", ang=" + ang +
                    ", x=" + x +
                    ", y=" + y +
                    "}\n";
        }


        /*Comparator for sorting the list by roll no*/
        public static Comparator<data> dataLenght = new Comparator<data>() {

            public int compare(data s1, data s2) {
                return (int)(-s1.l+s2.l);
            }};
}
