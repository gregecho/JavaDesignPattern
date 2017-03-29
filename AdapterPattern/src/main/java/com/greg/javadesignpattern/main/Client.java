package com.greg.javadesignpattern.main;

import com.greg.javadesignpattern.Target.*;
import com.greg.javadesignpattern.utils.XMLUtil;

public class Client {

	public static void main(String[] args) {
		ScoreOperation operation;
		operation = (ScoreOperation) XMLUtil.getBean();
		int scores[] = { 84, 76, 50, 69, 90, 91, 88, 96 };
		int result[];
		int score;

		System.out.println("Score sort result");
		result = operation.sort(scores);

		for (int i : scores) {
			System.out.print(i + ",");
		}
		System.out.println();

		System.out.println("search score 90");
		score = operation.search(result, 90);
		if (score != -1) {
			System.out.println("found score 90");
		} else {
			System.out.println("not found 90");
		}

		System.out.println("search score 92");
		score = operation.search(result, 92);
		if (score != -1) {
			System.out.println("found 92");
		} else {
			System.out.println("not found 92");
		}
	}

}
