package seminars.five.number;

import java.util.List;

public class MaxNumberModule {

    public static Integer getMax(List<Integer> list){
        return list.stream().max((e1,e2)->e1-e2).get();
    }

}
