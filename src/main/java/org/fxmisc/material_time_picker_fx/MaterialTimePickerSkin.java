package org.fxmisc.material_time_picker_fx;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalTime;

public class MaterialTimePickerSkin extends ComboBoxPopupControl<LocalTime> {

	public MaterialTimePickerSkin(MaterialTimePicker timePicker) {
		super(timePicker, new MaterialTimePickerBehaviour(timePicker));

		// TODO
	}

	@Override
	protected Node getPopupContent() {
		return null;// TODO
	}

	@Override
	protected TextField getEditor() {
		return null;// TODO
	}

	@Override
	protected StringConverter<LocalTime> getConverter() {
		return null;// TODO
	}

	@Override
	public Node getDisplayNode() {
		return null;// TODO
	}
}
