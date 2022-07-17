module com.arya.tugas2_praktikum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arya.tugas2_praktikum to javafx.fxml;
    exports com.arya.tugas2_praktikum;
}