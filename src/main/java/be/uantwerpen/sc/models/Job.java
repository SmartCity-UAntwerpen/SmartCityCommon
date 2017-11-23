package be.uantwerpen.sc.models;

/**
 * Job Data Class
 */
//Copied from RBackbone
public class Job
{
    /**
     * ID of Job
     */
    private long jobId;

    /**
     * ID of the start waypoint
     * TODO: Jobs are more variable than this
     */
    private long idStart;

    /**
     * ID of the end  waypoint
     * TODO: Jobs are more variable than this
     */
    private long idEnd;

    /**
     * ID of Vehicle
     */
    private long idVehicle;

    //Copied from RCore
    private String jobDescription;

//MAAS
    private String typeVehicle;
    private String Status;
    /**
     * Default Constructor
     * TODO Better
     */
    public Job(){}

    /**
     * Todo jobid
     * @param jobDescription
     */
    public Job(String jobDescription)
    {
        this(0L, jobDescription);
    }

    /**
     * Create Job with defined ID and description
     * @param jobId
     * @param jobDescription
     */
    public Job(Long jobId, String jobDescription)
    {
        this.jobId = jobId;
        this.jobDescription=jobDescription;
    }
    /**
     * Model that describes a job request.
     *
     * @param jobId ID of the job
     * @param idStart ID of the start waypoint of the route
     * @param idEnd ID of the end waypoint of the route
     * @param idVehicle ID of the vehicle
     */
    public Job(Long jobId, Long idStart, Long idEnd, Long idVehicle) {
        this.jobId = jobId;
        this.idStart = idStart;
        this.idEnd = idEnd;
        this.idVehicle = idVehicle;
    }
    /**
     * Get Job ID
     * @return ID of Job
     */
    public Long getJobId()
    {
        return jobId;
    }

    /**
     * Set Job ID
     * @param jobId ID of Job
     */
    public void setJobId(Long jobId)
    {
        this.jobId = jobId;
    }

    //RCore
    public String getJobDescription()
    {
        return jobDescription;
    }

    //RCore
    public void setJobDescription(String jobDescription)
    {
        this.jobDescription = jobDescription;
    }
    /**
     * Get Start waypoint ID
     * @return Start Point ID
     */
    public Long getIdStart()
    {
        return idStart;
    }

    /**
     * Set Start waypoint ID
     * @param idStart Start Point ID
     */
    public void setIdStart(Long idStart)
    {
        this.idStart = idStart;
    }

    /**
     * Get End waypoint ID
     * @return End Point ID
     */
    public Long getIdEnd()
    {
        return idEnd;
    }

    /**
     * Set End waypoint ID
     * @param idEnd End Point ID
     */
    public void setIdEnd(Long idEnd)
    {
        this.idEnd = idEnd;
    }

    /**
     * Get ID of related Job Vehicle
     * @return ID of Vehicle
     */
    public Long getIdVehicle()
    {
        return idVehicle;
    }

    /**
     * Set ID of Job Vehicle
     * @param idVehicle ID of vehicle
     */
    public void setIdVehicle(Long idVehicle)
    {
        this.idVehicle = idVehicle;
    }
    //MAAS
    public String getTypeVehicle() {
        return typeVehicle;
    }
    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    //MAAS
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString()
    {
        return "Job{" +
                "jobId=" + jobId +
                '}';
    }
}
