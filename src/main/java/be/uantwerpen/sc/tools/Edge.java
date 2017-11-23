package be.uantwerpen.sc.tools;

import be.uantwerpen.sc.models.Link;


/**
 * Edge Class
 * Mainly data, no function
 * TODO: Comment
 */
//RBackend
public class Edge
{
    /**
     * Edge Target TODO
     */
    private Long target;

    /**
     * Weight of Edge TODO
     */
    private int weight;

    /**
     * Link TODO
     */
    private Link linkEntity;

    /**
     * Create Edge using given Target, Weight and Link TODO
     * @param argTarget
     * @param argWeight
     * @param linkEntity
     */
    public Edge(Long argTarget, int argWeight, Link linkEntity)
    {
        target = argTarget;
        weight = argWeight;
        this.linkEntity = linkEntity;
    }

    /**
     * Create Edge using given Target and Weight, no Link TODO
     * @param argTarget
     * @param argWeight
     */
    public Edge(Long argTarget, int argWeight)
    {
        target = argTarget;
        weight = argWeight;
    }

    /**
     * Return Target TODO
     * @return Edge Target
     */
    public Long getTarget()
    {
        return target;
    }

    /**
     * Set Edge Target
     * @param target New Edge Target
     */
    public void setTarget(Long target)
    {
        this.target = target;
    }

    /**
     * Return Weight TODO
     * @return Edge Weight
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Set Edge Weight
     * @param weight New Edge Weight
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    /**
     * Return Edge Link TODO
     * @return Edge Link
     */
    public Link getLinkEntity()
    {
        return linkEntity;
    }

    /**
     * Set Edge Link
     * @param linkEntity Edge Link
     */
    public void setLinkEntity(Link linkEntity)
    {
        this.linkEntity = linkEntity;
    }
    //RCore
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(Vertex.class.isAssignableFrom(obj.getClass())) {
            final Vertex other = (Vertex) obj;
            if ((this.target == -1) ? (other.getId() != -1) : !(this.target == other.getId())) {
                return false;
            }
            return true;
        }else if(Edge.class.isAssignableFrom(obj.getClass())){
            final Edge other = (Edge) obj;
            if ((this.target == -1) ? (other.getTarget() != -1) : !(this.target == other.getTarget())) {
                return false;
            }
            return true;
        }
        return false;
    }
}
