package be.uantwerpen.sc.models.points;

import javax.persistence.*;

/**
 *
 * @author Niels
 * Created by Niels on 24/03/2016.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "point", schema = "", catalog = "core")
public class Point
{
    private Long id;

    private String type; //TODO: figure out different types a point can be
    private String access; //TODO: what types of access
    private Long hub; //TODO: What is the hub
    private int xCoord;
    private int yCoord;
    //RBackend
    private String rfid;
    private int pointLock;

    public Point() {}

    public Point(Long id, int x, int y, String type)
    {
        this.id = id;
        this.xCoord = x;
        this.yCoord = y;
        this.type = type;
    }
    @Id
    @Column(name = "pid")
    //    @Column(name = "idpoint") //RBackend
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
    @Column(name = "type")
    public String getPointType()
    {
        return type;
    }
    public void setPointType(String type)
    {
        this.type =type;
    }

    @Basic
    @Column(name = "hub")
    public Long getHub()
    {
        return hub;
    }

    public void setHub(Long hub)
    {
        this.hub = hub;
    }

    @Basic
    @Column(name = "access")
    public String getAccess()
    {
        return access;
    }

    public void setAccess(String access)
    {
        this.access = access;
    }

    @Basic
    @Column(name = "xcoord")
    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    @Basic
    @Column(name = "ycoord")
    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
   //Backend
    /**
     * Gets Point Lock State
     * @return Point Lock State
     */
    @Basic
    @Column(name = "\"lockedby\"")
    public int getPointLock()
    {
        return pointLock;
    }
//Backend
    /**
     * Set Point Lock State
     * @param pointLock Point Lock State
     */
    public void setPointLock(int pointLock)
    {
        this.pointLock = pointLock;
    }
//Backend
    /**
     * Get Point RFID
     * @return Point RFID
     */
    @Basic
    @Column(name = "rfid")
    public String getRfid()
    {
        return rfid;
    }
//Backend
    /**
     * Set Point RFID
     * @param rfid Point RFID
     */
    public void setRfid(String rfid)
    {
        this.rfid = rfid;
    }

    /**
     * Overrides inherited equals method
     * <p>Commpares class, id and pointType</p>
     *
     * @param o The object o be checked against
     * @return
     */
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Point that = (Point) o;
        if(id != that.id) return false;
        if(rfid != null ? !rfid.equals(that.rfid) : that.rfid != null) return false;        //RBackend
        if(type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    /**
     * Makes a hash for this object based on id and pointType
     *
     * @return The hash
     */
    @Override
    public int hashCode()
    {
        int result = (int)(id % Integer.MAX_VALUE);
        result = 31 * result + (rfid != null ? rfid.hashCode() : 0);        //RBackend
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    //TODO: Again toStringTop
    public String toStringTop()
    {
        return "{" +
                " \"id\" : " + id +
                ", \"x\" : " + xCoord +
                ", \"y\" : " + yCoord +
                ", \"type\" : \"" + access + //pointType refers to vehicle pointType in the Maas
                "\"}";
    }
}
