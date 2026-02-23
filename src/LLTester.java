public class LLTester {
    public static void main(String[] args) {
        CircularlyLinkedList linkedList = new CircularlyLinkedList();
        linkedList.add("Jared");
        linkedList.add("My Guy");
        linkedList.add("Byron");
        linkedList.add("Why");
        linkedList.add("Andrew");
        linkedList.add("Reels");
        linkedList.printAll();
        System.out.println("\n\n\n\n\n");
        linkedList.printReverse();
        System.out.println("\n\n\n\n\n");
        linkedList.remove("Jared");
        linkedList.printAll();
        System.out.println("\n\n\n\n\n");
        linkedList.removeAt(3);
        linkedList.printAll();
        System.out.println("\n\n\n\n\n");
        linkedList.remove("Invalid");
        linkedList.printAll();
    }
}