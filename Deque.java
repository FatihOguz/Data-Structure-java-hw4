/**
 * @author Fatih OGUZ
 */

import java.util.*;

/**
 * Deque class extends AbstractCollection class and implemet java.util.Deque interface
 * this class add and remove  first or last element
 * so avoids the loop
 * deleted elements are collected in a separate list and garbage collector operation is not required.
 * When a new element is added, a node is taken from the list holding those deleted elements. If not, the new node opens.
 * @param <E> this class is generic class
 */
public class Deque<E>  extends AbstractCollection implements java.util.Deque{
    /**
     *front of the list of deleted elements
     */
   private Node<E> removeLinkedListFront;
    /**
     * rear of the list of deleted elements
     */
    private Node<E> removeLinkedListRear;
    /**
     * front of the list of added elements
     */
    private Node<E> addLinkedListFront;
    /**
     * rear of the list of added elements
     */
    private Node<E> addLinkedListRear;
    /**
     * size of the list of added elements
     */
    private int size = 0;
    /**
     * size of the list of removed elements
     */
    private int removeSize = 0;
    /**
     * for some methods exception
     */
    private Object NoSuchElementException;

    /**
     * no parameter constructor
     * everything was null at the beginning
     */
    public Deque(){
       addLinkedListFront = null;
       addLinkedListRear = null;
       removeLinkedListFront = null;
    }

    /**
     * add elements to the front of the list
     * if removeSize>0 , instead of create new node use node of removeLinkedList
     * @param o is element to be added
     */
    @Override
    public void addFirst(Object o) {

        if(removeSize==0){
            if(addLinkedListFront==null){
                addLinkedListFront = new Node<>();
                addLinkedListFront.data = (E) o;
                addLinkedListRear = addLinkedListFront;
                addLinkedListFront.next = null;
                addLinkedListFront.prev = null;
                size++;
            }
            else{
                addLinkedListFront.prev=new Node<>();
                addLinkedListFront.prev.data= (E) o;
                addLinkedListFront.prev.next = addLinkedListFront;
                addLinkedListFront.prev.prev=null;
                addLinkedListFront=addLinkedListFront.prev;
                size++;
            }
        }
        else{
            if(size == 0){
                addLinkedListFront = removeLinkedListRear;
                removeLinkedListRear  = removeLinkedListRear.prev;
                addLinkedListFront.data= (E) o;
                addLinkedListRear = addLinkedListFront;
                addLinkedListFront.next = null;
                addLinkedListFront.prev = null;
                size++;
                removeSize--;
            }
            else{
                addLinkedListFront.prev=removeLinkedListRear;
                removeLinkedListRear = removeLinkedListRear.prev;
                addLinkedListFront.prev.data= (E) o;
                addLinkedListFront.prev.next = addLinkedListFront;
                addLinkedListFront.prev.prev=null;
                addLinkedListFront=addLinkedListFront.prev;
                size++;
                removeSize--;
            }
        }

    }
    /**
     * add elements to the rear of the list
     * if removeSize>0 , instead of create new node use node of removeLinkedList
     * @param o is element to be added
     */
    @Override
    public void addLast(Object o) {


        if(removeSize==0){

            if(addLinkedListFront == null){
                addLinkedListFront = new Node<>();
                addLinkedListFront.data = (E) o;
                addLinkedListRear = addLinkedListFront;
                addLinkedListFront.next = null;
                addLinkedListFront.prev = null;
                size++;
            }
            else{
                addLinkedListRear.next = new Node<>();
                addLinkedListRear.next.data = (E) o;
                addLinkedListRear.next.prev = addLinkedListRear;
                addLinkedListRear.next.next = null;
                addLinkedListRear = addLinkedListRear.next;
                size++;
            }
        }
        else{
            if (size == 0) {

                addLinkedListFront = removeLinkedListRear;
                removeLinkedListRear=removeLinkedListRear.prev;
                addLinkedListFront.data = (E) o;
                addLinkedListRear = addLinkedListFront;
                addLinkedListFront.next = null;
                addLinkedListFront.prev = null;
                size++;
                removeSize--;
            }
            else{
                addLinkedListRear.next = removeLinkedListRear;
                removeLinkedListRear=removeLinkedListRear.prev;
                addLinkedListRear.next.data = (E) o;
                addLinkedListRear.next.prev = addLinkedListRear;
                addLinkedListRear.next.next = null;
                addLinkedListRear = addLinkedListRear.next;
                size++;
                removeSize--;
            }
        }

    }

    /**
     *
     *  add elements to the front of the list
     *  if removeSize>0 , instead of create new node use node of removeLinkedList
     *
     * @param o is element to be added
     * @return is always true
     */
    @Override
    public boolean offerFirst(Object o) {
      addFirst(o);
      return true;
    }

    /**
     *  add elements to the rear of the list
     *  if removeSize>0 , instead of create new node use node of removeLinkedList
     * @param o is element to be added
     * @return is always true
     */
    @Override
    public boolean offerLast(Object o) {
        addLast(o);
        return true;
    }

