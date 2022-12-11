/*
 * Course: CS 1021
 * Term: Winter
 * Assignment Name:
 * Name: Cherise Malisa
 * Created:
 */

package malisac;

import javafx.fxml.FXML;


import edu.msoe.se1021.Lab6.WebsiteTester;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ButtonType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.rmi.UnknownHostException;
import java.util.Optional;

/**
 * controller class for fxml file
 */
public class Lab6Controller {

    @FXML
    private TextField timeOut;
    @FXML
    private TextField url;
    @FXML
    private TextField size;
    @FXML
    private TextField time;
    @FXML
    private TextField host;
    @FXML
    private TextField port;
    @FXML
    private TextArea pane;

    WebsiteTester tester = new WebsiteTester();


    @FXML
    private void analyze() throws IOException { // when testing errors remember to remove

        Alert b = new Alert(Alert.AlertType.ERROR);
        Alert c = new Alert(Alert.AlertType.CONFIRMATION);

        String userUrl, size, time, host, port;
        userUrl = url.getText();

        if (userUrl.isEmpty()) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText("The URL entered in the text box is invalid");
            b.showAndWait();
        }
        try {
            tester.openURL(userUrl);
        } catch (MalformedURLException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
            url.clear();
        }

        try {
            tester.openConnection();

        } catch (MalformedURLException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
            url.clear();
        } catch (UnknownHostException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
        } catch (SocketTimeoutException e) {
            TextInputDialog textInputDialog = new TextInputDialog();
            c.setTitle("Timeout Dialog");
            c.setHeaderText("Wait longer?");
            c.setContentText(e.getMessage());
            Optional<ButtonType> result = c.showAndWait();
            if (result.get() == ButtonType.OK) {
                textInputDialog.setHeaderText("Set extended timeout");
                textInputDialog.setContentText("There has been a timeout reaching the site." +
                        "Click OK to extend the timeout period?");
                textInputDialog.setContentText("Desired Timeout: ");

                Optional<String> r1 = textInputDialog.showAndWait();
                if (r1.isPresent()) {
                    timeOut.setText(r1.get());
                }
            }


        } catch (IOException e) {
            b.setTitle("Error Dialog");
            b.setContentText(e.getMessage());
            b.showAndWait();
        }
        try {
            tester.downloadText();
        } catch (ConnectException e) {
            b.setTitle("Error Dialog");
            b.setContentText(e.getMessage());
            b.showAndWait();

        } catch (FileNotFoundException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("File Error");
            b.setContentText("Error: File not found on the server,\n" + e.getMessage());
            b.showAndWait();

        } catch (UnknownHostException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
        }


        size = Integer.toString(tester.getSize());
        this.size.setText(size);
        time = Long.toString(tester.getDownloadTime());
        this.time.setText(time);
        host = tester.getHostname();
        this.host.setText(host);
        port = Integer.toString(tester.getPort());
        this.port.setText(port);
        pane.setText(tester.getContent());


    }

    @FXML
    private void setTimeOut() {
        Alert a = new Alert(Alert.AlertType.ERROR);

        String userTime;
        userTime = timeOut.getText();
        try {
            tester.setTimeout(userTime);
        } catch (NumberFormatException e) {
            a.setTitle("Time Error");
            a.setHeaderText("Invalid Timeout Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
            userTime = tester.getTimeout();
        }

        timeOut.setText(userTime);

    }


}
