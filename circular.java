public class circular {

    public static void main(String[] args) {

        circularlist list = new circularlist();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);

        list.deleteLast();

        list.print();
    }
}

class circularlist {

    node head;
    int size = 0;

    void insertFirst(int data) {

        node newnode = new node(data);

        if (head == null) {
            head = newnode;
            head.next = head;
        } 
        else {
            newnode.next = head;

            node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newnode;
            head = newnode;
        }

        size++;
    }
    void insertLast(int data) {

        node newnode = new node(data);

        if (head == null) {
            head = newnode;
            newnode.next = head;
        } 
        else {
            node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newnode;
            newnode.next = head;
        }

        size++;
    }

    void deleteFirst() {

        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } 
        else {
            node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            head = head.next;
            temp.next = head;
        }

        size--;
    }

    void deleteLast() {

        if (head == null) {
            return;
        }

        if (size == 1) {
            head = null;
        } 
        else {
            node temp = head;

            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }

            temp.next = head;
        }

        size--;
    }
    void print() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        node temp = head;

        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } 
        while (temp != head);

        System.out.println("(back to head)");
    }
}


class node {

    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}