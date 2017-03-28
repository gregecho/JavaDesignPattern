package com.greg.javadesignpattern.Factory;

import com.greg.javadesignpattern.Product.*;

public interface SkinFactory {
	public Button createButton();
	public TextBox createTextBox();
}
