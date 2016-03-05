package org.fxmisc.material_time_picker_fx.dials;

import javafx.scene.layout.StackPane;

public class TwentyFourHourDial extends HourDial {

	public TwentyFourHourDial() {
		this(null);
	}

	public TwentyFourHourDial(Integer value) {
		initialize(value);
	}

	@Override
	protected void onHourSelected(StackPane hourPane) {

	}

	@Override
	protected void setupUnitPanes(CircularPane dialPane) {

	}
}
