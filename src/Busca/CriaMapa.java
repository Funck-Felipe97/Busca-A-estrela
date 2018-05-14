
package Busca;

import Model.Node;
import Model.NodeMoeda;
import Model.NodeParede;
import Model.TerrenoFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 *
 * @author funck
 */
public class CriaMapa {
    
    public Node[][] terrenos;
    public final int tamanho = 10;
    public TerrenoFactory factory;
    
    public CriaMapa(){
        terrenos = new Node[tamanho][tamanho];
        criarGrafo();
    }
    
    private void criarGrafo(){
        Node terreno = null;
        int aux = 0;
         
        for(int i = 0 ; i < tamanho ; ++i){
            for(int j = 0 ; j < tamanho ; ++j){
                Random randomico = new Random();
                int n = 0;
                n = randomico.nextInt(6);         // Criação do terreno
                terreno = factory.values()[n].getTerreno(i , j);
                
                if(terreno instanceof NodeMoeda){   // Delimitar Moedas
                    if(aux < 5){
                        terrenos[i][j] = terreno;
                        aux++;
                    }else{
                        terreno = factory.values()[0].getTerreno(i , j);
                        terrenos[i][j] = terreno;
                    }
                }else{
                    terrenos[i][j] = terreno;
                }   
            }
        }
        criarNovoMapa();
 
    }
    
    /*
    * @Metodo que faz as ligações entre os nós do grafo
    */
    
    private void criarNovoMapa(){
        for(int i = 0 ; i < tamanho ; ++i){
            for(int j = 0; j < tamanho ; ++j){
                if(!(terrenos[i][j] instanceof NodeParede)){
                    if (j > 0) 
                        if(!(terrenos[i][j - 1] instanceof NodeParede))
                            terrenos[i][j].adjacentes.add(terrenos[i][j - 1]);
                        
                    if (i > 0)
                        if(!(terrenos[i - 1][j] instanceof NodeParede))
                            terrenos[i][j].adjacentes.add(terrenos[i - 1][j]);
                    
                    if (j < (tamanho - 1)) 
                        if(!(terrenos[i][j + 1] instanceof NodeParede))
                            terrenos[i][j].adjacentes.add(terrenos[i][j + 1]);
                    
                    if (i < (tamanho - 1)) 
                        if(!(terrenos[i + 1][j] instanceof NodeParede))
                            terrenos[i][j].adjacentes.add(terrenos[i + 1][j]);         
                }
            }
        }
      
    }
  
}
