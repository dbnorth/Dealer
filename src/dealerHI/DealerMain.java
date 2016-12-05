package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dealerPD.Dealer;

public class DealerMain extends JPanel {

  /**
   * Create the panel.
   */
  public DealerMain(Dealer dealer) {
    setLayout(null);
    
    JLabel lblNewLabel = new JLabel(dealer.getName());
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(115, 78, 211, 16);
    add(lblNewLabel);
    
    JLabel lblCarsForSale = new JLabel("Cars for Sale : " +dealer.getCarForSaleCount());
    lblCarsForSale.setBounds(165, 119, 125, 16);
    add(lblCarsForSale);

  }
}
