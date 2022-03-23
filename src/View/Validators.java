package View;

public class Validators {
    static Integer getInt(String value, int min, int max) throws InvalidIntValueException, InvalidIntFormatException {
        try{
            Integer newInt = Integer.parseInt(value);
            if (max == 0 && newInt < min){
                throw new InvalidIntValueException();
            }
            else if ((newInt < min || newInt > max) && max != 0){
                throw new InvalidIntValueException();
            }
            return newInt;
        }catch(NumberFormatException e){
            throw new InvalidIntFormatException();
        }
    }

    static Float getFloat(String value, int min) throws InvalidIntValueException, InvalidIntFormatException {
        try{
            Float newFloat = Float.parseFloat(value);
            if (newFloat < min){
                throw new InvalidIntValueException();
            }
            return newFloat;
        }catch(NumberFormatException e){
            throw new InvalidIntFormatException();
        }
    }

    static String getString(String text) throws InvalidStringFieldException {
        try{
            if (text.isEmpty() || text == null || !text.matches("[a-zA-Z0-9 ]+")){
                throw new NullPointerException();
            }
            return text;
        } catch(NullPointerException e){
            throw new InvalidStringFieldException();
        }
    }
}
