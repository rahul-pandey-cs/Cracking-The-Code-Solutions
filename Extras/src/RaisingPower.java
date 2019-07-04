import java.util.ArrayList;
import java.util.List;

public class RaisingPower {


    static int raisingPower(List<Integer> a){

        int moduloValue = 1000000007;
        int maxOpsResult = Integer.MIN_VALUE;
        int returnIndex = 0;

        for(int i=0; i<a.size()-1; i++){

            int listElement = (int)Math.pow(a.get(i), a.get(i+1));
            if(listElement % moduloValue ==maxOpsResult && returnIndex > i){
                maxOpsResult = listElement % moduloValue;
                returnIndex = i+1;
            }
        }
        return returnIndex;
    }

    public static void main(String[] args){
        ArrayList<Integer> gfg = new ArrayList<Integer>();
//        gfg.add(1);
        gfg.add(2);
        gfg.add(3);
        System.out.println(raisingPower(gfg));

        String a = "abc";
        String b = new String("abc");
        String c = a;

        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b.equals(c));



    }


}
