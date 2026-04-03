package model;

import java.util.List;
import java.util.function.Function;

final class JsonUtils {
    private JsonUtils() {
    }

    static String escape(String value) {
        if (value == null) {
            return "";
        }

        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    static <T> String toJsonArray(List<T> items, Function<T, String> serializer) {
        StringBuilder json = new StringBuilder("[");

        for (int index = 0; index < items.size(); index++) {
            if (index > 0) {
                json.append(",");
            }
            json.append(serializer.apply(items.get(index)));
        }

        json.append("]");
        return json.toString();
    }
}
