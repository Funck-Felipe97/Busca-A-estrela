
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */
public class NodePantado extends Node{

    public NodePantado(int xCord, int ycord){
        super(xCord , ycord , 20);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/pantano.jpg"));
    }
    
}
