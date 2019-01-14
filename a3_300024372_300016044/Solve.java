
/**
 * The class <b>Solve<b> solves the instant insanity problem using 4 cubes.
 * The class contains two methods to solve the puzzle as well as a main
 * method to run the program.
 * 
 * @author Arik Barenboim 300024372
 * @author Jeremy Soong 300016044
 */
public class Solve{
  Cube c1 = new Cube(new Color[]{Color.BLUE,Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
  Cube c2 = new Cube(new Color[]{Color.WHITE,Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
  Cube c3 = new Cube(new Color[]{Color.GREEN,Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});
  Cube c4 = new Cube(new Color[]{Color.BLUE,Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
  
  /**
   * Finds all the solutions to the instant insanity problem by iterating
   * through all possible solutions. Returns a queue containing only the valid solutions to the puzzle.
   * 
   * @return a queue containing only the valid solutions 
   */
  public Queue generateAndTest(){
    Queue<Solution>queue=new LinkedQueue<Solution>();
    Solution sol = new Solution(new Cube[]{c1,c2,c3,c4});
    sol.resetNumberOfCalls();
    for (int i = 0; i < 24; i ++){
      if(!sol.getCube(0).hasNext()){
        sol.getCube(0).reset();
      }
      sol.getCube(0).next();
      for (int j = 0; j < 24; j ++){
        if(!sol.getCube(1).hasNext()){
          sol.getCube(1).reset();
        }
        sol.getCube(1).next();
        for (int k = 0; k < 24; k ++){
          if(!sol.getCube(2).hasNext()){
            sol.getCube(2).reset();
          } 
          sol.getCube(2).next();    
          for (int l = 0; l < 24; l ++){
            if(!sol.getCube(3).hasNext()){
              sol.getCube(3).reset();
            }
            sol.getCube(3).next(); 
            if (sol.isValid()){
              queue.enqueue(sol);
            }
          }
        }
      }
    }
    return queue;
  }
  
  /**
   * Finds all the solutions to the instant insanity problem by using the "breadth first search"
   * algorithm seen in class. Returns a queue containing all the valid solutions to the problem.
   * 
   * @return queue containing all valid solutions to the problem
   */
 public Queue<Solution> breadthFirstSearch (){
      Queue<Solution>open=new LinkedQueue<Solution>();
      Queue<Solution>solutions=new LinkedQueue<Solution>();
      Solution current = new Solution(new Cube[]{c1});
      Solution all = new Solution(new Cube[]{c1,c2,c3,c4});
      current.resetNumberOfCalls();
      for (int i = 0; i < 24; i ++){
        if(!current.getCube(0).hasNext()){
              current.getCube(0).reset();
          }
          current.getCube(0).next();
        open.enqueue(new Solution(new Cube[]{current.getCube(0)}));
      }
      while (!open.isEmpty()){
        current = open.dequeue();
        for (int i = 0; i < 24; i ++){
          if(!all.getCube(current.size()).hasNext()){
                all.getCube(current.size()).reset();
            }
            all.getCube(current.size()).next();
            if (current.isValid(all.getCube(current.size()))){
              if (current.size() == 3){
                solutions.enqueue(new Solution(current,all.getCube(current.size())));
                break;
              }
              else{
                open.enqueue(new Solution(current,all.getCube(current.size())));
              }
            }
        }

      }
      return solutions;
    }
  
  /**
   * <b>main<b> of the application. Creates an instance of solve 
   * and prints the time it takes for <b>generateAndTest<b> and 
   * <b>breadthFirstSearch<b> to solve the instant insanity problem.
   */
 public static void main(String[] args) {
    StudentInfo i = new StudentInfo();

    i.display();

    Solve a = new Solve();

    long start, stop;

    System.out.println("generateAndTest:");
    start = System.nanoTime();

    a.generateAndTest();

    stop = System.nanoTime();
    System.out.println("Elapsed time: " + (stop - start) + " nanoseconds");

    System.out.println("breadthFirstSearch:");

    start = System.nanoTime();

    a.breadthFirstSearch();

    stop = System.nanoTime();
    System.out.println("Elapsed time: " + (stop - start) + " nanoseconds");


  } 
  
}