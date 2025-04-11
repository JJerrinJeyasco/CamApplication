package com.Camera.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

public class CameraStyleApp {
    private FrameGrabber grabber;
    private CanvasFrame canvas;
    private boolean running = true;
    private JPanel controlPanel;

    public static void main(String[] args) {
        new CameraStyleApp().start();
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            try {
                // Create main frame
                JFrame mainFrame = new JFrame("Camera App");
                mainFrame.setLayout(new BorderLayout());
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create video display
                canvas = new CanvasFrame("Camera Feed");
                canvas.setCanvasSize(640, 480);
                
                // Create control panel with camera-style layout
                controlPanel = new JPanel(new BorderLayout()) {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        // Draw semi-transparent black background
                        g.setColor(new Color(0, 0, 0, 200));
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                controlPanel.setPreferredSize(new Dimension(200, 220));
                
                // Create camera-style snapshot button
                JButton snapButton = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        
                        // Outer white ring
                        g2.setColor(Color.WHITE);
                        g2.fill(new Ellipse2D.Double(5, 5, 70, 70));
                        
                        // Inner red circle (camera button)
                        g2.setColor(new Color(255, 60, 60));
                        g2.fill(new Ellipse2D.Double(15, 15, 50, 50));
                        
                        // Inner white ring when pressed
                        if (getModel().isPressed()) {
                            g2.setColor(new Color(255, 255, 255, 150));
                            g2.fill(new Ellipse2D.Double(20, 20, 40, 40));
                        }
                        g2.dispose();
                    }
                    
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(80, 80);
                    }
                };
                
                snapButton.setContentAreaFilled(false);
                snapButton.setBorderPainted(false);
                snapButton.setFocusPainted(false);
                snapButton.addActionListener(e -> takeSnapshot());
                
                // Add flash animation effect
                snapButton.addActionListener(e -> {
                    canvas.getCanvas().setBackground(Color.WHITE);
                    Timer timer = new Timer(100, ev -> {
                        canvas.getCanvas().setBackground(Color.BLACK);
                        ((Timer)ev.getSource()).stop();
                    });
                    timer.setRepeats(false);
                    timer.start();
                });

                // Exit button styled as back button
                JButton exitButton = new JButton("✕");
                exitButton.setFont(new Font("Arial", Font.BOLD, 20));
                exitButton.setContentAreaFilled(false);
                exitButton.setForeground(Color.WHITE);
                exitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                exitButton.addActionListener(e -> stopCamera());
                
                // Layout components
                JPanel centerPanel = new JPanel(new GridBagLayout());
                centerPanel.setOpaque(false);
                centerPanel.add(snapButton);
                
                JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                topPanel.setOpaque(false);
                topPanel.add(exitButton);
                
                controlPanel.add(topPanel, BorderLayout.NORTH);
                controlPanel.add(centerPanel, BorderLayout.CENTER);
                
                // Add components to main frame
                mainFrame.add(canvas.getCanvas(), BorderLayout.CENTER);
                mainFrame.add(controlPanel, BorderLayout.SOUTH);
                
                mainFrame.pack();
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);

                // Initialize camera
                grabber = FrameGrabber.createDefault(0);
                grabber.setImageWidth(640);
                grabber.setImageHeight(480);
                grabber.start();

                // Video capture loop
                new Thread(() -> {
                    try {
                        while (running) {
                            Frame frame = grabber.grab();
                            if (frame != null) {
                                canvas.showImage(frame);
                            }
                            Thread.sleep(30);
                        }
                    } catch (Exception e) {
                        if (running) {
                            showError("Camera Error: " + e.getMessage());
                        }
                    } finally {
                        stopCamera();
                    }
                }).start();
                
            } catch (Exception e) {
                showError("Initialization Error: " + e.getMessage());
            }
        });
    }

    private void takeSnapshot() {
        try {
            Frame frame = grabber.grab();
            if (frame != null) {
                Java2DFrameConverter converter = new Java2DFrameConverter();
                BufferedImage image = converter.convert(frame);
                
                File file = new File("snapshot_" + System.currentTimeMillis() + ".jpg");
                ImageIO.write(image, "jpg", file);
                
                // Show preview animation
                JOptionPane.showMessageDialog(controlPanel,
                    new ImageIcon(image.getScaledInstance(300, -1, Image.SCALE_SMOOTH)),
                    "Snapshot Saved",
                    JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception ex) {
            showError("Failed to take snapshot: " + ex.getMessage());
        }
    }

    private void stopCamera() {
        running = false;
        try {
            if (grabber != null) {
                grabber.stop();
            }
            if (canvas != null) {
                canvas.dispose();
            }
            System.exit(0);
        } catch (Exception e) {
            showError("Error stopping camera: " + e.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(controlPanel,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
