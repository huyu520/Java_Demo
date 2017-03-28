package com.intoms.Thread;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.com.intoms.Thread.Ball;

public class Bounce {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame jFrame = new BounceFrame();
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame.setVisible(true);
			}
		});
	}
}
class BounceFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1453799772870689145L;
	
	private BallComponent component ;
	
	private static final int DEFAULT_WIDTH = 450 ;
	private static final int DEFAULT_HEIGHT = 350 ;
	public static final int DELAY = 3;
	
	public BounceFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Bounce");
		component = new BallComponent() ;
		add(component, BorderLayout.CENTER);
		
		JPanel jPanel = new JPanel();
		addButton(jPanel, "Start", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});
		addButton(jPanel, "Close", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(jPanel, BorderLayout.SOUTH);
	}
	
	public void addButton(Container c, String title ,ActionListener aListener){
		JButton jb = new JButton(title) ;
		c.add(jb);
		jb.addActionListener(aListener);
	}
	
	public void addBall(){
		Ball ball = new Ball();
		component.add(ball);
		Runnable runnable = new BallRunnable(ball, component);
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
class BallRunnable implements Runnable{
	
	private Component component ;
	private Ball ball ;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000*100;
	public static final int DELAY = 5;
	
	public BallRunnable(Ball ball ,Component component) {
		this.ball = ball ;
		this.component = component ;
	}
	
	@Override
	public void run() {
		for( int i = 0 ;i <=STEPS ;i++ ){
			try {
				ball.move(component.getBounds());
				component.repaint(); 
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
