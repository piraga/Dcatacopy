package com.datacopy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.datacopy.application.Main;
import com.datacopy.application.PopUp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class FrontController  implements Initializable {
	
	@FXML
	Button connectdb;
	@FXML
	TextField username = new TextField();
	@FXML
	TextField hostname = new TextField();
	@FXML
	TextField portnumber = new TextField();
	@FXML
	TextField sid = new TextField();
	@FXML
	TextField password = new TextField();
	
	Main main = new Main();
	PopUp popUp=new PopUp();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		sid.setFocusTraversable(false);
	}
	
	public void connectDatabase() {
		connectdb.setDisable(true);
		try {
			ProgressBar pb = new ProgressBar();
			pb.setProgress(0.5);
		boolean process=popUp.processPermission(username.getText(), password.getText(), portnumber.getText(), 
				hostname.getText(), sid.getText());
	
		
		main.changeScene();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hai"+sid.getText()+username.getText()+hostname.getText()+portnumber.getText()+sid.getText());
		connectdb.setDisable(false);
	}
	
	

}
