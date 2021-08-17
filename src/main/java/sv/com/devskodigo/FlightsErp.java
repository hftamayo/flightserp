package sv.com.devskodigo;

import lombok.Getter;
import lombok.Setter;

public class FlightsErp {

    @Getter
    @Setter
    private static int testId;

    public static void main(String[] args){
        testId = 920;
        System.out.println(testId);
    }
}

