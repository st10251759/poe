
package com.mycompany.poe_p1;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginIT {
    
    public LoginIT() {
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    Login login = new Login("Cameron","Chetty","kyl_1","Ch&&sec@ke99!");
    //test the validity of the username methodm --> checkUserName() if it is true
    @Test
    public void testCheckUserNameCorrect() {
        
        
        login.setUserName("kyl_1");
        boolean actual = login.checkUserName();
        boolean Expected = true;
        
        assertEquals(Expected, actual);
        //assertTrue(actual);
    }
    
        //test the validity of the username methodm --> checkUserName() if it is false
    @Test
    public void testCheckUserNameInCorrect() {
        login.setUserName("kyle!!!!!");
        boolean actual = login.checkUserName();
        assertFalse(actual);
    }
    
    /**
     * Test of checkPasswordComplexity method Correct, of class Login.
     */
    @Test
    public void testCheckPasswordComplexityCorrect() {
        login.setPassword("Ch&&sec@ke99!");
        boolean actual = login.checkPasswordComplexity();
        assertTrue(actual);
    }

        
    /**
     * Test of checkPasswordComplexity method InCorrect, of class Login.
     */
    @Test
    public void testCheckPasswordComplexityInCorrect() {
        login.setPassword("password");
        boolean actual = login.checkPasswordComplexity();
        assertTrue(actual);
    }

    
}
