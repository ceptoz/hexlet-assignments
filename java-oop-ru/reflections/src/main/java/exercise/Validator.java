package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> result = new ArrayList<>();
        Class<?> c = address.getClass();
        List<Field> fields = List.of(c.getDeclaredFields());

        for (Field field :fields) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            if (annotation != null) {
                field.setAccessible(true);
                if (field.get(address) == null) {
                    result.add(field.getName());
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        Map<String, List<String>> result = new HashMap<>();
        Class<?> c = address.getClass();
        List<Field> fields = List.of(c.getDeclaredFields());

        for (Field field : fields) {
            List<String> errors = new ArrayList<>();
            NotNull notNullAnno = field.getAnnotation(NotNull.class);
            MinLength minLengthAnno = field.getAnnotation(MinLength.class);
            if (notNullAnno != null || minLengthAnno != null) {
                field.setAccessible(true);
                if (notNullAnno != null && field.get(address) == null) {
                    errors.add("can not be null");
                    result.put(field.getName(), errors);
                    continue;
                }
                if (minLengthAnno != null && field.get(address).toString().length() < minLengthAnno.minLength()) {
                    errors.add("Length less than " + minLengthAnno.minLength());
                    result.put(field.getName(), errors);
                }
            }
        }
        return result;
    }
}
// END
