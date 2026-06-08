package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.SelectionMode;

public class Controlador {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private ComboBox<String> cmbCarrera;

    @FXML
    private ComboBox<String> cmbSemestre;

    @FXML
    private ListView<String> listaMaterias;

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private TextField txtResultado;

    @FXML
    private ComboBox<String> cmbOperacion;

    @FXML
    private ListView<String> listaHistorial;
    @FXML
    private Label lblUltimoCalculo;

    @FXML
    private Label lblRegistro;

    @FXML
    public void initialize() {

        cmbCarrera.getItems().addAll(
                "Ingeniería en Sistemas",
                "Ingenieria Civíl",
                "Software",
                "Industrial"
        );

        cmbSemestre.getItems().addAll(
                "1er Semestre",
                "2do Semestre",
                "3er Semestre",
                "4to Semestre",
                "5to Semestre"
        );

        cmbOperacion.getItems().addAll(
                "Suma",
                "Resta",
                "Multiplicación",
                "División",
                "Potencia",
                "Raíz",
                "Módulo",
                "Promedio"
        );

        listaMaterias.getItems().addAll(
                "Programación",
                "Base de Datos",
                "Redes",
                "Matemáticas",
                "Estadística"

        );
        listaMaterias.getSelectionModel().setSelectionMode(
                javafx.scene.control.SelectionMode.MULTIPLE
        );
        txtResultado.setEditable(false);
    }

    @FXML
    private void registrarEncuesta() {

        String nombre = txtNombre.getText();

        lblMensaje.setText("Registro guardado para: " + nombre);

        String edad = txtEdad.getText();
        String carrera = cmbCarrera.getValue();
        String semestre = cmbSemestre.getValue();

        String materias = String.join(", ", listaMaterias.getSelectionModel().getSelectedItems());

        lblRegistro.setText(nombre + " | " + edad + " años | " + carrera + " | " + semestre + " | Materias: " + materias
        );
    }

    @FXML
    private void limpiarEncuesta() {

        txtNombre.clear();
        txtEdad.clear();

        cmbCarrera.setValue(null);
        cmbSemestre.setValue(null);

        listaMaterias.getSelectionModel().clearSelection();
    }

    @FXML
    private void calcular() {

        try {

            double n1 =
                    Double.parseDouble(txtNum1.getText());

            double n2 =
                    Double.parseDouble(txtNum2.getText());

            String op =
                    cmbOperacion.getValue();

            double resultado = 0;

            if(op.equals("Suma"))
                resultado = n1 + n2;

            else if(op.equals("Resta"))
                resultado = n1 - n2;

            else if(op.equals("Multiplicacion"))
                resultado = n1 * n2;

            else if(op.equals("Division"))
                resultado = n1 / n2;

            else if(op.equals("Potencia"))
                resultado = Math.pow(n1,n2);

            else if(op.equals("Raiz"))
                resultado = Math.sqrt(n1);

            else if(op.equals("Modulo"))
                resultado = n1 % n2;

            else if(op.equals("Promedio"))
                resultado = (n1 + n2) / 2.0;

            txtResultado.setText(
                    String.valueOf(resultado)
            );

            lblUltimoCalculo.setText("Ultimo cálculo: "+
                    n1 + " " + op + " " + n2 +
                            " = " + resultado
            );

            listaHistorial.getItems().add(
                    n1 + " " + op + " " + n2 +
                            " = " + resultado
            );


        } catch(Exception e) {

            txtResultado.setText("Error");
        }
    }

    @FXML
    private void limpiarCalculo() {

        txtNum1.clear();
        txtNum2.clear();

        txtResultado.clear();

        cmbOperacion.setValue(null);
    }

    @FXML
    private void borrarHistorial() {

        listaHistorial.getItems().clear();
    }
    @FXML
    private Label lblMensaje;
}