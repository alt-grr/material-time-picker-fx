package org.fxmisc.material_time_picker_fx.dials;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TwelveHourDial extends HourDial {

	private static final double HOUR_DIAMETER = 17d;

	public TwelveHourDial() {
		this(null);
	}

	public TwelveHourDial(Integer value) {
		initialize(value);
	}

	@Override
	protected void setupUnitPanes(CircularPane dialPane) {

		for (int i = 1; i <= 12; i++) {
			StackPane hourPane = createHourPane(i);
			dialPane.add(hourPane);
			hourNumbersToHourPanes.put(i, hourPane);
		}
	}

	private StackPane createHourPane(int i) {

		StackPane hourPane = new StackPane();
		hourPane.setShape(new Circle(HOUR_DIAMETER));

		Text hourName = new Text(String.valueOf(i));
		hourName.setFont(Font.font(18));

		Circle hourCircle = new Circle(HOUR_DIAMETER);
		hourCircle.setFill(Color.valueOf("rgba(0,0,0,0)"));

		hourPane.setOnMouseEntered(e -> {
			if (!hourCircle.equals(selectedHourCircle.get())) {
				hourCircle.setFill(Color.valueOf("#1491FF"));
			}
		});
		hourPane.setOnMouseExited(e -> {
			if (!hourCircle.equals(selectedHourCircle.get())) {
				hourCircle.setFill(Color.valueOf("rgba(0,0,0,0)"));
			}
		});


		hourPane.setOnMouseClicked(event -> setSelectedValue(Integer.parseInt(hourName.getText())));

		selectedHourCircle.addListener((observable, oldValue, newValue) -> {

			if (hourCircle.equals(newValue)) {
				hourCircle.setFill(Color.valueOf("#009688"));
				hourName.setFill(Color.WHITE);
			} else {
				hourCircle.setFill(Color.valueOf("rgba(0,0,0,0)"));
				hourName.setFill(Color.BLACK);
			}
		});

		hourPane.getChildren().addAll(hourCircle, hourName);

		return hourPane;
	}


	protected void onHourSelected(StackPane hourPane) {

		selectedValueNodeXPosition.unbind();
		selectedValueNodeYPosition.unbind();

		Circle circle = (hourPane != null ? (Circle) hourPane.getChildren().get(0) : null);
		selectedHourCircle.set(circle);

		if (hourPane != null) {
			selectedValueNodeXPosition.bind(hourPane.layoutXProperty().add(HOUR_DIAMETER));
			selectedValueNodeYPosition.bind(hourPane.layoutYProperty().add(HOUR_DIAMETER));
		}
	}
}
