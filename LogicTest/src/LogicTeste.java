import com.sun.source.tree.UnaryTree;

import java.util.ArrayList;
import java.util.List;

public class LogicTeste {

    public static void main(String[] args){
        List<UtilClassForTeste> list = new ArrayList<>();
        UtilClassForTeste um = new UtilClassForTeste(1, "Um");
        UtilClassForTeste dois = new UtilClassForTeste(2, "Dois");
        list.add(um);
        list.add(dois);
        System.out.println(list.size());

    }
}
