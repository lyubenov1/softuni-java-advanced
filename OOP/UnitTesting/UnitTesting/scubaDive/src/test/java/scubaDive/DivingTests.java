package scubaDive;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {
    private Diving diving;
    private DeepWaterDiver diver;

    @Before
    public void setUp() {
        diving = new Diving("test", 5);
        diver = new DeepWaterDiver("test1", 90);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Diving(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Diving("", 3);
    }

    @Test
    public void testConstructorShouldSetCorrectParameters() {
        String expectedName = "test";
        int expectedCapacity = 5;

        String actualName = diving.getName();
        int actualCapacity = diving.getCapacity();

        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualCapacity, expectedCapacity);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailIfBelowZero() {
        new Diving("test", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDiverShouldFailIfNoMoreCapacity() {
        Diving diving1 = new Diving("test", 0);
        diving1.addDeepWaterDiver(diver);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDiverShouldFailIfDiverAlreadyExist() {
        diving.addDeepWaterDiver(diver);
        diving.addDeepWaterDiver(diver);
    }

    @Test
    public void testAddDiverShouldSucceed() {
        diving.addDeepWaterDiver(diver);
    }

    @Test
    public void testRemoveDiverShouldReturnTrueIfDiverIsFound() {
        diving.addDeepWaterDiver(diver);
        DeepWaterDiver testDiver = new DeepWaterDiver("test7", 60);
        diving.addDeepWaterDiver(testDiver);
        Boolean isRemove = diving.removeDeepWaterDiver(testDiver.getName());

        Assert.assertTrue(isRemove);
    }



}
