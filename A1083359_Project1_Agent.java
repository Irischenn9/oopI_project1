public class A1083359_Project1_Agent
{
    // Number of this explorer.
    private final int number;
    // This explorer's status of exploration, which determines whether they stay in the tomb or not.
    private boolean inExploring;
    // The gems that this explorer has collected during a round.
    private int collectedGems;
    // The gems which were stored safely in this explorer's tent.
    private int gemsInsideTent;
    
    public A1083359_Project1_Agent(int number)
    {
        this.number = number;
        this.inExploring = false;
        this.collectedGems = 0;
        this.gemsInsideTent = 0;
    }

    public int getNumber()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-1: Get the variable $number via this accessor method.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        return number;


        /************* END OF YOUR CODE *************/
    }

    public boolean isInExploring()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-2: Get the variable $inExploring via this accessor method.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        if (inExploring==true) {
    		return true;
    	}else {
    		return false;
    	}


        /************* END OF YOUR CODE *************/
    }

    public void setInExploring(boolean inExploring)
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-3: Set the variable $inExploring via this mutator method.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        this.inExploring=inExploring;
    


        /************* END OF YOUR CODE *************/
    }

    public int getCollectedGems()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-4: Get the variable $collectedGems via this accessor method.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        return collectedGems;


        /************* END OF YOUR CODE *************/
    }

    public int getGemsInsideTent()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-5: Get the variable $gemsInsideTent via this accessor method.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/

        return gemsInsideTent;

        /************* END OF YOUR CODE *************/
    }

    public void addCollectedGems(int additionalGems)
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-6: Add in additional value of gems to this explorer's collection.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        collectedGems+=additionalGems;
  
    	

        /************* END OF YOUR CODE *************/
    }

    public void storeGemsIntoTent()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 1-7: Make this explorer's holdings store into their tent.
         * Hint 1: Add in the tent with their collected gems, and remember to reset it to zero.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        gemsInsideTent+=collectedGems;
    	collectedGems=0;
   
    	

        /************* END OF YOUR CODE *************/
    }
    
    @Override
    public String toString()
    {
        return "Explorer " + this.number;
    }

    public void act(A1083359_Project1_Environment environment)
    {
        if (this.inExploring)
        {
            double choice = Math.random();
            this.inExploring = (choice < environment.getDefaultDecisionProbability());
        }
    }
}
