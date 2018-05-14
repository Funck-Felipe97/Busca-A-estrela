
package Busca;

import Model.Node;
import Model.NodeMoeda;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author funck
 */

public class BuscaHeuristica{
 
    public List<Node> aEstrela(Node inicio , Node destino) {
        List<Node> abertos = new ArrayList<>();
        List<Node> fechados = new ArrayList<>();

        inicio.custoAtual = 0;
        inicio.heuristica = inicio.calcularHeuristica(destino);
        inicio.f = inicio.heuristica;

        abertos.add(inicio);

        while (true) {
            Node atual = null;

            if (abertos.isEmpty()) {
                throw new RuntimeException("nenhum caminho econtrado!");
            }

            for (Node node : abertos) {
                if (atual == null || node.f < atual.f) {
                    atual = node;
                }
            }

            if (atual == destino) {  //Termina a busca
               break;
            }

            abertos.remove(atual);
            fechados.add(atual);

            for (Node no : atual.adjacentes) {
                if (no == null) {
                    continue;
                }
             
                if (!fechados.contains(no)) {
                    no.custoAtual = atual.custoAtual + no.peso;
                    no.heuristica = no.calcularHeuristica(destino);
                    no.f = no.custoAtual + no.heuristica;
                    no.pai = atual;
                    abertos.add(no);
                }
            }
        }
        return calcularCaminho(inicio, destino);
    }
    
    public List<Node> calcularCaminho(Node inicio, Node destino ){
        List<Node> nodes = new ArrayList<Node>();
        Node atual = destino;
        while (atual.pai != null) {
            nodes.add(atual);
            atual = atual.pai;
        }
        nodes.add(inicio);
        return nodes;
    }

}
