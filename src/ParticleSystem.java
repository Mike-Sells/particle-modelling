import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ParticleSystem {

    private List<Particle> particles;

    public ParticleSystem() {
        particles = new ArrayList<>();
    }

    public void addParticle(Particle p) {
        particles.add(p);
    }

    public void update() {
        for (Particle p : particles) {
            p.update();
        }
        handleCollisions();
    }

    public void draw(Graphics g) {
        for (Particle p : particles) {
            p.draw(g);
        }
    }

    public void handleCollisions() {
        for (int i = 0; i < particles.size(); i++) {
            for (int j = i + 1; j < particles.size(); j++) {
                Particle p1 = particles.get(i);
                Particle p2 = particles.get(j);

                if (p1.isColliding(p2)) {
                    p1.resolveCollision(p2);
                }
            }
        }
    }
}
