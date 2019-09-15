package my_demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringToDateConverter implements Converter<String, LocalDate> {

    private String datePattern;

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public LocalDate convert(String source) {
        System.out.println("==========StringToDateConverter");
        LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern(datePattern));
        return localDate;
    }
}
