package by.pvt;

import java.util.ArrayList;
import java.util.List;

class BaseWithCommands {

    private static List<String> base = new ArrayList<>();
    static {
        base.add("How many years have we known each other?");
        base.add("What is the weather in Minsk?");
        base.add("What is the weather in Moscow?");
        base.add("What is the weather in Brest?");
        base.add("What is the weather in Warsaw?");
        base.add("What is the weather in Boston?");
        base.add("What is the weather in Prague?");
        base.add("What is the weather in Berlin?");
        base.add("What is the weather in Madrid?");
        base.add("What is the weather in Bangladesh?");
        base.add("What is the weather in Toronto?");
        base.add("What is the weather in Washington?");
        base.add("What is the weather in New-York?");
        base.add("What is the weather in Budapest?");
        base.add("What is the weather in Gomel'?");
        base.add("What is the weather in Vitebsk?");
        base.add("What is the weather in Grodno?");
        base.add("What is the weather in Saint-Petersburg?");
        base.add("What is the weather in Vladivostok?");
    }

    static List<String> getBase() {
        return base;
    }
}
