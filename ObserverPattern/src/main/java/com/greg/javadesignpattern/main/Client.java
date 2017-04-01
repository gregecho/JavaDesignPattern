package com.greg.javadesignpattern.main;

import java.util.ArrayList;
import java.util.List;

import com.greg.javadesignpattern.observer.*;
import com.greg.javadesignpattern.subject.*;

public class Client {

	public static void main(String[] args) {
		AllyControlCenter acc;
		acc = new ConcreteAllyControlCenter("LOL");

		Observer player1, player2, player3, player4;

		player1 = new Player("a");
		acc.join(player1);

		player2 = new Player("b");
		acc.join(player2);

		player3 = new Player("c");
		acc.join(player3);

		player4 = new Player("d");
		acc.join(player4);

		player1.beAttacked(acc);
	}
}
