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
}
