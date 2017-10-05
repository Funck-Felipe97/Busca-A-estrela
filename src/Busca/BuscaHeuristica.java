
package Busca;

import Model.Node;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author funck
 */
public class BuscaHeuristica{
 
    public List<Node> aStar(Node start, Node goal) {
        Set<Node> open = new HashSet<Node>();
        Set<Node> closed = new HashSet<Node>();

        start.g = 0;
        start.h = estimateDistance(start, goal);
        start.f = start.h;

        open.add(start);

        while (true) {
            Node current = null;

            if (open.size() == 0) {
                throw new RuntimeException("no route");
            }

            for (Node node : open) {
                if (current == null || node.f < current.f) {
                    current = node;
                }
            }

            if (current == goal) {
                break;
            }

            open.remove(current);
            closed.add(current);

            for (Node neighbor : current.neighbors) {
                if (neighbor == null) {
                    continue;
                }

                int nextG = current.g + neighbor.cost;

                if (nextG < neighbor.g) {
                    open.remove(neighbor);
                    closed.remove(neighbor);
                }

                if (!open.contains(neighbor) && !closed.contains(neighbor)) {
                    neighbor.g = nextG;
                    neighbor.h = estimateDistance(neighbor, goal);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;
                    open.add(neighbor);
                }
            }
        }

        List<Node> nodes = new ArrayList<Node>();
        Node current = goal;
        while (current.parent != null) {
            nodes.add(current);
            current = current.parent;
        }
        nodes.add(start);

        return nodes;
    }

    public int estimateDistance(Node node1, Node node2) {
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }

}
