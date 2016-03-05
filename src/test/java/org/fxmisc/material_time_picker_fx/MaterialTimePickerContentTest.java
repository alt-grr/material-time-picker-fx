package org.fxmisc.material_time_picker_fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MaterialTimePickerContentTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(new MaterialTimePickerContent(new MaterialTimePicker())));
		primaryStage.show();
	}
}
