public class CircularlyLinkedList {
    Node head;
    Node tail;

    public void add(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while(tempNode.getNextNode() != null){
                tempNode = tempNode.getNextNode();
            }
            tempNode.setNextNode(newNode);
            newNode.setLastNode(tempNode);
        }
        tail = newNode;
    }

    public void printAll(){
        Node tempNode = head;
        while(tempNode != null){
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNextNode();
        }
    }

    public void printReverse(){
        Node tempNode = tail;
        while(tempNode != null){
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getLastNode();
        }
    }

    public void removeAt(int index) {
        Node tempNode = head;

        if (index == 0) {
            Node newNextNode = tempNode.getNextNode();
            if (newNextNode != null) {
                newNextNode.setLastNode(null);
                head = newNextNode;
            } else {
                head = null;
                tail = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNextNode();
            }
            Node prevNode = tempNode.getLastNode();
            Node nextNode = tempNode.getNextNode();

            prevNode.setNextNode(nextNode);
            if (nextNode != null) {
                nextNode.setLastNode(prevNode);
            } else {
                tail = prevNode;
            }
        }
    }

    public void remove(String value) {
        Node tempNode = head;
        boolean found = false;

        if (head.getValue().equalsIgnoreCase(value)) {
            Node newNextNode = tempNode.getNextNode();
            if (newNextNode != null) {
                newNextNode.setLastNode(null);
                head = newNextNode;
            } else {
                head = null;
                tail = null;
            }
            found = true;
        } else {
            while (tempNode != null && !found) {
                if (tempNode.getValue().equalsIgnoreCase(value)) {
                    Node prevNode = tempNode.getLastNode();
                    Node nextNode = tempNode.getNextNode();

                    prevNode.setNextNode(nextNode);
                    if (nextNode != null) {
                        nextNode.setLastNode(prevNode);
                    } else {
                        tail = prevNode;
                    }
                    found = true;
                } else {
                    tempNode = tempNode.getNextNode();
                }
            }
        }
        if(!found){
            System.out.println("The given value '" + value + "' does not exist in the linked list\n\n");
        }
    }
}