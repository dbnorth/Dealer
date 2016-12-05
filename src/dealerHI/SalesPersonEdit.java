package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dealerPD.Dealer;
import dealerPD.SalesPerson;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesPersonEdit extends JPanel {
  private JTextField textField;
  private JTextField textField_1;

  /**
   * Create the panel.
   */
  public SalesPersonEdit(JFrame currentFrame, Dealer dealer, SalesPerson salesPerson, boolean isAdd) {
    setLayout(null);
    
    JLabel lblSalesPersonEdit = new JLabel("Sales Person Edit");
    lblSalesPersonEdit.setBounds(157, 32, 126, 16);
    add(lblSalesPersonEdit);
    
    JLabel lblName = new JLabel("Name :");
    lblName.setBounds(50, 86, 76, 16);
    add(lblName);
    
    textField = new JTextField(salesPerson.getName());
    textField.setBounds(131, 81, 130, 26);
    add(textField);
    textField.setColumns(10);
    
    JLabel lblPosition = new JLabel("Position : ");
    lblPosition.setBounds(50, 136, 76, 16);
    add(lblPosition);
    
    textField_1 = new JTextField(salesPerson.getPosition());
    textField_1.setBounds(131, 131, 130, 26);
    add(textField_1);
    textField_1.setColumns(10);
    
    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        salesPerson.setName(textField.getText());
        salesPerson.setPosition(textField_1.getText());
        if (isAdd) dealer.addSalesPerson(salesPerson);
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new SalesPersonSelection(currentFrame,dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnSave.setBounds(89, 219, 117, 29);
    add(btnSave);
    
    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new SalesPersonSelection(currentFrame,dealer));
        currentFrame.getContentPane().revalidate();
 
      }
    });
    btnCancel.setBounds(236, 219, 117, 29);
    add(btnCancel);

  }

}
