/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizbotones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author Junior
 */
public class Tablero {
    int[][] matrizBotonesLogica = new int[16][16];
    JButton[][] matrizBotones = new JButton[16][16];
    String[] colores = new String[9];
    public void colores(){
       colores[0] = "#000000"; //Negro
       colores[1] = "#A4A4A4"; //Gris
       colores[2] = "#FF0000"; //Rojo
       colores[3] = "#0404B4"; //Azul
       colores[4] = "#00FF00"; //Verde
       colores[5] = "#FF8000"; //Anaranjado
       colores[6] = "#FFFF00"; //Amarillo
       colores[7] = "#8904B1"; //Morado
       colores[8] = "#FFFFFF"; //Blanco
    }
    
    public void crearTableroLogico(){
        colores();
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){
                matrizBotonesLogica[i][j] = 0;
            }
        }
    }
    
    public void crearTablero(){
        crearTableroLogico();
        JFrame ventana = new JFrame();
        ventana.setSize(505,535);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLayout(null);
        for(int fila=0;fila<16;fila++){
            for(int colum=0;colum<16;colum++){
                matrizBotones[fila][colum] = new JButton();
                matrizBotones[fila][colum].setBounds(10+(colum*30), 10+(fila*30), 29, 29);
                matrizBotones[fila][colum].setBackground(Color.decode("#FAFAFA"));
                final int numFila = fila;
                final int numColum = colum;//parametros finales
                matrizBotones[fila][colum].addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed (ActionEvent e){
                        cambioColor(numFila,numColum);
                    }
                });
                /**/
                ventana.add(matrizBotones[fila][colum]);
                
            }
        }
        ventana.setResizable(false);
        ventana.setLayout(null);
    }
    
    public void cambioColor(int fila, int colum){
        if(matrizBotonesLogica[fila][colum]==9){
            matrizBotones[fila][colum].setBackground(Color.decode(colores[0]));
            matrizBotonesLogica[fila][colum]=0;
        }else{
            int color = matrizBotonesLogica[fila][colum];
            matrizBotonesLogica[fila][colum]++;
            matrizBotones[fila][colum].setBackground(Color.decode(colores[color]));
        }
    }
}
