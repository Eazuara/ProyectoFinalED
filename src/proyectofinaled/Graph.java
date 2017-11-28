/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaled;

import java.util.*;
import proyectofinaled.*;

/**
 *
 * @author esteb
 */
 public class Graph  {
    private int v,e;
    private List<Edge> g[];
    private boolean visited[];
    private String path = "";
    
  
    
    public Graph(int v){
        this.v=v;
        this.e=0;
        g = new List[v+1];
        for(int i=0; i<v+1; i++){
            g[i]= new List<Edge>(); //Instancía una lista en cada elemento del arreglo
        }
    }
    public int getEdges(){
        return this.e;
    }
    
    public int getVertices(){
        return this.v;
    }
    
    public boolean isEdge(int s, int d){
        List<Edge> l = this.g[s];
        Node<Edge> p = l.first;
        for(int i=0;i<l.length;i++){
            if (d == p.data.getDest()){
                return true;
            }
            p = p.next;
        }
        return false;
    }
    
    public double getEWeight(int s, int d){
        List<Edge> l = this.g[s];
        Node<Edge> p = l.first;
        for(int i=0;i<l.length;i++){
            if (d == p.data.getDest()){
                return p.data.getWeight();
            }
            p = p.next;
        }
        return -1.0;
    }
    
    public void insertE(int s, int d, double w){
        if(!isEdge(s,d)){
            this.g[s].insertLast(new Edge(d, (int) w));
            this.e++;
        }else{
            System.out.println("No es posible insertar el elemento, ("+s+","+d+") ya se encuentra en el grafo");
        }
    }
    
    public void insertE(int s, int d){
        insertE(s,d,0.0);
    }
    
    public List<Edge> adjacentTo(int s){
        return this.g[s];
    }
    
    public String to_string(){
        String r="";
        for (int i=1; i<this.v+1; i++){
            r += "\nVértice "+ Integer.toString(i) +" ";
            List<Edge> lp = adjacentTo(i);
            if (lp.isEmpty()){
                r += "sin Adyacentes.\n\n";
            }else{
                r += "con Adyacentes:\n";
                lp.pointer=lp.first;
                for (int j=1; j<=lp.length; j++){
                    r += lp.pointer.data.toString()+"\n";
                    lp.pointer=lp.pointer.next;
                }
            }
        }
        System.out.println(r);
        return r;
    }
    
    public String BFS(int origin){
        visited = new boolean [v+1]; //Matriz que indica los nodos visitados 
        String path="\nRecorrido BFS\n";
        Queue<Integer> q = new Queue<Integer>();//Cola donde iremos guardando las visitas *ClosedList
        path += Integer.toString(origin) + "->";
        q.enqueue(origin); //Insertamos el primer nodo enviado
        visited[origin]=true; //Indicamos que ya fue visitado
        while (!q.isEmpty()){ //Mientras que la cola no esté vaía
            List<Edge> l = adjacentTo(q.dequeue()); //obtenemos los adyacentes del nodo visitado y lo sacamos de la cola;
            l.pointer=l.first; //inicializamos el puntero de la lista en la primer posición.
            while(l.pointer!=null){ //Recorremos la lista de adyacencia
                if(!visited[(int)l.pointer.data.getDest()]){ //Preguntamos si ya fue visitado
                //Si no fue visitado, obtenemos el nodo adyacente
                    int a=(int) l.pointer.data.getDest();
                    visited[a]=true;
                    q.enqueue(a);
                    
                    path += Integer.toString(a) +"->";
                }
               l.pointer=l.pointer.next;
            }
        }
        System.out.println(path += "\n");
        return path;
    }
    
    public String DFS(int origin,int destiny){
        //Inicializamos variables globales
        boolean visited[]  = new boolean [v+1];
        System.out.println(path="\nRecorrido DFS\n" + recursiveDFS(origin,visited,destiny) +"\n");
        return path;
    }
    
      private String recursiveDFS(int origin,boolean visited[],int destiny){
        List<Edge> l = adjacentTo(origin);//Obtenemos lista de adyacencia
        visited[origin] = true;
        System.out.print(origin+"->");
        l.pointer=l.first; //Recorrido d ela lista
        while (l.pointer!=null){//Mientras no lleguemos al final de la lista
            if ((int)l.pointer.data.getDest()==destiny){//obtenemos el adyacente
                return path;//se regersa el camino
            }
            if (!visited[(int)l.pointer.data.getDest()])
                recursiveDFS((int)l.pointer.data.getDest(), visited, destiny);
            }
        return path; //devolvemos la trayectoria
    }
 }