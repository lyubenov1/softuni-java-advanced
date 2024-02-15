package bank;

import org.junit.*;
public class BankTests {
    Bank bank;
    Client client;

    @Before
    public void setUp() {
        bank = new Bank("test", 3);
        client = new Client("testClient");
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        Bank testBank = new Bank(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        Bank testBank = new Bank("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenNegative() {
        Bank testBank = new Bank("test", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientShouldFailWhenNoCapacityLeft() {
        bank.addClient(client);
        bank.addClient(client);
        bank.addClient(client);
        bank.addClient(client);
    }

    @Test
    public void testAddClientShouldWorkCorrectly() {
        bank.addClient(client);
        Assert.assertTrue(bank.getClients().contains(client));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientShouldFailWhenNull() {
        bank.removeClient("nonExistentClient");
    }

    @Test
    public void testRemoveClientShouldWorkCorrectly() {
        bank.addClient(client);
        Assert.assertTrue(bank.getClients().contains(client));
        bank.removeClient(client.getName());
        Assert.assertEquals(0, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalShouldFailWhenClientDoesNotExist() {
        bank.loanWithdrawal("nonExistentClient");
    }

    @Test
    public void testLoanWithdrawalShouldWorkCorrectly() {
        bank.addClient(client);
        Assert.assertTrue(bank.getClients().contains(client));
        bank.loanWithdrawal(client.getName());
        Assert.assertFalse(client.isApprovedForLoan());
    }

    @Test
    public void testStatisticsShouldWorkCorrectly() {
        bank.addClient(client);
        bank.addClient(new Client("Petrov"));
        String expected = "The client testClient, Petrov is at the test bank!";
        Assert.assertEquals(expected, bank.statistics());
    }
}
