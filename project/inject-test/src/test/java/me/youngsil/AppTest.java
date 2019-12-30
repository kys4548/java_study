package me.youngsil;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1() {
        AccountService accountService = ContainerService.getObject(AccountService.class);
        assertNotNull(accountService);
        assertNotNull(accountService.accountRepository);
        accountService.join();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
