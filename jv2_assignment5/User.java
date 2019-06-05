package jv2_assignment5;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class User {
    public Integer id;
    public String username;
    public String email;
    public String password;
    public Button edit;

    public User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.edit = new Button("Edit");
    }

    public Button getEdit() {
        return edit;
    }

    public void updateButton(){
        this.edit.setOnAction(event -> {
            Edit.userEdit = this;
            try{
                goToEdit();
            }catch (Exception e){}

        });
    }

    public void goToEdit() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
