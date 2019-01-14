/**
 * Queue Abstract Data Type. A queue is a linear data structure that follows
 * first-in first-out protocol, i.e. the first element added to the Queue is 
 * the first element to be removed
 * 
 * @author Arik Barenboim 300024372
 * @author Jeremy Soong 300016044
 */
public interface Queue<E> {
  
  /**
   * Tests if the queue is empty
   * 
   * @return true if queue is empty, false otherwise
   */
  public boolean isEmpty();
    
   /**
    * Puts an element at the rear of the queue
    * 
    * @param o
    *        the element to be put at the rear of the queue
    */ 
   public void enqueue( E o );
    
   /**
    * Removes and returns the element at the front of the queue
    * 
    * @return front element of queue
    */
   public E dequeue();
}