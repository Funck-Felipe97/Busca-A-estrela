
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */
public class NodeArenoso extends Node{

    public NodeArenoso(int xCord, int ycord){
        super(xCord , ycord , 4);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/arenoso.png"));
        
    }
 
}
