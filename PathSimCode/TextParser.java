
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TextParser {

    // extract data from original file and put to arrayList
    static public ArrayList<String[]> splitFile(File file) throws IOException {
        ArrayList<String[]> list = new ArrayList<String[]>();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(file));
        String contentLine = br.readLine();
        while (contentLine != null) {
            String[] splited = contentLine.split(" ");

            list.add(splited);
            contentLine = br.readLine();
        }
        br.close();
        return list;
    }

    static public HashMap<Integer, RatingUser> ratingUsersList2Table(ArrayList<String[]> list) {
        HashMap<Integer, RatingUser> ret = new HashMap<Integer, RatingUser>();
        for (String[] ele : list) {
            String userId = ele[0];
            String label = "ratingUser "+userId;
            ret.put(new Integer(userId), new RatingUser(userId, label));
        }
        return ret;
    }

    static public HashMap<Integer, RatedItem> ratedItemList2Table(ArrayList<String[]> list) {
        HashMap<Integer, RatedItem> ret = new HashMap<Integer, RatedItem>();
        for (String[] ele : list) {
            String itemId = ele[1];
            String label = "ratedItem "+itemId;            
            ret.put(new Integer(itemId), new RatedItem(itemId, label));
        }
        return ret;
    }

    static public HashMap<Integer, TrustorUser> trustorUserList2Table(ArrayList<String[]> list) {
        HashMap<Integer, TrustorUser> ret = new HashMap<Integer, TrustorUser>();
        for (String[] ele : list) {
            String userId = ele[0];
            String label = "trustorUser "+userId;            
            ret.put(new Integer(userId), new TrustorUser(userId, label));
        }
        return ret;
    }

    static public HashMap<Integer, TrusteeUser> trusteeUserList2Table(ArrayList<String[]> list) {
        HashMap<Integer, TrusteeUser> ret = new HashMap<Integer, TrusteeUser>();
        for (String[] ele : list) {
            String userId = ele[1];
            String label = "trusteeUser "+userId;            
            ret.put(new Integer(userId), new TrusteeUser(userId, label));
        }
        return ret;
    }
}
