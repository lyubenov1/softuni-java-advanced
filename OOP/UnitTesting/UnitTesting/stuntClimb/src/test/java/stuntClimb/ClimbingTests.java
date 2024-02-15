package stuntClimb;

import org.junit.*;
public class ClimbingTests {

    Climbing climbing;
    RockClimber rockClimber;

    @Before
    public void setup() {
        climbing = new Climbing("Mountain", 4);
        rockClimber = new RockClimber("Misho", 90);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        Climbing climb = new stuntClimb.Climbing(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        Climbing climb = new stuntClimb.Climbing("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenNegative() {
        Climbing climb = new stuntClimb.Climbing("testMountain", -1);
    }

    @Test
    public void testRemoveClimberShouldReturnFalseWhenNoSuchAdded() {
        Assert.assertFalse(climbing.removeRockClimber(rockClimber.getName()));
    }

    @Test
    public void testRemoveClimberShouldReturnTrueWhenRemoved() {
        climbing.addRockClimber(rockClimber);
        climbing.addRockClimber(new stuntClimb.RockClimber("testName", 70));
        boolean isRemove = climbing.removeRockClimber(rockClimber.getName());
        Assert.assertTrue(isRemove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClimberShouldFailWhenNoMoreCapacity() {
        climbing.addRockClimber(rockClimber);
        climbing.addRockClimber(new stuntClimb.RockClimber("test21", 50));
        climbing.addRockClimber(new stuntClimb.RockClimber("test35", 732));
        climbing.addRockClimber(new stuntClimb.RockClimber("test83", 53));
        climbing.addRockClimber(new stuntClimb.RockClimber("test8362", 531));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClimberShouldFailWhenClimberAlreadyExists() {
        climbing.addRockClimber(rockClimber);
        climbing.addRockClimber(rockClimber);
    }

    @Test
    public void testAddShouldAddCorrectly() {
        climbing.addRockClimber(rockClimber);
        climbing.addRockClimber(new stuntClimb.RockClimber("test111", 30));
        Assert.assertEquals(2, climbing.getCount());
    }

}
