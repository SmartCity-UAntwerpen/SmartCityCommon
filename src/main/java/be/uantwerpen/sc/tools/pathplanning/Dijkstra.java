package be.uantwerpen.sc.tools.pathplanning;

import be.uantwerpen.sc.tools.Edge;
import be.uantwerpen.sc.tools.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Calculates Dijkstra Path for Robot TODO
 */
public class Dijkstra
{
    /**
     * Computes Dijkstra path based on Source Vertex and list of possible Vertices to visit
     * @param source Source (start) Vertex
     * @param vertexes Map Vertices
     */
    public void computePaths(Vertex source, List<Vertex> vertexes)
    {
        source.setMinDistance(0);
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);
        List<Vertex> vertexList = new ArrayList<>();
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            Vertex v = new Vertex(1L);
            // Visit each edge exiting u
            for (Edge e : u.getAdjacencies())
            {
                for (Vertex w : vertexes){
                    if(w.getId() == e.getTarget()){
                        v =w;
                        vertexList.add(v);
                    }
                }

                double weight = e.getWeight();
                double distanceThroughU = u.getMinDistance() + weight;
                if (distanceThroughU < v.getMinDistance()) {
                    vertexQueue.remove(v);

                    v.setMinDistance(distanceThroughU) ;
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }
            }
        }
    }

    /**
     * Calculates shortest path between given Vertex and list of available Vertices
     * @param target Start or End point TODO
     * @param vertexes List of available Vertices
     * @return
     */
    public List<Vertex> getShortestPathTo(Vertex target, List<Vertex> vertexes)
    {
        List<Vertex> path = new ArrayList<Vertex>();
       /* int i;
        for (Vertex vertex = target; vertex != null;  i = vertex.getPrevious())
            path.add(vertex);
        int i;
        Vertex vertex = target;
        path.add(vertex);
        i = vertex.getPrevious();
        vertex= vertexes.get(i);*/


        int i = (int)(target.getId() % Integer.MAX_VALUE);
        do {
            for (Vertex v : vertexes){
                if(v.getId() == i)
                    path.add(vertexes.get(i-1));
            }
            try {
                i = (int)(vertexes.get(i-1).getPrevious().getId() % Integer.MAX_VALUE);
            }catch (Exception e){
               i = 0;
            }
        } while (i != 0);

       /* for (int i = target.getId(); vertexes.get(i).getPrevious() != null; i = vertexes.get(i).getPrevious()){
            for (Vertex v : vertexes){
                if(v.getId() == i)
                    path.add(vertexes.get(i-1));
            }
        }*/


        Collections.reverse(path);
        return path;
    }
}
