package jv2_assignment5;
import Connector.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Connector.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void Login(){
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String sql = "SELECT * FROM user WHERE username=? and password=?";
try {
    Class.forName("com.mysql.jdbc.Driver");
String url ="jdbc:mysql://localhost:3306/user";
Connection conn = DriverManager.getConnection(url ,"root","");
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, username);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
        goToList();
    }else {
    }
}catch (Exception E){

}
    }
    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
    public void register() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
    public void goToList() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
}
