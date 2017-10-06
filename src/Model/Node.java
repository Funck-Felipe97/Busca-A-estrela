
package Model;

import Util.CalculaHeuristica;
import java.awt.Graphics2D;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author funck
 */

public class Node {
     
    public ImageIcon imagem;
    public List<Node> neighbors = new ArrayList<Node>();
    public Node parent;
    public int f;
    public int g;
    public int h;
    public int x;
    public int y;
    public int cost;
    
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        return " {" + x + " , " + y + "}";
    }
    
    public void renderizar(Graphics2D g , int espacoColuna , int espacoLinha){
        g.drawImage(imagem.getImage() , espacoColuna + 50 , espacoLinha + 30 , 40 , 40 , null);
    }
    
}
