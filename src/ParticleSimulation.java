public class ParticleSimulation {

    public static final float PARTICLE_RADIUS = 1;
    public static final int NUMBER_OF_PARTICLES = 10;
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
    }

    public static void main(String[] args) {}
}
