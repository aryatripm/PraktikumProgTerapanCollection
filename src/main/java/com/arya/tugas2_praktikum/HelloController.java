package com.arya.tugas2_praktikum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    public TextArea nrp;
    @FXML
    public TextArea nama;
    @FXML
    public TextArea ipa;
    @FXML
    public TextArea ips;
    @FXML
    public Button btnTambah;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnHapus;
    @FXML
    public TableView<Student> table;
    @FXML
    public TableColumn<Student, Integer> columnNrp;
    @FXML
    public TableColumn<Student, String> columnNama;
    @FXML
    public TableColumn<Student, Integer> columnIpa;
    @FXML
    public TableColumn<Student, Integer> columnIps;

    private ObservableList<Student> students;

    public void initialize() {
        students = FXCollections.observableArrayList();
        students.add(new Student(2072023, "Arya", 100, 100));
        students.add(new Student(2072021, "Tri", 60, 10));
        table.setItems(students);
        columnNrp.setCellValueFactory(new PropertyValueFactory<Student, Integer>("nrp"));
        columnNama.setCellValueFactory(new PropertyValueFactory<Student, String>("nama"));
        columnIpa.setCellValueFactory(new PropertyValueFactory<Student, Integer>("nilaiIpa"));
        columnIps.setCellValueFactory(new PropertyValueFactory<Student, Integer>("nilaiIps"));

        btnUpdate.setDisable(true);
        btnHapus.setDisable(true);
    }

    public void tambah(ActionEvent actionEvent) {
        Integer newNrp = Integer.parseInt(nrp.getText());
        String newNama = nama.getText();
        Integer newIpa = Integer.parseInt(ipa.getText());
        Integer newIps = Integer.parseInt(ips.getText());

        Student newStudent = new Student(newNrp, newNama, newIpa, newIps);
        students.add(newStudent);

        btnUpdate.setDisable(true);
        btnHapus.setDisable(true);
        formReset();
    }

    public void update(ActionEvent actionEvent) {
        Integer updateNrp = Integer.parseInt(nrp.getText());
        String updateNama = nama.getText();
        Integer updateIpa = Integer.parseInt(ipa.getText());
        Integer updateIps = Integer.parseInt(ips.getText());

        Student student = table.getSelectionModel().getSelectedItem();

        if (student != null) {
            students.remove(student);

//            updateStudent.setNrp(updateNrp);
//            updateStudent.setNama(updateNama);
//            updateStudent.setNilaiIpa(updateIpa);
//            updateStudent.setNilaiIps(updateIps);

            Student newStudent = new Student(updateNrp, updateNama, updateIpa, updateIps);
            students.add(newStudent);
        }

        btnUpdate.setDisable(true);
        btnHapus.setDisable(true);
        formReset();
    }

    public void hapus(ActionEvent actionEvent) {
//        Integer nrp = Integer.parseInt(hapusNrp.getText());
        Student student = table.getSelectionModel().getSelectedItem();
        students.remove(student);
//        students.removeIf(student -> student.getNrp().equals(nrp));

        btnUpdate.setDisable(true);
        btnHapus.setDisable(true);
        formReset();
    }

    private Student search(Integer nrp) {
        for (Student student: students) {
            if (student.getNrp().equals(nrp)) {
                return student;
            }
        }
        return null;
    }

    private void formReset() {
        nrp.setText("");
        nama.setText("");
        ipa.setText("");
        ips.setText("");
    }

    public void dataClicked(MouseEvent mouseEvent) {
        boolean dataSelected = table.getSelectionModel().getSelectedCells().isEmpty();
        if (!dataSelected) {
            btnUpdate.setDisable(false);
            btnHapus.setDisable(false);

            Student selectedStudent = table.getSelectionModel().getSelectedItem();
            nrp.setText(selectedStudent.getNrp().toString());
            nama.setText(selectedStudent.getNama());
            ipa.setText(selectedStudent.getNilaiIpa().toString());
            ips.setText(selectedStudent.getNilaiIps().toString());
        }

    }
}