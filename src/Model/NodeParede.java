
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */

public class NodeParede extends Node{
    
    public NodeParede(int xCord, int ycord) {
        super(xCord, ycord , 1000);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/parede.png"));
    }
    
}
