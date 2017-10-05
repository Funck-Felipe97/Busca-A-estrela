/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */
public class NodeParede extends Node{
    
    public NodeParede(int xCord, int ycord) {
        super(xCord, ycord , 100);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/parede.png"));
    }
    
}
