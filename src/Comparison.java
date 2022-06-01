import java.util.HashMap;

public class Comparison {
    static private HashMap<String, Integer> monthCmnEx = new HashMap<>();
    static private HashMap<String, Integer> monthCmnIn = new HashMap<>();
    void setMonthHashMaps(HashMap monthCmnEx, HashMap monthCmnIn){
        this.monthCmnEx = monthCmnEx;
        this.monthCmnIn = monthCmnIn;
    }

    HashMap getMonthsCmnEx(){
        return monthCmnEx;
    }

    HashMap getMonthsCmnIn(){
        return monthCmnIn;
    }


}
