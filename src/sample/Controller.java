package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;


public class Controller {
    @FXML
    private TextArea txtArea;
    @FXML
    private CheckMenuItem Arial;
    @FXML
    private CheckMenuItem TimesNewRoman;
    @FXML
    private CheckMenuItem Size24;
    @FXML
    private CheckMenuItem Size11;

    public void onClick(ActionEvent e) {

        //Creamos un action event para el menu
        CheckMenuItem fonts[] = {Arial, TimesNewRoman};
        CheckMenuItem size[] = {Size24, Size11};
        double tSize = txtArea.getFont().getSize();
        String tFont = txtArea.getFont().getFamily();
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
            case "Cortar":
                txtArea.cut();
                txtArea.requestFocus();
                break;
            case "Pegar":
                txtArea.paste();
                txtArea.requestFocus();
                break;

            case "Arial":
                txtArea.setFont(Font.font("Arial", tSize));
                for (CheckMenuItem item : fonts) {
                    if (!item.getId().equalsIgnoreCase("Arial") && item.isSelected()) {
                        item.setSelected(false);
                        return;
                    }
                }
                break;
            case "TimesNewRoman":
                txtArea.setFont(Font.font("TimesNewRoman", tSize));
                for (CheckMenuItem item : fonts) {
                    if (!item.getId().equalsIgnoreCase("TimesNewRoman") && item.isSelected()) {
                        item.setSelected(false);
                        return;
                    }
                }
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
