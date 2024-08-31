public class myPair<K,V> {
    private K student;
    private V schedule;
    public myPair(K x, V y){
        student = x;
        schedule = y;
    }
    public String toString(){
        return student + ":" + schedule;
    }
    public K getType1(){
        return student;
    }
    public V getType2(){
        return schedule;
    }

}
