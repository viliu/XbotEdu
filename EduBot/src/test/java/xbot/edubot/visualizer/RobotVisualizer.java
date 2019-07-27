package xbot.edubot.visualizer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;

public class RobotVisualizer {

    JFrame mainWindow;
    FieldAndRobotPanel fieldAndRobot;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RobotVisualizer window = new RobotVisualizer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RobotVisualizer(/* eventually initialize with the test case?*/) {
        initialize();
    }

    private void initialize() {
        mainWindow = new JFrame();
        mainWindow.setVisible(true);
        mainWindow.setTitle("Robot Visualizer");
        mainWindow.setSize(800, 600);

        JSplitPane splitPane = new JSplitPane();
        mainWindow.getContentPane().add(splitPane);
        
        //vizPanel = new LinearVisualizationPanel(800, 500);
        //splitPane.setLeftComponent(vizPanel);
        
        JPanel controlPanel = new JPanel();
        splitPane.setRightComponent(controlPanel);
        
        JSlider speedSlider = new JSlider();
        speedSlider.setMinimum(1);
        speedSlider.setValue(10);
        controlPanel.add(speedSlider);

        FieldAndRobotPanel robotPanel = new FieldAndRobotPanel();
        splitPane.setLeftComponent(robotPanel);
        
        // start doing thing
/*
        while (true) {
            robotPanel.repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */

    }
}