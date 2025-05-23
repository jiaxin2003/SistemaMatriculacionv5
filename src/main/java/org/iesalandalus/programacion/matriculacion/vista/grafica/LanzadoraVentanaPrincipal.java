package org.iesalandalus.programacion.matriculacion.vista.grafica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.matriculacion.vista.grafica.controladores.ControladorVentanaPrincipal;
import org.iesalandalus.programacion.matriculacion.vista.grafica.recursos.LocalizadorRecursos;
import org.iesalandalus.programacion.matriculacion.vista.grafica.utilidades.Dialogos;

public class LanzadoraVentanaPrincipal extends Application {

    public static void comenzar() {
        launch();
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/VentanaPrincipal.fxml"));
            Parent raiz = fxmlLoader.load();


            escenarioPrincipal.setOnCloseRequest(e -> confirmarSalida(e, escenarioPrincipal));

            Scene escena = new Scene(raiz);
            escenarioPrincipal.setTitle("Sistema de Matriculacion 24-25");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.setResizable(false);
            escenarioPrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmarSalida(WindowEvent e, Stage escenarioCerrar) {
        if (Dialogos.mostrarDialogoConfirmacion("Ventana Principal", "¿Realmente quieres salir de la aplicación?"))
        {
            escenarioCerrar.close();
        }
        else
            e.consume();
    }
}
