import java.util.*;
import java.util.stream.Collectors;

public class TwoSumClosestToTarget {

    public List<List<Integer>> twoSumClosest2Target(int maxTravelDist, List<List<Integer>> forwardRouteList,
                                                     List<List<Integer>> retumRouteList) {
                 // Boundary case
                 if(forwardRouteList == null || forwardRouteList.size() == 0 || retumRouteList == null || retumRouteList.size() == 0){
                         return new ArrayList<>();
                     }

                 int routeSumTillNow ;
                 int minimumRouteSum = 0;
                 List<List<Integer>> reutrnPairsList = new ArrayList<>();


                 for (int i = 0; i < forwardRouteList.size(); i++) {
                         for (int j = 0; j < retumRouteList.size(); j++) {
                                routeSumTillNow = forwardRouteList.get(i).get(1) + retumRouteList.get(j).get(1);
                                 if (Math.abs(routeSumTillNow - maxTravelDist) < Math.abs(minimumRouteSum - maxTravelDist)) {
                                         minimumRouteSum = routeSumTillNow;
                                         List<Integer> list = new ArrayList<>();
                                         list.add(forwardRouteList.get(i).get(0));
                                         list.add(retumRouteList.get(j).get(0));
                                         reutrnPairsList.clear();
                                         reutrnPairsList.add(list);
                                     }

                                 else if (Math.abs(routeSumTillNow - maxTravelDist) == Math.abs(minimumRouteSum - maxTravelDist)) { // if many matchable pairs, add them all to result
                                         List<Integer> list = new ArrayList<>();
                                         list.add(forwardRouteList.get(i).get(0));
                                         list.add(retumRouteList.get(j).get(0));
                                         reutrnPairsList.add(list);
                                     }
                           }
                   }
               return reutrnPairsList;
}

public List<List<Integer>> twoSumClosest2TargetImpl2(int maxTravelDist, List<List<Integer>> forwardRouteList,
                                                    List<List<Integer>> retumRouteList) {

    List<List<Integer>> returnPairsList = new LinkedList<List<Integer>>();
    forwardRouteList = forwardRouteList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
            .collect(Collectors.toList());
    forwardRouteList = forwardRouteList.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1)))
            .collect(Collectors.toList());
    int maxDist = maxTravelDist;
		while (true) {
        for (List<Integer> l : forwardRouteList) {
            for (List<Integer> b : forwardRouteList) {
                int forward = l.get(1);
                int backward = b.get(1);
                int tot = (forward + backward);
                if (tot > maxDist) {
                    break;
                }
                if (tot == maxDist) {
                    // print the pair of Id and optimum distance
                    returnPairsList.add(Arrays.asList(l.get(0), b.get(0), maxDist));
                    break;
                }

            }
        }
        if (returnPairsList.size() > 0) {
            break;
        }
        maxDist--;
    }
		return returnPairsList;
}



    private List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
                                                   List<List<Integer>> retumRouteList)
      {
          // WRITE YOUR CODE HERE
                TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
                 for (List<Integer> pair : retumRouteList) {
                         List<Integer> list = tree.getOrDefault(pair.get(1), new ArrayList<>());
                         list.add(pair.get(0));
                         tree.put(pair.get(1), list);
                     }
                 TreeMap<Integer, List<List<Integer>>> result = new TreeMap<>();
                 for (List<Integer> pair : forwardRouteList) {
                         Integer floorKey = tree.floorKey(maxTravelDist - pair.get(1));
                        if (floorKey != null) {
                            int diff = Math.abs(maxTravelDist - pair.get(1) - floorKey);
                       List<List<Integer>> list = result.getOrDefault(diff, new ArrayList<>());
                                 for (int id : tree.get(floorKey)) {
                                        List<Integer> match = new ArrayList<>();
                                         match.add(pair.get(0));
                                         match.add(id);
                                         list.add(match);
                                     }
                               result.put(diff, list);
                             }
                   }
               return result.get(result.firstKey());
             }

/*
        TEST CASE
      */
     public static void main(String[] args) {

                 TwoSumClosestToTarget test = new TwoSumClosestToTarget();
                 int maxTravelDist = 10000;
                 // ----------- INPUT: forwardRouteList---------
                 List<List<Integer>> forwardRouteList = new ArrayList<>();
                 List<Integer> list1 = new ArrayList<>();
                 list1.add(1);
                 list1.add(3000);
                 List<Integer> list2 = new ArrayList<>();
                 list2.add(2);
                 list2.add(5000);
                 List<Integer> list3 = new ArrayList<>();
                 list3.add(3);
                 list3.add(7000);
                 List<Integer> list4 = new ArrayList<>();
                 list4.add(4);
                 list4.add(10000);
                 forwardRouteList.add(list1);
                 forwardRouteList.add(list2);
                 forwardRouteList.add(list3);
                 forwardRouteList.add(list4);

                // ----------- INPUT: retumRouteList---------
         List<List<Integer>> retumRouteList = new ArrayList<>();
                 List<Integer> lr1 = new ArrayList<>();
                 lr1.add(1);
                 lr1.add(2000);
                 List<Integer> lr2 = new ArrayList<>();
                 lr2.add(2);
                 lr2.add(3000);
                 List<Integer> lr3 = new ArrayList<>();
                 lr3.add(3);
                 lr3.add(4000);
                 List<Integer> lr4 = new ArrayList<>();
                 lr4.add(4);
                 lr4.add(5000);
                 retumRouteList.add(lr1);
                 retumRouteList.add(lr2);
                 retumRouteList.add(lr3);
                 retumRouteList.add(lr4);
         System.out.println("FIRST APPROACH");
                 List<List<Integer>> result = test.twoSumClosest2Target(maxTravelDist, forwardRouteList, retumRouteList);
                 for (int i = 0; i < result.size(); i++) {
                        System.out.println("[" + result.get(i).get(0) + "," + result.get(i).get(1) + "]");
                     }

                 System.out.println("Solution from 2nd program with less complexity");
         List<List<Integer>> result2 = test.twoSumClosest2TargetImpl2(maxTravelDist, forwardRouteList, retumRouteList);
         for (int i = 0; i < result2.size(); i++) {
             System.out.println("[" + result2.get(i).get(0) + "," + result2.get(i).get(1) + "]");
         }

         System.out.println("Solution from 3RD program with less complexity");
         List<List<Integer>> result3 = test.optimalUtilization(maxTravelDist, forwardRouteList, retumRouteList);
         for (int i = 0; i < result3.size(); i++) {
             System.out.println("[" + result3.get(i).get(0) + "," + result3.get(i).get(1) + "]");
         }

           }
}