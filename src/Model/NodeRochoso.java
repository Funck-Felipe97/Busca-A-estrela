
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */
public class NodeRochoso extends Node{

    public NodeRochoso(int xCord, int ycord){
        super(xCord, ycord , 10);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/rochoso.jpg"));
    }
    
}
