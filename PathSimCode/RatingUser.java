
public class RatingUser extends SimNode implements Comparable<RatingUser>{

    private int type;
    private int path2other;
    private int path2self;
    private double sim_UrImUr;
    private double sim_UrImUrImUr;

    public RatingUser(String id, String data) {
        super(id, data);
        this.type = 1;
    }

    public void resetData() {
        path2other = 0;
        path2self = 0;
        sim_UrImUr = 0;
    }
    
    public void incrementOPath() {
        this.path2other++;
    }
    
    public void incrementSPath() {
        this.path2self++;
    }    
    
    public int getSPath() {
        return this.path2self;
    }

    public int getOPath() {
        return this.path2other;
    }

    public void set_sim_UrImUr(double sim) {
        this.sim_UrImUr = sim;
        setSimilarity(sim);
    } 
    
    public void set_sim_UrImUrImUr(double sim) {
        this.sim_UrImUrImUr = sim;
        setSimilarity(sim);
    }
    
    @Override
    public int compareTo(RatingUser o) {
        String metaPath = getMetaPath();
        if (metaPath.equals("UrImUr")) {
            if (this.sim_UrImUr == o.sim_UrImUr) {
                return 0;
            }
            if (this.sim_UrImUr > o.sim_UrImUr) {
                return 1;
            }
            return -1;
        }
        if(this.sim_UrImUrImUr == o.sim_UrImUrImUr)
            return 0;
        else if(this.sim_UrImUrImUr > o.sim_UrImUrImUr)
            return 1;
        return -1;
    }

}
