
package Busca;

import Model.Node;
import Model.NodeArenoso;
import Model.NodePantado;
import Model.Objetivo;
import java.util.List;

/**
 *
 * @author funck
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Objetivo.x = 3;
        Objetivo.y = 3;
        CriaMapa mapa = new CriaMapa();
        
        for(List<Node> linha : mapa.terrenos){
            for(Node coluna : linha){
                System.out.print(" { " + coluna.cost + " }");
            }
            System.out.println("");
        }
        System.out.println("---------");
        System.out.println("---------");
        
        List<Node> caminho = new BuscaHeuristica().
                aStar(mapa.terrenos.get(0).get(0), mapa.terrenos.get(3).get(3));
        
        caminho.forEach(System.out::println);
        
        
        
                
    }
    
}