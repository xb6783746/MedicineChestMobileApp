package vsu.ru.medicamentmobileapp.Exceptions;

/**
 * Created by Влад on 31.05.2017.
 */

public class DataIsNotAvailableException extends Exception {

    public DataIsNotAvailableException(Throwable inner, String message){

        super(message, inner);
    }

}
