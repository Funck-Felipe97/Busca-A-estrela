
package Busca;

import Model.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author funck
 */
public class BuscaHeuristica{
 
    public List<Node> aStar(Node inicio , Node destino) {
        List<Node> abertos = new ArrayList<>();
        List<Node> fechados = new ArrayList<>();

        inicio.custoAtual = 0;
        inicio.heuristica = estimateDistance(inicio , destino);
        inicio.f = inicio.heuristica;

       abertos.add(inicio);

        while (true) {
            Node current = null;

            if (abertos.isEmpty()) {
                throw new RuntimeException("no route");
            }

            for (Node node : abertos) {
                if (current == null || node.f < current.f) {
                    current = node;
                }
            }

            if (current == destino) {
                break;
            }

            abertos.remove(current);
            fechados.add(current);

            for (Node no : current.adjacentes) {
                if (no == null) {
                    continue;
                }

                int nextG = current.custoAtual + no.peso;

                if (nextG < no.custoAtual) {
                    abertos.remove(no);
                    fechados.remove(no);
                }

                if (!abertos.contains(no) && !fechados.contains(no)) {
                    no.custoAtual = nextG;
                    no.heuristica = estimateDistance(no, destino);
                    no.f = no.custoAtual + no.heuristica;
                    no.pai = current;
                    abertos.add(no);
                }
            }
        }

        List<Node> nodes = new ArrayList<Node>();
        Node atual = destino;
        while (atual.pai != null) {
            nodes.add(atual);
            atual = atual.pai;
        }
        nodes.add(inicio);

        return nodes;
    }

    public int estimateDistance(Node node1, Node node2) {
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }

}