    /**
     * remove elements to the front of the list
     * add removed node to removedLinkedList
     * @return information of the deleted element if there is no element to be deleted  throw NoSuchElement
     */
    @Override
    public Object removeFirst() {
        if(removeSize==0){
            removeLinkedListFront=null;
            removeLinkedListRear=null;
        }
        if(addLinkedListFront==null){
            return null;
        }
        else{
            if(removeLinkedListFront==null){
                removeLinkedListFront = addLinkedListFront;
                addLinkedListFront = addLinkedListFront.next;
                addLinkedListFront.prev = null;
                removeLinkedListRear = removeLinkedListFront;
                size--;
                removeSize++;
                return removeLinkedListFront.data;
            }
            else {
                Node<E> temp = addLinkedListFront;
                addLinkedListFront = addLinkedListFront.next;
                if (size != 1) {
                    addLinkedListFront.prev=null;
                }
                removeLinkedListRear.next=temp;
                removeLinkedListRear.next.prev = removeLinkedListRear;
                removeLinkedListRear = removeLinkedListRear.next;
                removeLinkedListRear.next = null;
                size--;
                removeSize++;
                return removeLinkedListRear.data;
            }
        }

    }
    /**
     * remove elements to the rear of the list
     * add removed node to removedLinkedList
     * @return information of the deleted element  if there is no element to be deleted throw NoSuchElement
     */
    @Override
    public Object removeLast() {
        if(removeSize==0){
            removeLinkedListFront=null;
            removeLinkedListRear=null;
        }
        if(size == 0){
            try {
                throw (Throwable) NoSuchElementException;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        }
        else {
            if(removeLinkedListFront == null){
                removeLinkedListFront = addLinkedListRear;
                addLinkedListRear = addLinkedListRear.prev;
                addLinkedListRear.next = null;
                removeLinkedListRear = removeLinkedListFront;
                size--;
                removeSize++;
                return removeLinkedListFront.data;
            }
            else{
                Node<E> temp = addLinkedListRear;
                addLinkedListRear = addLinkedListRear.prev;
                if(size!=1){
                    addLinkedListRear.next = null;
                }

                removeLinkedListRear.next = temp;


                removeLinkedListRear.next.prev = removeLinkedListRear;
                removeLinkedListRear = removeLinkedListRear.next;
                removeLinkedListRear.next = null;
                size--;
                removeSize++;
                return removeLinkedListRear.data;
            }
        }

    }

    /**
     * remove elements to the front of the list
     * add removed node to removedLinkedList
     * @return information of the deleted element if there is no element to be deleted  return null
     */
    @Override
    public Object pollFirst() {
        if(size==0){
            return null;
        }
        else{
            Object res = removeFirst();
            return res;
        }

    }
    /**
     * remove elements to the rear of the list
     * add removed node to removedLinkedList
     * @return information of the deleted element  if there is no element to be deleted return last
     */
    @Override
    public Object pollLast() {
        if(size==0){
            return null;
        }
        else{
            Object res = removeLast();
            return res;
        }

    }

    /**
     *returns the first element
     * @return returns the first element
     */
    @Override
    public Object getFirst() {
        return addLinkedListFront.data;
    }
    /**
     * returns the last element
     * @return returns the last element
     */
    @Override
    public Object getLast() {
        return addLinkedListRear.data;
    }
    /**
     *returns the first element
     * @return returns the first element
     */
    @Override
    public Object peekFirst() {
        return addLinkedListFront.data;
    }
    /**
     * returns the last element
     * @return returns the last element
     */
    @Override
    public Object peekLast() {
        return addLinkedListRear.data;
    }

    /**
     * NOT IMPLEMENTED
     * @param o
     * @return
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    /**
     * NOT IMPLEMENTED
     * @param o
     * @return
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    /**
     *  add elements to the rear of the list
     * if removeSize>0 , instead of create new node use node of removeLinkedList
     * @param o is element to be added
     * @return is always true;
     */
    @Override
    public boolean add(Object o) {
      addLast(o);
      return true;
    }
    /**
     *  add elements to the rear of the list
     * if removeSize>0 , instead of create new node use node of removeLinkedList
     * @param o is element to be added
     * @return is always true;
     */
    @Override
    public boolean offer(Object o) {
      offerLast(o);
      return true;
    }
    /**
     * remove last element
     * @return same removeLast()
     */
    @Override
    public Object remove() {
        return this.removeLast();
    }
    /**
     * remove elements to the front of the list
     * add removed node to removedLinkedList
     * @return information of the deleted element if there is no element to be deleted return null
     */
    @Override
    public Object poll() {
        E item = (E) this.peek();
        if(item == null){
            return null;
        }
        else
        {
            return removeFirst();
        }

    }
    /**
     *returns the first element if there is no element throw NoSuchException
     * @return returns the first element if there is no element throw NoSuchException
     */
    @Override
    public Object element() {
       if(size==0){
           try {
               throw (Throwable) NoSuchElementException;
           } catch (Throwable throwable) {
               throwable.printStackTrace();
           }
           return null;
       }
       else{
           return addLinkedListFront.data;
       }
    }

    /**
     *
     * if there is no element return null else return data of first element of linkedList
     * @return if there is no element return null else return data of first element of linkedList
     */
    @Override
    public Object peek() {
        if(size==0){
            return null;
        }
        else {
            return addLinkedListFront.data;
        }
    }

    /**
     * NOT IMPLEMENTED
     * @param c is collection
     * @return boolean
     */
    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    /**
     * NOT IMPLEMENTED
     */
    @Override
    public void clear() {

    }

    /**
     * NOT IMPLEMENTED
     * @param c is collection
     * @return boolean
     */
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    /**
     * NOT IMPLEMENTED
     * @param c is collection
     * @return boolean
     */
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    /**
     * add elements to the front of the list
     * if removeSize>0 , instead of create new node use node of removeLinkedList
     * @param o is element to be added
     */
    @Override
    public void push(Object o) {
        addFirst(o);
    }
    /**
     * remove elements to the front of the list
     * add removed node to removedLinkedList
     * @return information of the deleted element if there is no element to be deleted  throw NoSuchElement
     */
    @Override
    public Object pop() {
        return removeFirst();
    }

    /**
     * NOT IMPLEMENTED
     * @param o NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * NOT IMPLEMENTED
     * @param c NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     * NOT IMPLEMENTED
     * @param o NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public boolean contains(Object o) {
        return false;
    }

    /**
     * return size of linkedList
     * @return size of linkedList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * if there is element return false otherwise return true
     * @return if there is element return false otherwise return true
     */
    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     * NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * NOT IMPLEMENTED
     * @param a NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * NOT IMPLEMENTED
     * @return NOT IMPLEMENTED
     */
    @Override
    public Iterator descendingIterator() {
        return null;
    }

    /**
     * print the elements side by side from the beginning
     * @return print the elements side by side from the beginning
     */
    @Override
    public String toString() {
        String res = "";

        Node<E> iter = this.addLinkedListFront;

        for(int i = 0 ; i<this.size();i++){
            res = res + iter.data + " ";
            iter = iter.next;

        }

        return res;
    }

    /**
     * print the elements side by side from the beginning for removeLinkedList
     * @return print the elements side by side from the beginning for removeLinkedList
     */
    public String removeToString(){
        String res = "Removed nodes ";
        Node<E> iter = this.removeLinkedListFront;

        for(int i = 0 ; i<this.removeSize;i++){
            res = res + iter.data + " ";
            iter = iter.next;

        }

        return res;
    }
/********************NODE CLASS*******************************************************************/

    /**
     * NODE class has array and array size is 10.
     * it has generic data
     *this class for double linked list( Node<E> next and Node<E> prev)
     * @param <E>
     */
    private static class Node<E> {

        private Node<E> next;
        /**
         * reference prev
         */
        private Node<E> prev;
        /**
         * item for node (generic array)
         */
        private E data;

        /**
         * no paramater constructor
         */
        private Node(){

        }
    }

    /**
     * this class for using iterator
     * however there is no need to use
     * because we add or remove elements to either end or beginning
     * so the loop is avoided
     */
    private class myIterator implements ListIterator<E>{

        /** A reference to the next item. */
        private Node<E> nextItem;

        /**
         * are there any element to next
         * @return if next equals null return false otherwise return true
         */
        @Override
        public boolean hasNext() {
            if(this.nextItem.next!=null){
                return true;
            }
            else{
                return false;
            }

        }

        /**
         * move next element
         * @return next element
         */
        @Override
        public E next() {
            return (E) this.nextItem.next;
        }
        /**
         * are there any element to previous
         * @return if previous equals null return false otherwise return true
         */
        @Override
        public boolean hasPrevious() {
            if(this.nextItem.prev!=null){
                return true;
            }
            else{
                return false;
            }

        }

        /**
         * move previous element
         * @return previous  element
         */
        @Override
        public E previous() {
            return (E) this.nextItem.prev;
        }

        /**
         * not implement
         * @return
         */
        @Override
        public int nextIndex() {

            return 0;
        }

        /**
         * not implement
         * @return
         */
        @Override
        public int previousIndex() {
            return 0;
        }

        /**
         * remove last element
         */
        @Override
        public void remove() {
            Node<E> temp ;
                while(this.hasNext()){
                    this.next();
                }
                temp= (Node<E>) this.previous();
                temp.next = temp.next.next;
        }

        /**
         * update element in parameter
         * @param e is element in linkedList
         */
        @Override
        public void set(E e) {
            this.nextItem.data = e;

        }

        /**
         * add element in last node
         * @param e is adding element
         */
        @Override
        public void add(E e) {
            while(this.hasNext()){
                this.next();
            }
            this.nextItem.next=new Node<>();
            this.nextItem.next.next=null;
            this.nextItem.next.data = e;
        }
    }

}
