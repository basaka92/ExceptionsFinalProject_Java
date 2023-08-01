package Exceptions;

public class DataSizeException extends RuntimeException{
    public DataSizeException (int size){
        super("Вы ввели неверное количество данных. Попробуйте ввести данные заново.");
    }
}
