
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

    static Network filmTrust;

    // "509" stands for Trustor User with most neighbors in trust.txt, change me
    // "272" stands for rating User with most ratings
    static int userId = 509;
    
    static String similaritMatrixFileName = "sim-";
        
    
    //static String metaPath = "TrTeTr";
    //static String metaPath = "TrTeTrTeTr";
    //static String metaPath = "TrTrTeTrTr";

    //static String metaPath = "TeTrTe";
    //static String metaPath = "TeTrTeTrTe";
    //static String metaPath = "TeTeTrTeTe";
    
    //static String metaPath = "UrImUr";    
    
    //static String metaPath = "TrImTr";
    //static String metaPath = "TeImTe";
    
    static String metaPath = "Testt";
    
    static double maeSum = 0;
    static double rmseSum = 0;
    static double preditionCounter = 0;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub        
        System.out.println("------------------------------------------------");
        System.out.println("FilmTrust Dataset Testing.");
        System.out.println("------------------------------------------------");

        double duration = System.currentTimeMillis();
        filmTrust = new Network(new File("src//data//ratings.txt"),
                new File("src//data//trust.txt"));

        filmTrust.connect();
        duration = System.currentTimeMillis() - duration;
        System.out.println("FilmTrust connected in " + duration / 1000 + " seconds.");
        System.out.println("------------------------------------------------");
        System.out.println("Data Statistics:");
        filmTrust.showStatistics();
        System.out.println("------------------------------------------------");

        duration = System.currentTimeMillis();

        if (metaPath.equals("TrTeTr")) {
            System.out.println("PathSim using Trustor -> Trustee -> Trustor :");
            String predictionFileName = similaritMatrixFileName+metaPath+ ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));
            

            Set<Integer> trustorUsers = filmTrust.getTrustorUsers();                        
            
            for (int userId : trustorUsers) {                                
                ArrayList<TrustorUser> similarTrustors = filmTrust.PathSimTrustor(userId, metaPath);                
                writeSimilarityToFile(similarTrustors, userId, pFile);
                
            }// for trustor users                        
            
            pFile.close();
            System.out.println("");          
            System.out.println("End of TrTeTr path");
        } // if TrTeTr
        
        else if (metaPath.equals("TrTeTrTeTr")) {
            System.out.println("PathSim using Trustor -> Trustee -> Trustor -> Trustee -> Trustor :");
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));

            Set<Integer> trustorUsers = filmTrust.getTrustorUsers();            

            int counter = 0,processStatus=0, size = trustorUsers.size();
            for (int userId : trustorUsers) {
                                
                ArrayList<TrustorUser> similarTrustors = filmTrust.PathSimTrustor(userId, metaPath);
                writeSimilarityToFile(similarTrustors, userId, pFile);                
                
            }// for            

            pFile.close();
            System.out.println("End of TrTeTrTeTr path");
        } // if TrTeTrTeTr
        
        else if (metaPath.equals("TrTrTeTrTr")) {
            System.out.println("PathSim using Trustor -> Trustor -> Trustee -> Trustor -> Trustor :");
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));            
            
            Set<Integer> trustorUsers = filmTrust.getTrustorUsers();


            for (int userId : trustorUsers) {                
                ArrayList<TrustorUser> similarTrustors = filmTrust.PathSimTrustor(userId, metaPath);
                writeSimilarityToFile(similarTrustors, userId, pFile);
            }
            pFile.close();
            System.out.println("End of TrTrTeTrTr path");
        } // if TrTrTeTrTr
        
        else if (metaPath.equals("TeTrTe")) {
            System.out.println("PathSim using Trustee -> Trustor -> Trustee :");
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));

            Set<Integer> trusteeUsers = filmTrust.getTrusteeUsers();

            for (int userId : trusteeUsers) {                
                ArrayList<TrusteeUser> similarTrustees = filmTrust.PathSimTrustee(userId, metaPath);
                writeSimilarityToFile(similarTrustees, userId, pFile);                                
            }
            pFile.close();
            System.out.println("End of TeTrTe path");
        } // if TeTrTe
        
        else if (metaPath.equals("TeTrTeTrTe")) {
            System.out.println("PathSim using Trustee -> Trustor -> Trustee -> Trustor -> Trustee:");                
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));

            Set<Integer> trusteeUsers = filmTrust.getTrusteeUsers();
            for (int userId : trusteeUsers) {                
                ArrayList<TrusteeUser> similarTrustees = filmTrust.PathSimTrustee(userId, metaPath);
                writeSimilarityToFile(similarTrustees, userId, pFile);
            }

            pFile.close();
            System.out.println("End of TeTrTeTrTe path");
        } // if TeTrTeTrTe                
        
        else if (metaPath.equals("TeTeTrTeTe")) {
            System.out.println("PathSim using Trustee -> Trustee -> Trustor -> Trustee -> Trustee:");                                
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));

            Set<Integer> trusteeUsers = filmTrust.getTrusteeUsers();

            for (int userId : trusteeUsers) {                
                ArrayList<TrusteeUser> similarTrustees = filmTrust.PathSimTrustee(userId, metaPath);
                writeSimilarityToFile(similarTrustees, userId, pFile);
            }

            pFile.close();
            System.out.println("End of TeTeTrTeTe path");
        } // if TeTeTrTeTe
        
        else if (metaPath.equals("UrImUr")) {
            System.out.println("PathSim using User -> Item -> User :");
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));

            Set<Integer> ratingUsers = filmTrust.getRatingUsers();
            
            for (int userId : ratingUsers) {
                filmTrust.resetDataOfUsers();
                ArrayList<RatingUser> similarRatingUsers = filmTrust.PathSimRatingUser(userId, metaPath);
                writeSimilarityToFile(similarRatingUsers, userId, pFile);
            }
            pFile.close();
            System.out.println("End of UrImUr path");
        }// if UrImUr
        else if (metaPath.equals("TrImTr")) {
            System.out.println("PathSim using Trustor -> Item -> Trustor :");            
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));
           
            Set<Integer> trustorUsers = filmTrust.getTrustorUsers();

            for (int userId : trustorUsers) {               
                ArrayList<TrustorUser> similarTrustors = filmTrust.PathSimTrustor(userId, metaPath);
                writeSimilarityToFile(similarTrustors, userId, pFile);
            }
            pFile.close();
            System.out.println("End of TrImTr path");
        }// if TrImTr
        
        else if (metaPath.equals("TeImTe")) {
            System.out.println("PathSim using Trustee -> Item -> Trustee :");             
            String predictionFileName = similaritMatrixFileName+metaPath + ".csv";
            FileWriter pFile = new FileWriter(new File(predictionFileName));

            Set<Integer> trusteeUsers = filmTrust.getTrusteeUsers();

            for (int userId : trusteeUsers) {                
                ArrayList<TrusteeUser> similarTrustees = filmTrust.PathSimTrustee(userId, metaPath);
                writeSimilarityToFile(similarTrustees, userId, pFile);
            }
            pFile.close();
            System.out.println("End of TeImTe path");
        }// if TrImTr
        else if(metaPath.equals("Test")){
            System.out.println("sperating users:");
            HashMap<Integer, RatingUser> ratingUsersItems = filmTrust.getRatingUsersItems();            
            HashMap<Integer, RatedItem> ratedItemsUsers = filmTrust.getRatedItemsUsers();
            
            System.out.println("cold users...");
            String seperatedUsers = "filmtrust-coldusers";
            String seperatedFileName = seperatedUsers + ".txt";
            FileWriter pFile = new FileWriter(new File(seperatedFileName));
            
            writeColdUsersToFile(ratingUsersItems, pFile);                        
            pFile.close();
            
            System.out.println("heavy users...");
            seperatedUsers = "filmtrust-heavyusers";
            seperatedFileName = seperatedUsers + ".txt";
            pFile = new FileWriter(new File(seperatedFileName));            
            writeHeavyUsersToFile(ratingUsersItems, pFile);                        
            pFile.close();   
            
            System.out.println("opinionated users...");
            seperatedUsers = "filmtrust-opinionatedusers";
            seperatedFileName = seperatedUsers + ".txt";
            pFile = new FileWriter(new File(seperatedFileName));            
            writeOpinionatedUsersToFile(ratingUsersItems, pFile);                        
            pFile.close();  
            
            System.out.println("niche items...");            
            seperatedUsers = "filmtrust-nicheitems";
            seperatedFileName = seperatedUsers + ".txt";
            pFile = new FileWriter(new File(seperatedFileName));            
            writeNicheItemsToFile(ratedItemsUsers, pFile);                        
            pFile.close();
            
            System.out.println("controversial items...");            
            seperatedUsers = "filmtrust-controversialitems";
            seperatedFileName = seperatedUsers + ".txt";
            pFile = new FileWriter(new File(seperatedFileName));            
            writeControversialItemsToFile(ratedItemsUsers, pFile);                        
            pFile.close();
            
            System.out.println("End of seperation");
        }//test

        duration = System.currentTimeMillis() - duration;

        System.out.println("------------------------------------------------");
        System.out.println("calculations done in " + duration / 1000 + " seconds.");

    }// main method

    public static void writeSimilarityToFile(ArrayList arr, int userId, FileWriter file) throws IOException {
        FileWriter similarityFile = file;
        ArrayList<SimNode> similarUsers = arr;
        int nSimilarUsers = similarUsers.size();       

        int maxSimilarUser = 0;
        int pureSimilarUser = 0;

        for (int i = 0; i < nSimilarUsers; i++) {

            SimNode similarUser = similarUsers.get(nSimilarUsers - i - 1);
            //System.out.println("i: "+i+" similaruserId: "+similarUser.getId());

            double similarity = similarUser.getSimilaritySimNode();

            if (similarity == 0) {
                break;
            }

            String result = userId + ","+similarUser.getId()+","+similarity;
            similarityFile.append(result + "\n");
        }// end of for knn
    }// end write similarity to file
       
    
    public static void writeColdUsersToFile(HashMap<Integer,RatingUser> arr, FileWriter file) throws IOException {
        FileWriter coldUserFile = file;
        HashMap<Integer,RatingUser> ratingUsers = arr;
        for(RatingUser ru: ratingUsers.values())
            if(ru.getNeighbors().size() <5)
                for(SimNode s: ru.getNeighbors().keySet())
                    coldUserFile.append(""+ru.getId()+" "+s.getId()+" "+ru.getNeighbors().get(s)+"\n");
    }// end write coldUsers to file
    
    public static void writeHeavyUsersToFile(HashMap<Integer,RatingUser> arr, FileWriter file) throws IOException {
        FileWriter coldUserFile = file;
        HashMap<Integer,RatingUser> ratingUsers = arr;
        for(RatingUser ru: ratingUsers.values())
            if(ru.getNeighbors().size() >=10)
                for(SimNode s: ru.getNeighbors().keySet())
                    coldUserFile.append(""+ru.getId()+" "+s.getId()+" "+ru.getNeighbors().get(s)+"\n");
    }// end write coldUsers to file
   
    public static void writeOpinionatedUsersToFile(HashMap<Integer,RatingUser> arr, FileWriter file) throws IOException {
        FileWriter coldUserFile = file;
        HashMap<Integer,RatingUser> ratingUsers = arr;
        for(RatingUser ru: ratingUsers.values())
            if(ru.getNeighbors().size() >=5){
                
                double sum = 0;
                int size = ru.getNeighbors().size();
                for(SimNode s: ru.getNeighbors().keySet())
                    sum+= Double.valueOf(ru.getNeighbors().get(s));
                double mean = sum / size;
                sum =0;
                for(SimNode s: ru.getNeighbors().keySet())
                    sum += Math.pow(Double.valueOf(ru.getNeighbors().get(s)) - mean ,2);
                double standardDev = Math.sqrt(sum/size);
                if(standardDev >=1.4)
                    for(SimNode s: ru.getNeighbors().keySet())
                        coldUserFile.append(""+ru.getId()+" "+s.getId()+" "+ru.getNeighbors().get(s)+"\n");
            }
    }// end write coldUsers to file
    
    public static void writeNicheItemsToFile(HashMap<Integer,RatedItem> arr, FileWriter file) throws IOException {
        FileWriter coldUserFile = file;
        HashMap<Integer,RatedItem> ratedItems = arr;
        for(RatedItem ri: ratedItems.values())
            if(ri.getNeighbors().size() <5)
                for(SimNode s: ri.getNeighbors().keySet())
                    coldUserFile.append(""+s.getId()+" "+ri.getId()+" "+ri.getNeighbors().get(s)+"\n");
    }// end write coldUsers to file
    
    public static void writeControversialItemsToFile(HashMap<Integer,RatedItem> arr, FileWriter file) throws IOException {
        FileWriter coldUserFile = file;
        HashMap<Integer,RatedItem> ratedItems = arr;
        for(RatedItem ri: ratedItems.values())
            if(ri.getNeighbors().size() >=1){
                
                double sum = 0;
                int size = ri.getNeighbors().size();
                for(SimNode s: ri.getNeighbors().keySet())
                    sum+= Double.valueOf(ri.getNeighbors().get(s));
                double mean = sum / size;
                sum =0;
                for(SimNode s: ri.getNeighbors().keySet())
                    sum += Math.pow(Double.valueOf(ri.getNeighbors().get(s)) - mean ,2);
                double standardDev = Math.sqrt(sum/size);
                if(standardDev >=1.5)
                    for(SimNode s: ri.getNeighbors().keySet())
                        coldUserFile.append(""+s.getId()+" "+ri.getId()+" "+ri.getNeighbors().get(s)+"\n");
            }
    }// end write coldUsers to file
    
    public static void printArray(ArrayList arr, int userId) {
        int itemId = 13;
        ArrayList<SimNode> similarUsers = arr;
        System.out.println("Size of similar users of user " + userId + ": " + similarUsers.size());
        int n = similarUsers.size();
        int knn = 18;
        double predictedRating = 0, similaritySum = 0, ratingSum = 0;
        int pureRatingUser = 0, noSimilarUser = 0;
        for (int i = 0; i < knn; i++) {

            SimNode similarUser = similarUsers.get(n - i - 1);
            String rate = filmTrust.getRateOfItem(similarUser.getId(), itemId);

            double similarity = similarUser.getSimilaritySimNode();
            if (similarity == 0) {
                noSimilarUser++;
            }
            if (noSimilarUser > knn) {
                break;
            }
            System.out.printf("%-20s%-30s%-20s%-20s%n", similarUser.getData(), similarity == 0 ? "noSimilarity" : similarity, "rate to item " + itemId + " : ", rate);
            if (similarUser.getId() == userId) {
                continue;
            }

            if (similarity == 0) {
                continue;
            }

            if (rate.equals("noRating")) {
                continue;
            }
            similaritySum += similarity;
            pureRatingUser++;
            if (pureRatingUser >= knn) {
                break;
            }
            double similarUserRating = Double.valueOf(rate);
            ratingSum += similarUserRating * similarity;

            //predictedRating += (1d/(i+1))*similarUserRating;
        } // end of for knn
        //predictedRating /= pureRatingUser;
        //predictedRating *= similaritySum;
        predictedRating = ratingSum / similaritySum;
        System.out.println("pure similar users: " + pureRatingUser + " and sum of similarities: " + similaritySum);

        System.out.println("** pridicted rating of item " + itemId + " for user " + userId + " : " + predictedRating);
    }// end of print array
}// main class

