package be.uantwerpen.sc.models.points;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by quent on 5/17/2017.
 */
//Not in RBackend
@Entity
@Table(name="point_drone", schema = "", catalog = "core")
@Deprecated
public class PointDrone extends Point {

    private float x;
    private float y;
    private float z;

    @Basic
    @Column(name = "x")
    public float getX(){return x;}
    public void setX(float x){this.x = x;}

    @Basic
    @Column(name = "y")
    public float getY(){return y;}
    public void setY(float y){this.y = y;}

    @Basic
    @Column(name = "z")
    public float getZ(){return z;}
    public void setZ(float z){this.z = z;}

    @Override
    public String toString()
    {
        return "{" +
                "\"id\":" + getId() +
                ", \"x\":" + getX() +
                ", \"y\":" + getY() +
                ", \"z\":" + getZ() +
                '}';
    }
}
