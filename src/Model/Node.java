
package Model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


/**
 *
 * @author funck
 */

public class Node implements Comparable<Object>{
     
    public ImageIcon imagem;
    public List<Node> adjacentes = new ArrayList<Node>();
    public Node pai;
    public int f;
    public int custoAtual;
    public int heuristica;
    public int x;
    public int y;
    public int peso;
    
    public Node(int x, int y, int peso) {
        this.x = x;
        this.y = y;
        this.peso = peso;
    }
    
    @Override
    public String toString() {
        return " {" + x + " , " + y + "}";
    }
    
    public void renderizar(Graphics2D g , int espacoColuna , int espacoLinha){
        posMapaX = espacoColuna;
        posMapaY = espacoLinha;
        g.drawImage(imagem.getImage() , posMapaX + 50 , posMapaY + 30 , 40 , 40 , null);
    }
    
    public int posMapaX;
    public int posMapaY;
    
    public int calcularHeuristica(Node no){
         return Math.abs(x - no.x) + Math.abs(y - no.y);
    }

    public int getX() {
        return x;
    }

    @Override
    public int compareTo(Object o) {
         Node obj = (Node) o;
         if((x + y) > (obj.x + obj.y)){
             return 1;
         }
         if((x + y) < (obj.x + obj.y)){
             return -1;
         }
         return 0;
    }
    
    
}
