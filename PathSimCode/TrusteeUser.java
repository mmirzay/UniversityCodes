
public class TrusteeUser extends SimNode implements Comparable<TrusteeUser> {

    private int type;
    private int path2other;
    private int path2self;
    private double sim_TeTrTe;
    private double sim_TeTrTeTrTe;
    private double sim_TeTeTrTeTe;
    private double sim_TeImTe;

    public TrusteeUser(String id, String data) {
        super(id, data);
        this.type = 4;
    }

    public void resetData() {
        path2other = 0;
        path2self = 0;
        sim_TeTrTe = 0;
        sim_TeTrTeTrTe = 0;
        sim_TeTeTrTeTe = 0;
        sim_TeImTe = 0;
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

    public void set_sim_TeTrTe(double sim) {
        this.sim_TeTrTe = sim;
        setSimilarity(sim);
    }

    public double get_sim_TeTrTe() {
        return this.sim_TeTrTe;
    }

    public void set_sim_TeTrTeTrTe(double sim) {
        this.sim_TeTrTeTrTe = sim;
        setSimilarity(sim);
    }

    public double get_sim_TeTrTeTrTe() {
        return this.sim_TeTrTeTrTe;
    }

    public void set_sim_TeTeTrTeTe(double sim) {
        this.sim_TeTeTrTeTe = sim;
        setSimilarity(sim);
    }

    public double get_sim_TeTeTrTeTe() {
        return this.sim_TeTeTrTeTe;
    }

    public void set_sim_TeImTe(double sim) {
        this.sim_TeImTe = sim;
        setSimilarity(sim);
    }

    public double get_sim_TeImTe() {
        return this.sim_TeImTe;
    }

    @Override
    public int compareTo(TrusteeUser o) {
        String metaPath = getMetaPath();
        if (metaPath.equals("TeTrTe")) {
            if (this.sim_TeTrTe == o.sim_TeTrTe) {
                return 0;
            }
            if (this.sim_TeTrTe > o.sim_TeTrTe) {
                return 1;
            }
            return -1;
        } else if (metaPath.equals("TeTrTeTrTe")) {
            if (this.sim_TeTrTeTrTe == o.sim_TeTrTeTrTe) {
                return 0;
            }
            if (this.sim_TeTrTeTrTe > o.sim_TeTrTeTrTe) {
                return 1;
            }
            return -1;
        } else if (metaPath.equals("TeTeTrTeTe")) {
            if (this.sim_TeTeTrTeTe == o.sim_TeTeTrTeTe) {
                return 0;
            }
            if (this.sim_TeTeTrTeTe > o.sim_TeTeTrTeTe) {
                return 1;
            }
            return -1;
        }
        if (this.sim_TeImTe == o.sim_TeImTe) {
            return 0;
        }
        if (this.sim_TeImTe > o.sim_TeImTe) {
            return 1;
        }
        return -1;
    }
}
