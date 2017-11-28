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
public class Stack<T>{
    private Node<T> top;
    private int size;

    public Stack(){
        top= null;
        size=0;
    }
    public Stack(T d){
        Node<T> node = new Node<T>(d);
        top=node;
        size=1;
    }

    public int getSize(){//Devuelve el tamaño de la pila
        return size;
    }
    public void push(T d){//Inserta un nodo en la cima de la pila
        Node<T> node = new Node<T>(d);
        node.next=top;
        top=node;
        size++;
    }
    public T pop(){//Elimina un valor de la cima de la pila y lo devuelve
        if(size>0){
            T d = top.data;
            top=top.next;
            size--;
            return d;
        } else return null;
    }
    public T getTop(){//Devuelve el valor de la cima
        if (size>0){
            return top.data;
        } else return null;
    }
    public void showStack(){//Muestra la pila
        Node<T> t = top;
        while (t!=null){
            t.printS();
            t=t.next;
        }
        System.out.println("NULL");;
    }
    
    public void deleteStack(){//Elimina la pila
        top=null;
        size=0;
    }
}