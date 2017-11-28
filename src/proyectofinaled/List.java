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
public class List <T> {
   Node<T> first;
   Node<T> last;
   Node<T> pointer;
   int length;

    public List() {
        this.first = null;
        this.last = null;
        this.pointer = null;
    }

    public List(T data) {
        Node node = new Node(data);
        first = node;
        last = node;
        node.next=null;
    }

    public boolean isEmpty(){
        return this.first==null;
    }

    public void insertFirst(T n){
        Node node = new Node(n);
        if(isEmpty()){//Si la lista esta vacia
            first = node;//firts y las apuntan a nodo
            last = node;
            node.next=null;//nodo apunta a null , a su nada
        }else{
            node.next=first;// Apuntador next del nuevo nodo apunta al primer nodo
            first = node; //First apunta a nodo
        }
    }

    public void insertLast(T n){
        Node node = new Node(n);
        if(isEmpty()){ //Si la lista esta vacia
            first = node;
            last = node;
            node.next=null;
        }else{//Si no esta vacia
            last.next=node;//apuntador de last apunta al nuevo nodo
            last=node;//Lats apunta al nuevo nodo
        }
    }

    public void deleteFirst(){
        if(!isEmpty()){//No esta vacia
            if(first.next==null){//Todo se iguala a NULL para borrar
                first = null;
                last = null;
            }else {// Si no , first va a ser su siguiente
                first = first.next;
            }
        }
    }

    public void deleteLast(){
        if(!isEmpty()){
            if(first.next==null){
                first = null;
                last = null;
            }else{
                pointer=first;
                do{
                    if(pointer.next==null) {
                        last = pointer;
                        last.next = pointer = null;
                    } else {
                        pointer=pointer.next;
                    }
                } while(pointer.next!=null);
            }

        }
    }

    public boolean deleteNode(T n){
        Node temp = fetchBack(n);
        if(temp!=null) { //si encuentra el nodo
            if (temp.data == n) { //si es el primero o unico
                deleteFirst(); //borra el primer/unico
                return true;
            } else {
                temp.next = temp.next.next; //si no es el primero/unico lo borra
                return true;
            }
        }
        return false; //si no lo encuentra regresa false
    }
    
    public Node fetchBack(T n){
        if(!isEmpty()){
            if(first==last){//si la lista es de 1 elemento
                if(first.data==n){ //y el primero es el que buscamos
                    return first; //regresamos el primero
                } else return null; //si no null
            } else { //si la lista tiene varios elementos
                if (first.data == n) {  //si es el primero en la lista
                    return first;       //regresamos first
                }
                pointer = first;
                Node result;
                do {
                    if (pointer.next.data == n) { //si el siguente nodo tiene el dato que buscamos
                        result = pointer;       //asignamos el nodo a otra variable
                        pointer = null;         //limpiamos pointer
                        return result;          //regresamos esa variable
                    } else {
                        pointer = pointer.next; //si no, seguimos en la lista
                    }
                } while (pointer.next != null); //mientras que el siguiente no sea nulo
            }
        } return null; //si no lo encontramos regresamos nulo
    }
    
    public Node fetch(T n){
        if(!isEmpty()) {
            if (first.data == n) return first;
            Node temp = fetchBack(n);
            if (temp != null) {
                return temp.next;
            }
        } return null;
    }
}