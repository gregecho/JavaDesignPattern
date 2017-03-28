package com.greg.javadesignpattern.Factory;

import com.greg.javadesignpattern.Product.*;

public class SpringSkinFactory implements SkinFactory {

	@Override
	public Button createButton() {
		return new SpringButton();
	}

	@Override
	public TextBox createTextBox() {
		return new SpringTextBox();
	}

}
