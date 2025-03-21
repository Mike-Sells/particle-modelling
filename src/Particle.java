public class Particle {

    private float xDisplacement, yDisplacement;
    private float xVelocity, yVelocity;
    private float radius;

    public Particle(
        float xDisplacement,
        float yDisplacement,
        float xVelocity,
        float yVelocity,
        float radius
    ) {
        this.xDisplacement = xDisplacement;
        this.yDisplacement = yDisplacement;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
    }

    public void update() {
        xDisplacement += xVelocity;
        yDisplacement += yVelocity;

        if (xDisplacement < 0 || xDisplacement > 800) xVelocity = -xVelocity;
        if (yDisplacement < 0 || yDisplacement > 800) yVelocity = -yVelocity;
    }
}
