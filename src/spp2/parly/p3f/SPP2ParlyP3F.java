/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp2.parly.p3f;

import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Samsung
 */
public class SPP2ParlyP3F {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        //EQUIPO
    // Cecilia Gutiérrez de Lara Hernández
    // Erick Eduardo Gervacci Romero
    // Norma Alejandra Ledezma Martínez
    // Diego Santana Leiva
    // Benito Rafael Morante vázquez
   
    
        

// PROGRAMA DE MINIMOS COMUNES
        menu();
    }
    
    public static void menu(){
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione una de las opciones mostradas", "Menu de Opciones",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Maximo comun divisor", "Minimo comun multiplo", "Salir"}, "Maximo comun divisor");
        int primerNumero, segundoNumero;
        switch (opcion){
            case 0:
                primerNumero = pedirNumero("primer numero");
                segundoNumero = pedirNumero("segundo numero");
                maximoComunDivisor(primerNumero, segundoNumero);
                preguntaContinuidad();
                break;
            case 1:
                primerNumero = pedirNumero("primer número");
                segundoNumero = pedirNumero("segundo número");
                minimoComunMultiplo(primerNumero, segundoNumero);
                preguntaContinuidad();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
                System.exit(0);
        }
    }
    
    public static int pedirNumero(String mensaje){
        boolean flag;
        int x=0;
        do{
            try{
             String respuesta = JOptionPane.showInputDialog(null, "Ingrese el "+mensaje); 
             x=Integer.parseInt(respuesta);
             flag=true;
            }catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "ERROR, vuelva a intentarlo");
             flag=false;
            }
            }
        while(flag==false);
        return x;
    }
    
    public static void maximoComunDivisor(int primerNumero, int segundoNumero){
        int maximoComunDivisor;
        while(primerNumero != segundoNumero)
            if(primerNumero > segundoNumero)
                primerNumero = primerNumero - segundoNumero;
            else
                segundoNumero = segundoNumero - primerNumero;
        JOptionPane.showMessageDialog(null, "El Maximo Comun Divisor es: " + primerNumero);
    }
    
    public static void minimoComunMultiplo(int primerNumero, int segundoNumero){
        int minimoComunMultiplo = 1;
        int i = 2;
        while(i <= primerNumero || i <= segundoNumero)
        {
            if(primerNumero%i == 0 || segundoNumero%i == 0)
            {
            minimoComunMultiplo = minimoComunMultiplo * i;
            if(primerNumero%i == 0) primerNumero = primerNumero / i;
            if(segundoNumero%i == 0) segundoNumero = segundoNumero / i;
            }
            else
                i = i+1;               
        }                        
        JOptionPane.showMessageDialog(null, "El Minimo Comun Multiplo es: " + minimoComunMultiplo);            
    }
    
    public static void preguntaContinuidad(){
        int respuesta = JOptionPane.showOptionDialog(null, "¿Desea seguir ejecutando el programa?", "Pregunta de Continuidad",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Si", "No"}, "Si");
       
        switch (respuesta){
            case 0:
                menu();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
                System.exit(0);
        }
    }
}