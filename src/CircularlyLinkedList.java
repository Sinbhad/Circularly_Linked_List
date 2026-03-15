@SuppressWarnings("ALL")
public class CircularlyLinkedList<T>{
    Node head;
    Node tail;

    public Node getHead(){
        return head;
    }

    public void clear(){
        head = null;
        tail = null;
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setNextNode(newNode);
            newNode.setLastNode(newNode);
        } else {
            tail.setNextNode(newNode);
            newNode.setLastNode(tail);

            newNode.setNextNode(head);
            head.setLastNode(newNode);

            tail = newNode;
        }
    }

    public void printAll(){
        if (head == null) return;
        Node tempNode = head;
        do{
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNextNode();
        }while(tempNode != head);
    }

    public T getValAtIndex(int index){
        Node tempNode = head;
        for(int i = 0; i < index; i++){
            if(tempNode == null) return null;
            tempNode = tempNode.getNextNode();
        }
        return (T) tempNode.getValue();
    }

    public Node getNodeAtIndex(int index){
        Node tempNode = head;
        for(int i = 0; i < index; i++){
            if(tempNode == null) return null;
            tempNode = tempNode.getNextNode();
        }
        return tempNode;
    }

    public void printReverse(){
        if (tail == null) return;
        Node tempNode = tail;
        do{
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getLastNode();
        }while(tempNode != tail);
    }

    public void removeAt(int index) {
        int size = getSize();
        if (size == 0 || index < 0 || index >= size) return;

        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNextNode();
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node prevNode = tempNode.getLastNode();
            Node nextNode = tempNode.getNextNode();

            prevNode.setNextNode(nextNode);
            nextNode.setLastNode(prevNode);

            if (tempNode == head) head = nextNode;
            if (tempNode == tail) tail = prevNode;
        }
    }

    public boolean find(T data)
    {
        if (head == null) return false;
        Node<T> currentNode = head;
        do{
            if(currentNode.getValue().equals(data))
            {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }while(currentNode != head);
        return false;
    }

    public void remove(T value) {
        if (head == null) return;

        Node tempNode = head;
        boolean found = false;

        do {
            if (tempNode.getValue().equals(value)) {
                found = true;
                if (head == tail && head == tempNode) {
                    head = null;
                    tail = null;
                } else {
                    Node prevNode = tempNode.getLastNode();
                    Node nextNode = tempNode.getNextNode();

                    prevNode.setNextNode(nextNode);
                    nextNode.setLastNode(prevNode);

                    if (tempNode == head) head = nextNode;
                    if (tempNode == tail) tail = prevNode;
                }
                break;
            }
            tempNode = tempNode.getNextNode();
        } while (tempNode != head);

        if(!found){
            System.out.println("The given value '" + value + "' does not exist in the linked list\n\n");
        }
    }

    public int getSize(){
        if (head == null) return 0;
        Node tempNode = head;
        int size = 0;
        do{
            size++;
            tempNode = tempNode.getNextNode();
        }while(tempNode != head);
        return size;
    }

    public Node getLast(){
        return tail;
    }
}