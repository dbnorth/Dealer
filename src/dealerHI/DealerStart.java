package dealerHI;

import dealerPD.Dealer;
import dealerTest.Test;
import dealerTest.TestDBN;

public class DealerStart {

  public static void main(String[] args) {
    
    Dealer dealer = new Dealer("David's Car Lot","123 1st Street", "Edmond", "OK", "73013");
    Test test = new TestDBN();
    test.printTest(dealer);
    DealerFrame.open(dealer);

  }

}
