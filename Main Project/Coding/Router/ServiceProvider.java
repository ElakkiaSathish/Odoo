import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ServiceProvider implements ActionListener {

	Container c;
	JLabel l1, img, op, op2;
	JButton b1, b2, b3;
	public Font f6 = new Font("Bell MT", Font.BOLD, 18);
	public Font f4 = new Font("Bell MT", Font.BOLD, 15);
	JTextArea ta;
	JScrollPane sp;
	JFrame jf;

	String fname;
	String mac;
	File field;

	ServiceProvider() {

		jf = new JFrame(" ");

		LineBorder border1 = new LineBorder(Color.red);

		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.ORANGE);

		Border b11 = BorderFactory.createRaisedBevelBorder();
		Border b0 = BorderFactory.createCompoundBorder(border1, b11);

		op = new JLabel();
		op.setBorder(b0);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("ServiceProvider.PNG"));
		JLabel title=new JLabel();
		title.setIcon(banner);
		title.setBounds(0, 0, 850, 100);
		
		

		Border bb = BorderFactory.createBevelBorder(0);
		op2 = new JLabel();
		op2.setBorder(bb);

		l1 = new JLabel("UPLOAD FILE");
		l1.setFont(f4);

		l1.setForeground(Color.BLACK);

		img = new JLabel();

		ta = new JTextArea();
		ta.setFont(f6);
		ta.setRows(20);
		ta.setColumns(20);

		sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setBounds(110, 175, 475, 350);

		b1 = new JButton("S E N D");
		b2 = new JButton("C A N C E L ");
		b3 = new JButton("BROWSE");

		b3.setFont(f4);
		b2.setFont(f4);
		b1.setFont(f4);

		b3.setForeground(Color.blue);
		b3.setBackground(Color.white);

		b1.setForeground(Color.blue);
		b1.setBackground(Color.white);
		b2.setForeground(Color.blue);
		b2.setBackground(Color.white);

		b1.setBounds(175, 575, 120, 40);
		b2.setBounds(375, 575, 120, 40);
		b3.setBounds(300, 120, 125, 35);
		l1.setBounds(100, 120, 150, 30);
		l1.setForeground(Color.blue);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		op.setBounds(40, 100, 600, 450);
		op.setBackground(Color.white);
		op2.setBounds(40, 560, 600, 70);
		op2.setBackground(Color.white);

		c.add(l1);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(sp);
		c.add(img);
		c.add(op);
		c.add(op2);
		c.add(title);
		jf.setVisible(true);
		jf.setTitle("Service Provider::Discovery and Verification of Neighbor Positions in Mobile Ad Hoc Networks");
		jf.setBounds(50, 25, 700, 700);
		

	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b2) {

			System.exit(0);

		}

		if (e.getSource() == b3) {

			JFileChooser jc = new JFileChooser();

			try {
				File f = new File(new File("filename.txt").getCanonicalPath());
				jc.setSelectedFile(f);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			int rt = jc.showOpenDialog(b3);

			if (rt == JFileChooser.APPROVE_OPTION) {

				field = jc.getSelectedFile();

				fname = field.getName();

			}

			File ff = jc.getSelectedFile();

			try {

				FileInputStream fis = new FileInputStream(ff);

				DataInputStream dis = new DataInputStream(fis);

				BufferedReader br = new BufferedReader(new InputStreamReader(
						dis));

				StringBuffer bf = new StringBuffer();

				String s;

				while ((s = br.readLine()) != null) {
					bf.append(s + "\n");
				}

				ta.setText(bf.toString());

				new FileOutputStream("Source/" + fname).write(ta.getText()
						.getBytes());

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (e.getSource() == b1) {

			JOptionPane op = new JOptionPane();

			try {

				String[] Reciever = { "Select", "Router1", "Router2", "Router3" };
				String SReciever = (String) JOptionPane.showInputDialog(null,
						"Select Router", "Select",
						JOptionPane.QUESTION_MESSAGE, null, Reciever,
						Reciever[0]);

				MessageDigest md = MessageDigest.getInstance("SHA1");
				FileInputStream in1 = new FileInputStream("Source\\" + fname);

				DigestInputStream dis2 = new DigestInputStream(in1, md);

				BufferedInputStream bd = new BufferedInputStream(dis2);

				while (true) {
					int b2 = bd.read();
					if (b2 == -1)
						break;
				}

				BigInteger bi2 = new BigInteger(md.digest());
				mac = bi2.toString(16);

				if (SReciever == "Router1") {

					String[] Action = { "Select Action", "Jamming", "Sybil" };

					String SAction = (String) JOptionPane.showInputDialog(null,
							"Select Action", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Action,
							Action[0]);

					Socket socket = new Socket(op.showInputDialog(null,
							"Enter IPAddress"), 9009);

					DataOutputStream dos = new DataOutputStream(
							socket.getOutputStream());

					dos.writeUTF(SAction);
					dos.writeUTF(fname);
					dos.writeUTF(mac);
					dos.writeUTF(ta.getText());

				}

				if (SReciever == "Router2") {

					String[] Action = { "Select Action", "Adversial",
							"Hyperbola" };

					String SAction = (String) JOptionPane.showInputDialog(null,
							"Select Action", "Select",
							JOptionPane.QUESTION_MESSAGE, null, Action,
							Action[0]);

					Socket socket = new Socket(op.showInputDialog(null,
							"Enter IPAddress"), 9010);

					DataOutputStream dos = new DataOutputStream(
							socket.getOutputStream());

					dos.writeUTF(SAction);
					dos.writeUTF(fname);
					dos.writeUTF(ta.getText());

				}

				if (SReciever == "Router3") {

					Socket socket = new Socket(op.showInputDialog(null,
							"Enter IPAddress"), 9011);

					DataOutputStream dos = new DataOutputStream(
							socket.getOutputStream());

					dos.writeUTF(fname);
					//dos.writeUTF(mac);
					dos.writeUTF(ta.getText());
				}

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}

	public static void main(String[] args) {
		new ServiceProvider();

	}
}
