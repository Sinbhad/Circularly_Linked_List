public class Node {
    private Node prev;
    private Node next;
    private String value;

    public Node(){
        this.prev = null;
        this.next = null;
        this.value = "";
    }

    public Node(String value){
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    public void setNextNode(Node next){
        this.next = next;
    }

    public Node getNextNode(){
        return next;
    }

    public void setLastNode(Node prev){
        this.prev = prev;
    }

    public Node getLastNode(){
        return prev;
    }

    public void setNodeValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public Boolean checkIfNextExists(){
        return this.getNextNode() != null;
    }

    public Node getLast() {
        Node nextNode;
        Node tempNode = this;
        while (tempNode.checkIfNextExists()) {
            nextNode = tempNode.getNextNode();
            tempNode = nextNode;
        }
        return tempNode;
    }
}


