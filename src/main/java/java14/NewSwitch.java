package java14;

public class NewSwitch {

    public static void main(String[] args)
    {
        executeNewSwitchExpression("M");
        executeNewSwitchExpression("TH");
        executeNewSwitchExpression("");
        executeNewSwitchExpression("SUN");
    }

    public static void executeNewSwitchExpression(String day){

        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day.";
                else
                    yield "Looks like a Sunday.";
            }

        };

        System.out.println(result);
    }
}

/*
	In Java(prior to 14), a switch can traditionally be used as a statement, which means it performs actions but doesn't return a value. 
	However, starting with Java 12 (as a preview feature) and becoming a standard in Java 14, the switch can also be used as an expression, which means it can return a value.
*/