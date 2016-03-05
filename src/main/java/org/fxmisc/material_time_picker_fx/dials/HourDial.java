package org.fxmisc.material_time_picker_fx.dials;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Map;

abstract class HourDial extends ClockDial {

	protected final Map<Integer, StackPane> hourNumbersToHourPanes = new HashMap<>();

	protected final ObjectProperty<Circle> selectedHourCircle = new SimpleObjectProperty<>();


	public HourDial() {
	}

	public HourDial(Integer value) {
	}

	@Override
	protected void setupSelectedValueListener(Integer value) {
		selectedValue.addListener((observable, oldValue, newValue) ->
				onHourSelected(hourNumbersToHourPanes.getOrDefault(newValue, null))
		);
		setSelectedValue(value);
	}

	protected abstract void onHourSelected(StackPane hourPane);
}
