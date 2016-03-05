package org.fxmisc.material_time_picker_fx;

import javafx.scene.layout.VBox;
import org.fxmisc.material_time_picker_fx.dials.ClockDial;
import org.fxmisc.material_time_picker_fx.dials.MinuteDial;

public class MaterialTimePickerContent extends VBox {

	private final MaterialTimePicker timePicker;

	MaterialTimePickerContent(MaterialTimePicker timePicker) {
		this.timePicker = timePicker;

		setPrefSize(250, 250);
		setStyle("-fx-background-color: white");
		ClockDial clockDial = new MinuteDial(7);
		getChildren().addAll(clockDial);

//		new Thread(() -> {
//			for (int i = 1; i < 13; i++) {
//
//				final int finalI = i;
//				Platform.runLater(() -> clockDial.setSelectedValue(finalI));
//
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//			Platform.runLater(() -> clockDial.setSelectedValue(null));
//
//		}).start();
	}
}
