package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    @FXML
    private TextArea txtArea;


    public void onClick(ActionEvent e) {

        //Creamos un action event para el menu
        Button tempBton;
        MenuItem tempMenuItem;
        MenuItem tempCheckMenu;
        String option;
        Class clase = e.getSource().getClass();


        if (clase == Button.class) {
            tempBton = (Button) e.getSource();
            option = tempBton.getText();
        } else if (clase == CheckMenuItem.class) {
            tempCheckMenu = (CheckMenuItem) e.getSource();
            option = tempCheckMenu.getText();
        } else {
            tempMenuItem = (MenuItem) e.getSource();
            option = tempMenuItem.getText();
        }
        switch (option) {
            case "Copiar":
                txtArea.copy();
                txtArea.requestFocus();
                break;
            case "Pegar":
                txtArea.paste();
                txtArea.requestFocus();
                break;
            case "App":
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setContentText("Editor de texto");
                info.setTitle("Sobre el programa");
                info.setHeaderText("JavaFX P03");
                info.show();
        }
    }
}
