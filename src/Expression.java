public class Expression {
    String expressionTxt;
    Digit firstDigit;
    Digit secondDigit;
    Operation operation;
    boolean rome;

    public Expression(String expressionTxt, boolean rome) {
        this.expressionTxt = expressionTxt;
        this.rome = rome;
    }

    protected void parse() throws IncorrectInput {
        if(!rome){
            parseArabian();
        }else {
            parseRome();
        }

    }
    private void parseArabian() throws IncorrectInput {
        String digit1 = "";
        String digit2 = "";
        boolean first = true;
        char[] txt = expressionTxt.toCharArray();
        int i = 0;
        while (i < txt.length){
            if(txt[i] >= '0' && txt[i] <= '9'){
                if(first) {
                    digit1 = digit1.concat(String.valueOf(txt[i]));
                }
                else{
                    digit2 = digit2.concat(String.valueOf(txt[i]));
                }
                i++;
                continue;
            }
            if(txt[i] == '+') {
                if(!first) throw new IncorrectInput();
                else first = false;
                operation = Operation.ADD;
                i++;
                continue;
            }
            if(txt[i] == '-') {
                if(!first) throw new IncorrectInput();
                else first = false;
                operation = Operation.SUBTRACT;
                i++;
                continue;
            }
            if(txt[i] == '/') {
                if(!first) throw new IncorrectInput();
                else first = false;
                operation = Operation.DIVIDE;
                i++;
                continue;
            }
            if(txt[i] == '*') {
                if(!first) throw new IncorrectInput();
                else first = false;
                operation = Operation.MULTIPLY;
                i++;
                continue;
            }
            if(txt[i] == ' '){
                i++;
                continue;
            }
            throw new IncorrectInput();
        }

        try {
            firstDigit = new Digit(Integer.parseInt(digit1));
            secondDigit = new Digit(Integer.parseInt(digit2));
        } catch (Exception e) {
            throw new IncorrectInput();
        }
    }
    private void parseRome() throws IncorrectInput {
        String digit1 = "";
        String digit2 = "";
        boolean first = true;
        char[] txt = expressionTxt.toCharArray();
        int i = 0;
        while (i < txt.length){
            switch (txt[i]){
                case 'I':
                    if(first) digit1 = digit1.concat("I");
                    else digit2 = digit2.concat("I");
                    i++;
                    break;
                case 'V':
                    if(first) digit1 = digit1.concat("V");
                    else digit2 = digit2.concat("V");
                    i++;
                    break;
                case 'X':
                    if(first) digit1 = digit1.concat("X");
                    else digit2 = digit2.concat("X");
                    i++;
                    break;
                case '+':
                    if(!first) throw new IncorrectInput();
                    else {
                        first = false;
                        operation = Operation.ADD;
                        i++;
                    }
                    break;
                case '-':
                    if(!first) throw new IncorrectInput();
                    else {
                        first = false;
                        operation = Operation.SUBTRACT;
                        i++;
                    }
                    break;
                case '/':
                    if(!first) throw new IncorrectInput();
                    else {
                        first = false;
                        operation = Operation.DIVIDE;
                        i++;
                    }
                    break;
                case '*':
                    if(!first) throw new IncorrectInput();
                    else {
                        first = false;
                        operation = Operation.MULTIPLY;
                        i++;
                    }
                    break;
                case ' ':
                    i++;
                    break;
                default:
                    throw new IncorrectInput();
            }
        }
        firstDigit = new Digit(digit1);
        secondDigit = new Digit(digit2);
    }

    String calculate() throws IncorrectInput {
        parse();
        String resultStr = "";
        Digit result = new Digit(1);
        switch (operation){
            case ADD:
                result.arabValue = firstDigit.arabValue + secondDigit.arabValue;
                break;
            case SUBTRACT:
                result.arabValue = firstDigit.arabValue - secondDigit.arabValue;
                break;
            case MULTIPLY:
                result.arabValue = firstDigit.arabValue * secondDigit.arabValue;
                break;
            case DIVIDE:
                result.arabValue = firstDigit.arabValue / secondDigit.arabValue;
                break;
        }
        if(rome){
            result.setRomeValue();
            resultStr = result.romeValue;
        }else {
            resultStr = String.valueOf(result.arabValue);
        }

        return resultStr;
    }

    enum Operation{
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }
}

