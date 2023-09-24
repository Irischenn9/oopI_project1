import java.util.ArrayList;

public class A1083359_Project1_Gemstone
{
    // The original value (gems) of this gemstone card.
    private final int value;
    // The current value (gems) remains on the card.
    private int remainValue;
    
    public A1083359_Project1_Gemstone(int value)
    {
        this.value = value;
        this.remainValue = value;
    }

    public int getValue()
    {
        return value;
    }

    public int getRemainValue()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 2-1: Get the variable $remainValue via this accessor method.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        return remainValue;

        /************* END OF YOUR CODE *************/
    }

    public void resetValue()
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 2-2: Reset the current value of this card to its original value.
         ************************************* End of TODO *************************************/

        /************ START OF YOUR CODE ************/
        remainValue=value;

        /************* END OF YOUR CODE *************/
    }

    public String name()
    {
        return "Gemstone";
    }

    public void share(ArrayList<A1083359_Project1_Agent> receivers)
    {
        /********************************* TODO (Checkpoint 1) *********************************
         * TODO 2-3: Evenly share the gems that they find with all receivers, then the leftover remains.
         * Hint 1: If this gemstone card contains 17 gems and there are 3 receivers,
         *         each receiver will obtain 5 gems and the rest of 2 gems will remain on the card.
         * Hint 2: You can use addCollectedGems() method of Agent object to let the receivers get their gems.
         ************************************* END OF TODO *************************************/

        /************ START OF YOUR CODE ************/
        
    	
    	for(A1083359_Project1_Agent receiver:receivers) {
    		receiver.addCollectedGems(remainValue/receivers.size());
            
    	}
   
    	remainValue=remainValue%receivers.size();


        /************* END OF YOUR CODE *************/
    }

    @Override
    public String toString()
    {
        return String.format("<%d/%d>", this.remainValue, this.value);
    }
}
