package br.com.fean.si.poo2.projetounikahair.zexemplos;
import java.awt.Color;
import javax.swing.JFrame;

public class TesteGradient {
	
	    public static void main(String[] args) {
	        JFrame frame = new JFrame();
	        JGradientPanel panel = new JGradientPanel(Color.WHITE, Color.BLUE);
	        frame.setContentPane(panel);
	        frame.setSize(640, 480);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setVisible(true);
	    }
	}

