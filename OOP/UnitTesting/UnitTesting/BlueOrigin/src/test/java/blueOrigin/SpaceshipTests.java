package blueOrigin;

import org.junit.*;

public class SpaceshipTests {
    Spaceship spaceship;
    Astronaut astronaut;
    @Before
    public void setUp() {
        spaceship = new Spaceship("test", 3);
        astronaut = new Astronaut("testName", 100);
    }

    @Test
    public void testGetCountReturnsCorrect() {
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsNullPointerExceptionWhenNull() {
        Spaceship testSpaceship = new Spaceship(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsNullPointerExceptionWhenEmpty() {
        Spaceship testSpaceship = new Spaceship("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsWhenNegative() {
        Spaceship spaceship = new Spaceship("testSpaceship", -3);
    }

    @Test
    public void testSetCapacityReturnsCorrectValue() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Ivan", 100));
        spaceship.add(new Astronaut("Ivan1", 100));
        Assert.assertEquals(3, spaceship.getCount());
    }

    @Test
    public void testRemoveShouldRemove() {
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
        spaceship.remove(astronaut.getName());
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenNoMoreCapacity() {
        spaceship.add(astronaut);
        spaceship.add(new Astronaut("Ivan", 100));
        spaceship.add(new Astronaut("Ivan1", 100));
        spaceship.add(new Astronaut("Ivan2", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWhenAstronautExists() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testAddTwoShouldAddTwo() {
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
        spaceship.add(new Astronaut("Ivan", 100));
        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testGetNameShouldReturnCorrectName() {
        String expectedName = "test";
        Assert.assertEquals(expectedName, spaceship.getName());
    }
}
