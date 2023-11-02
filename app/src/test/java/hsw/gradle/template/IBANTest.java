package hsw.gradle.template;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IBANTest {
    @Test void IBANDE() {
        String myIBAN = "DE68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertEquals(classUnderTest.check(myIBAN), true);
    }

    @Test void KontonummerAusgabe() {
        String myIBAN = "DE68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertEquals(classUnderTest.getKontonummer(myIBAN), "0012345678");
    }

    @Test void IBANByIncrements(){
        String myIBAN = "DE68210501700012345678";
        String pruefzahl = "68";
        String blz = "21050170";
        String kntnr = "0012345678";
        IBAN classUnderTest = new IBAN(pruefzahl, blz, kntnr);
        assertEquals(classUnderTest.check(myIBAN), true);
    }

    @Test void IBANnotDE() {
        String myIBAN = "US68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertEquals(classUnderTest.check(myIBAN), false);
    }

    @Test void IBANWrong() {
        String myIBAN = "ZZ68210501700012345678";
        IBAN classUnderTest = new IBAN(myIBAN);
        assertEquals(classUnderTest.check(myIBAN), false);
    }
}