import java.util.*;

public class ModifiedMSP {
    /**
     * Transform a int[][] to a ArrayList<ArrayList<Integer>>.
     * @param target
     * @return out
     */
    public static ArrayList<ArrayList<Integer>> toArrayList(int[][] target) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        for(int[] list : target){
            ArrayList<Integer> al = new ArrayList<>();
            for(int v : list) al.add(v);
            out.add(al);
        }
        return out;
    }

    /**
     * Create a stable matching where every buyers has been matched with
     * their desired number of sellers and every seller is match with exactly
     * one buyer.
     * @param nBuyerWants
     * @param buyers
     * @param sellers
     * @return map
     */
    public static HashMap<Integer, ArrayList<Integer>> matching(int[] nBuyerWants,
                                                                ArrayList<ArrayList<Integer>> buyers,
                                                                ArrayList<ArrayList<Integer>> sellers){
        System.out.println("Start to do matching.");
        System.out.println("nBuyerWants " + Arrays.toString(nBuyerWants));
        System.out.println("buyers " + buyers);
        System.out.println("sellers " + sellers);

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // key: buyer, value: seller
        Queue<Integer> q = new LinkedList<>(); // store unmatched sellers

        for (int i = 0; i < buyers.size(); i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < sellers.size(); i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int num = q.poll();
            if (sellers.get(num).size() == 0) { // no more buyer on the list
                System.out.println("Unable to find stable matching.");
                return map;
            }

            int first = sellers.get(num).get(0);
            ArrayList<Integer> list = map.get(first);
            list.add(num);
            nBuyerWants[first]--;
            if(nBuyerWants[first] < 0){ // # of buyer wants exceeded
                ArrayList<Integer> ranked = buyers.get(first);
                for(int i = ranked.size()-1; i >= 0; i--){
                    int kicked = ranked.get(i);
                    if(list.contains(kicked)){ // kick least preferred seller
                        sellers.get(kicked).remove(0);
                        q.offer(kicked);
                        list.remove(list.indexOf(kicked));
                        break;
                    }
                }
                nBuyerWants[first]++;
            }
            map.put(first, list);
        }

        return map;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> buyers, sellers; // ranked list of sellers and buyers
        // Sample.
        int[] nBuyerWants = {3, 2, 1, 2}; // # of sellers the buyers want
        int[][] _buyers = {
                {0,1,2,3,4,5,6,7},
                {0,1,2,3,4,5,6,7},
                {0,1,2,3,4,5,6,7},
                {0,1,2,3,4,5,6,7}
        };
        int[][] _sellers = {
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3}
        };

        sellers = toArrayList((_sellers));
        buyers = toArrayList((_buyers));

        System.out.println("Results " + matching(nBuyerWants, buyers, sellers));

        return;
    }
}
