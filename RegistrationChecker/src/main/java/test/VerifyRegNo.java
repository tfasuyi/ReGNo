package main.java.test;

import main.java.Utilities.Parq;

import static main.java.Utilities.Parq.*;

public class VerifyRegNo {
    public static void verifyCarRegDetails(final String label, final String value) throws Exception {
        focus(Parq.text(label));
        Parq.ascend();
        show();
        Parq.contains(value);

    }
}
