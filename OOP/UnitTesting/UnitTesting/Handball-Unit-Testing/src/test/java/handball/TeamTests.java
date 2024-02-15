package handball;

import org.junit.*;

public class TeamTests {

    Team team;
    HandballPlayer handballPlayer;

    @Before
    public void setUp() {
        team = new Team("testTeam", 3);
        handballPlayer = new HandballPlayer("testName1");
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        Team team = new Team(null, 11);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        Team team = new Team("", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPositionShouldFailWhenNegative() {
        Team team = new Team("testTeam", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWhenNoCapacityLeft() {
        team.add(handballPlayer);
        team.add(new handball.HandballPlayer("testName3"));
        team.add(new handball.HandballPlayer("testName4"));
        team.add(new handball.HandballPlayer("testName5"));
    }

    @Test
    public void testAddShouldWorkCorrectly() {
        team.add(handballPlayer);
        Assert.assertEquals(1, team.getCount());
        team.add(new handball.HandballPlayer("testName3"));
        Assert.assertEquals(2, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldFailWhenNameIsNull() {
        team.remove("noneExistentName");
    }

    @Test
    public void testRemoveShouldRemoveCorrectly() {
        team.add(handballPlayer);
        Assert.assertEquals("testName1", handballPlayer.getName());
        team.remove(handballPlayer.getName());
        Assert.assertEquals(0, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamShouldFailWhenNameIsNull() {
        team.add(handballPlayer);
        team.add(new HandballPlayer("Misho"));
        team.playerForAnotherTeam("Tosho");
    }


    @Test
    public void testPlayerForAnotherTeamShouldSetStatusToFalse() {
        HandballPlayer one = new handball.HandballPlayer("Misho");
        HandballPlayer two = new handball.HandballPlayer("Ivan");
        team.add(one);
        team.add(two);
        team.playerForAnotherTeam("Ivan");
        Assert.assertFalse(two.isActive());
    }

    @Test
    public void testPlayerForAnotherTeamShouldSetStatusToTue() {
        HandballPlayer one = new handball.HandballPlayer("Misho");
        HandballPlayer two = new handball.HandballPlayer("Ivan");
        team.add(one);
        team.add(two);
        Assert.assertTrue(two.isActive());
    }

    @Test
    public void testPlayerForAnotherTeamShouldReturnThePlayer() {
        team.add(handballPlayer);
        HandballPlayer player = team.playerForAnotherTeam(handballPlayer.getName());
        Assert.assertEquals(player, handballPlayer);
    }

    @Test
    public void testGetStatistics() {
        team.add(new HandballPlayer("Ivan"));
        team.add(new HandballPlayer("Ivanov"));

        String expected = "The player Ivan, Ivanov is in the team testTeam.";
        String actual = team.getStatistics();

        Assert.assertEquals(expected, actual);
    }
}
