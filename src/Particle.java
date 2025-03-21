import java.awt.Color;
import java.awt.Graphics;

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

        if (
            xDisplacement < 0 ||
            xDisplacement > ParticleSimulation.WINDOW_WIDTH - radius
        ) xVelocity = -xVelocity;

        if (
            yDisplacement < 0 ||
            yDisplacement > ParticleSimulation.WINDOW_HEIGHT - radius
        ) yVelocity = -yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(
            (int) xDisplacement,
            (int) yDisplacement,
            (int) radius,
            (int) radius
        );
    }

    public boolean isColliding(Particle other) {
        float dx = other.xDisplacement - this.xDisplacement;
        float dy = other.yDisplacement - this.yDisplacement;
        float distanceSquared = dx * dx + dy * dy;
        float radiusSum = this.radius + other.radius;

        return distanceSquared <= radiusSum * radiusSum;
    }

    public void resolveCollision(Particle other) {
        float dx = other.xDisplacement - this.xDisplacement;
        float dy = other.yDisplacement - this.yDisplacement;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        if (distance == 0) return;

        float nx = dx / distance;
        float ny = dy / distance;

        float vx = other.xVelocity - this.xVelocity;
        float vy = other.yVelocity - this.yVelocity;

        float dotProduct = vx * nx + vy * ny;

        if (dotProduct > 0) return;

        float coefficientOfRestitution = 1.0f;

        float impulse = (2 * dotProduct) / (1 + 1);

        this.xVelocity += impulse * nx;
        this.yVelocity += impulse * ny;
        other.xVelocity -= impulse * nx;
        other.yVelocity -= impulse * ny;
    }
}
