package home.assignment;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ObjectBuffer {
    ArrayList<ObjectBuffer> objects = new ArrayList<ObjectBuffer>();
    Date date;
    String messageType;
    String messageText;
    String exceptionData;
    public ObjectBuffer(Date date, String messageType, String messageText, String exceptionData)
    {
        this.date = date;
        this.messageType = messageType;
        this.messageText = messageText;
        this.exceptionData = exceptionData;
    }
    public ObjectBuffer(ArrayList<ObjectBuffer> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "ObjectBuffer{" +
                "date=" + date +
                ", messageType='" + messageType + '\'' +
                ", messageText='" + messageText + '\'' +
                ", exceptionData='" + exceptionData + '\'' +
                '}';
    }
}
