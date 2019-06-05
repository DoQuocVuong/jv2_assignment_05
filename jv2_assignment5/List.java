package jv2_assignment5;

import Connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import java.sql.*;

public class List implements Initializable {
    public TableView<User> tbView;

    public TableColumn<User,Integer> colId;
    public TableColumn<User,String> colUsername;
    public TableColumn<User,String> colEmail;
    public TableColumn<User,String> colPassword;
    public TableColumn<User, Button> colEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));

        String sql = "SELECT * FROM user";
        try {
            LocalDate x = LocalDate.now();
            Connector cn = Connector.getInstance();
            ResultSet rs = cn.getQuery(sql);

            ObservableList<User> list = FXCollections.observableArrayList();

            while (rs.next()){
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User u = new User(id,username,email,password);
                list.add(u);
                u.updateButton();
            }

            tbView.setItems(list);

        }catch (Exception e){

        }
    }

    public void home()throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void register() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
}
