import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;
public class AdminSuccess extends JFrame {
	static AdminSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSuccess();
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
	public AdminSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel adminSection = new JLabel("ADMIN ARENA");
		adminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		adminSection.setForeground(Color.RED);
		
		JButton adduser = new JButton("Add User");
		adduser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UserForm.main(new String[]{});
			frame.dispose();
			}
		});
		adduser.setForeground(Color.BLUE);
		adduser.setBackground(Color.CYAN);
		JButton viewuser = new JButton("View User");
		viewuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewUser.main(new String[]{});
			}
		});
		viewuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewuser.setBackground(Color.GREEN);
		viewuser.setForeground(Color.BLUE);
		JButton deleteLibrarian = new JButton("Delete User");
		deleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteUser.main(new String[]{});
			frame.dispose();
			}
		});
		deleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteLibrarian.setForeground(Color.BLUE);
		deleteLibrarian.setBackground(Color.CYAN);
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GoodReads.main(new String[]{});
				frame.dispose();
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logout.setBackground(Color.GREEN);
		logout.setForeground(Color.BLUE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(adminSection, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(logout, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewuser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(adduser, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(adminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(adduser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewuser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(deleteLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(logout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
