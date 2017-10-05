
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */
public class NodeMoeda extends Node{
    
    public NodeMoeda(int xCord , int ycord) {
        super(xCord, ycord , 0);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/moeda.png"));
    }
    
}
