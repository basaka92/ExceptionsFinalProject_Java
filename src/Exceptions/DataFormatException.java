package Exceptions;

public class DataFormatException extends RuntimeException{
    public DataFormatException(){
        super("Формат введёных вами данных неверен. Попробуйте ввести данные заново.");
    }
}
