package org.fxmisc.material_time_picker_fx;

import javafx.scene.control.ComboBoxBase;

import java.time.LocalTime;

public class MaterialTimePicker extends ComboBoxBase<LocalTime> {

	public MaterialTimePicker() {
	}

	public MaterialTimePicker(LocalTime localTime) {
		setValue(localTime);
	}
}
