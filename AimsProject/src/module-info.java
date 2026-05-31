module AimsProject {
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    opens hust.soict.hedspi.aims.screen to javafx.fxml;
    exports hust.soict.hedspi.aims.screen;
    exports hust.soict.hedspi.aims.media;
    exports hust.soict.hedspi.aims.cart;
    opens hust.soict.hedspi.aims.media to javafx.fxml;
    opens hust.soict.hedspi.aims.cart to javafx.fxml;
    exports hust.soict.hedspi.aims.exception;

}
