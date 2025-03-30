package com.AlexandreLoiola.ApiTester.ApiTestSuite.infrastructure;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Converter(autoApply = true)
public class ZonedDateTimeAttributeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null) {
            return Timestamp.from(zonedDateTime.toInstant());
        }
        return null;
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp timestamp) {
        if (timestamp != null) {
            return ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}