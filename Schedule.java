
import java.util.ArrayList;
public class Schedule {

    private ArrayList<myPair<Integer, String>> mySchedule = new ArrayList<>();
    private String schedule = "";
    public Schedule(){
        mySchedule.add(new myPair<Integer,String>(1, "U.S. History"));
        mySchedule.add(new myPair<Integer,String>(3, "P.E."));
        mySchedule.add(new myPair<Integer, String>(4, "English"));
    }
    public void addClass(int x, String y){
        
        mySchedule.add(new myPair<Integer, String>(x,y));
        int size = mySchedule.size();
        for(int i = 0; i < size; i++){
            // checks and replaces if same period.
            if(mySchedule.get(i).getType1() == x && mySchedule.get(i).getType2() != y){
                mySchedule.remove(i);
                size = size-1;
                i=0;
            }
            
            //rearranges period
            if (mySchedule.get(i).getType1() > mySchedule.get(i+1).getType1()){
                myPair<Integer,String> replace = mySchedule.get(i+1);
                mySchedule.set(i+1, mySchedule.get(i));
                mySchedule.set(i, replace);
                i=0;
            }
        }
    }
    public String toString(){
        schedule = "";
        for(int i = 0; i < mySchedule.size(); i++){
            schedule += mySchedule.get(i) + " \n";
        }
        return schedule;
    }
}
