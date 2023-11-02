package com.mycompany.main.utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

/**
 *
 * @author Jairo F
 */
public class Utility {

    public static final String TEXT_ONLY = "[a-zA-Z]+";
    public static final String INTEGERS_ONLY = "\\d+";
    public static final String DOUBLES = "\\d+\\.\\d+";
    public static final String LARGE_NUMBER = "\\d*|\\d+\\,\\d*";
    public static final String DATE_YYYYMMDD = "((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
    public static final String URL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    public static final String EMAIL = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@" 
        + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";

    public static void setMaskFormattedIntegerTextField(TextField tf) {
        
        StringConverter<Integer> intStringConverter = new StringConverter<>() {
            @Override
            public String toString(Integer object) {
                return object.toString();
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        };

        TextFormatter<Integer> formatter = new TextFormatter<>(
                intStringConverter, 
                0
        );
        
        tf.setTextFormatter(formatter);
    }
    
    public static void setMaskFormattedDoubleTextField(TextField tf) {
        DecimalFormat f = new DecimalFormat("###,###.##");
        
        StringConverter<Double> doubleStringConverter = new StringConverter<>() {
            @Override
            public String toString(Double object) {
                return f.format(object);
            }

            @Override
            public Double fromString(String string) {
                return Double.parseDouble(string);
            }
        };

        TextFormatter<Double> formatter = new TextFormatter<>(
                doubleStringConverter, //converter
                0.00//default value
        );
        
        tf.setTextFormatter(formatter);
    }
    
    public static void setMaskFormattedCurrencyTextField(TextField tf) {
        NumberFormat f = NumberFormat.getCurrencyInstance();
        StringConverter<Double> currencyStringConverter = new StringConverter<>() {
           @Override
            public String toString(Double object) {
              
                return f.format(object);
            }

            @Override
            public Double fromString(String data) {
                Double valor = Double.parseDouble(data);
                return valor;
            }
        };

        TextFormatter<Double> formatter = new TextFormatter<>(
                currencyStringConverter, //converter
                0.00
        );
        
        tf.setTextFormatter(formatter);
    }
    
       
    public static void ssetMaskFormattedDateTimeTextField(TextField tf, String pattern, LocalDateTime date) {
        
        StringConverter<LocalDateTime> dateStringConverter = new StringConverter<>() {
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            
            @Override
            public String toString(LocalDateTime object) {
                return object.format(dateFormatter);
            }

            @Override
            public LocalDateTime fromString(String date) {
                return LocalDateTime.parse(date, dateFormatter);
            }
        };

        TextFormatter<LocalDateTime> formatter = new TextFormatter<>(
                dateStringConverter, //converter
                date//default value
        );
        
        tf.setTextFormatter(formatter);
    }
    
    public static void ssetMaskFormattedDateTextField(TextField tf, String pattern, LocalDate date) {
        
        StringConverter<LocalDate> dateStringConverter = new StringConverter<>() {
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            
            @Override
            public String toString(LocalDate object) {
                return object.format(dateFormatter);
            }

            @Override
            public LocalDate fromString(String date) {
                return LocalDate.parse(date, dateFormatter);
            }
        };

        TextFormatter<LocalDate> formatter = new TextFormatter<>(
                dateStringConverter, //converter
                date//default value
        );
        
        tf.setTextFormatter(formatter);
    }
    
    public static void ssetMaskFormattedTimeTextField(TextField tf, String pattern, LocalTime hour) {
        
        StringConverter<LocalTime> dateStringConverter = new StringConverter<>() {
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            
            @Override
            public String toString(LocalTime object) {
                return object.format(dateFormatter);
            }

            @Override
            public LocalTime fromString(String date) {
                return LocalTime.parse(date, dateFormatter);
            }
        };

        TextFormatter<LocalTime> formatter = new TextFormatter<>(
                dateStringConverter, //converter
                hour//default value
        );
        
        tf.setTextFormatter(formatter);
    }
    
    public static boolean validateTextOnly(String text){
        return validateText(text, Utility.TEXT_ONLY);
    }
    
    public static boolean validateIntegersOnly(String text){
        return validateText(text, Utility.INTEGERS_ONLY);
    }
    
    public static boolean validateDouble(String text){ //doubles allowed
        return validateText(text, Utility.DOUBLES);
    }
    
    public static boolean validateNumbers(String text){ //Larger numbers with optional commas
        return validateText(text, Utility.LARGE_NUMBER);
    }
    
    public static boolean validateEmail(String text){ 
        return validateText(text, Utility.EMAIL);
    }
    
    public static boolean validateUrls(String text){
        return validateText(text, Utility.URL);
    }
    
    private static boolean validateText(String text, String pattern){
        return text.matches(pattern);
    }
    
    public static void validateCharacterEmptyPasswordField(PasswordField pf) {
        pf.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCharacter().equals(" ")) {
                    t.consume();
                }
            }

        });
    }

    public static void validateCharacterEmptyTextField(TextField tf) {
        tf.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCharacter().equals(" ")) {
                    t.consume();
                }
            }

        });
    }
}

