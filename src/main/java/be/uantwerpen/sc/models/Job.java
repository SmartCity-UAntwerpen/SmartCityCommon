package be.uantwerpen.sc.models;

import be.uantwerpen.sc.models.MyAbstractPersistable;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *  NV 2018
 */
@Entity

public class Job extends MyAbstractPersistable<Long> {

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "ID_ORDER")
    private JobList jobList;

    private long idStart;
    private long idEnd;
    /**
     * Start en einde zijn steeds in dezelfde map
     */
    private int idMap;
    private String status;

    public Job() {

    }

    public Job(Long idStart, Long idEnd, int idMap) {
        this.idStart = idStart;
        this.idEnd = idEnd;
        this.idMap = idMap;
        this.status = "TODO";
    }

    public String toString(){
        return "[ start: "+idStart+" - end:"+idEnd+" ] map:" + idMap;
    }

    public long getIdStart() {
        return idStart;
    }

    public void setIdStart(long idStart) {
        this.idStart = idStart;
    }

    public long getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(long idEnd) {
        this.idEnd = idEnd;
    }

    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JobList getJobList() {
        return jobList;
    }

    public void setJobList(JobList jobList) {
        this.jobList = jobList;
    }
}