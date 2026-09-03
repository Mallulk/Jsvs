public class doubly {

    public static void main(String[] args) {

        doublylist list = new doublylist();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);

        System.out.println("Size = " + list.size);

        System.out.println("Forward:");
        list.print();

        System.out.println("Backward:");
        list.printReverse();

        list.deleteFirst();
        list.deleteLast();

        System.out.println("After deletion:");
        System.out.println("Size = " + list.size);

        list.print();
    }
}


class doublylist {

    dnode head;
    int size = 0;


    // INSERT FIRST
    void insertFirst(int data) {

        dnode newnode = new dnode(data);

        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }

        size++;
    }


    // INSERT LAST
    void insertLast(int data) {

        dnode newnode = new dnode(data);

        if (head == null) {
            head = newnode;
        } else {

            dnode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newnode;
            newnode.prev = temp;
        }

        size++;
    }


    // DELETE FIRST
    void deleteFirst() {

        if (head == null) {
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        size--;
    }


    // DELETE LAST
    void deleteLast() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
        } else {

            dnode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.prev.next = null;
        }

        size--;
    }


    // PRINT FORWARD
    void print() {

        dnode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }


    // PRINT BACKWARD
    void printReverse() {

        if (head == null) {
            return;
        }

        dnode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
    }
}


// DOUBLY NODE
class dnode {

    int data;
    dnode next;
    dnode prev;

    dnode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}