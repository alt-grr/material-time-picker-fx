package org.fxmisc.material_time_picker_fx.dials;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;

public abstract class ClockDial extends Pane {

	protected static final double DIAL_DIAMETER = 250d;

	protected static final double DIAL_RADIUS = DIAL_DIAMETER / 2;


	protected final ObjectProperty<Integer> selectedValue = new SimpleObjectProperty<>(null);


	protected final DoubleProperty selectedValueNodeXPosition = new SimpleDoubleProperty(0d);

	protected final DoubleProperty selectedValueNodeYPosition = new SimpleDoubleProperty(0d);


	public ClockDial() {
	}

	public ClockDial(Integer value) {
	}


	public Integer getSelectedValue() {
		return selectedValue.get();
	}

	public void setSelectedValue(Integer selectedValue) {
		this.selectedValue.set(selectedValue);
	}

	public ObjectProperty<Integer> selectedValueProperty() {
		return selectedValue;
	}


	// Private and protected methods

	protected final void initialize(Integer value) {

		CircularPane dialPane = createDialPane();
		dialPane.setShowDebug(Paint.valueOf("#345678"));

		setupUnitPanes(dialPane);

		Line unitHand = createUnitHand();
		Circle dialBackground = createDialBackground();
		Circle dialCenter = createDialCenter();

		getChildren().addAll(dialBackground, unitHand, dialCenter, dialPane);

		setupSelectedValueListener(value);
	}

	private CircularPane createDialPane() {

		CircularPane dialPane = new CircularPane();
		dialPane.setDiameter(DIAL_DIAMETER);
		dialPane.setStartAngle(15d);
		dialPane.setAnimationInterpolation(CircularPane::animateFromTheOrigin);

		return dialPane;
	}

	protected abstract void setupUnitPanes(CircularPane dialPane);

	private Line createUnitHand() {

		Line unitHand = new Line();
		unitHand.endXProperty().bind(selectedValueNodeXPosition);
		unitHand.endYProperty().bind(selectedValueNodeYPosition);

		unitHand.setStrokeType(StrokeType.OUTSIDE);
		unitHand.setStroke(Color.valueOf("#009688"));

		selectedValue.addListener((observable, oldValue, newValue) -> {

			if (newValue == null) {
				unitHand.setVisible(false);
			} else {
				unitHand.setStartX(DIAL_RADIUS);
				unitHand.setStartY(DIAL_RADIUS);
				unitHand.setVisible(true);
			}
		});

		return unitHand;
	}

	private Circle createDialBackground() {
		return new Circle(DIAL_RADIUS, DIAL_RADIUS, DIAL_RADIUS - 5, Color.valueOf("#F5F5F5"));
	}

	private Circle createDialCenter() {
		return new Circle(DIAL_RADIUS, DIAL_RADIUS, 1);
	}

	protected abstract void setupSelectedValueListener(Integer value);
}
