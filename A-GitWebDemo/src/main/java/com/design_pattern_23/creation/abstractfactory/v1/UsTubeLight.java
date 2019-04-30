package com.design_pattern_23.creation.abstractfactory.v1;

public class UsTubeLight implements ITubeLight {

	@Override
	public void switchOn() {
		System.out.println("switchOn UsTubeLight ..");

	}

	@Override
	public void switchOff() {
		System.out.println("switchOff UsTubeLight ..");

	}

	@Override
	public void controlLight() {
		System.out.println("controlLight UsTubeLight ..");

	}

}
