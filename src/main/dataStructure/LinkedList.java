package dataStructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    // Classe interna Node
    class Node {
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }
    }

    // Construtor da LinkedList
    public LinkedList(String data){
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Método para obter a cauda da lista
    public void getTail(){
        if (this.tail == null){
            System.out.println("Lista vazia");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    // Método para obter a cabeça da lista
    public void getHead(){
        if (this.head == null){
            System.out.println("Lista vazia");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    // Método para obter o comprimento da lista
    public void getLength(){
        System.out.println("Length: " + this.length);
    }

    // Método para esvaziar a lista
    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }

    public void append(String data){
        Node newNode = new Node(data);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0) return null;
        Node pre = head;
        Node temp = null;

        while(pre.next != tail){
            pre = pre.next;
        }
        temp = tail;
        tail = pre;
        tail.next = null;

        length--;
        if (length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void print(){
        System.out.println("##################");
        Node temp = this.head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("##################");
    }

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, String data){
        Node temp = get(index);
        if (temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }

    public boolean insert(int index, String data){
        if (index<0 || index>length) return false;
        if (index == 0){
            prepend(data);
            return true;
        }
        if (index == length){
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp =  get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }


    // Método principal para testar a LinkedList
    public static void main(String[] args){
        LinkedList list = new LinkedList("elemento 1");
        list.append("elemento 2");
        list.append("elemento 3");
        list.prepend("elemento 0");

        list.remove(2);
        list.print();
    //    list.insert(3, "elemento 2.5");
    //    System.out.println(list.get(2).data);
    //    System.out.println(list.removeFirst().data);
    //    list.print();
    //    list.set(1, "elemento 0.5");
    //    list.print();
    }
}
