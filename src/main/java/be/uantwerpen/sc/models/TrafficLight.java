package be.uantwerpen.sc.models;

import be.uantwerpen.sc.models.links.Link;
import be.uantwerpen.sc.models.points.Point;

import javax.persistence.*;

/**
 * Created by Quentin Van Ravels on 26-Apr-17.
 */

@Entity
@DiscriminatorValue("light")
@Table(name = "trafficlight", schema = "", catalog = "\"robotDB\"") //RBackend
//Completely implemented in RBackend
public class TrafficLight
{
    /**
     * Traffic Light ID
     */
    private Long id;
    private String direction;
    private int placeLink;
    private String state;
    private Link link;
    //RCore
//    @ElementCollection(targetClass=Point.class)
    private int pointid;

    @Id
    @Column(name = "\"idtlight\"")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "direction")
    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    @Basic
    @Column(name = "state")
    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    //RCore
    public int getPointid() {
        return pointid;
    }

    //Rcore
    public void setPointid(int pointid) {
        this.pointid = pointid;
    }
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TrafficLight that = (TrafficLight) o;

        if(id != that.id) return false;
        if(direction != null ? !direction.equals(that.direction) : that.direction != null) return false;
        if(state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int)(id % Integer.MAX_VALUE);

        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);

        return result;
    }


    @OneToOne
    @JoinColumn(name = "\"link\"", referencedColumnName = "lid")
    public Link getLink()
    {
        return link;
    }

    public void setLink(Link link)
    {
        this.link = link;
    }

    @Basic
    @Column(name = "\"linkprogress\"")
    public int getPlaceLink()
    {
        return placeLink;
    }

    public void setPlaceLink(int placeLink)
    {
        this.placeLink = placeLink;
    }
}