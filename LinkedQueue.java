
/**The LinkedQueue class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports adding and removing
 *  operations, along with methods for testing if the queue is empty, 
 *  and iterating through the items in FIFO order.
 *  This class contains a static nested class for linked elements.
 */
public class LinkedQueue<E> implements Queue<E> {
    
    //Helper static linked list class
    private static class Elem<T> {

        private T value;
        private Elem<T> next;

        private Elem( T value, Elem<T> next ) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    /**
     * Returns the element at the front of the queue
     * 
     * @return element at front of queue
     */
    public E peek() {
        return front.value;
    }
   
    /**
     * Adds element to rear of queue
     * 
     * @param o
     *        element to be added to queue
     * 
     */
    public void enqueue( E o ) {
        Elem<E> newElem;
        newElem = new Elem<E>( o, null );

        if ( rear == null ) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }
    
    /**
    * Removes and returns the element at the front of the queue
    * 
    * @return front element of queue
    */
    public E dequeue() {
        E result = front.value;
        if ( front != null & front.next == null ) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return result;
    }

   /**
   * Tests if the queue is empty
   * 
   * @return true if queue is empty, false otherwise
   */
    public boolean isEmpty() {
        return front == null;
    }

}