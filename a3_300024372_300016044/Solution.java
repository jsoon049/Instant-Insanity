
/**
 * The class <b>Solution<b> is a container to store cubes.
 * It represents a partial solution to the instant insanity problem.
 * @author Arik Barenboim 300024372
 * @author Jeremy Soong 300016044
 */
public class Solution{
  
  private Cube[] cubes;
  private int numberOfCalls;
  
  /**
   * Constructor used to initialize a solution using cubes from the array Cubes.
   * 
   * @param cubes
   *            array containing cubes
   */
  public Solution(Cube[] cubes){
  	if (cubes.length > 4 && cubes.length < 0){
  		throw new ArrayIndexOutOfBoundsException("the length of cube can on be an element of [1,2,3,4]");
  	}
    this.cubes = new Cube[cubes.length];
    for (int i = 0 ; i < cubes.length; i ++){
      this.cubes[i] = new Cube(cubes[i]);
    }
    numberOfCalls = 0;
  }
  
  /**
   * Constructor used to initialize a solution containing the same elements as the solution 
   * in the parameter other
   * 
   * @param other
   *            a partial solution
   * 
   * @ param c
   *            a cube
   */
  public Solution(Solution other, Cube c){
  	if (c == null){
  		throw new NullPointerException("Cube c cannot be null");
  	}
    Cube[] newCubes = new Cube[other.cubes.length + 1];
    int i;
    for (i = 0; i<other.cubes.length;i++){
      newCubes[i] = new Cube(other.cubes[i]);
    }
    newCubes[i] = new Cube(c);
    cubes = newCubes;
    numberOfCalls = 0;
  }
  
  /**
   * Returns number of cubes in solution
   * 
   * @return number of cubes in solution
   */
  public int size(){
    return this.cubes.length;
  }
  
  /**
   * Returns reference of Cube at specified position
   * 
   * @param pos
   *            Specified position
   * @return cube at position pos
   */
  public Cube getCube(int pos){
    return this.cubes[pos];
  }
  
  /**
   * Returns true if sides of stack of cubes contain no duplicates
   * 
   * @return true if sides of stack of cubes contain no duplicates, false otherwise
   */
  public boolean isValid(){
    numberOfCalls++;
    Color[] temp = new Color[this.cubes.length];
    boolean status = true;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < this.cubes.length; j++){
        temp[j] = cubes[j].getColor(i + 1);
      }
      for (int j = 0; j < this.cubes.length; j++){
        for (int k = j+1; k < this.cubes.length;k++){
          if (temp[j] == temp[k]){
            status = false;
            break;
          }
        }
        if (!(status))
          break;
      }
      if (!(status))
        break;
    }
    return status;
  }
  
  /**
   * Returns true if solution remains true after adding cube
   * 
   * @param next
   *            Cube to be added to solution
   * 
   * @return true if solution remains true after adding parameter next, false otherwise
   */
  public boolean isValid(Cube next){
    numberOfCalls++;
    Color[] temp = new Color[this.cubes.length+1];
    boolean status = true;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < this.cubes.length; j++){
        temp[j] = cubes[j].getColor(i + 1);
      }
      temp[this.cubes.length] = next.getColor(i+1);
      for (int j = 0; j < this.cubes.length + 1; j++){
        for (int k = j + 1; k < this.cubes.length + 1;k++){
          if (temp[j] == temp[k]){
            status = false;
            break;
          }
        }
        if (!(status))
          break;
      }
      if (!(status))
        break;
    }
    return status;
  }
  
  /**
   * Return total number of calls to method <b>isValid<b> since the last call to method <b>resetNumberOfCalls<b>
   * 
   * @return total number of calls to method <b>isValid<b>
   */
  public int getNumberOfCalls(){
    return numberOfCalls;
  }
  
  /**
   * Initialize the statistic and reset it to zero
   */
  public void resetNumberOfCalls(){
    numberOfCalls=0;
  }
  
  /**
   * Builds string representation of the solution
   * 
   * @return string representation of solution
   */
  public String toString(){
    String rep = "";
    for ( int i = 0; i < this.cubes.length;i++){
      rep += cubes[i] + "\n";
    }
    return rep;
  }
  
}