
package Util;

import Model.Node;
import Model.Objetivo;
import java.lang.Math;

/**
 *
 * @author funck
 */
public class CalculaHeuristica {
    
    public static int calcular(Node node){
        return (Math.abs(Objetivo.y - node.y)
        +Math.abs((Objetivo.x - node.x))) * 10;
    }
    
}
