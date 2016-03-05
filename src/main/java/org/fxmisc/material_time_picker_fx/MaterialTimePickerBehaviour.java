package org.fxmisc.material_time_picker_fx;

import com.sun.javafx.scene.control.behavior.ComboBoxBaseBehavior;

import java.time.LocalTime;

public class MaterialTimePickerBehaviour extends ComboBoxBaseBehavior<LocalTime> {

	public MaterialTimePickerBehaviour(final MaterialTimePicker timePicker) {
		super(timePicker, null);
	}

	@Override
	public void onAutoHide() {

		MaterialTimePickerSkin timePickerSkin = (MaterialTimePickerSkin) getControl().getSkin();
		//timePickerSkin.hideTimePickerOnPopupHiding();
		if (!timePickerSkin.getSkinnable().isShowing()) {
			super.onAutoHide();
		}
	}
}
