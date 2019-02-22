package edu.neumont.kinsey.controller;

import edu.neumont.kinsey.view.PongView;

public class PongController {

	private PongView view;

	public PongController(PongView view) {
		this.view = view;
		this.view.registerController(this);
	}

	public void run() {
		this.view.init();
	}
}
