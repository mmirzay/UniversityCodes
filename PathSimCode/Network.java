
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Network {

    private HashMap<Integer, RatingUser> ratingUsers = new HashMap<Integer, RatingUser>();
    private HashMap<Integer, RatedItem> ratedItems = new HashMap<Integer, RatedItem>();
    private HashMap<Integer, TrustorUser> trustorUsers = new HashMap<Integer, TrustorUser>();
    private HashMap<Integer, TrusteeUser> trusteeUsers = new HashMap<Integer, TrusteeUser>();
    private ArrayList<String[]> ratings = new ArrayList<String[]>();
    private ArrayList<String[]> trusts = new ArrayList<String[]>();

    public Network(File ratingsFile, File trustFile) throws IOException {
        ArrayList<String[]> ratingUsersList = TextParser.splitFile(ratingsFile);
        ArrayList<String[]> ratedItemList = TextParser.splitFile(ratingsFile);
        ArrayList<String[]> truestorList = TextParser.splitFile(trustFile);
        ArrayList<String[]> trusteeList = TextParser.splitFile(trustFile);

        this.ratings = TextParser.splitFile(ratingsFile);
        this.trusts = TextParser.splitFile(trustFile);

        this.ratingUsers = TextParser.ratingUsersList2Table(ratingUsersList);
        this.ratedItems = TextParser.ratedItemList2Table(ratedItemList);
        this.trustorUsers = TextParser.trustorUserList2Table(truestorList);
        this.trusteeUsers = TextParser.trusteeUserList2Table(trusteeList);
    }

    // the constructor is just setting up the nodes
    // this method is setting up the edges
    public void connect() {

        // ratings
        for (String[] rating : ratings) {
            int ratingUserID = Integer.valueOf(rating[0]); // id for a rating user
            RatingUser ratingUser = ratingUsers.get(ratingUserID);
            Integer ratedItemKey = new Integer(rating[1]); // rated item id
            RatedItem ratedItem = ratedItems.get(ratedItemKey);
            ratingUser.setNeighbors(ratedItem, rating[2]);
            ratedItem.setNeighbors(ratingUser, rating[2]);
        }// for ratings

        // - trusts
        for (String[] trust : trusts) {
            int trustorUserId = Integer.valueOf(trust[0]); // id for a trustor user
            TrustorUser trustorUser = trustorUsers.get(trustorUserId);
            Integer trusteeKey = new Integer(trust[1]);
            TrusteeUser trusteeUser = trusteeUsers.get(trusteeKey);
            trustorUser.setNeighbors(trusteeUser, trust[2]);
            trusteeUser.setNeighbors(trustorUser, trust[2]);
        }// for ratings
    }// connect
    
    public void showStatistics(){
        System.out.println("- Number of Ratings information:   "+ratings.size());
        System.out.println("- Number of rating users:          "+ratingUsers.size());
        System.out.println("- Number of rated items:           "+ratedItems.size());
        System.out.println("- Number of Trusts information:    "+trusts.size());
        System.out.println("- Number of trustor users:         "+trustorUsers.size());
        System.out.println("- Number of trustee users:         "+trusteeUsers.size());
        
        int counter =0 ;
        for(TrustorUser t: trustorUsers.values())
            if(trusteeUsers.get(t.getId())==null)
                counter++;
        System.out.println("- Number of trustor user that are not trustee:             "+counter);
        counter =0 ;
        for(TrusteeUser t: trusteeUsers.values())
            if(trustorUsers.get(t.getId())==null)
                counter++;
        System.out.println("- Number of trustee user that are not trustor:             "+counter);
        
        counter =0 ;
        for(TrustorUser t: trustorUsers.values())
            if(ratingUsers.get(t.getId())==null)
                counter++;
        System.out.println("- Number of trustor user with no rating items:             "+counter);
        
        counter =0 ;
        for(TrusteeUser t: trusteeUsers.values())
            if(ratingUsers.get(t.getId())==null)
                counter++;
        System.out.println("- Number of trustee user with no rating items:             "+counter);
        
        counter =0 ;
        for(RatingUser r: ratingUsers.values())
            if(trusteeUsers.get(r.getId())==null && trustorUsers.get(r.getId())== null)
                counter++;
        System.out.println("- Number of rating users with no trust relation:           "+counter);
        
        counter =0 ;
        for(TrustorUser t: trustorUsers.values())
            if(ratingUsers.get(t.getId())==null)
                counter++;        
        for(TrusteeUser t: trusteeUsers.values())
            if(ratingUsers.get(t.getId())==null)
                counter++;
        System.out.println("- Number of trust users with no rating relation:           "+counter);        
        counter =0 ;
        for(TrustorUser t: trustorUsers.values())
            if(trusteeUsers.get(t.getId())!=null)
                counter++;        
        for(TrusteeUser t: trusteeUsers.values())
            if(trustorUsers.get(t.getId())!=null)
                counter++;
        System.out.println("- Number of user that are trustor & trustee:               "+counter);
        counter =0 ;
        for(RatingUser r: ratingUsers.values())
            if(trusteeUsers.get(r.getId())!= null && trustorUsers.get(r.getId())!=null)
                counter++;
        System.out.println("- user that are trustor & trustee and has rating:          "+counter);        
        
        int max =0, maxid = -1, min=Integer.MAX_VALUE, minId=-1;
        for(TrustorUser t: trustorUsers.values()){
            int s = t.getNeighbors().size();
            int id = t.getId();
            if(s > max){
                max = s;
                maxid = id;
            }
            if(s < min){
                min = s;
                minId = id;
            }
        }
        System.out.println("- trustorId with most trustee:    "+maxid+" has  "+max+"  trustees");
        System.out.println("- trustorId with least trustee:   "+minId+" has  "+min+"  trustees");
        max= 0; maxid = -1; min = Integer.MAX_VALUE; minId = -1;
        
        for(TrusteeUser t: trusteeUsers.values()){
            int s = t.getNeighbors().size();
            int id = t.getId();
            if(s > max){
                max = s;
                maxid = id;
            }
            if(s < min){
                min = s;
                minId = id;
            }
        }
        System.out.println("- trusteeId with most trustor:    "+maxid+" has  "+max+"  trustors");
        System.out.println("- trusteeId with least trustor:   "+minId+" has  "+min+"  trustors");
        max= 0; maxid = -1; min = Integer.MAX_VALUE; minId = -1;
        
        for(RatingUser t: ratingUsers.values()){
            int s = t.getNeighbors().size();
            int id = t.getId();
            if(s > max){
                max = s;
                maxid = id;
            }
            if(s < min){
                min = s;
                minId = id;
            }
        }
        System.out.println("- userId with most ratings:       "+maxid+" has  "+max+"  rated items");
        System.out.println("- userId with least ratings:      "+minId+" has  "+min+"  rated items");
        max= 0; maxid = -1; min = Integer.MAX_VALUE; minId = -1;
        
        for(RatedItem t: ratedItems.values()){
            int s = t.getNeighbors().size();
            int id = t.getId();
            if(s > max){
                max = s;
                maxid = id;
            }
            if(s < min){
                min = s;
                minId = id;
            }
        }
        System.out.println("- itemId with most ratings:       "+maxid+" has  "+max+"  rating users");
        System.out.println("- itemId with least ratings:      "+minId+" has  "+min+"  rating users");
        max= 0; maxid = -1; min = Integer.MAX_VALUE; minId = -1;
                
        
        
    }
    
    public void resetDataOfUsers(){
        for(RatingUser x : ratingUsers.values()){
            x.resetData();           
        }
    }    
    
    public void resetTrustorsTrusteesPathData(){
        for(TrustorUser x : trustorUsers.values()){
            x.resetData();           
        }    
        
        for(TrusteeUser x : trusteeUsers.values()){
            x.resetData();           
        }        
    }
    
    
    public HashMap<Integer, RatingUser> getRatingUsersItems(){
        
        return ratingUsers;
    }
    
    public HashMap<Integer, RatedItem> getRatedItemsUsers(){
        return ratedItems;
    }    
    
    // TrTeTr
    // number of path from Trustor(Tr) x to Trustor(Tr) y using common Trustee(Te) 
    public void calculatePXY_TrTeTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode teNeighbor : xneighbors.keySet()) { // traversing the trustee users of user x
            if (teNeighbor instanceof TrusteeUser) { // neighbor is a trustee
                HashMap<SimNode, String> teNeighbors = teNeighbor.getNeighbors();
                for (SimNode trNeighbor : teNeighbors.keySet()) {// traversing trustor users of trustee
                    if (trNeighbor instanceof TrustorUser) { // neighbor is a trustor
                        ((TrustorUser) trNeighbor).incrementOPath();// end V
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee
            }// if neighbor is a trustee
        } // for traversing the trustee users of user x
    }// end of calculatePXY_TrTeTr(Integer xid)

    //TrTeTr which Tr1 == Tr2
    // number of path from Trustor(Tr) x to himself(Tr) y using common Trustee(Te) 
    public void calculatePXX_TrTeTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();
        for (SimNode teNeighbor : xneighbors.keySet()) { // traversing the trustee users of user x
            if (teNeighbor instanceof TrusteeUser) { // neighbor is a trustee
                HashMap<SimNode, String> teNeighbors = teNeighbor.getNeighbors();
                for (SimNode trNeighbor : teNeighbors.keySet()) {// traversing trustor users of trustee
                    if (trNeighbor.getId() == x.getId()) { // neighbor is a trustor user x                     
                        // System.out.println("tr: " + trNeighbor.getData());
                        x.incrementSPath();// end V
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee
            }// if neighbor is a trustee
        } // for traversing the trustee users of user x
    } //end of calculatePXX_TrTeTr(Integer xid)

    // calculate all TrTeTr path to self for each trustor
    public void calculatePXX_TrTeTr() {
        for (TrustorUser trustorUser : trustorUsers.values()) {
            calculatePXX_TrTeTr(trustorUser.getId());
        }// for of all trustor user self-path
    }// end of calculatePXX_TrTeTr()
    

    // TrTrTeTrTr
    // number of path from Trustor(Tr) x to Trustor(Tr) y using common Trustors of common Trustee(Te) 
    public void calculatePXY_TrTrTeTrTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode trNeighbor1 : xneighbors.keySet()) { // traversing the first trustor users of user x            
            if (trustorUsers.containsKey(trNeighbor1.getId())) { // neighbor is a trustor  
                SimNode tempTr = trustorUsers.get(trNeighbor1.getId());
                HashMap<SimNode, String> trNeighbors1 = tempTr.getNeighbors(); // get trustor1 neighbors                
                for (SimNode teNeighbor : trNeighbors1.keySet()) {// traversing trustee users of trustor of user x                    
                    if (teNeighbor instanceof TrusteeUser) { // neighbor is a trustee                        
                        HashMap<SimNode, String> teNeighbors = teNeighbor.getNeighbors();
                        for (SimNode trNeighbor2 : teNeighbors.keySet()) { // traversing trustor users of trustee
                            if (trNeighbor2 instanceof TrustorUser) {// neighbor is a trustor                                
                                HashMap<SimNode, String> trNeighbors2 = trNeighbor2.getNeighbors();
                                for(SimNode trNeighbor3: trNeighbors2.keySet()){ // traversing trustor user of trustor
                                    if (trustorUsers.containsKey(trNeighbor3.getId())) { // neighbor is trustor
                                        SimNode tempTr2 = trustorUsers.get(trNeighbor3.getId());                                        
                                        ((TrustorUser) tempTr2).incrementOPath();// end V
                                    }// if neighbor is trustor
                                }//for traversing trustor user of trustor
                            }// if neighbor is a trustor
                        }// for traversing trustor users of trustee
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee
            }// if neighbor is a trustee
        } // for traversing the trustee users of user x
    }// end of calculatePXY_TrTeTr(Integer xid)

    //TrTrTeTrTr which Tr1 == Tr4
    // number of path from Trustor(Tr) x to himself(Tr) y using common Trustee(Te) of common trusters 
    public void calculatePXX_TrTrTeTrTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();
        
        for (SimNode trNeighbor1 : xneighbors.keySet()) { // traversing the first trustor users of user x
            if (trustorUsers.containsKey(trNeighbor1.getId())) { // neighbor is a trustor  
                SimNode tempTr = trustorUsers.get(trNeighbor1.getId());
                HashMap<SimNode, String> trNeighbors1 = tempTr.getNeighbors(); // get trustor1 neighbors
                for (SimNode teNeighbor : trNeighbors1.keySet()) {// traversing trustee users of trustor
                    if (teNeighbor instanceof TrusteeUser) { // neighbor is a trustee
                        HashMap<SimNode, String> teNeighbors = teNeighbor.getNeighbors();
                        for (SimNode trNeighbor2 : teNeighbors.keySet()) { // traversing trustor users of trustee
                            if (trNeighbor2 instanceof TrustorUser) {// neighbor is a trustor
                                HashMap<SimNode, String> trNeighbors2 = trNeighbor2.getNeighbors();
                                for (SimNode trNeighbor3 : trNeighbors2.keySet()) { // traversing trustor user of trustor                                    
                                    if (trustorUsers.containsKey(trNeighbor3.getId())
                                            && trNeighbor3.getId() == x.getId()) { // neighbor is trustor user x                                        
                                        x.incrementSPath();// end V
                                    }// if neighbor is trustor                                    
                                }//for traversing trustor user of trustor
                            }// if neighbor is a trustor
                        }// for traversing trustor users of trustee
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee
            }// if neighbor is a trustee
        } // for traversing the trustee users of user x        
               
    } //end of calculatePXX_TrTeTr(Integer xid)

    // calculate all TrTrTeTrTr path to self for each trustor
    public void calculatePXX_TrTrTeTrTr() {
        for (TrustorUser trustorUser : trustorUsers.values()) {
            calculatePXX_TrTrTeTrTr(trustorUser.getId());
        }// for of all trustor user self-path
    }// end of calculatePXX_TrTrTeTrTr()
    
    // TrTeTrTeTr
    // number of path from Trustor(Tr) x to Trustor(Tr) y using common Trustors of common Trustee(Te) 
    public void calculatePXY_TrTeTrTeTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode teNeighbor1 : xneighbors.keySet()) { // traversing the first trustee users of user x            
            if (teNeighbor1 instanceof TrusteeUser) { // neighbor is a trustee                  
                HashMap<SimNode, String> teNeighbors1 = teNeighbor1.getNeighbors(); // get trustee1 neighbors                
                for (SimNode trNeighbor2 : teNeighbors1.keySet()) {// traversing trustor users of trustee of user x                    
                    if (trNeighbor2 instanceof TrustorUser) { // neighbor is a trustor                        
                        HashMap<SimNode, String> trNeighbors2 = trNeighbor2.getNeighbors();
                        for (SimNode teNeighbor2 : trNeighbors2.keySet()) { // traversing trustee users of trustor
                            if (teNeighbor2 instanceof TrusteeUser) {// neighbor is a trustee                                
                                HashMap<SimNode, String> teNeighbors2 = teNeighbor2.getNeighbors();
                                for(SimNode trNeighbor3: teNeighbors2.keySet()){ // traversing trustor user of trustee2
                                    if (trNeighbor3 instanceof TrustorUser) { // neighbor is trustor                                        
                                        ((TrustorUser) trNeighbor3).incrementOPath();
                                    }// if neighbor is trustor
                                }//for traversing trustor user of trustee2
                            }// if neighbor is a trustee
                        }// for traversing trustee users of trustor
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee of user x
            }// if neighbor is a trustee
        } // for traversing the trustee users of user x
    }// end of calculatePXY_TrTeTrTeTr(Integer xid)
    
    public void calculatePXX_TrTeTrTeTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();
        
        for (SimNode teNeighbor1 : xneighbors.keySet()) { // traversing the first trustee users of user x
            if (teNeighbor1 instanceof TrusteeUser) { // neighbor is a trustee1                  
                HashMap<SimNode, String> teNeighbors1 = teNeighbor1.getNeighbors(); // get trustor1 neighbors
                for (SimNode trNeighbor2 : teNeighbors1.keySet()) {// traversing trustor users of trustee1
                    if (trNeighbor2 instanceof TrustorUser) { // neighbor is a trustor
                        HashMap<SimNode, String> trNeighbors2 = trNeighbor2.getNeighbors();
                        for (SimNode teNeighbor2 : trNeighbors2.keySet()) { // traversing trustee2 users of trustor2
                            if (teNeighbor2 instanceof TrusteeUser) {// neighbor is a trustee2
                                HashMap<SimNode, String> teNeighbors2 = teNeighbor2.getNeighbors();
                                for (SimNode trNeighbor3 : teNeighbors2.keySet()) { // traversing trustor3 user of trustee2                                    
                                    if (trNeighbor3.getId() == x.getId()) { // neighbor is trustor user x and equal with him                                       
                                        ((TrustorUser) x).incrementSPath();
                                    }// if neighbor is trustor  and equal with x                                  
                                }//for traversing trustor3 user of trustee2
                            }// if neighbor is a trustee2
                        }// for traversing trustee2 users of trustor2
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee1
            }// if neighbor is a trustee1
        } // for traversing the trustee users of user x        
               
    } //end of calculatePXX_TrTeTrTeTr(Integer xid)
    
    public void calculatePXX_TrTeTrTeTr() {
        for (TrustorUser trustorUser : trustorUsers.values()) {
            calculatePXX_TrTeTrTeTr(trustorUser.getId());
        }// for of all trustor user self-path
    }// end of calculatePXX_TrTeTrTeTr()
    
    
    // TrImTr
    // number of path from Trustor(Tr) x to Trustor(Tr) y using common ratedItem(Im) 
    public void calculatePXY_TrImTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        Set<SimNode> ratedItemsX = getRatedItems(xid);// get RatedITems of x
        if(ratedItemsX == null)
            return;
        for(SimNode ratedItem: ratedItemsX){// search in ratedItems of x
            HashMap<SimNode,String> ratedItemNeighbors = ratedItem.getNeighbors(); // get neighbor of ratedItem
            for(SimNode ratingUser: ratedItemNeighbors.keySet()){ // search in ratingUser of ratedItem                
                TrustorUser trustorUser2 = trustorUsers.get(ratingUser.getId());                
                if(trustorUser2!=null){                    
                    trustorUser2.incrementOPath();
                } // if rating user is in trustors
            }// for search in ratingUser of ratedITem
        }// for search in ratedItems of x
    }// end of calculatePXY_TrImTr(Integer xid)

    //TrImTr which Tr1 == Tr2
    // number of path from Trustor(Tr) x to himSelf(Tr) y using common ratedItem(Im) 
    public void calculatePXX_TrImTr(Integer xid) {
        TrustorUser x = trustorUsers.get(xid);
        Set<SimNode> ratedItemsX = getRatedItems(xid);// get RatedITems of x
        if(ratedItemsX == null)
            return;
        for(SimNode ratedItem: ratedItemsX){// search in ratedItems of x
            HashMap<SimNode,String> ratedItemNeighbors = ratedItem.getNeighbors(); // get neighbor of ratedItem
            for(SimNode ratingUser: ratedItemNeighbors.keySet()){ // search in ratingUser of ratedItem                
                TrustorUser trustorUser2 = trustorUsers.get(ratingUser.getId());                
                if(trustorUser2!=null && trustorUser2.getId() == x.getId()){                    
                    trustorUser2.incrementSPath();
                } // if rating user is in trustors
            }// for search in ratingUser of ratedITem
        }// for search in ratedItems of x
    }// end of calculatePXY_TrImTr(Integer xid)

    // calculate all TrImTr path to self for each trustor
    public void calculatePXX_TrImTr() {
        for (TrustorUser trustorUser : trustorUsers.values()) {
            calculatePXX_TrImTr(trustorUser.getId());
        }// for of all trustor user self-path
    }// end of calculatePXX_TrImTr()
    

    // return the sorted Trustor using MEtaPath as an arraylist
    
    public ArrayList<TrustorUser> PathSimTrustor(Integer xid, String meta) {
        resetTrustorsTrusteesPathData();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        TrustorUser x = trustorUsers.get(xid); //  509 is most trusting user in trust.txt, change me !!!!!!!!!!!!!!!!!!!
        x.setMetaPath(meta);
        if (meta.equals("TrTeTr")) {
            calculatePXY_TrTeTr(xid);
            calculatePXX_TrTeTr();
        } else if(meta.equals("TrTrTeTrTr")){
            calculatePXY_TrTrTeTrTr(xid);
            calculatePXX_TrTrTeTrTr();
        } else if(meta.equals("TrTeTrTeTr")){            
            calculatePXY_TrTeTrTeTr(xid);
            calculatePXX_TrTeTrTeTr();
            
        } else if(meta.equals("TrImTr")){
            calculatePXY_TrImTr(xid);
            calculatePXX_TrImTr();
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        int pxx = x.getSPath();
        ArrayList<TrustorUser> ret = new ArrayList<TrustorUser>();
        for (TrustorUser trustorUser : trustorUsers.values()) {
            int dividend = 2 * trustorUser.getOPath();
            int divisor = pxx + trustorUser.getSPath();
            double sim = divisor == 0 ? 0 : ((double) dividend / divisor);
            trustorUser.setMetaPath(meta);
            if(meta.equals("TrTeTr"))
                trustorUser.set_sim_TrTeTr(sim);
            else if(meta.equals("TrTrTeTrTr"))
                trustorUser.set_sim_TrTrTeTrTr(sim);
            else if(meta.equals("TrTeTrTeTr"))
                trustorUser.set_sim_TrTeTrTeTr(sim);
            else if(meta.equals("TrImTr"))
                trustorUser.set_sim_TrImTr(sim);
            ret.add(trustorUser);
        }
        Collections.sort(ret);
        return ret;
    }// end of PathSim(Integer xid, StringMeta)
        
    
    
    
    
    // ------------------------------------------------------------------------------------------------------------------------------------//
    
    
    
    
    
        // TeTrTe
    // number of path from Trustee(Te) x to Trustee(Te) y using common Trustor(Te) 
    public void calculatePXY_TeTrTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode trNeighbor : xneighbors.keySet()) { // traversing the trustor users of user x
            if (trNeighbor instanceof TrustorUser) { // neighbor is a trustor
                HashMap<SimNode, String> trNeighbors = trNeighbor.getNeighbors();
                for (SimNode teNeighbor : trNeighbors.keySet()) {// traversing trustee users of trustor
                    if (teNeighbor instanceof TrusteeUser) { // neighbor is a trustee
                        ((TrusteeUser) teNeighbor).incrementOPath();// end V
                    }// if neighbor is a trustor
                } // for traversing trustee users of trustor
            }// if neighbor is a trustor
        } // for traversing the trustor users of user x
    }// end of calculatePXY_TeTrTe(Integer xid)

    //TrTeTr which Tr1 == Tr2
    // number of path from Trustor(Tr) x to himself(Tr) y using common Trustee(Te) 
    public void calculatePXX_TeTrTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();
        for (SimNode trNeighbor : xneighbors.keySet()) { // traversing the trustor users of user x
            if (trNeighbor instanceof TrustorUser) { // neighbor is a trustor
                HashMap<SimNode, String> trNeighbors = trNeighbor.getNeighbors();
                for (SimNode teNeighbor : trNeighbors.keySet()) {// traversing trustee users of trustor
                    if (teNeighbor.getId() == x.getId()) { // neighbor is  trustee user x                                             
                        x.incrementSPath();
                    }// if neighbor is a trustee
                } // for traversing trustee users of trustor
            }// if neighbor is a trustor
        } // for traversing the trustor users of user x
    } //end of calculatePXX_TeTrTe(Integer xid)

    // calculate all TrTeTr path to self for each trustor
    public void calculatePXX_TeTrTe() {
        for (TrusteeUser trusteeUser : trusteeUsers.values()) {
            calculatePXX_TeTrTe(trusteeUser.getId());
        }// for of all trustee user self-path
    }// end of calculatePXX_TeTrTe()
    


        // TeTrTeTrTe
    // number of path from Trustee(Te) x to Trustee(Te) y using common Trustee(Te) of common Trustors(Tr)
    public void calculatePXY_TeTrTeTrTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode trNeighbor1 : xneighbors.keySet()) { // traversing the trustor1 users of user x
            if (trNeighbor1 instanceof TrustorUser) { // neighbor is a trustor1
                HashMap<SimNode, String> trNeighbors1 = trNeighbor1.getNeighbors();
                for (SimNode teNeighbor2 : trNeighbors1.keySet()) {// traversing trustee2 users of trustor1
                    if (teNeighbor2 instanceof TrusteeUser) { // neighbor is a trustee2
                        HashMap<SimNode, String> teNeighbors2 = teNeighbor2.getNeighbors();
                        for (SimNode trNeighbor2 : teNeighbors2.keySet()) { // traversing the trustor2 users of user Trustee2
                            if(trNeighbor2 instanceof TrustorUser) { // neighbor is a trustor2
                                HashMap<SimNode, String> trNeighbors2 = trNeighbor2.getNeighbors();
                                for (SimNode teNeighbor3 : trNeighbors2.keySet()) {// traversing trustee3 users of trustor2
                                    if (teNeighbor3 instanceof TrusteeUser) { // neighbor is a trustee3
                                        ((TrusteeUser) teNeighbor3).incrementOPath();// end V
                                    }// if neighbor is a trustee3
                                }//for traversing trustee3 users of trustor2
                            }// if neighbor is a trustor2
                        }// for traversing the trustor2 users of user Trustee2
                    }// if neighbor is a trustee2  
                } // for traversing trustee2 users of trustor1
            }// if neighbor is a trustor1
        } // for traversing the trustor1 users of user x 
    }// end of calculatePXY_TeTrTeTrTe(Integer xid) 

    //TeTrTeTrTe which Te1 == Te2
    // number of path from Trustee(Te) x to himself(Te) y using common Trustee(Te) of Common Trustors(Tr) 
    public void calculatePXX_TeTrTeTrTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode trNeighbor1 : xneighbors.keySet()) { // traversing the trustor1 users of user x
            if (trNeighbor1 instanceof TrustorUser) { // neighbor is a trustor1
                HashMap<SimNode, String> trNeighbors1 = trNeighbor1.getNeighbors();
                for (SimNode teNeighbor2 : trNeighbors1.keySet()) {// traversing trustee2 users of trustor1
                    if (teNeighbor2 instanceof TrusteeUser) { // neighbor is a trustee2
                        HashMap<SimNode, String> teNeighbors2 = teNeighbor2.getNeighbors();
                        for (SimNode trNeighbor2 : teNeighbors2.keySet()) { // traversing the trustor2 users of user Trustee2
                            if(trNeighbor2 instanceof TrustorUser) { // neighbor is a trustor2
                                HashMap<SimNode, String> trNeighbors2 = trNeighbor2.getNeighbors();
                                for (SimNode teNeighbor3 : trNeighbors2.keySet()) {// traversing trustee3 users of trustor2
                                    if (teNeighbor3.getId() ==  x.getId()) { // neighbor is a equals to x
                                        x.incrementSPath();
                                    }// if neighbor is equal to x
                                }//for traversing trustee3 users of trustor2
                            }// if neighbor is a trustor2
                        }// for traversing the trustor2 users of user Trustee2
                    }// if neighbor is a trustee2  
                } // for traversing trustee2 users of trustor1
            }// if neighbor is a trustor1
        } // for traversing the trustor1 users of user x 
    }// end of calculatePXX_TeTrTeTrTe(Integer xid)

    // calculate all TeTrTeTrTe path to self for each trustor
    public void calculatePXX_TeTrTeTrTe() {
        for (TrusteeUser trusteeUser : trusteeUsers.values()) {
            calculatePXX_TeTrTeTrTe(trusteeUser.getId());
        }// for of all trustee user self-path
    }// end of calculatePXX_TeTrTeTrTe()
    
    
    // TeTeTrTeTe
    // number of path from Trustee(Te) x to Trustee(Te) y using common Trustors of common Trustee(Te) 
    public void calculatePXY_TeTeTrTeTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode teNeighbor1 : xneighbors.keySet()) { // traversing the first trustee users of user x            
            if (trusteeUsers.containsKey(teNeighbor1.getId())) { // neighbor is a trustee  
                SimNode tempTr = trusteeUsers.get(teNeighbor1.getId());
                HashMap<SimNode, String> teNeighbors1 = tempTr.getNeighbors(); // get trustee1 neighbors                
                for (SimNode trNeighbor : teNeighbors1.keySet()) {// traversing trustor users of trustee of user x                    
                    if (trNeighbor instanceof TrustorUser) { // neighbor is a trustor                        
                        HashMap<SimNode, String> trNeighbors = trNeighbor.getNeighbors();
                        for (SimNode teNeighbor2 : trNeighbors.keySet()) { // traversing trustee users of trustor
                            if (teNeighbor2 instanceof TrusteeUser) {// neighbor is a trustee                                
                                HashMap<SimNode, String> teNeighbors2 = teNeighbor2.getNeighbors();
                                for(SimNode teNeighbor3: teNeighbors2.keySet()){ // traversing trustee user of trustee
                                    if (trusteeUsers.containsKey(teNeighbor3.getId())) { // neighbor is trustee
                                        tempTr = trusteeUsers.get(teNeighbor3.getId());                                        
                                        ((TrusteeUser) tempTr).incrementOPath();
                                    }// if neighbor is trustee
                                }//for traversing trustee user of trustee
                            }// if neighbor is a trustee
                        }// for traversing trustee users of trustor
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee of user x
            }// neighbor is a trustee
        } // traversing the first trustee users of user x
    }//  calculatePXY_TeTeTrTeTe(Integer xid)

    //TeTeTrTeTe which Te1 == Te4
    // number of path from Trustee(Te) x to himself(Te) y using common Trustee(Te) of common trusters 
    public void calculatePXX_TeTeTrTeTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();
        
        for (SimNode teNeighbor1 : xneighbors.keySet()) { // traversing the first trustee users of user x
            if (trusteeUsers.containsKey(teNeighbor1.getId())) { // neighbor is a trustee  
                SimNode tempTr = trusteeUsers.get(teNeighbor1.getId());
                HashMap<SimNode, String> teNeighbors1 = tempTr.getNeighbors(); // get trustee1 neighbors
                for (SimNode trNeighbor : teNeighbors1.keySet()) {// traversing trustor users of trustee
                    if (trNeighbor instanceof TrustorUser) { // neighbor is a trustor
                        HashMap<SimNode, String> trNeighbors = trNeighbor.getNeighbors();
                        for (SimNode teNeighbor2 : trNeighbors.keySet()) { // traversing trustee users of trustor
                            if (teNeighbor2 instanceof TrusteeUser) {// neighbor is a trustee
                                HashMap<SimNode, String> teNeighbors2 = teNeighbor2.getNeighbors();
                                for (SimNode teNeighbor3 : teNeighbors2.keySet()) { // traversing trustee user of trustee                                    
                                    
                                    if (trusteeUsers.containsKey(teNeighbor3.getId())
                                            && teNeighbor3.getId() == x.getId()) { // neighbor is trustee user x                                        
                                        ((TrusteeUser) x).incrementSPath();
                                    }// if neighbor is trustee user x                                                                           
                                }//for  traversing trustee user of trustee                                    
                            }//if neighbor is a trustee
                        }// for traversing trustee users of trustor
                    }// if neighbor is a trustor
                } // for traversing trustor users of trustee
            }// if neighbor is a trustee
        } // for traversing the first trustee users of user x               
    } //end of calculatePXX_TeTeTrTeTe(Integer xid)

    // calculate all TeTeTrTeTe path to self for each trustee
    public void calculatePXX_TeTeTrTeTe() {
        for (TrusteeUser trusteeUser : trusteeUsers.values()) {
            calculatePXX_TeTeTrTeTe(trusteeUser.getId());
        }// for of all trustee user self-path
    }// end of calculatePXX_TeTeTrTeTe()
    
        // TeImTe
    // number of path from Truste(Te) x to Trustee(Te) y using common ratedItem(Im) 
    public void calculatePXY_TeImTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        Set<SimNode> ratedItemsX = getRatedItems(xid);// get RatedITems of x
        if(ratedItemsX == null)
            return;
        for(SimNode ratedItem: ratedItemsX){// search in ratedItems of x
            HashMap<SimNode,String> ratedItemNeighbors = ratedItem.getNeighbors(); // get neighbor of ratedItem
            for(SimNode ratingUser: ratedItemNeighbors.keySet()){ // search in ratingUser of ratedItem                
                TrusteeUser trusteeUser2 = trusteeUsers.get(ratingUser.getId());                
                if(trusteeUser2!=null){                    
                    trusteeUser2.incrementOPath();
                } // if rating user is in trustees
            }// for search in ratingUser of ratedITem
        }// for search in ratedItems of x
    }// end of calculatePXY_TeImTe(Integer xid)

    //TeImTe which Te1 == Te2
    // number of path from Trustee(Tee) x to himSelf(Te) y using common ratedItem(Im) 
    public void calculatePXX_TeImTe(Integer xid) {
        TrusteeUser x = trusteeUsers.get(xid);
        Set<SimNode> ratedItemsX = getRatedItems(xid);// get RatedITems of x
        if(ratedItemsX == null)
            return;
        for(SimNode ratedItem: ratedItemsX){// search in ratedItems of x
            HashMap<SimNode,String> ratedItemNeighbors = ratedItem.getNeighbors(); // get neighbor of ratedItem
            for(SimNode ratingUser: ratedItemNeighbors.keySet()){ // search in ratingUser of ratedItem                
                TrusteeUser trusteeUser2 = trusteeUsers.get(ratingUser.getId());                
                if(trusteeUser2!=null && trusteeUser2.getId() == x.getId()){                    
                    trusteeUser2.incrementSPath();
                } // if rating user is in trustees
            }// for search in ratingUser of ratedITem
        }// for search in ratedItems of x
    }// end of calculatePXY_TeImTe(Integer xid)

    // calculate all TeImTe path to self for each trustor
    public void calculatePXX_TeImTe() {
        for (TrusteeUser trusteeUser : trusteeUsers.values()) {
            calculatePXX_TeImTe(trusteeUser.getId());
        }// for of all trustor user self-path
    }// end of calculatePXX_TeImTe()
    
    
    public ArrayList<TrusteeUser> PathSimTrustee(Integer xid, String meta) {
        resetTrustorsTrusteesPathData();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        TrusteeUser x = trusteeUsers.get(xid); 
        x.setMetaPath(meta);
        if (meta.equals("TeTrTe")) {
            calculatePXY_TeTrTe(xid);
            calculatePXX_TeTrTe();
        }else if(meta.equals("TeTrTeTrTe")){
            calculatePXY_TeTrTeTrTe(xid);
            calculatePXX_TeTrTeTrTe();
        }else if(meta.equals("TeTeTrTeTe")){
            calculatePXY_TeTeTrTeTe(xid);
            calculatePXX_TeTeTrTeTe();
        } else if(meta.equals("TeImTe")){
            calculatePXY_TeImTe(xid);
            calculatePXX_TeImTe();
            
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        int pxx = x.getSPath();
        ArrayList<TrusteeUser> ret = new ArrayList<TrusteeUser>();
        for (TrusteeUser trusteeUser : trusteeUsers.values()) {
            int dividend = 2 * trusteeUser.getOPath();
            int divisor = pxx + trusteeUser.getSPath();
            double sim = divisor == 0 ? 0 : ((double) dividend / divisor);
            
            trusteeUser.setMetaPath(meta);
            
            if(meta.equals("TeTrTe"))
                trusteeUser.set_sim_TeTrTe(sim);
            else if(meta.equals("TeTrTeTrTe"))
                trusteeUser.set_sim_TeTrTeTrTe(sim);
            else if(meta.equals("TeTeTrTeTe"))
                trusteeUser.set_sim_TeTeTrTeTe(sim);
            else if(meta.equals("TeImTe"))
                trusteeUser.set_sim_TeImTe(sim);
            ret.add(trusteeUser);
        }// for trustee
        Collections.sort(ret);
        return ret;
    }// end of PathSimTrustee(Integer xid, StringMeta)
    
        // ------------------------------------------------------------------------------------------------------------------------------------//
    
    
    
    
    
        // UrImUr
    // number of path from RatingUser(Ur) x to ratingUser(Ur) y using common RatedItem(Im) 
    public void calculatePXY_UrImUr(Integer xid) {
        RatingUser x = ratingUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode imNeighbor : xneighbors.keySet()) { // traversing the rated items of x
            if (imNeighbor instanceof RatedItem) { // neighbor is a ratedItem
                HashMap<SimNode, String> imNeighbors = imNeighbor.getNeighbors();
                for (SimNode ruNeighbor : imNeighbors.keySet()) {// traversing ratingUser of ratedItem imNeighbor
                    if (ruNeighbor instanceof RatingUser) { // neighbor is a ratingUser
                        ((RatingUser) ruNeighbor).incrementOPath();
                    }// if neighbor is a ratingUser
                } // for traversing ratingUser of ratedItem imNeighbor
            }// if neighbor is a ratedItem
        } // for traversing the rated items of x
    }// end of alculatePXY_UrImUr(Integer xid)

    //UrImUr which Ur1 == Ur2
    // number of path from RatingUser(Ur) x to himself(Ur) x using common RatedItem(Im) 
    public void calculatePXX_UrImUr(Integer xid) {
        RatingUser x = ratingUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();
        for (SimNode imNeighbor : xneighbors.keySet()) { // traversing the ratedItem of x
            if (imNeighbor instanceof RatedItem) { // neighbor is a ratedITem
                HashMap<SimNode, String> imNeighbors = imNeighbor.getNeighbors();
                for (SimNode ruNeighbor : imNeighbors.keySet()) {// traversing ratingUser of imNeighbor
                    if (ruNeighbor.getId() == x.getId()) { // neighbor is  rating user equals to x                                             
                        x.incrementSPath();
                    }// if neighbor is  rating user equals to x                                             
                } // for traversing ratingUser of imNeighbor
            }// if neighbor is a ratedITem
        } // for traversing the ratedItem of x
    } //end of calculatePXX_UrImUr(Integer xid)

    // calculate all UrImUr path to self for each ratingUser
    public void calculatePXX_UrImUr() {
        for (RatingUser ratingUser : ratingUsers.values()) {
            calculatePXX_UrImUr(ratingUser.getId());
        }// for of all rating user self-path
    }// end of calculatePXX_UrImUr()
    
        // UrImUrImUr
    // number of path from RatingUser(Ur) x to ratingUser(Ur) y using common RatingUser(Ur) of common RatedItems(Im) 
    long counter1 = 0, counter2=0;
    public void calculatePXY_UrImUrImUr(Integer xid) {
        RatingUser x = ratingUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode imNeighbor1 : xneighbors.keySet()) { // traversing the rated items1 of x
            if (imNeighbor1 instanceof RatedItem) { // neighbor is a ratedItem1
                HashMap<SimNode, String> imNeighbors1 = imNeighbor1.getNeighbors();
                for (SimNode ruNeighbor2 : imNeighbors1.keySet()) {// traversing ratingUser2 of ratedItem1
                    if (ruNeighbor2 instanceof RatingUser) { // neighbor is a ratingUser2
                        HashMap<SimNode, String> ruNeighbors2 = ruNeighbor2.getNeighbors();
                        for (SimNode imNeighbor2 : ruNeighbors2.keySet()) {// traversing ratedItems2 of ratingUser2
                            if (imNeighbor2 instanceof RatedItem) { // neighbor is a ratedItem2
                                HashMap<SimNode, String> imNeighbors2 = imNeighbor2.getNeighbors();
                                for (SimNode ruNeighbor3 : imNeighbors2.keySet()) {// traversing ratingUser3 of ratedItem3
                                    if (ruNeighbor3 instanceof RatingUser) { // neighbor is a ratingUser3
                                        ((RatingUser) ruNeighbor3).incrementOPath();                                        
                                    }// if neighbor is a ratingUser3
                                }// for traversing ratingUser3 of ratedItem3
                            }// if neighbor is a ratedItem2                        
                        }// for traversing ratedItems2 of ratingUser2
                    }// if neighbor is a ratingUser2
                } // for traversing ratingUser2 of ratedItem1
            }// if neighbor is a ratedItem1
        } // for traversing the rated items1 of x
    }// end of calculatePXY_UrImUrImUr(Integer xid)

    //UrImUrImUr which Ur1 == Ur3
    // number of path from RatingUser(Ur) x to himself(Ur) x using coomon ratingUsers(Ur) common RatedItem(Im) 
    public void calculatePXX_UrImUrImUr(Integer xid) {
        RatingUser x = ratingUsers.get(xid);
        HashMap<SimNode, String> xneighbors = x.getNeighbors();

        for (SimNode imNeighbor1 : xneighbors.keySet()) { // traversing the rated items1 of x
            if (imNeighbor1 instanceof RatedItem) { // neighbor is a ratedItem1
                HashMap<SimNode, String> imNeighbors1 = imNeighbor1.getNeighbors();
                for (SimNode ruNeighbor2 : imNeighbors1.keySet()) {// traversing ratingUser2 of ratedItem1
                    if (ruNeighbor2 instanceof RatingUser) { // neighbor is a ratingUser2
                        HashMap<SimNode, String> ruNeighbors2 = ruNeighbor2.getNeighbors();
                        for (SimNode imNeighbor2 : ruNeighbors2.keySet()) {// traversing ratedItems2 of ratingUser2
                            if (imNeighbor2 instanceof RatedItem) { // neighbor is a ratedItem2
                                HashMap<SimNode, String> imNeighbors2 = imNeighbor2.getNeighbors();
                                for (SimNode ruNeighbor3 : imNeighbors2.keySet()) {// traversing ratingUser3 of ratedItem3
                                    if (ruNeighbor3.getId() == x.getId()) { // neighbor is x
                                        x.incrementSPath();                                        
                                    }// neighbor is x
                                }// for traversing ratingUser3 of ratedItem3
                            }// if neighbor is a ratedItem2                        
                        }// for traversing ratedItems2 of ratingUser2
                    }// if neighbor is a ratingUser2
                } // for traversing ratingUser2 of ratedItem1
            }// if neighbor is a ratedItem1
        } // for traversing the rated items1 of x
    }// end of calculatePXX_UrImUrImUr(Integer xid)

    // calculate all UrImUrImUr path to self for each ratingUser
    public void calculatePXX_UrImUrImUr() {
        for (RatingUser ratingUser : ratingUsers.values()) {
            calculatePXX_UrImUrImUr(ratingUser.getId());
        }// for of all rating user self-path
    }// end of calculatePXX_UrImUrImUr()    
    
    public ArrayList<RatingUser> PathSimRatingUser(Integer xid, String meta) {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        RatingUser x = ratingUsers.get(xid); 
        x.setMetaPath(meta);
        if (meta.equals("UrImUr")) {
            calculatePXY_UrImUr(xid);
            calculatePXX_UrImUr();
        }else if (meta.equals("UrImUrImUr")) {
            calculatePXY_UrImUrImUr(xid);
            calculatePXX_UrImUrImUr();
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        int pxx = x.getSPath();
        ArrayList<RatingUser> ret = new ArrayList<RatingUser>();
        for (RatingUser ratingUser : ratingUsers.values()) {
            int dividend = 2 * ratingUser.getOPath();
            int divisor = pxx + ratingUser.getSPath();
            double sim = divisor == 0 ? 0 : ((double) dividend / divisor);
                        
            ratingUser.setMetaPath(meta);            
            
            if(meta.equals("UrImUr"))
                ratingUser.set_sim_UrImUr(sim);
            else if(meta.equals("UrImUrImUr"))
                ratingUser.set_sim_UrImUrImUr(sim);
            ret.add(ratingUser);
        }// for ratingUser        
        Collections.sort(ret);
        return ret;        
    }// end of PathSimRatingUser(Integer xid, String meta)

    public Set<Integer> getTrustorUsers(){
        return trustorUsers.keySet();
    }
    
    public Set<Integer> getTrusteeUsers(){
        return trusteeUsers.keySet();
    }
    
    public Set<Integer> getRatingUsers(){
        return ratingUsers.keySet();
    }
    
    public Set<SimNode> getRatedItems(int xid) {
        SimNode user = ratingUsers.get(xid);
        if (user == null) {
            return null;
        }        
        return user.getNeighbors().keySet();
    }// get ratedItems of x
    
    public String getRateOfItem(int userId, int itemId){
        String rate = "noRating";
        SimNode user = ratingUsers.get(userId);
        if (user != null) {
            HashMap<SimNode, String> neighbors = user.getNeighbors();
            for(SimNode s: neighbors.keySet()){                
                if(s.getId() == itemId)
                    rate = neighbors.get(s);
            }
        }
        return rate;
    }
    

    public int getSimilarRatedItemXY(int xid, int yid) {
        SimNode userX = ratingUsers.get(xid);
        SimNode userY = ratingUsers.get(yid);
        if(userY == null) return 0;
        int similarRatedItems = 0;
        for (SimNode x : userX.getNeighbors().keySet()) {
            for (SimNode y : userY.getNeighbors().keySet()) {
                if (x.equals(y)) {
                    similarRatedItems++;
                }
            }
        }

        return similarRatedItems;
    }// similar rated items    
    
    public int getTrustedUser(int xid) {
        SimNode user = trustorUsers.get(xid);
        if (user == null) {
            return 0;
        }
        int size = user.getNeighbors().size();
        return size;
    }// get trusted user of x
    
    public int getSimilarTrustedUserXY(int xid, int yid) {
        SimNode userX = trustorUsers.get(xid);
        SimNode userY = trustorUsers.get(yid);
        int similarTrusted = 0;
        for (SimNode x : userX.getNeighbors().keySet()) {
            for (SimNode y : userY.getNeighbors().keySet()) {
                if (x.equals(y)) {
                    similarTrusted++;
                }
            }
        }

        return similarTrusted;
    }// get similar trusted user x y    

    
    public int getTrustedUserOfTrusedUser(int xid) {
        SimNode user = trustorUsers.get(xid);
        if (user == null) {
            return 0;
        }
        HashMap<SimNode, String> trUsers1 = user.getNeighbors();
        int size = 0;
        for(SimNode s: trUsers1.keySet()){
            if(trustorUsers.containsKey(s.getId())){
                SimNode temp = trustorUsers.get(s.getId());
                size += temp.getNeighbors().size();
            }
        }
        return size;
    }// get trusted user of x

    public int getSimilarTrustedUserOfTrustedUserXY(int xid, int yid) {
        SimNode userX = trustorUsers.get(xid);
        SimNode userY = trustorUsers.get(yid);
        int similarTrusted = 0;
        
        HashMap<SimNode, String> trUsers1X = new HashMap<>();
        HashMap<SimNode, String> trUsers1Y = new HashMap<>();
        
        for(SimNode x : userX.getNeighbors().keySet())
            if(trustorUsers.containsKey(x.getId())){
                SimNode temp = trustorUsers.get(x.getId());
                trUsers1X.putAll(temp.getNeighbors());
            }
        for(SimNode y : userY.getNeighbors().keySet())
            if(trustorUsers.containsKey(y.getId())){
                SimNode temp = trustorUsers.get(y.getId());
                trUsers1Y.putAll(temp.getNeighbors());
            }
        
        for (SimNode x : trUsers1X.keySet()) 
            for (SimNode y : trUsers1Y.keySet()) 
                if (x.equals(y)) 
                    similarTrusted++;                                                                               

        return similarTrusted;
    }// get similar trusted user x y    
    
}// Network class end
