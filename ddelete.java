public class ddelete {

    dnode head = null;

    // DELETE FIRST
    void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    // DELETE LAST
    void deleteLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        dnode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        if (temp.prev == null) {
            head = null;
        } else {
            temp.prev.next = null;
        }
    }

    // DELETE SPECIFIC
    void deleteSpecific(int pos) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        dnode temp = head;

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.prev == null) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // DISPLAY
    void display() {

        dnode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        ddelete d = new ddelete();

        // Creating doubly linked list
        d.head = new dnode(10);

        dnode n2 = new dnode(20);
        dnode n3 = new dnode(30);
        dnode n4 = new dnode(40);

        d.head.next = n2;
        n2.prev = d.head;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        System.out.println("Original List:");
        d.display();

        // Delete first
        d.deleteFirst();

        System.out.println("After Delete First:");
        d.display();

        // Delete last
        d.deleteLast();

        System.out.println("After Delete Last:");
        d.display();

        // Delete position 2
        d.deleteSpecific(2);

        System.out.println("After Delete Position 2:");
        d.display();
    }
}


// NODE CLASS
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