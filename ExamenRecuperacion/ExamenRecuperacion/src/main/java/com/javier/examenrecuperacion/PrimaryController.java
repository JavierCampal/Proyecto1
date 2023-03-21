package com.javier.examenrecuperacion;

import dao.Dao;
import models.Alumno;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{
    @FXML
    private TableColumn<Alumno, String> cNombre;
    
    @FXML
    private TableColumn<Alumno, String> cApellidos;
     
    @FXML
    private TableColumn<Alumno, Double> cAD;
       
    @FXML
    private TableColumn<Alumno, Double> cSGE;
        
    @FXML
    private TableColumn<Alumno, Double> cDI;
         
    @FXML
    private TableColumn<Alumno, Double> cPMDM;
          
    @FXML
    private TableColumn<Alumno, Double> cPSP;
           
    @FXML
    private TableColumn<Alumno, Double> cEIE;
            
    @FXML
    private TableColumn<Alumno, Double> cHLC;
    
    @FXML
    private TableView<Alumno> tabla;
    
    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtApellidos;
    
    @FXML
    private TextField txtAD;
    
    @FXML
    private TextField txtDI;
    
    @FXML
    private TextField txtSGE;
    
    @FXML
    private TextField txtPMDM;
    
    @FXML
    private TextField txtPSP;
    
    @FXML
    private TextField txtEIE;
    
    @FXML
    private TextField txtHLC;
    
    @FXML
    private void guardar() throws IOException {
        
        if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtAD.getText().isEmpty() ||
                txtSGE.getText().isEmpty() || txtDI.getText().isEmpty() || txtPMDM.getText().isEmpty() ||
                txtPSP.getText().isEmpty() || txtEIE.getText().isEmpty() || txtHLC.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Los campos para insertar un alumno son obligatorios");
            alert.showAndWait();
        } else {
            Alumno a = new Alumno(txtNombre.getText(), txtApellidos.getText(), Double.valueOf(txtAD.getText()),
                Double.valueOf(txtSGE.getText()), Double.valueOf(txtDI.getText()), Double.valueOf(txtPMDM.getText()), 
            Double.valueOf(txtPSP.getText()), Double.valueOf(txtEIE.getText()), Double.valueOf(txtHLC.getText()));
       
            Dao.aniadir(a);
            actualizarTabla();
        }
        
    }
    
    @FXML
    private void descargar() throws IOException{
        
    }
    
    @FXML
    private void salir() throws IOException{
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();    
    }
    
    @FXML
    private void seleccionar() throws IOException{
        if(tabla.getSelectionModel().getSelectedItem() != null){
            var selected = tabla.getSelectionModel().getSelectedItem();
            Alumno a = Dao.getByNombre(selected.getNombre(), selected.getApellidos());

            
            if(a != null){            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                
                if(a.getAd() >= 5 && a.getDi()>= 5 && a.getEie()>= 5 && a.getHlc()>= 5 && a.getSge()>= 5 && a.getPsp()>= 5 && a.getPsp()>= 5){
                    double total = a.getAd() + a.getDi() + a.getEie() + a.getHlc() + a.getSge() + a.getPsp() + a.getPsp();
                    double media = total / 7;
                    
                    alert.setContentText("La media del alumno " + a.getNombre() + " es: " + media);
                    alert.showAndWait();
                } else {
                    int count = 0;
                    if(a.getAd() < 5){
                        count++;
                    }
                    
                    if(a.getDi() < 5){
                        count++;
                    }
                    
                    if(a.getPsp() < 5){
                        count++;
                    }
                    
                    if(a.getPmdm() < 5){
                        count++;
                    }
                    
                    if(a.getHlc() < 5){
                        count++;
                    }
                    
                    if(a.getSge() < 5){
                        count++;
                    }
                    
                    if(a.getEie() < 5){
                        count++;
                    }
                    
                    alert.setContentText("El alumno " + a.getNombre() + " tiene : " + count + " asignaturas suspensas");
                    alert.showAndWait();
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));       
        cApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        cAD.setCellValueFactory(new PropertyValueFactory("ad"));        
        cSGE.setCellValueFactory(new PropertyValueFactory("sge"));
        cDI.setCellValueFactory(new PropertyValueFactory("di"));
        cPMDM.setCellValueFactory(new PropertyValueFactory("pmdm"));
        cPSP.setCellValueFactory(new PropertyValueFactory("psp"));
        cEIE.setCellValueFactory(new PropertyValueFactory("eie"));
        cHLC.setCellValueFactory(new PropertyValueFactory("hlc"));
        
        actualizarTabla();
    }

    private void actualizarTabla() {
        vaciarText();
        tabla.getItems().clear();
        
        List<Alumno> alumnos = Dao.getAlumnos();
        
        for(var a : alumnos){
            tabla.getItems().add(a);
        }   
    }

    private void vaciarText() {
        txtNombre.clear();
        txtApellidos.clear();
        txtAD.clear();
        txtDI.clear();
        txtSGE.clear();
        txtHLC.clear();
        txtPMDM.clear();
        txtPSP.clear();
        txtEIE.clear();
    }
}
