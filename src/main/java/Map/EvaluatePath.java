package Map;

public class EvaluatePath
{
    String path = "";
    int value = 0;

    public EvaluatePath(String path)
    {
        // System.out.println("EvaluatePath constructor setting path to :: " + path);
        this.path = path;
    }

    public int getValue()
    {
        // System.out.println("EvaluatePath.getValue()");


        // System.out.println("path value is :: " + value);
        return value;
    }
}
