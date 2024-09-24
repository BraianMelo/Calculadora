/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplication;

import javax.swing.JOptionPane;
import view.CalculadoraView;


/**
 *
 * @author braian
 */
public class Program {
    
    public static void main(String [] args){
        
        try{
            CalculadoraView calculadora = new CalculadoraView();
            calculadora.show();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR);
        }
        
    }
    
}
