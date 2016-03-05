package org.fxmisc.material_time_picker_fx.dials;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class MinuteDial extends ClockDial {

	private static final double MINUTE_DIAMETER = 17d;

	private final Map<Integer, StackPane> minuteNumbersToMinutePanes = new HashMap<>();

	private final ObjectProperty<Circle> selectedMinuteCircle = new SimpleObjectProperty<>();

	public MinuteDial() {
	}

	public MinuteDial(Integer value) {
		initialize(value);
	}

	@Override
	protected void setupUnitPanes(CircularPane dialPane) {

		for (int i = 5; i < 60; i += 5) {
			StackPane minutePane = createMinutePane(String.valueOf(i));
			dialPane.add(minutePane);
			minuteNumbersToMinutePanes.put(i, minutePane);
		}

		StackPane hourPane = createMinutePane("00");
		dialPane.add(hourPane);
	}

	private StackPane createMinutePane(String minute) {

		StackPane minutePane = new StackPane();
		minutePane.setShape(new Circle(MINUTE_DIAMETER));

		Text minuteName = new Text(minute);
		minuteName.setFont(Font.font(18));

		Circle minuteCircle = new Circle(MINUTE_DIAMETER);
		minuteCircle.setFill(Color.valueOf("rgba(0,0,0,0)"));

		minutePane.setOnMouseEntered(e -> {
			if (!minuteCircle.equals(selectedMinuteCircle.get())) {
				minuteCircle.setFill(Color.valueOf("#1491FF"));
			}
		});
		minutePane.setOnMouseExited(e -> {
			if (!minuteCircle.equals(selectedMinuteCircle.get())) {
				minuteCircle.setFill(Color.valueOf("rgba(0,0,0,0)"));
			}
		});


		//minutePane.setOnMouseClicked(event -> setSelectedHour(Integer.parseInt(minuteName.getText())));

		selectedMinuteCircle.addListener((observable, oldValue, newValue) -> {

			if (minuteCircle.equals(newValue)) {
				minuteCircle.setFill(Color.valueOf("#009688"));
				minuteName.setFill(Color.WHITE);
			} else {
				minuteCircle.setFill(Color.valueOf("rgba(0,0,0,0)"));
				minuteName.setFill(Color.BLACK);
			}
		});

		minutePane.getChildren().addAll(minuteCircle, minuteName);

		return minutePane;
	}

	@Override
	protected void setupSelectedValueListener(Integer value) {

	}
}
