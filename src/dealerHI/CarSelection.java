package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import dealerPD.Car;
import dealerPD.Dealer;


public class CarSelection extends JPanel {
  private JList<Car> list;
  DefaultListModel<Car> listModel;
  JButton btnEdit;
  JButton btnAdd;
  JButton btnDelete;
  /**
   * Create the panel.
   */
  public CarSelection(JFrame currentFrame, Dealer dealer) {
    setLayout(null);
    
    JLabel lblCarSelection = new JLabel("Car Selection");
    lblCarSelection.setBounds(174, 24, 120, 16);
    add(lblCarSelection);
    
    listModel = new DefaultListModel<Car>();
    for(Car car : dealer.getCars()) {
      listModel.addElement(car);
    }
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(120, 54, 203, 145);
    add(scrollPane);
    
    list = new JList<Car>(listModel);
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
        currentFrame.getContentPane().add(new CarEdit(currentFrame,dealer, new Car(),true));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnAdd.setBounds(53, 240, 117, 29);
    add(btnAdd);
    
    btnEdit = new JButton("Edit");
    btnEdit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new CarEdit(currentFrame,dealer, list.getSelectedValue(),false));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnEdit.setBounds(177, 240, 117, 29);
    add(btnEdit);
    btnEdit.setEnabled(false);
    
    btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnDelete.setBounds(306, 240, 117, 29);
    add(btnDelete);
    btnDelete.setEnabled(false);

  }
}
