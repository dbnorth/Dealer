package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dealerPD.Dealer;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DealerEdit extends JPanel {
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;

  /**
   * Create the panel.
   */
  public DealerEdit(JFrame currentFrame, Dealer dealer) {
    setLayout(null);
    
    JLabel lblDealerEdit = new JLabel("Dealer Edit");
    lblDealerEdit.setBounds(164, 28, 98, 16);
    add(lblDealerEdit);
    
    JLabel lblName = new JLabel("Name :");
    lblName.setBounds(43, 71, 61, 16);
    add(lblName);
    
    textField = new JTextField(dealer.getName());
    textField.setBounds(152, 66, 130, 26);
    add(textField);
    textField.setColumns(10);
    
    JLabel lblAddress = new JLabel("Address :");
    lblAddress.setBounds(43, 109, 61, 16);
    add(lblAddress);
    
    textField_1 = new JTextField(dealer.getAddress());
    textField_1.setBounds(152, 104, 130, 26);
    add(textField_1);
    textField_1.setColumns(10);
    
    JLabel lblCityStateZip = new JLabel("City, State, Zip :");
    lblCityStateZip.setBounds(43, 158, 111, 16);
    add(lblCityStateZip);
    
    textField_2 = new JTextField(dealer.getCity());
    textField_2.setBounds(152, 153, 130, 26);
    add(textField_2);
    textField_2.setColumns(10);
    
    textField_3 = new JTextField(dealer.getState());
    textField_3.setBounds(293, 153, 40, 26);
    add(textField_3);
    textField_3.setColumns(10);
    
    textField_4 = new JTextField(dealer.getZip());
    textField_4.setBounds(345, 153, 80, 26);
    add(textField_4);
    textField_4.setColumns(10);
    
    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dealer.setName(textField.getText());
        dealer.setAddress(textField_1.getText());
        dealer.setCity(textField_2.getText());
        dealer.setState(textField_3.getText());
        dealer.setZip(textField_4.getText());
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new DealerMain(dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnSave.setBounds(99, 215, 117, 29);
    add(btnSave);
    
    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new DealerMain(dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnCancel.setBounds(241, 215, 117, 29);
    add(btnCancel);

  }
}
