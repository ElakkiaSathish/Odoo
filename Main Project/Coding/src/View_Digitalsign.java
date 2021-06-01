import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View_Digitalsign extends JFrame

{

	private static final long serialVersionUID = 1L;

	JScrollPane pane;

	JPanel c;

	JLabel imglabel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	View_Digitalsign() {

		c = new JPanel();
		c.setLayout(null);

		c.setBackground(Color.LIGHT_GRAY);

		try {

			Vector heading = new Vector();

			heading.addElement("NodeName");

			heading.addElement("Digital Sign");
			heading.addElement("Message");
			heading.addElement("Attacker");

			Vector data = new Vector();

			ResultSet rs = DBCon.getConnection().createStatement()
					.executeQuery("Select * from SybilAttack");

			ResultSetMetaData rsm = rs.getMetaData();

			int col = rsm.getColumnCount();

			while (rs.next()) {

				Vector row = new Vector();

				for (int i = 1; i <= col; i++) {

					row.addElement(rs.getString(i));

				}

				data.addElement(row);

			}

			JTable table = new JTable(data, heading);

			pane = new JScrollPane(table);

			pane.setBounds(25, 10, 450, 250);
			c.add(pane);

			add(c);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}