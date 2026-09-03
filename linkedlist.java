class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}
class linkedlist {
    node head;
    int size = 0;
    public void append(int data) {
        node newnode = new node(data);

        if (head == null) {
            head = newnode;
        } else {
            node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newnode;
        }

        size++;
    }    
    public void addFirst(int data) {
        node newnode = new node(data);

        newnode.next = head;
        head = newnode;

        size++;
    }
    public void addAt(int data, int position) {

        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(data);
            return;
        }
        node newnode = new node(data);
        node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
        size++;
    }
    public void print() {
        node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public boolean search(int data) {
        node temp = head;

        while (temp != null) {

            if (temp.data == data) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        size--;
    }
    public void deleteLast() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        size--;
    } 
    public void delete(int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }
        node temp = head;
        while (temp.next != null) {

            if (temp.next.data == data) {
                temp.next = temp.next.next;
                size--;
                return;
            }

            temp = temp.next;
        }

        System.out.println("Element not found");
    }  
    public int getSize() {
        return size;
    }
    public int getFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        return head.data;
    }
    public int getLast() {

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }
    public void reverse() {

        node prev = null;
        node current = head;

        while (current != null) {

            node next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        head = prev;
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        System.out.println("Original list:");
        list.print();
        System.out.println("Search 20: " + list.search(20)); 
        list.addFirst(5);
        System.out.println("After addFirst:");
        list.print();
        list.addAt(25, 3);
        System.out.println("After addAt:");
        list.print();
        list.deleteFirst();
        System.out.println("After deleteFirst:");
        list.print();
        list.deleteLast();
        System.out.println("After deleteLast:");
        list.print();
        list.delete(25);
        System.out.println("After deleting 25:");
        list.print();
        System.out.println("Size: " + list.getSize());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        list.reverse();
        System.out.println("After reverse:");
        list.print();
        list.clear();
        System.out.println("After clear:");
        list.print();
    }
}