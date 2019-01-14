
/**
* The class <b>Cube<b> is used to represent a cube from the puzzle Instant Insanity.
* This class stores the state of the cube and controls its orientation. This class 
* also tracks the number of orientations that the cube has undergone, as well as 
* Getters for each face of the cube.
*
* @author Arik Barenboim 300024372
* @author Jeremy Soong 300016044
*/

public class Cube{
  
  private Color[] faces;
  private final Color[] IDENTITY;
  private int nbreOfRotations;
  

  /**
  * Constructor used to initialize a cube
  *
  * @param faces
  *            array containing the colors on each face of the cube
  *
  */
  public Cube(Color[] faces){
    this.faces = faces;
    if(faces.length>6){
        throw new ArrayIndexOutOfBoundsException("Array Index Out Of Bounds");
    }
    this.IDENTITY = new Color[]{faces[0],faces[1],faces[2],faces[3],faces[4],faces[5]};
    this.nbreOfRotations = 0;
  }
  
  /**
  * Constructor used to deep copy a cube
  *
  * @param other
  *           an instance of cube
  *
  */
  public Cube(Cube other){
    this(other.copy().faces);
  }
  
  /**
  * Getter method for color of cube face
  *
  * @param pos
  *           desired face of cube
  *
  * @return color of cube face 
  */
  public Color getColor(int pos){
    return faces[pos];
  }
  
  /**
  * Getter method for top face of cube
  *
  * @return color of top face of cube
  */
  public Color getUp(){
    return faces[0];
  }
  
  /**
  * Getter method for front face
  *
  * @return color of front face
  */
  public Color getFront(){
    return faces[1];
  }
  
  /**
  * Getter method for right face
  *
  * @return color of right face
  */
  public Color getRight(){
    return faces[2];
  }
  
  /**
  * Getter method for back face
  *
  * @return color of back face 
  */
  public Color getBack(){
    return faces[3];
  }
  
  /**
  * Getter method for left face
  *
  * @return color of left face
  */
  public Color getLeft(){
    return faces[4];
  }
  
  /**
  * Getter method for bottom face
  *
  * @return color of bottom face
  */
  public Color getDown(){
    return faces[5];
  }
  
  /**
  * Builds a string representation of the cube 
  *
  * @return string representation of the cube
  */ 
  public String toString(){
    return ("["+ faces[0]+", "+ faces[1]+", "+ faces[2]+", "+ faces[3]+", "+ faces[4]+", "+ faces[5] +"]");
  }
  
  /**
  * Returns a deep copy of the cube
  *
  * @return deep copy of the cube 
  */
  public Cube copy(){
    Color[] nfaces = new Color[faces.length];
    for (int i =0; i < faces.length; i++){
      nfaces[i] = faces[i];
    }
    Cube copy = new Cube(nfaces);
    return copy;
  }
  
  /**
  * Returns true if a call to the method <b>next<b> would succeed.
  *
  * @return true if call to the method <b>next<b> would succeed,false otherwise
  */
  public boolean hasNext(){
    return nbreOfRotations < 24 && nbreOfRotations > -1;
  }
  
  /**
  * Returns all faces back to their original colors
  *
  * @return all faces back to their original state (colors)
  */
  public Color[] identity(){
    return IDENTITY;
  }
  
  /**
  * The method <b>rotate<b> rotates the cube to the right around the 
  * top-bottom axis so that the left side is now facing the front.
  */
  public void rotate(){
    Color temp;
    
    temp = faces[4];
    
    faces [4] = faces [3];
    faces [3] = faces [2];
    faces [2] = faces [1];
    faces [1] = temp;
    
  }
  
  /**
  * The method <b>rightRoll<b> rolls the cube to the right around the 
  * back-front axis so that the left side is now up.
  */
  public void rightRoll(){
    Color temp;
    
    temp = faces[5];
    
    faces [5] = faces [2];
    faces [2] = faces [0];
    faces [0] = faces [4];
    faces [4] = temp;
    
  }
  
  /**
  * The method <b>leftRoll<b> rolls the cube to the left around the back-front axis 
  * so that the right side is now up.
  */
  public void leftRoll(){
    Color temp;
    
    temp = faces[5];
    
    faces [5] = faces [4];
    faces [4] = faces [0];
    faces [0] = faces [2];
    faces [2] = temp;
    
  }
  
  /**
  * The method <b>next<b> changes the orientation of the cube with respect to 
  * the list of operations. It throws an exception IllegalStateException
  * if the call to next sets the orientation to one that has already been seen
  * since the last call to reset. 
  */
  public void next(){
    switch (nbreOfRotations){
      case 0: identity(); break;
      case 1: rotate(); break;
      case 2: rotate(); break;
      case 3: rotate(); break;
      case 4: rightRoll(); break;
      case 5: rotate(); break;
      case 6: rotate(); break;
      case 7: rotate(); break;
      case 8: rightRoll(); break;
      case 9: rotate(); break;
      case 10: rotate(); break; 
      case 11: rotate(); break;
      case 12: leftRoll(); break;
      case 13: rotate(); break;
      case 14: rotate(); break;
      case 15: rotate(); break;
      case 16: leftRoll(); break;
      case 17: rotate(); break;
      case 18: rotate(); break;
      case 19: rotate(); break;
      case 20: rightRoll(); break;
      case 21: rotate(); break;
      case 22: rotate(); break;
      case 23: rotate(); break;
      default:
        throw new IllegalStateException("Orientation already seen. Please reset!");
    }
    nbreOfRotations++;
  }
  
  /**
  * The method <b>reset<b> puts the cube back in its original orientation.
  */
  public void reset(){
    for (int i = 0; i < IDENTITY.length; i++){
      faces[i] = IDENTITY[i];
    }
    nbreOfRotations = 0;
  }

}