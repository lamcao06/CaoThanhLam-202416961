module GUI.project {
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    opens hust.soict.hedspi.javafx to javafx.fxml;
    exports hust.soict.hedspi.javafx;
    exports hust.soict.hedspi.swing;
    opens hust.soict.hedspi.swing to javafx.fxml;

}