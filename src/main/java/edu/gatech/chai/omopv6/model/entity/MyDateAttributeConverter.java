package edu.gatech.chai.omopv6.model.entity;

import edu.gatech.chai.omopv6.dba.service.DrugExposureServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter(autoApply = true)
public class MyDateAttributeConverter implements AttributeConverter<Date, String> {
    final static Logger logger = LoggerFactory.getLogger(MyDateAttributeConverter.class);
    @Override
    public String convertToDatabaseColumn(Date entityDate) {
        return null;
    }

    @Override
    public Date convertToEntityAttribute(String databaseDate) {
        if(databaseDate == null)
            return null;
        // parse databaseDate and return Date object
        try {
            logger.info(databaseDate);
            logger.info("HELLO WORLD");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            return  formatter.parse(databaseDate);
        } catch (ParseException e) {
            return null;
        }

    }
}
