package bankSafe;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankVaultTest {
    BankVault vault;
    Item item;
    @Before
    public void setUp() {
        vault = new BankVault();
        item = new Item("John", "123");
    }

    @Test
    public void testConstructorShouldAdd12Cells() {
        assertEquals(12, vault.getVaultCells().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellDoesNotExist() throws OperationNotSupportedException {
        vault.addItem("A12", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellIsAlreadyTaken() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        vault.addItem("A1", new Item("Ivan", "152"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfItemIsAlreadyInCell() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        assertTrue(vault.getVaultCells().containsValue(item));
        vault.addItem("A1", item);
    }

    @Test
    public void testAddItem() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        vault.addItem("A2", new Item("Peter", "231"));
        vault.addItem("A3", new Item("Peter7", "282"));
        long actual = vault.getVaultCells().values().stream().filter(value -> value != null).count();
        assertEquals(3, actual);
    }

    @Test
    public void testAddItemShouldAddCorrectly() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        assertEquals(item.getItemId(), vault.getVaultCells().get("A1").getItemId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfCellDoesNotExist() {
        vault.removeItem("nonExistentCell", item);
    }

    @Test
    public void testRemoveItem() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        assertTrue(vault.getVaultCells().values().stream().anyMatch(v -> v.getItemId().equals(item.getItemId())));
        vault.addItem("A2", new Item("Peter", "231"));
        vault.addItem("A3", new Item("Peter7", "282"));
        vault.removeItem("A1", item);
        Item[] items = vault.getVaultCells().values().stream().filter(value -> value != null).toArray(bankSafe.Item[]::new);
        assertEquals(2, items.length);
        assertTrue(Arrays.stream(items).noneMatch(i -> i.getItemId().equals(item.getItemId())));
    }

    @Test
    public void testRemoveShouldSetValueToNull() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        vault.addItem("A2", new Item("Peter", "231"));
        vault.addItem("A3", new Item("Peter7", "282"));
        vault.removeItem("A1", item);
        assertEquals(null, vault.getVaultCells().get("A1"));
    }

    @Test
    public void testGetterShouldReturn() {
        Map<String, Item> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A1", null);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", null);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);


        Map<String, Item> actualMap = vault.getVaultCells();

        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void testAddShouldReturnString() throws OperationNotSupportedException {
        String actualMessage = vault.addItem("A1", item);
        String expectedMessage = String.format("Item:123 saved successfully!");
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testRemoveShouldReturnString() throws OperationNotSupportedException {
        vault.addItem("A1", item);
        String actualMessage = vault.removeItem("A1", item);
        String expectedMessage = String.format("Remove item:123 successfully!");
        assertEquals(expectedMessage, actualMessage);
    }
}