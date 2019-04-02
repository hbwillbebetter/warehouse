package com.design_pattern_23.structural.adapter.v1;

public class Vga2HdmiAdapter implements IHdmi {
	
	private IVga vgaDisplay;
	
	public Vga2HdmiAdapter(IVga vgaDisplay) {
		this.vgaDisplay = vgaDisplay;
	}
	
	@Override
	public void openHdmi() {
		//适配逻辑
		this.vgaDisplay.openVga();
		System.out.println("Opening Hdmi Device");
	}

}
