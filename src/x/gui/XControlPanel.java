package x.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import x.logic.XStatistic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class XControlPanel extends JPanel{

	private JButton startButton;
	private JButton pauseButton;
	private JButton stopButton;
	
	public XControlPanel() {
		setupView();
		setupButtons();
		setVisible(true);
	}

	private void setupView() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		
		private void setupButtons() {
			// START
			this.startButton = new JButton();
			startButton.setIcon(new ImageIcon("src\\resources\\gui\\icons\\control-start.png"));
			startButton.setPreferredSize(new Dimension(25, 25)); //размер кнопок
			startButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					XForce.start();
					startButton.setEnabled(false);
					pauseButton.setEnabled(true);
					stopButton.setEnabled(false);
				}
			});
			add(startButton);
			// PAUSE
			this.pauseButton = new JButton();
			pauseButton.setIcon(new ImageIcon("src\\resources\\gui\\icons\\control-pause.png"));
			pauseButton.setPreferredSize(new Dimension(25, 25));
			pauseButton.setEnabled(false);
			pauseButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						XForce.pause();
						startButton.setEnabled(true);
						pauseButton.setEnabled(false);
						stopButton.setEnabled(true);
				}
			});
			add(pauseButton);
			// STOP
			this.stopButton = new JButton();
			stopButton.setIcon(new ImageIcon("src\\resources\\gui\\icons\\control-stop.png"));
			stopButton.setPreferredSize(new Dimension(25, 25));
			stopButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					XForce.stop();
					XStatistic.reset();
					long[][] data = new long[XMapPanel.MAP_SIZE][XMapPanel.MAP_SIZE];
					FileInputStream fis = null;
					ObjectInputStream ois = null;
					try {
						fis = new FileInputStream("src\\resources\\data\\test-data.dat");
						ois = new ObjectInputStream(fis);
						data = (long[][]) ois.readObject();	
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
					finally {
						if (fis != null) {
							try {
								fis.close();
							} 
							catch (IOException ex) {
								ex.printStackTrace();
							}
						}
						if (ois != null) {
							try {
								ois.close();
							} 
							catch (IOException ex) {
								ex.printStackTrace();
							}
						}
					}
					XMapPanel map = XMainPanel.mapPanel;
					for (int y = 0; y < XMapPanel.MAP_SIZE; y++) {
						for (int x = 0; x < XMapPanel.MAP_SIZE; x++) {
							 map.setValueAt(data[y][x], y, x);
						}
					}
					XMainPanel.mapInfoPanel.reset();
					XMainPanel.eventsInfoPanel.reset();
					XMainPanel.cellInfoPanel.reset();
				}
			});
			add(stopButton);	
		}
	
}
	

