package be.uantwerpen.sc.models.map;

import be.uantwerpen.sc.models.links.Link;
import be.uantwerpen.sc.models.points.Point;
import be.uantwerpen.sc.tools.pathplanning.AbstractMap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
//RBackend
public class MapNew implements AbstractMap
{
    private List<Point> pointList;
    private List<Link> linkList;

    public MapNew(){
        pointList = new ArrayList<>();
        linkList = new ArrayList<>();
    }

    public void addPoint(Point point){
        pointList.add(point);
    }

    public void addLink(Link link){
        linkList.add(link);
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public List<Link> getLinkList()
    {
        return linkList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public List<Point> getPointList()
    {
        return pointList;
    }

    @Override
    public String toString() {
        return "AbstractMap{" +
                "pointList=" + pointList +
                ", linkList=" + linkList +
                '}';
    }
}
