package View;

abstract class FormExceptions extends Exception {}

class InvalidIntValueException extends FormExceptions {
    @Override
    public String toString() {
        return "Niewłaściwy zakres wartości.";
    }
}

class InvalidIntFormatException extends FormExceptions {
    @Override
    public String toString() {
        return "Niewłaściwy format wartości.";
    }
}

class InvalidStringFieldException extends FormExceptions {
    @Override
    public String toString() {
        return "Brak wymaganych wartości.";
    }
}

class CannotSaveToFileException extends FormExceptions {
    @Override
    public String toString() {
        return "Nie udało się zapisać do pliku";
    }
}