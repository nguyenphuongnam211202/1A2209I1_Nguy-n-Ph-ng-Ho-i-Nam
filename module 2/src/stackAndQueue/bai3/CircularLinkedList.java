package stackAndQueue.bai3;

public class CircularLinkedList {

    private Queue queue;


    private class Node {

        public int data;

        public Node link;

        public Node(int data) {

            this.data = data;

        }

    }

    private class Queue {
        public Node front = null;

        public Node rear = null;

        public Queue() {
            front = rear;
        }

    }


    public void enQueue(int data) {

        //Create new node
        Node newNode = new Node(data);


        //Checks if the list is empty.

        if (queue.rear == null) {

            queue.front = newNode;

            queue.rear = newNode;

            queue.rear.link = queue.front;

        } else {

            queue.rear.link = newNode;


            queue.rear = newNode;


            queue.rear.link = queue.front;

        }


    }


    public void deQueue() {

        if (queue.front == null) {

            System.out.println("null");

        } else {
            if (queue.front == queue.rear) {
                queue.front = null;
                queue.rear = null;
            } else {
                queue.front = queue.front.link;
                queue.rear.link = queue.front;
            }
        }


    }

    public void display(){
        Node temp = queue.front;
        while (temp != queue.rear) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println(queue.rear.data);
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.enQueue(2);
        cl.enQueue(5);
        cl.enQueue(1);
        cl.deQueue();
        cl.display();
    }
}
