import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ParticleSimulation extends JPanel implements ActionListener {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int PARTICLE_RADIUS = 10;
    public static final int NUMBER_OF_PARTICLES = 100;
    private ParticleSystem particleSystem = new ParticleSystem();

    public ParticleSimulation() {
        for (int i = 0; i < NUMBER_OF_PARTICLES; i++) {
            int xDisplacement = (int) (Math.random() * 800);
            int yDisplacement = (int) (Math.random() * 600);
            int xVelocity = (int) (Math.random() * 10) - 5;
            int yVelocity = (int) (Math.random() * 10) - 5;

            Particle particle = new Particle(
                xDisplacement,
                yDisplacement,
                xVelocity,
                yVelocity,
                PARTICLE_RADIUS
            );
            particleSystem.addParticle(particle);
        }

        Timer timer = new Timer(30, this);
        timer.start();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        particleSystem.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        particleSystem.update();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Particle Simulation");
        ParticleSimulation panel = new ParticleSimulation();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
}
