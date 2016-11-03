package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.IOException;


public class Controller {
    @FXML
    private TextArea txtArea;
    @FXML
    private Button Copiar;
    @FXML
    private Button Cortar;
    @FXML
    private Parent root;


    public void onClick(ActionEvent e) throws IOException {

        //Creamos un action event para el menu
        double tSize = txtArea.getFont().getSize();
        String tFont = txtArea.getFont().getFamily();
        Button tempBton;
        MenuItem tempMenuItem;
        String option;
        Class clase = e.getSource().getClass();


        if (clase == Button.class) {
            tempBton = (Button) e.getSource();
            option = tempBton.getText();
        } else {
            tempMenuItem = (MenuItem) e.getSource();
            option = tempMenuItem.getText();
        }
        switch (option) {
            //Fa referencia al text del botó per aixo serveix per als dos btons
            case "Copiar":
                txtArea.copy();
                txtArea.requestFocus();
                break;
            case "Cortar":
                txtArea.cut();
                txtArea.requestFocus();
                break;
            case "Pegar":
                txtArea.paste();
                txtArea.requestFocus();
                break;
            case "Deshacer":
                txtArea.undo();
                txtArea.requestFocus();
                break;
            case "Abrir":
                txtArea.setText(DialogUtils.AbrirDialogo(root));
                break;
            case "Guardar":
                DialogUtils.GuardarDialogo(txtArea.getText(), root);
                break;
            case "Cerrar":
                Platform.exit();
                break;
            case "Arial":
                txtArea.setFont(Font.font("Arial", tSize));
                break;
            case "Calibri":
                txtArea.setFont(Font.font("Calibri", tSize));
                break;
            case "11px":
                tSize = 11;
                txtArea.setFont(Font.font(tFont, tSize));
                break;
            case "24px":
                tSize = 24;
                txtArea.setFont(Font.font(tFont, tSize));
                break;
            case "App":
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setContentText("Editor de texto");
                info.setTitle("Sobre el programa");
                info.setHeaderText("JavaFX P03");
                info.show();
        }
    }

    public void onMouseIn(MouseEvent e) {
        txtArea.selectionProperty().addListener(observable -> {
            if (txtArea.getSelectedText().equals("")) {
                Copiar.setDisable(true);
                Cortar.setDisable(true);
            } else {
                Copiar.setDisable(false);
                Cortar.setDisable(false);
            }
        });
    }

}
