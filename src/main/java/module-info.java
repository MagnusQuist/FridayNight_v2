module com.example.fridaynight_v2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.fridaynight_v2 to javafx.fxml;
    exports com.example.fridaynight_v2;
    exports com.example.fridaynight_v2.controllers;
    opens com.example.fridaynight_v2.controllers to javafx.fxml;
    exports com.example.fridaynight_v2.controllers.sceneControllers;
    opens com.example.fridaynight_v2.controllers.sceneControllers to javafx.fxml;
}