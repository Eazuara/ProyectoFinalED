/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaled;

/**
 *
 * @author esteb
 */
public class Edge {
    private int dest;
    private int source;
    private double weight;

    public Edge(int dest, int source) {
        this.dest = dest;
        this.source = source;
    }

    public Edge(int dest, int source, double weight) {
        this.dest = dest;
        this.source = source;
        this.weight = weight;
    }

    public int getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" + "dest=" + dest + ", source=" + source + ", weight=" + weight + '}';
    }
    
    
    
}