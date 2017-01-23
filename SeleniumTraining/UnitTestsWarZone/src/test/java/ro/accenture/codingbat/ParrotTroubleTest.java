package ro.accenture.codingbat;

import org.junit.Test;

/**
 * Created by andreicontan on 13/12/16.
 */
//@RunWith(value = Parameterized.class)
public class ParrotTroubleTest {

//    //default value = 0
//    @Parameterized.Parameter(value = 0)
//    public boolean talking;
//
//    @Parameterized.Parameter(value = 1)
//    public int hour;
//
//    @Parameterized.Parameter(value = 2)
//    public boolean expected;
//
//    @Parameterized.Parameters(name = "{index}: parrot talking {0} at {1} oclock expects {2}")
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {true, 7, false },
//                {true, 6, true},
//                {true, 10, false},
////                {true, 25, new IndexOutOfBoundsException()},
//                {false, 0, false }
//        });
//    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testForException()
    {
        ParrotTrouble parrot = new ParrotTrouble();

        parrot.parrotTroubleException(true,1000);
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
