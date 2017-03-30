package com.greg.javadesignpattern.command;

import com.greg.javadesignpattern.receiver.HelpHandler;

public class HelpCommand extends Command {

	private HelpHandler hhObj;

	public HelpCommand() {
		hhObj = new HelpHandler();
	}

	public void execute() {
		hhObj.display();
	}

}
