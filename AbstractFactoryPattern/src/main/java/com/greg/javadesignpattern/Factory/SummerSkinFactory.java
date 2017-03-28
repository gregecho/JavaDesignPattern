package com.greg.javadesignpattern.Factory;

import com.greg.javadesignpattern.Product.*;

public class SummerSkinFactory implements SkinFactory {

	@Override
	public Button createButton() {
		return new SummerButton();
	}

	@Override
	public TextBox createTextBox() {
		return new SummerTextBox();
	}

}
