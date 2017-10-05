
package Model;

/**
 *
 * @author funck
 */

public enum TerrenoFactory {
    
    solido{
        @Override
        public Node getTerreno(int x, int y) {
            return new NodeSolido(x , y);
        }
    },
    rochoso{
        @Override
        public Node getTerreno(int x , int y) {
            return new NodeRochoso(x, y);
        }
    },
    arenoso{
        @Override
        public Node getTerreno(int x, int y) {
             return new NodeArenoso(x , y);
        }
    },
    pantano{  
        @Override
        public Node getTerreno(int x , int y) {
            return new NodePantado(x , y);
        }
    },
    parede{
        @Override
        public Node getTerreno(int x, int y) {
            return new NodeParede(x, y);
        }
    },
    moeda{
        @Override
        public Node getTerreno(int x, int y) {
            return new NodeMoeda(x, y);
        }  
    };
    
    public abstract Node getTerreno(int x, int y);
    
    
}
