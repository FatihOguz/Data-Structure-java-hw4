/**
 * this class tests Deque class
 */
public class Test {
    public static void main(String[] args){
        Deque<Integer> deque = new Deque<>();
     System.out.println("addFirst ==> 23" );
     deque.addFirst(23);
     System.out.println("addFirst ==> 53" );
     deque.addFirst(53);
     System.out.println("offerFirst ==> 69");
     deque.offerFirst(69);
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("addLast ==> 100");
     deque.addLast(100);
     System.out.println("offerLast ==> 250");
     deque.offerLast(250);
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("removeFirst ");
     deque.removeFirst();
     System.out.println("removeLast ");
     deque.removeLast();
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("***************************************************************************************");



     System.out.println("pollFirst ");
     deque.pollFirst();
     System.out.println("pollLast ");
     deque.pollLast();
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("push 55");
     deque.push("55");
     System.out.println("push 85");
     deque.push("85");
     System.out.println("*** use node of removedLinkedList for adding ***");
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("getFirst ==> "  + deque.getFirst());
     System.out.println("getLast ==> "  + deque.getLast());
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("peekFirst " + deque.peekFirst());
     System.out.println("peekLast " + deque.peekLast());
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");

     System.out.println("*************************************************************************************************");


     System.out.println("add ==> 99 "+ deque.add(99));
     System.out.println("*** use node of removedLinkedList for adding ***");
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("offer ==> 44 " + deque.offer(44));
     System.out.println("*** use node of removedLinkedList for adding ***");
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("poll==> " +      deque.poll());
     System.out.println("removeFirst ==> " + deque.removeFirst());
     System.out.println("remove ==> " + deque.remove());
     System.out.println("pop ==> " + deque.pop());
     System.out.println("size ==> " + deque.size());
     System.out.println("isEmpty ==> " + deque.isEmpty());
     System.out.println("element ==> " + deque.element());
     System.out.println("peek ==> " + deque.peek());
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");
     System.out.println("removeFirst ==>" + deque.removeFirst());
     System.out.println("isEmpty ==> " + deque.isEmpty() );
     System.out.println("size ==> " + deque.size());
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");




     System.out.println("*************************************************************************************************");



     System.out.println("removeFirst==>" + deque.removeFirst());
     System.out.println("addLinkedList of deque " + deque);
     System.out.println("removeLinkedList of deque " + deque.removeToString());
     System.out.println("\n");







    }
}
