
public class RatedItem extends SimNode{

    private int type;

    public RatedItem(String id, String data) {
        super(id, data);
        this.type = 2;
    }

    public int getType() {
        return this.type;
    }

}
