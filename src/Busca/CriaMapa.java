
package Busca;

import Model.Node;
import Model.NodeMoeda;
import Model.NodeParede;
import Model.TerrenoFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author funck
 */
public class CriaMapa {
    
    public List<List<Node>> terrenos;
    public final int tamanho = 10;
    public TerrenoFactory factory;
    public List<Node> listaNodes;

    public CriaMapa(){
        this.terrenos = new ArrayList<>();
        criarGrafo();
    }
    
    private void criarGrafo(){
        Node terreno = null;
        List<Node> colunas = null;
        int aux = 0;
        
        for(int i = 0 ; i < tamanho ; ++i){
            colunas = new ArrayList<Node>();
            terrenos.add(colunas);
            for(int j = 0 ; j < tamanho ; ++j){
                Random randomico = new Random();
                int n = 0;
                n = randomico.nextInt(6);         // Criação do terreno
                terreno = factory.values()[n].getTerreno(i , j);
                
                if(terreno instanceof NodeMoeda){   // Delimitar Moedas
                    if(aux < 5){
                        colunas.add(terreno);
                        aux++;
                    }else{
                        terreno = factory.values()[0].getTerreno(i , j);
                        colunas.add(terreno);
                    }
                }else{
                    colunas.add(terreno);
                }   
            }
        }
        criarNovoMapa();
    }
    
    /*
    * @Method que faz as ligações entre os nós do grafo
    */
    private void criarNovoMapa(){
        for(int i = 0 ; i < tamanho ; ++i){
            for(int j = 0; j < tamanho ; ++j){
                if (j > 0) {
                    terrenos.get(i).get(j).neighbors.add(terrenos.get(i).get(j - 1));
                }
                if (i > 0) {
                    terrenos.get(i).get(j).neighbors.add(terrenos.get(i - 1).get(j));
                }
                if (j < (tamanho - 1)) {
                    terrenos.get(i).get(j).neighbors.add(terrenos.get(i).get(j + 1));
                }
                if (i < (tamanho - 1)) {
                    terrenos.get(i).get(j).neighbors.add(terrenos.get(i + 1).get(j));
                }   
            }
        }
        gerarListaNodes();
        
    }

    private void gerarListaNodes() {
        listaNodes = new ArrayList<>();
        for(List<Node> linha : terrenos){
            for(Node no : linha){
                if(!(no instanceof NodeParede)){
                    listaNodes.add(no);
                }
            }
        }
    }
    
}
