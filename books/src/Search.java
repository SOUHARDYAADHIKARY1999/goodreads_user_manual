import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class SearchBook extends JFrame implements ActionListener {

    JLabel st1,nameLabel, authorNameLabel, ratingLabel, isbnLabel, categoryLabel;
    JTextField st1Field, nameField, authorNameField, ratingField, isbnField, categoryField;
    private JButton submit; // name, author, rating, isbn, category;

//    Container contentPane = getContentPane();
//    SpringLayout layout = new SpringLayout();

    SearchBook() {
        super("Search Book");
        st1 = new JLabel("Enter book name: ");
        st1.setBounds(20,20,100,20);
        st1.setForeground(Color.BLUE);

        st1Field = new JTextField(); 
        st1Field.setBounds(20,50,250,20);

        submit = new JButton("Search");
        submit.setBounds(290,50,100,20);
        submit.addActionListener(this);
        submit.setForeground(Color.BLUE);
        submit.setBackground(Color.GREEN);

        nameField = new JTextField();//nameField.setSize(100, 20);
        nameLabel = new JLabel("Name of publisher: ");
        nameLabel.setBounds(20,80,100,20);
        nameField.setBounds(120,80,250,20); 
        nameField.setEditable(true);
        nameLabel.setForeground(Color.RED);

        authorNameField = new JTextField();
        authorNameLabel = new JLabel("Author: ");
        authorNameField.setEditable(true);
        authorNameLabel.setBounds(20,110,100,20);
        authorNameField.setBounds(120,110,250,20);
        authorNameLabel.setForeground(Color.RED);

        ratingField = new JTextField();
        ratingLabel = new JLabel("Rating: ");
        ratingField.setEditable(true);
        ratingLabel.setBounds(20,140,100,20);
        ratingField.setBounds(120,140,250,20);
        ratingLabel.setForeground(Color.RED);

        isbnField = new JTextField();
        isbnLabel = new JLabel("ISBN: ");
        isbnField.setEditable(true);
        isbnLabel.setBounds(20,170,100,20);
        isbnField.setBounds(120,170,250,20);
        isbnLabel.setForeground(Color.RED);

        categoryLabel = new JLabel("Category: "); 
        categoryField = new JTextField();
        categoryField.setEditable(true);
        categoryLabel.setBounds(20,200,100,20);
        categoryField.setBounds(120,200,250,20);
        categoryLabel.setForeground(Color.RED);

        add(st1); add(st1Field); add(submit); add(nameLabel); add(nameField);
        add(authorNameLabel); add(authorNameField); add(categoryLabel); add(categoryField); add(ratingLabel); add(ratingField);
        add(isbnLabel); add(isbnField);

        setLayout(null);
//        contentPane.setLayout(layout);
//        layout.putConstraint(SpringLayout.NORTH, nameLabel,100,SpringLayout.WEST, contentPane);
//        layout.putConstraint(SpringLayout.NORTH, authorNameLabel,130,SpringLayout.WEST, contentPane);
//        layout.putConstraint(SpringLayout.NORTH, categoryLabel,400,SpringLayout.WEST, contentPane);
//        layout.putConstraint(SpringLayout.NORTH, ratingLabel,500,SpringLayout.WEST, contentPane);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("hi");
        try {
            String st = st1Field.getText();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("");// get connection from the server
            PreparedStatement statement = con.prepareStatement("select * from BookList where name=?");
            statement.setString(1,st);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                /// set column index from data table to the respective variable for [name], [book], etc.
                String name = resultSet.getString(1);
                String author = resultSet.getString(2);
                String category = resultSet.getString(3);
                String rating = resultSet.getString(4);
                String isbn = resultSet.getString(5);

                nameField.setText(name);
                authorNameField.setText(author);
                categoryField.setText(category);
                ratingField.setText(rating);
                isbnField.setText(isbn);
            }  else {
                JOptionPane.showMessageDialog(null,"BOOK NOT FOUND");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

class Search {
    public static void main(String args[]) {
        new SearchBook();
    }
}
