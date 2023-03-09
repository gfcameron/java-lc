package convbinarynuminalinkedlisttoint;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConvBinNumInALinkedListToIntTest {

    private static ConvBinNumInALinkedListToInt conv;

    @BeforeClass
    public static void setUp() throws Exception {
        conv = new ConvBinNumInALinkedListToInt();
    }

    @Test
    public void case0() {
        ConvBinNumInALinkedListToInt.ListNode testCase = ConvBinNumInALinkedListToInt
                .buildListNodesFromList(new int[] { 1, 0, 1 });
        int result = conv.getDecimalValue(testCase);
        Assert.assertEquals(5, result);
    }

    @Test
    public void case1() {
        ConvBinNumInALinkedListToInt.ListNode testCase = ConvBinNumInALinkedListToInt
                .buildListNodesFromList(new int[] { 0 });
        int result = conv.getDecimalValue(testCase);
        Assert.assertEquals(0, result);
    }

}