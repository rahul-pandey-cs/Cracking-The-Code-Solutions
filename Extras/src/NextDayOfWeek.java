public class NextDayOfWeek {

//    enum Days{
//        Sun, Mon, Tue, Wed, Thu, Fri, Sat;
//    }

public static String solution(String s, int k){

        String array[] = new String[]{ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String returnDay = null;

        int remainingDays = k%7;

        for(int i=0; i<array.length; i++){
            if(array[i].equals(s) && i==array.length-1){
                returnDay = array[remainingDays-1];
            }else if(array[i].equals(s)) {
                returnDay = array[i + remainingDays];

            }
        }
        return returnDay;
}


public static void main(String args[]){
        System.out.println(solution("Sat",2));
    }

}
