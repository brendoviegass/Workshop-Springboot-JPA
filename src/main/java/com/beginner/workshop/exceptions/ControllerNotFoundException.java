package com.beginner.workshop.exceptions;

public class ControllerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControllerNotFoundException(Object id) {
		super("Controller not found - Id: " + id);
	}

}
