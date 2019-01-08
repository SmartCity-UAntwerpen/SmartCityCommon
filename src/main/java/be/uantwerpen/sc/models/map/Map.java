package be.uantwerpen.sc.models.map;

import be.uantwerpen.sc.models.Bot;
import be.uantwerpen.sc.models.TrafficLight;
import be.uantwerpen.sc.tools.pathplanning.AbstractMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Map of the area
 * Data class
 */
@Deprecated
public class Map implements AbstractMap
{
    /**
     * List of nodes on map
     */
    private List<Node> nodeList;

    /**
     * List of bots on map
     */
    private List<Bot> botEntities;

    /**
     * List of traffic lights on map
     */
    private List<TrafficLight> trafficlightEntity;

    /**
     * Default Constructor
     */
    public Map(){
        nodeList = new ArrayList<>();
        botEntities = new ArrayList<>();
    }

    /**
     * Adds Node to map
     * @param node node to map
     */
    public void addNode(Node node){
        nodeList.add(node);
    }

    /**
     * Sets List of map nodes
     * @param nodeList list of nodes to set
     */
    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    /**
     * Gets list of map nodes
     * @return list of nodes
     */
    public List<Node> getNodeList()
    {
        return nodeList;
    }

    /**
     * Sets List of map Bots
     * @param botEntities
     */
    public void setBotEntities(List<Bot> botEntities) {
        this.botEntities = botEntities;
    }

    /**
     * Gets list of map bots
     * @return list of map bots
     */
    public List<Bot> getBotEntities() {
        return botEntities;
    }

    /**
     * Sets List of Map Traffic Lights
     * @param trafficlightEntity List of Map TrafficLights
     */
    public void setTrafficlightEntity(List<TrafficLight> trafficlightEntity) {
        this.trafficlightEntity = trafficlightEntity;
    }

    /**
     * Gets List of Map TrafficLights
     * @return List of Map TrafficLights
     */
    public List<TrafficLight> getTrafficlightEntity() {
        return trafficlightEntity;
    }
    //RCORE
    public boolean isEndPoint(String s){
        for (int i = 0; i < getNodeList().size(); i++) {
            if(s.equals(getNodeList().get(i).getPointEntity().getRfid())){
                if(getNodeList().get(i).getNeighbours().size()<2)
                    return true;
            }
        }
        return false;

    }
    //RCORE
    public String changeLookingDir(Long linkid, String rfidTag){
        for (int i = 0; i < getNodeList().size(); i++) {
            if (rfidTag.equals(getNodeList().get(i).getPointEntity().getRfid())) {
                for (int j = 0; j < getNodeList().get(i).getNeighbours().size(); j++) {
                    if (linkid == getNodeList().get(i).getNeighbours().get(j).getId()) {
                        switch(getNodeList().get(i).getNeighbours().get(j).getStopDirection()){
                            case "N":
                                return "Z";
                            case "E":
                                return "W";
                            case "Z":
                                return "N";
                            case "W":
                                return "E";
                        }
                    }
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "AbstractMap{" +
                "nodeList=" + nodeList +
                ", botEntities=" + botEntities +
                ", trafficlightEntity=" + trafficlightEntity +
                '}';
    }
}

