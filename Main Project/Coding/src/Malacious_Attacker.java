import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Malacious_Attacker extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JTextField t1 = new JTextField(), t2 = new JTextField(),
			t3 = new JTextField();
	JLabel l1 = new JLabel("Node-Name"), l2 = new JLabel("FileName"),
			l3 = new JLabel("IPAddress");

	public Font f4 = new Font("Times new roman", Font.BOLD, 18);

	JButton submit = new JButton("Submit"), request = new JButton(),
			reset = new JButton("Reset");

	JComboBox cb = new JComboBox();

	JTextArea ta = new JTextArea();
	JScrollPane pane = new JScrollPane();

	JPanel p = new JPanel();

	Malacious_Attacker() {

		p.setLayout(null);
		p.setBackground(Color.RED);

		ta.setColumns(10);
		ta.setRows(10);
		ta.setFont(f4);
		pane.setViewportView(ta);

		cb.addItem("Select");
		cb.addItem("N2");
		cb.addItem("N3");
		cb.addItem("N6");
		cb.addItem("N8");

		l1.setFont(f4);
		l2.setFont(f4);
		l3.setFont(f4);
		t1.setFont(f4);
		t2.setFont(f4);

		l1.setBounds(50, 50, 100, 25);
		l2.setBounds(50, 100, 100, 25);
		l3.setBounds(50, 150, 100, 25);

		cb.setBounds(160, 50, 150, 25);
		t2.setBounds(160, 100, 150, 25);
		t3.setBounds(160, 150, 150, 25);

		submit.setBounds(70, 460, 120, 28);
		reset.setBounds(200, 460, 120, 28);

		pane.setBounds(50, 150, 400, 300);

		p.add(l1);
		p.add(l2);
		p.add(cb);
		p.add(t2);

		p.add(pane);

		p.add(submit);
		p.add(reset);

		add(p);

		submit.addActionListener(this);
		reset.addActionListener(this);

	}

	public static void main(String[] args) {

		Malacious_Attacker at = new Malacious_Attacker();
		at.setSize(500, 550);
		at.setTitle("Attacker");
		at.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			try {

				Socket socket = new Socket(JOptionPane.showInputDialog(null,
						"Enter Router IPAddress"), 8009);

				DataOutputStream dos = new DataOutputStream(
						socket.getOutputStream());

				dos.writeUTF((String) cb.getSelectedItem());
				dos.writeUTF(t2.getText());
				dos.writeUTF(ta.getText());
				
				JOptionPane.showMessageDialog(null, "Node Attacked Successfully");

			} catch (Exception ex) {
				System.out.println(ex);
			}

		}

		if (e.getSource() == reset) {

			t1.setText("");
			t2.setText("");
			ta.setText("");

		}

	}

}
