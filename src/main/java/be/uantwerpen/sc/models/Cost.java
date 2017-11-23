package be.uantwerpen.sc.models;

/**
 * Model that describes a cost request.
 */
public class Cost {
    private boolean status; // Status describing the availabity of the vehicle.
    private int weightToStart; // Weight from current position to start position of route. In Seconds.
    private int weight; // Weight from start position to end position of route. In Seconds.
    private Long idVehicle; // ID of the vehicle being requested.

    public Cost(){

    }
    /**
     * Model that describes a simulation of a Jar.
     *
     * @param status Status describing the availabity of the vehicle.
     * @param weightToStart Weight from current position to start position of route. In Seconds.
     * @param weight Weight from start position to end position of route. In Seconds.
     * @param idVehicle ID of the vehicle being requested.f
     */
    public Cost(boolean status, int weightToStart, int weight, Long idVehicle){
        this.status = status;
        this.weightToStart = weightToStart;
        this.weight = weight;
        this.idVehicle = idVehicle;
    }

    public boolean getStatus()
    {
        return status;
    }
    /**
     * Set the status of the vehicle being requested. Available means true, already on a route means false.
     *
     * @param status The status of the vehicle being requested. Available means true, already on a route means false.
     */
    public void setStatus(boolean status)
    {
        this.status = status;
    }

    /**
     * Get the weight between the current position and the start position of the route. In seconds.
     *
     * @return The weight between the current position and the start position of the route. In seconds.
     */
    public int getWeightToStart()
    {
        return weightToStart;
    }

    public void setWeightToStart(int w)
    {
        this.weightToStart = w;
    }

    /**
     * Get the weight between the start position and the end position of the route. In seconds.
     *
     * @return The weight between the start position and the end position of the route. In seconds.
     */
    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int w)
    {
        this.weight = w;
    }

    public Long getIdVehicle()
    {
        return idVehicle;
    }
    /**
     * Set the ID of the vehicle being requested to calculate cost.
     *
     * @param id The ID of the vehicle being requested to calculate cost.
     */
    public void setIdVehicle(Long id)
    {
        this.idVehicle = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cost cost = (Cost) o;

        if (status != cost.status) return false;
        if (weightToStart != cost.weightToStart) return false;
        if (weight != cost.weight) return false;
        return idVehicle.equals(cost.idVehicle);
    }
}
