package com.design_pattern_23.structural.adapter.v1;

//将VGA显示器通过适配器，适配到笔记本的Hdmi接口
public class LaptopMain {

	public static void main(String[] args) {
		VgaDisplay vgaDisplay = new VgaDisplay();
		Vga2HdmiAdapter adapter = new Vga2HdmiAdapter(vgaDisplay);
		operateHdmiLaptop(adapter);
	}

	private static void operateHdmiLaptop(IHdmi adapter) {
		adapter.openHdmi();
	}

}
