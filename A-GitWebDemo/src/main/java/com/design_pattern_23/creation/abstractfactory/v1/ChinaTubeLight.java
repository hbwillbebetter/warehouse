package com.design_pattern_23.creation.abstractfactory.v1;

public class ChinaTubeLight implements ITubeLight {

	@Override
	public void switchOn() {
		System.out.println("switchOn ChinaTubeLight ..");

	}

	@Override
	public void switchOff() {
		System.out.println("switchOff ChinaTubeLight ..");

	}

	@Override
	public void controlLight() {
		System.out.println("controlLight ChinaTubeLight ..");

	}

}
