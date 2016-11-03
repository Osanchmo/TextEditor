package sample;

import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class DialogUtils {

    static String Abrir(File file) throws IOException{
        String r = null;
        BufferedReader bf = new BufferedReader(new FileReader(file));
        while (bf.ready()){r = r+bf.readLine() + "\n";}
        bf.close();
        return r;
    }

    static void Guardar(File file, String text) throws IOException {
        FileWriter f = new FileWriter(file);
        f.write(text);
        f.close();
    }

    static String AbrirDialogo(Parent root) throws IOException {

        String text = null;
        FileChooser escoger = new FileChooser();

        Stage vista = (Stage) root.getScene().getWindow();
        escoger.setTitle("Elige un fichero");
        File file = escoger.showOpenDialog(vista);
        if (file != null) {text = Abrir(file);}
        return text;
    }

    static void GuardarDialogo(String content, Parent root) throws IOException {
        FileChooser escoger = new FileChooser();


        Stage vista = (Stage) root.getScene().getWindow();
        File file = escoger.showSaveDialog(vista);
        if (file != null) {
            Guardar(file, content);
        }
    }

}
