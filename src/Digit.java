public class Digit {
    int arabValue;
    String romeValue;

    public Digit(int arabValue) throws IncorrectInput {
        if(arabValue < 1 || arabValue > 10){
            throw new IncorrectInput();
        }
        this.arabValue = arabValue;
        this.romeValue = "";

    }

    public Digit(String romeValue)throws IncorrectInput {
        this.romeValue = romeValue;
        switch (romeValue) {
            case "I":
                arabValue = 1;
                break;
            case "II":
                arabValue = 2;
                break;
            case "III":
                arabValue = 3;
                break;
            case "IV":
                arabValue = 4;
                break;
            case "V":
                arabValue = 5;
                break;
            case "VI":
                arabValue = 6;
                break;
            case "VII":
                arabValue = 7;
                break;
            case "VIII":
                arabValue = 8;
                break;
            case "IX":
                arabValue = 9;
                break;
            case "X":
                arabValue = 10;
                break;
            default:
                throw new IncorrectInput();
        }
    }

    protected void setRomeValue() throws IncorrectInput {

        if(arabValue < 1) throw new IncorrectInput();
        int copyValue = arabValue;

        if (copyValue == 100) {
            romeValue = romeValue.concat("C");
            return;
        }
        if (copyValue < 100 && copyValue > 89) {
            romeValue = romeValue.concat("XC");
            copyValue = copyValue - 90;
        }
        if (copyValue > 49 && copyValue < 90) {
            romeValue = romeValue.concat("L");
            copyValue = copyValue - 50;
        }
        if (copyValue > 39 && copyValue < 50) {
            romeValue = romeValue.concat("XL");
            copyValue = copyValue - 40;
        }
        if (copyValue > 29 && copyValue < 40) {
            romeValue = romeValue.concat("XXX");
            copyValue = copyValue - 30;
        }
        if (copyValue > 19 && copyValue < 30) {
            romeValue = romeValue.concat("XX");
            copyValue = copyValue - 20;
        }
        if (copyValue > 9 && copyValue < 20) {
            romeValue = romeValue.concat("X");
            copyValue = copyValue - 10;
        }
        if (copyValue == 9) {
            romeValue = romeValue.concat("IX");
            return;
        }
        if (copyValue < 9 && copyValue > 4) {
            romeValue = romeValue.concat("V");
            copyValue = copyValue - 5;
        }
        if (copyValue == 4) {
            romeValue = romeValue.concat("IV");
            return;
        }
        if (copyValue > 0 && copyValue < 4) {
            for (int i = 0; i < copyValue; i++) {
                romeValue = romeValue.concat("I");
            }
        }
    }
}

