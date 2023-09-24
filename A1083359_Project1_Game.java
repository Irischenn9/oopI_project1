import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



	public class A1083359_Project1_Game
	{
	    // The randomizer which is used for shuffling the deck.
	    private static final Random RANDOM = new Random(System.currentTimeMillis());
	    // The game consists of 5 rounds of exploration.
	    private static final int ROUND = 5;

	    // All explorers participate in the game.
	    private final ArrayList<A1083359_Project1_Agent> explorers = new ArrayList<>();
	    // The deck of cards to be used for the game.
	    private final ArrayList<A1083359_Project1_Gemstone> deck = new ArrayList<>();
	    // A tomb-like path for exploration.
	    private final ArrayList<A1083359_Project1_Gemstone> path = new ArrayList<>();




	    public A1083359_Project1_Game()
	    {
	        this.explorers.add(new A1083359_Project1_Agent(0));
	        this.explorers.add(new A1083359_Project1_Agent(1));
	        this.explorers.add(new A1083359_Project1_Agent(2));
	        this.explorers.add(new A1083359_Project1_Agent(3));
	        this.explorers.add(new A1083359_Project1_Agent(4));
	        this.explorers.add(new A1083359_Project1_Agent(5));
	        
	        this.setUpCards();
	    }
	    
	    public void runGame()
	    {
	        for (int round = 0; round < ROUND; round++)
	        {
	            /********************************* TODO (Checkpoint 1) *********************************
	             * TODO 4-1: First, the game data should be initialized at the beginning of each round.
	             * Hint 1: All explorers' status should be switched to true.
	             * Hint 2: Clear all cards on the path and shuffle them back in the deck.
	             * Hint 3: Reset the value of all gemstone cards.
	             * Hint 4: Make sure you use shuffleDeck() method to shuffle the deck.
	             * Hint 5: You need to print "ROUND X START!" which X represents for the round number (1~5).
	             * Notice 1: In this section, you can use doNothing() method as you like to set timeout between any message you would print,
	             *           but the format of your output must identically be the same as what the document shows.
	             ************************************* End of TODO *************************************/

	            /************ START OF YOUR CODE ************/
	 	
	            for(A1083359_Project1_Agent explorer:this.explorers) {
	                explorer.setInExploring(true);
	            } 		
 
				for(int j=0;j<path.size();j++){	
					deck.add(path.get(j));
				}
				path.clear();

               for(A1083359_Project1_Gemstone card:deck){
                   card.resetValue();
                }	           
	            shuffleDeck();

	            System.out.printf("ROUND %d START!%n", round+1); 
				doNothing(100); 

	            /************* END OF YOUR CODE *************/

	            while (this.isAnyoneStay() && this.path.size() < 10)
	            {
	                /********************************* TODO (Checkpoint 1) *********************************
	                 * TODO 4-2: During a round, all explorers explore the path in the ancient tomb and hunt for abundant treasures.
	                 * Hint 1: To move forward in our exploration, you need to draw a card from the top of the deck and put it on the end of the path.
	                 *         Use share() method of Gemstone object so that the value of the card can be shared by all explorers who stay.
	                 * Hint 2: Print out the information of the path.
	                 * Hint 3: Print out the information of all explorers in sequence. If the explorer stays in the tomb, print "Explorer X has Y gem(s).",
	                 *         otherwise, print "Explorer X left." which X and Y represent for their number and the quantity of collected gems.
	                 * Hint 4: After "----- STAY or LEAVE -----" is printed, all explorers who stay have to make their decision about staying or leaving.
	                 *         For this purpose, you can use act() method of Agent object.
	                 * Hint 5: Print "Everyone keeps exploring." if there is no explorer choose to leave,
	                 *         else print "Explorer X wants to leave." for each explorer who chose to leave, which X represents for their number.
	                 * Hint 6: For those who chose to leave the tomb, should share the value of all the cards on the path while each one works independently.
	                 *         If the path is [<3/11>, <1/9>, <5/13>], for instance, there are 3 explorers who chose to leave,
	                 *         then the path will become [<0/11>, <1/9>, <2/13>] after they leave.
	                 * Notice 1: In this checkpoint, we'll only implement the mechanism of gemstone, i.e., artifact and hazard are not considered now.
	                 * Notice 2: In this checkpoint, a round will end when either everyone leaves the tomb or the length of the path reaches 10.
	                 *           Note that when the 10th card shows, the game will still ask about staying or leaving, no special handling required.
	                 * Notice 3: The act() method of Agent requires an Environment object as its parameter, which indicates that agent can act upon the environment.
	                 *           Note that the variable $environment was already declared for you, all you need to do is pass it into the act() method.
	                 *           All explorers should act upon the same environment, so do not declare another Environment object or it may cause some error.
	                 * Notice 4: In this section, you can use doNothing() method as you like to set timeout between any message you would print,
	                 *           but the format of your output must identically be the same as what the document shows.
	                 ************************************* End of TODO *************************************/

	                /************ START OF YOUR CODE ************/
	            	for(int i=0;i<10;i++){
	                    if(isAnyoneStay()==false){
	                        break;
	                    }

						path.add(deck.remove(deck.size()-1));
						
	                    path.get(i).share(getStayExplorers());
                        System.out.println();
	                    System.out.print(path);
	                    System.out.println();
						doNothing(100); 
					
	                

	                for(A1083359_Project1_Agent getGem:this.explorers) {
						if(getGem.isInExploring()==true) {
							System.out.printf(getGem+" has "+getGem.getCollectedGems()+" gem(s).%n");
						}else {
							System.out.printf(getGem+" left.%n");
							
							
						}
	                } 
					doNothing(100); 
	                
	            
	                /************* END OF YOUR CODE *************/

	                System.out.println("----- STAY or LEAVE -----");

					A1083359_Project1_Environment environment = this.createEnvironment();

	                /************ START OF YOUR CODE ************/
	                ArrayList<A1083359_Project1_Agent> leave = new ArrayList<>();
	                int count=0;
	                int leavenum=0;
	            
	                for(A1083359_Project1_Agent action:getStayExplorers()) {
	                    leavenum++;
	                	action.act(environment);
	                    if (action.isInExploring()==false) {
	                        leave.add(action);
	                        System.out.printf(action+" wants to leave.%n");    
                               
	                    }else{
	                        count++;
	                     }
	                    doNothing(300);
	                }
                
	                if(count==leavenum) {
	                    System.out.println("Everyone keeps exploring.");
                       
	                    doNothing(300);
	                   

	                }else{
	                    for(A1083359_Project1_Gemstone gems:path) {
	                            gems.share(leave);          
	                        }
	                    }
					}
	               System.out.println(); 
	                /************* END OF YOUR CODE *************/
	            }

	            /********************************* TODO (Checkpoint 1) *********************************
	             * TODO 4-3: At the end of a round, all explorers finish their exploration and return to the camp with treasure.
	             * Hint 1: First, print "ROUND X END!" which X represents for the round number (1~5).
	             * Hint 2: To make all explorers store gems they've collected during this round into their tent,
	             *         you can use storeGemsIntoTent() method of Agent object.
	             * Notice 1: In this section, you can use doNothing() method as you like to set timeout between any message you would print,
	             *           but the format of your output must identically be the same as what the document shows.
	             ************************************* End of TODO *************************************/

	            /************ START OF YOUR CODE ************/
	           System.out.printf("ROUND %d END!%n",round+1);
               System.out.println();
	           	
	            for(A1083359_Project1_Agent stone:this.explorers) {
	            	stone.storeGemsIntoTent();	
	        	}  		
	        	
	            /************* END OF YOUR CODE *************/
	        }
            
	        System.out.println("GAME OVER!");
	        System.out.println();
	        System.out.println("----- Final result -----");

	        for (A1083359_Project1_Agent explorer : this.explorers)
	            System.out.println(explorer + ": " + explorer.getGemsInsideTent());
	    
	    }

	    private void setUpCards()
	    {
	        this.deck.add(new A1083359_Project1_Gemstone(1));
	        this.deck.add(new A1083359_Project1_Gemstone(2));
	        this.deck.add(new A1083359_Project1_Gemstone(3));
	        this.deck.add(new A1083359_Project1_Gemstone(4));
	        this.deck.add(new A1083359_Project1_Gemstone(5));
	        this.deck.add(new A1083359_Project1_Gemstone(5));
	        this.deck.add(new A1083359_Project1_Gemstone(7));
	        this.deck.add(new A1083359_Project1_Gemstone(7));
	        this.deck.add(new A1083359_Project1_Gemstone(9));
	        this.deck.add(new A1083359_Project1_Gemstone(11));
	        this.deck.add(new A1083359_Project1_Gemstone(11));
	        this.deck.add(new A1083359_Project1_Gemstone(13));
	        this.deck.add(new A1083359_Project1_Gemstone(14));
	        this.deck.add(new A1083359_Project1_Gemstone(15));
	        this.deck.add(new A1083359_Project1_Gemstone(17));
	    }

	    private void shuffleDeck()
	    {
	        Collections.shuffle(this.deck, RANDOM);
	    }

	    private ArrayList<A1083359_Project1_Agent> getStayExplorers()
	    {
	        /********************************* TODO (Checkpoint 1) *********************************
	         * TODO 3-1: Get all explorers who stay in the tomb.
	         * Hint 1: You can check each explorer's status.
	         ************************************* End of TODO *************************************/

	        /************ START OF YOUR CODE ************/

	        ArrayList<A1083359_Project1_Agent> check = new ArrayList<A1083359_Project1_Agent>();
	    	
	    	for(A1083359_Project1_Agent getStay:this.explorers) {    		
	    		if (getStay.isInExploring()==true) {
	    			check.add(getStay); 
	    		}
	    	}return check;
	    	
	        /************* END OF YOUR CODE *************/
	    }

	    private boolean isAnyoneStay()
	    {
	        /********************************* TODO (Checkpoint 1) *********************************
	         * TODO 3-2: Check if there is anyone who stays in the tomb.
	         * Hint 1: Return true if at least one explorer is in exploring.
	         ************************************* End of TODO *************************************/

	        /************ START OF YOUR CODE *************/
	    	  		
	    		if (getStayExplorers().size()==0) {
	    			return false; 			
	    		} else{
	               return true; 
	            }		
	    	
	        /************* END OF YOUR CODE *************/
	    }

	    private A1083359_Project1_Environment createEnvironment()
	    {
	        A1083359_Project1_Environment environment = new A1083359_Project1_Environment();

	        environment.setDefaultDecisionProbability(0.65);

	        return environment;
	    }

	    private static void doNothing(long millisecond)
	    {
	        if (millisecond > 2000)
	            throw new IllegalArgumentException("timeout value is over 2000");

	        try
	        {
	            Thread.sleep(millisecond);
	        }
	        catch (InterruptedException e)
	        {
	            throw new IllegalStateException("unexpected interruption");
	        }
	    }
	}



