package my_demo.converter;


import java.time.LocalDate;

public class ConvertClass {

    public LocalDate date;

    public StringObject stringObject;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StringObject getStringObject() {
        return stringObject;
    }

    public void setStringObject(StringObject stringObject) {
        this.stringObject = stringObject;
    }

    @Override
    public String toString() {
        return "ConvertClass{" +
                "date=" + date +
                ", stringObject=" + stringObject +
                '}';
    }
}
