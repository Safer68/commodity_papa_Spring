package by.nenartovich.util;


import by.nenartovich.Section;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SectionConverter implements AttributeConverter<Section, String> {

    @Override
    public String convertToDatabaseColumn(Section category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public Section convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Section.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

