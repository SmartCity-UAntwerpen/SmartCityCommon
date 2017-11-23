package be.uantwerpen.sc.models;

/**
 * Model that describes a location and the progress on a route. When start and end are the same
 * the vehicle is stationary. Then the percentage will be 100% as well.
 */
public class Location {


    private long vehicleID; // ID of the vehicle
    private long startID; // Waypoint ID of the starting location of the route.
    private long stopID; // Waypoint ID of the end location of the route.
    private int percentage; // Percentage of the route completed between start and end.

    public Location(){

    }
    /**
     * Model that describes a location and the progress on a route. When start and end are the same
     * the vehicle is stationary. Then the percentage will be 100% as well.
     *
     * @param vehicleID ID of the vehicle
     * @param startID Waypoint ID of the starting location of the route.
     * @param stopID Waypoint ID of the end location of the route.
     * @param percentage Percentage of the route completed between start and end.
     */
    public Location(long vehicleID, long startID, long stopID, int percentage){
        this.vehicleID = vehicleID;
        this.startID = stopID;
        this.stopID  = stopID;
        this.percentage = percentage;
    }

public Long getStartID()
    {
        return startID;
    }

    /**
     * Set the start ID of the route.
     *
     * @param startID Waypoint ID of the starting location of the route.
     */
    public void setStartID(Long startID)
    {
        this.startID = startID;
    }
    /**
     * Get the end ID of the route.
     *
     * @return Waypoint ID of the ending location of the route.
     */
    public Long getStopID()
    {
        return stopID;
    }
    /**
     * Set the end ID of the route.
     *
     * @param stopID Waypoint ID of the ending location of the route.
     */
    public void setStopID(Long stopID)
    {
        this.stopID = stopID;
    }
    /**
     * Get the percentage completed of the route.
     *
     * @return Percentage completed of the route.
     */
    public int getPercentage()
    {
        return percentage;
    }
    /**
     * Set the percentage completed of the route.
     *
     * @param percentage Percentage completed of the route.
     */
    public void setPercentage(int percentage)
    {
        this.percentage = percentage;
    }

    public Long getVehicleID()
    {
        return vehicleID;
    }

    public void setVehicleID(Long v)
    {
        this.vehicleID = v;
    }

}
