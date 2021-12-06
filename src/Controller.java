import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public static void main(String[] args) throws IncorrectInput,IOException {
        Expression expression;
        String insert;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        insert = reader.readLine();
        reader.close();
        if(insert.contains("I") || insert.contains("X") || insert.contains("V")){
            expression = new Expression(insert, true);
        }else {
            expression = new Expression(insert, false);
        }

        System.out.println(expression.calculate());



    }
}
