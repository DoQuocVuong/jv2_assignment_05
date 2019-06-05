package jv2_assignment5;

import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Edit implements Initializable {
    public TextField txtUsername;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public static User userEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtUsername.setText(userEdit.getUsername());
        txtEmail.setText(userEdit.getEmail());
        txtPassword.setText(userEdit.getPassword());
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
    }

    public void update()throws Exception{
        String sql = "UPDATE user set username=? and email=? and password=? where id = id";

        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/user";
        Connection conn = DriverManager.getConnection(url ,"root","");
        PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
    }
}
