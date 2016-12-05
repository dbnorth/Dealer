package dealerHI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dealerPD.Dealer;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DealerFrame extends JFrame {

  private JFrame currentFrame;
  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void open(Dealer dealer) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DealerFrame frame = new DealerFrame(dealer);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public DealerFrame(Dealer dealer) {
    currentFrame = this;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 600, 450);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnMaintenance = new JMenu("Maintenance");
    menuBar.add(mnMaintenance);
    
    JMenuItem mntmDealer = new JMenuItem("Dealer");
    mntmDealer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(new DealerEdit(currentFrame,dealer));
        getContentPane().revalidate();
      }
    });
    mnMaintenance.add(mntmDealer);
    
    JMenuItem mntmSalespersons = new JMenuItem("SalesPersons");
    mntmSalespersons.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(new SalesPersonSelection(currentFrame,dealer));
        getContentPane().revalidate();
      }
    });
    mnMaintenance.add(mntmSalespersons);
    
    JMenuItem mntmCars = new JMenuItem("Cars");
    mntmCars.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getContentPane().removeAll();
        getContentPane().add(new CarSelection(currentFrame,dealer));
        getContentPane().revalidate();
      }
    });
    mnMaintenance.add(mntmCars);
    contentPane = new DealerMain(dealer);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
  }

}
