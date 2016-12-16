package ro.accenture.codingbat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by andreicontan on 13/12/16.
 */
@RunWith(value = Parameterized.class)
public class ParrotTroubleTest {

    //default value = 0
    @Parameterized.Parameter(value = 0)
    public boolean talking;

    @Parameterized.Parameter(value = 1)
    public int hour;

    @Parameterized.Parameter(value = 2)
    public boolean expected;

    @Parameterized.Parameters(name = "{index}: parrot talking {0} at {1} o'clock expects {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, 7, false },
                {true, 6, true},
                {true, 10, false},
                {true, 25, new IndexOutOfBoundsException()},
                {false, 0, false }
        });
    }


    @Test
    public void talkingLowBoundry_allowed()
    {
        ParrotTrouble parrot = new ParrotTrouble();
        boolean actual = parrot.parrotTrouble(talking,hour);
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void talkingAtMidnight_notAllowed()
//    {
//        ParrotTrouble parrot = new ParrotTrouble();
//        boolean talking = true;
//        int hour = 0;
//        Assert.assertTrue(parrot.parrotTrouble(talking,hour));
//    }
//
//    @Test(expected=IndexOutOfBoundsException.class)
//    public void talkingInvalidHour_throwException()
//    {
//        ParrotTrouble parrot = new ParrotTrouble();
//        boolean talking = false;
//        int hour = 25;
//        parrot.parrotTrouble(talking,hour);
//    }




}
