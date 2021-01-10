package main.java.test;

public class CarDataEnum {
    public enum Field  {
        REGISTRATION_NUMBER("Registration"),
        MAKE("Make"),
        MODEL("Model"),
        COLOUR("Colour"),
        YEAR("Year");

        String value;

        Field( String value ) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}
