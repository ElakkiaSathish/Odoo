import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AssignBandwidth extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel l1 = new JLabel("Enter BW"), l2 = new JLabel("Node2"), l3 = new JLabel(
			"Node3"), l4 = new JLabel("Node4"), l5 = new JLabel("Node5"),
			l6 = new JLabel("Node6"), l7 = new JLabel("Node7"),
			l8 = new JLabel("Node8");

	JButton b1 = new JButton("Assign"), b2 = new JButton("Reset");

	JTextField t1 = new JTextField(), t2 = new JTextField(),
			t3 = new JTextField(), t4 = new JTextField(),
			t5 = new JTextField(), t6 = new JTextField(),
			t7 = new JTextField(), t8 = new JTextField();

	JLabel net = new JLabel("Network");

	JPanel p = new JPanel();

	AssignBandwidth() {

		p.setLayout(null);
		p.setBackground(Color.cyan);

		net.setBounds(50, 50, 150, 25);
		l1.setBounds(50, 100, 150, 25);
		

		t1.setBounds(175, 100, 150, 25);
		

		b1.setBounds(50, 150, 125, 30);
		b2.setBounds(200, 150, 125, 30);

		p.add(l1);
		p.add(t1);

		
	
		p.add(b1);
		p.add(b2);

		add(p);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {

			try {

				
				String[] dsname = { "Select Node", "Node1", "Node2", "Node3", "Node4", "Node5" , "Node6", "Node7", "Node8"};
				
				String nname = (String) JOptionPane.showInputDialog(null,"Select Node", "Node Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
				
				
				

				String sql1 = "update Bandwidth set Bandwidth = '"
						+ t1.getText() + "' where NodeName ='" + nname + "'  ";

				

				Connection con = DBCon.getConnection();

				con.createStatement().executeUpdate(sql1);
				

			} catch (Exception ex) {
				System.out.println(ex);
			}

			JOptionPane.showMessageDialog(null, "Bandwidth Assigned");

		}

		if (e.getSource() == b2) {

			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");

		}

	}

}
