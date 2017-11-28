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
public class ProyectoFinalED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Graph grafo = new Graph(13);
    
    grafo.insertE(0, 1, 1);
    grafo.insertE(1, 2, 15);
    grafo.insertE(1, 4, 6);
    grafo.insertE(2, 8, 11);
    grafo.insertE(2, 7, 4);
    grafo.insertE(5, 3, 8);
    grafo.insertE(4, 5, 5);
    grafo.insertE(5, 6, 3);
    grafo.insertE(5, 10, 9);
    grafo.insertE(6, 7, 5);
    grafo.insertE(6, 11, 5);
    grafo.insertE(7, 9, 5);
    grafo.insertE(7, 6, 5);
    grafo.insertE(8, 12, 13);
    grafo.insertE(8, 11, 17);
    grafo.insertE(10, 11, 20);
    grafo.insertE(11, 8, 17);
     
    
  
        
        System.out.println(grafo.to_string());
        System.out.println("El camino mas corto es:" );
        System.out.println( grafo.DFS(0,13));
        System.out.println(grafo.BFS(0));
        
    
   
}
}