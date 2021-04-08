package utilities;

public class StringHelper {

    public static String extractNumber(String filterString) {
        return filterString.replaceAll("[^0-9]", "");
    }
}
