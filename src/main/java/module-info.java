module org.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
    requires javafx.media;


    opens org.example.game to javafx.fxml;
    exports org.example.game;
    exports org.example.game.view;
    opens org.example.game.view to javafx.fxml;
}