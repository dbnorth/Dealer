package dealerHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dealerPD.Car;
import dealerPD.Dealer;
import dealerPD.SalesPerson;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesPersonSelection extends JPanel {

  DefaultListModel<SalesPerson> listModel;
  JList<SalesPerson> list;
  JButton btnEdit;
  JButton btnAdd;
  JButton btnDelete;
  
  /**
   * Create the panel.
   */
  public SalesPersonSelection(JFrame currentFrame, Dealer dealer) {
    setLayout(null);
    
    JLabel lblSalespersonSelection = new JLabel("Sales Person Selection");
    lblSalespersonSelection.setBounds(152, 32, 145, 16);
    add(lblSalespersonSelection);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(124, 73, 202, 112);
    add(scrollPane);
    
    listModel = new DefaultListModel<SalesPerson>();
    for (SalesPerson salesPerson : dealer.getSalesPersons()) {
      listModel.addElement(salesPerson);
    }
    
    list = new JList<SalesPerson>(listModel);
    scrollPane.setViewportView(list);
    list.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        //if car is selected, edit button is enabled
        if (list.getSelectedValue() != null) 
        {
          btnEdit.setEnabled(true);
        }
        //doesn't let deletion of car that is being used.
        if (list.getSelectedValue() == null || !(list.getSelectedValue()).isOkToRemove())
        {
          btnDelete.setEnabled(false);
        }
        else
        {
          btnDelete.setEnabled(true);
        }
          
      }
    });
    btnAdd = new JButton("Add");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new SalesPersonEdit(currentFrame,dealer, new SalesPerson(),true));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnAdd.setBounds(69, 225, 117, 29);
    add(btnAdd);
    
    btnEdit = new JButton("Edit");
    btnEdit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new SalesPersonEdit(currentFrame,dealer, (SalesPerson)list.getSelectedValue(),false));
        currentFrame.getContentPane().revalidate();
 
      }
    });
    btnEdit.setBounds(180, 225, 117, 29);
    add(btnEdit);
    btnEdit.setEnabled(false);
    
    btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dealer.removeSalesPerson((SalesPerson)list.getSelectedValue());
        listModel.removeElement(list.getSelectedValue());
      }
    });
    btnDelete.setBounds(291, 225, 117, 29);
    add(btnDelete);
    btnDelete.setEnabled(false);

  }

}
