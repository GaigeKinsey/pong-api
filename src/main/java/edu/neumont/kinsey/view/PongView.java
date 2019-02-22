package edu.neumont.kinsey.view;

import edu.neumont.kinsey.controller.PongController;

public interface PongView {

	void registerController(PongController pongController);

	void init();

}
