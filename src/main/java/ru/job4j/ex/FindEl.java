package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element \"" + key + "\" not found in  area");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = new String[]{"==", "[]", "{}", "()", "&&", "||"};
        String key = "Uwu";
        try {
            indexOf(value, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
