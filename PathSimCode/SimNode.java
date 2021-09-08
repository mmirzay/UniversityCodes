
import java.util.ArrayList;
import java.util.HashMap;

// this is a general node class for all types of nodes in the network
/**
 * member classes are author type 0 paper type 1 venue type 2 term type 3
 *
 * RatingUser type = 1 RatedItem type = 2 TrustorUser type = 3 TrusteeUser type
 * = 4
 *
 */
public abstract class SimNode {

    private int id;
    private String data;
    private HashMap<SimNode, String> neighbors = new HashMap<SimNode, String>();
    private double similarity;
    private String metaPath;

    public SimNode(String id, String data) {
        int idint = Integer.parseInt(id);
        this.id = idint;
        this.data = data;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public HashMap<SimNode, String> getNeighbors() {
        return this.neighbors;
    }

    // setters
    public void setId(String id) {
        int idint = Integer.parseInt(id);
        this.id = idint;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNeighbors(SimNode node, String value) {
        this.neighbors.put(node, value);
    }
    
    public void setSimilarity(double sim){
        similarity = sim;
    }
    
    public double getSimilaritySimNode(){
        return similarity;
    }

    public void setMetaPath(String meta){
        metaPath = meta;
    }

    public String getMetaPath(){
        return metaPath;
    }
}
