import java.util.ArrayList;
public class Schedule {

    private ArrayList<Pair<Integer, String>> mySchedule = new ArrayList<>();
    private String schedule = "";
    public Schedule(){
        mySchedule.add(new Pair<Integer,String>(1, "U.S. History"));
        mySchedule.add(new Pair<Integer, String>(4, "English"));
    }
    public void addClass(int x, String y){
        mySchedule.add(new Pair<Integer,String>(x,y));
        for(int i = 0; i < mySchedule.size(); i++){
            if (mySchedule.get(i).getType1() > mySchedule.get(i+1).getType1()){
                Pair replace = mySchedule.get(i+1);
                mySchedule.set(i+1, mySchedule.get(i));
                mySchedule.set(i, replace);
            }
        }
    }
    public String toString(){
        
        for(int i = 0; i < mySchedule.size(); i++){
            schedule += mySchedule.get(i) + " \n";
        }
        return schedule;
    }
}
