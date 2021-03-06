package de.epsdev.plugins.MMO.particles;

import de.epsdev.plugins.MMO.tools.Vec2d;
import de.epsdev.plugins.MMO.tools.Vec2f;
import org.bukkit.Location;
import org.bukkit.Particle;

import java.util.ArrayList;
import java.util.List;

public class EF_Particle_Ring extends Particle_Effect{

    public double radius;
    public int ringPoints;
    public List<Vec2d> offsets;

    public EF_Particle_Ring(ParticleConfig config, double radius, int points){
        super(config);

        this.radius = radius;
        this.ringPoints = points;
        this.offsets = this.calcOffsets();
        super.name = "circle";
    }

    private List<Vec2d> calcOffsets(){
        List<Vec2d> offsets = new ArrayList<>();

        for (float i = 0; i < 360; i+=(360 / this.ringPoints)) {
            double x = radius * Math.cos(Math.toRadians(i));
            double y = radius * Math.sin(Math.toRadians(i));

            offsets.add(new Vec2d(x,y));
        }

        return offsets;
    }

    @Override
    public void display(Location location) {
        for (Vec2d offset : this.offsets){
            Location l = new Location(location.getWorld(), location.getX() + offset.x, location.getY(), location.getZ() + offset.y);
            super.renderParticle(l);
        }
    }

    @Override
    public String genData() {

        String ret = super.name + ">>" + super.config.particle.name() + ">>" + this.radius + ">>" + this.ringPoints;

        if(super.config.color != null){
            ret += ">>" + super.config.color.o_r;
            ret += ">>" + super.config.color.o_g;
            ret += ">>" + super.config.color.o_b;
        }

        return ret;
    }
}
