
public class TrustorUser extends SimNode implements Comparable<TrustorUser> {

    private int type;
    private int path2other;
    private int path2self;
    private double sim_TrTeTr;
    private double sim_TrTrTeTrTr;
    private double sim_TrTeTrTeTr;
    private double sim_TrImTr;

    public TrustorUser(String id, String data) {
        super(id, data);
        this.type = 3;
    }

    public void resetData() {
        path2other=0;
        path2self =0;
        sim_TrTeTr = 0;
        sim_TrTrTeTrTr =0;
        sim_TrTeTrTeTr = 0;
        sim_TrImTr = 0;
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

    public void set_sim_TrTeTr(double sim) {
        this.sim_TrTeTr = sim;
        setSimilarity(sim);
    }

    public double get_sim_TrTeTr() {
        return this.sim_TrTeTr;
    }

    public void set_sim_TrTrTeTrTr(double sim) {
        this.sim_TrTrTeTrTr = sim;
        setSimilarity(sim);
    }

    public double get_sim_TrTrTeTrTr() {
        return this.sim_TrTrTeTrTr;
    }

    public void set_sim_TrTeTrTeTr(double sim) {
        this.sim_TrTeTrTeTr = sim;
        setSimilarity(sim);
    }

    public double get_sim_TrTeTrTeTr() {
        return this.sim_TrTeTrTeTr;
    }

    public void set_sim_TrImTr(double sim) {
        this.sim_TrImTr = sim;
        setSimilarity(sim);
    }

    public double get_sim_TrImTr() {
        return this.sim_TrImTr;
    }

    @Override
    public int compareTo(TrustorUser o) {
        String metaPath = getMetaPath();
        if (metaPath.equals("TrTeTr")) {
            if (this.sim_TrTeTr == o.sim_TrTeTr) {
                return 0;
            }
            if (this.sim_TrTeTr > o.sim_TrTeTr) {
                return 1;
            }
            return -1;
        } else if (metaPath.equals("TrTrTeTrTr")) {
            if (this.sim_TrTrTeTrTr == o.sim_TrTrTeTrTr) {
                return 0;
            }
            if (this.sim_TrTrTeTrTr > o.sim_TrTrTeTrTr) {
                return 1;
            }
            return -1;

        } else if (metaPath.equals("TrTeTrTeTr")) {
            if (this.sim_TrTeTrTeTr == o.sim_TrTeTrTeTr) {
                return 0;
            }
            if (this.sim_TrTeTrTeTr > o.sim_TrTeTrTeTr) {
                return 1;
            }
            return -1;
        }
        if (this.sim_TrImTr == o.sim_TrImTr) {
            return 0;
        }
        if (this.sim_TrImTr > o.sim_TrImTr) {
            return 1;
        }
        return -1;
    }
}
