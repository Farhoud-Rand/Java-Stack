package com.example.NinjaGold;

public class MessageOutput {
	private String output;
	private String color;


	public MessageOutput(String output, String color) {
		this.output = output;
		this.color = color;
	}

	public MessageOutput() {
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
