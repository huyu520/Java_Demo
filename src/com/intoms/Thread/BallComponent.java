package com.intoms.Thread;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import src.com.intoms.Thread.Ball;

public class BallComponent extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1290391845304698156L;
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public void add(Ball ball){
		balls.add(ball);
	}
	
	public void patientComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g ;
		for(Ball b : balls){
			g2.fill(b.getShape());
		}
	}
}
