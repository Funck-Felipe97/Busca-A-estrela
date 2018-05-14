
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author funck
 */
public class NodeSolido extends Node{

    public NodeSolido(int xCord, int ycord){
        super(xCord, ycord , 1);
        super.imagem = new ImageIcon(getClass().getResource("/Imagem/solido.jpg"));
    }
   
}
