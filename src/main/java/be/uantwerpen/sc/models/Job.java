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

    private long idStart;
    private long idEnd;
    /**
     * Start en einde zijn steeds in dezelfde map
     */
    private int idMap;
    private JobState status;

    public Job() {

    }

    public Job(Long idStart, Long idEnd, int idMap) {
        this.idStart = idStart;
        this.idEnd = idEnd;
        this.idMap = idMap;
        this.status = JobState.TODO;
    }

    public String toString(){
        return "[ start: "+idStart+" - end:"+idEnd+" ] map:" + idMap + ", state: "+status;
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

    public JobState getStatus() {
        return status;
    }

    public void setStatus(JobState status) {
        this.status = status;
    }

}