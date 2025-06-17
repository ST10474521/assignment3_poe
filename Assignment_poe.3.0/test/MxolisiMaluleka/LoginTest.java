package MxolisiMaluleka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
        Registration.firstname = "John";
        Registration.lastname = "Doe";
    }

    @Test
    public void testCheckingtheusername() {
        assertTrue(Login.checkingtheusername("abc_"));
        assertFalse(Login.checkingtheusername("abcdef")); // too long, no underscore
        assertFalse(Login.checkingtheusername("abc"));    // no underscore
    }

    @Test
    public void testCheckpasswordcomplexity() {
        assertTrue(Login.checkpasswordcomplexity("Passw0rd@"));
        assertFalse(Login.checkpasswordcomplexity("password")); // no caps, number, or special char
        assertFalse(Login.checkpasswordcomplexity("PASS1234")); // no special char
    }

    @Test
    public void testCheckingtheSAcellnumber() {
        assertTrue(Login.checkingtheSAcellnumber("+27821234567"));
        assertFalse(Login.checkingtheSAcellnumber("0821234567")); // missing +27
        assertFalse(Login.checkingtheSAcellnumber("+2751234567")); // invalid prefix
    }

    @Test
    public void testUserRegistration() {
        String result = login.UserRegistration("abc_", "Passw0rd@", "+27821234567");
        assertEquals("YOUR ACCOUNT REGISTRATION IS COMPLETE AND SUCCESSFUL , PLEASE LOG IN.", result);
    }

    @Test
    public void testLogintheuser() {
        // First register the user
        login.UserRegistration("abc_", "Passw0rd@", "+27821234567");

        // Test correct login
        assertTrue(login.Logintheuser("abc_", "Passw0rd@"));

        // Test incorrect password
        assertFalse(login.Logintheuser("abc_", "WrongPass"));

        // Test unknown username
        assertFalse(login.Logintheuser("unknown", "Passw0rd@"));
    }

    @Test
    public void testLoginStatusreturner() {
        String successMessage = login.LoginStatusreturner(true);
        assertTrue(successMessage.contains("WELCOME BACK"));

        String failureMessage = login.LoginStatusreturner(false);
        assertEquals("INCORRECT USERNAME OR PASSWORD, PLEASE TRY AGAIN.", failureMessage);
    }
}