module br.edu.ifsp.jscopa {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.jscopa to javafx.fxml;
    exports br.edu.ifsp.jscopa;
}
