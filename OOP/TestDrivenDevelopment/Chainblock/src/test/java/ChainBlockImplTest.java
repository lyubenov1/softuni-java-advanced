import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainBlockImplTest {
    private ChainBlock chainBlock;
    private List<Transaction> transactions;

    @Before
    public void prepare() {
        this.chainBlock = new ChainBlockImpl();
        this.transactions = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Toshko", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Toshko", 9.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.UNAUTHORIZED, "Sasho", "Pesho", 11.0);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.FAILED, "Tasho", "Toshko", 12.20);
        this.transactions.add(transaction);
        this.transactions.add(transaction1);
        this.transactions.add(transaction2);
        this.transactions.add(transaction3);
    }

    private void fillChainBlockWithTransactions() {
        this.transactions.forEach(existingTransaction -> this.chainBlock.add(existingTransaction));
    }

    @Test
    public void testContainsReturnsTrue() {
        Transaction transaction = transactions.get(0);
        chainBlock.add(transaction);
        Assert.assertTrue(this.chainBlock.contains(transaction));
    }

    @Test
    public void testContainsReturnsFalse() {
        Transaction transaction = transactions.get(0);
        Assert.assertFalse(this.chainBlock.contains(transaction));
    }

    @Test
    public void testContainsByIdReturnsTrue() {
        Transaction transaction = transactions.get(0);
        this.chainBlock.add(transaction);
        Assert.assertTrue(this.chainBlock.contains(0));

    }

    @Test
    public void testContainsByIdReturnsFalse() {
        Assert.assertFalse(this.chainBlock.contains(0));
    }

    @Test
    public void testAddCorrectTransaction() {
        this.chainBlock.add(transactions.get(0));
        Assert.assertEquals(1, this.chainBlock.getCount());
        this.chainBlock.add(transactions.get(1));
        Assert.assertEquals(2, this.chainBlock.getCount());
    }

    @Test
    public void testAddTransactionFail() {
        Transaction transaction = this.transactions.get(0);
        this.chainBlock.add(transaction);
        this.chainBlock.add(transaction);
        Assert.assertEquals(1, this.chainBlock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeInvalidTransactionStatus() {
        this.chainBlock.changeTransactionStatus(100, TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeTransactionStatusSuccess() {
        Transaction transaction = this.transactions.get(0);
        this.chainBlock.add(transaction);
        this.chainBlock.changeTransactionStatus(0, TransactionStatus.UNAUTHORIZED);
        Assert.assertEquals(TransactionStatus.UNAUTHORIZED, this.chainBlock.getById(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithWrongId() {
        this.chainBlock.getById(100);
    }

    @Test
    public void testGetByIdSuccess() {
        fillChainBlockWithTransactions();
        Transaction actualTransaction = this.chainBlock.getById(0);
        Assert.assertEquals(0, actualTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionWithInvalidId() {
        fillChainBlockWithTransactions();
        this.chainBlock.removeTransactionById(100);
    }

    @Test
    public void testRemoveTransactionByIdSuccess() {
        fillChainBlockWithTransactions();
        this.chainBlock.removeTransactionById(0);
        Assert.assertEquals(3, this.chainBlock.getCount());
        Assert.assertFalse(this.chainBlock.contains(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWithWrongStatus() {
        fillChainBlockWithTransactions();
        this.chainBlock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusSuccess() {
        this.transactions.sort(Comparator.comparing(Transaction::getAmount).reversed());
        fillChainBlockWithTransactions();

        List<Transaction> successfulSortedTransactions = this.transactions.stream()
                .filter(transaction -> transaction.getStatus()
                        .equals(TransactionStatus.SUCCESSFUL))
                .collect(Collectors.toList());

        Iterable<Transaction> actualSortedTransactions = this.chainBlock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        List<Transaction> actualSortedTransactionList = new ArrayList<>();
        actualSortedTransactions.forEach(actualSortedTransactionList::add);

        Assert.assertEquals(successfulSortedTransactions, actualSortedTransactionList);
    }

    @Test
    public void getAllInAmountRangeSuccess() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> actualSortedTransactions = this.chainBlock.getAllInAmountRange(10, 12);
        for (Transaction actual : actualSortedTransactions) {
            Assert.assertTrue(actual.getAmount() >= 10 && actual.getAmount() <= 12);
        }
    }

    @Test
    public void getAllInAmountRangeEmptyResult() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> actualSortedTransactions = this.chainBlock.getAllInAmountRange(100, 200);
        List<Transaction> resultList = new ArrayList<>();
        actualSortedTransactions.forEach(resultList::add);
        Assert.assertTrue(resultList.isEmpty());
    }
}