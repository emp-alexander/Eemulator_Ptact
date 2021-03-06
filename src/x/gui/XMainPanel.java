package x.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class XMainPanel extends JPanel {
	
	public static JPanel leftGroupPanel;
	public static JPanel centerGroupPanel;
	public static JPanel rightGroupPanel;
	public static XMapInfoPanel mapInfoPanel;
	public static XEventsInfoPanel eventsInfoPanel;
	public static XMapPanel mapPanel;
	public static XControlPanel controlPanel;
	public static XCellInfoPanel cellInfoPanel;
	
	public XMainPanel() {
		setupView();
		setupGroupPanels();
		setupMapInfoPanel();
		setupEventsInfoPanel();
		setupMapPanel();
		setupControlPanel();
		setupCellInfoPanel();
		
		setVisible(true);
	}
	private void setupView() {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	
	private void setupGroupPanels() {
		leftGroupPanel = new JPanel();
		leftGroupPanel.setLayout(new BoxLayout(leftGroupPanel, BoxLayout.Y_AXIS));
		add(leftGroupPanel);
		centerGroupPanel = new JPanel();
		centerGroupPanel.setLayout(new BoxLayout(centerGroupPanel, BoxLayout.Y_AXIS));
		add(centerGroupPanel);
		rightGroupPanel = new JPanel();
		rightGroupPanel.setLayout(new BoxLayout(rightGroupPanel, BoxLayout.Y_AXIS));
		add(rightGroupPanel);
	}
	private void setupMapInfoPanel() {
			mapInfoPanel = new XMapInfoPanel();
			leftGroupPanel.add(mapInfoPanel);
		}
		
		private void setupEventsInfoPanel() {
			eventsInfoPanel = new XEventsInfoPanel();
			leftGroupPanel.add(eventsInfoPanel);
		}
		
		private void setupMapPanel() {
			mapPanel = new XMapPanel();
			centerGroupPanel.add(mapPanel);
		}
		
		private void setupControlPanel() {
			controlPanel = new XControlPanel();
			centerGroupPanel.add(controlPanel);
		}
		
		private void setupCellInfoPanel() {
		cellInfoPanel = new XCellInfoPanel();
		rightGroupPanel.add(cellInfoPanel);
		}	
}
