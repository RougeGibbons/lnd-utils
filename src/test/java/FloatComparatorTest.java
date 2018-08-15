import org.junit.Test;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatComparator;

import static org.junit.Assert.*;

public final class FloatComparatorTest {
    @Test
    public void compareTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertEquals("lhs shall be less than rhs",
                FloatComparator.LESS_CODE,
                FloatComparator.compare(lhsOne, rhsOne).intValue());
        assertEquals("lhs shall be more than lhs",
                FloatComparator.MORE_CODE,
                FloatComparator.compare(rhsOne, lhsOne).intValue());
        final Float rhsTwo = 1.00000f;
        assertEquals("lhs shall be equal to rhs",
                FloatComparator.EQUAL_CODE,
                FloatComparator.compare(lhsOne, rhsTwo).intValue());
        final Float lhsTwo = 1.00001f;
        assertEquals("lhs shall be equal to rhs (weak difference)",
                FloatComparator.EQUAL_CODE,
                FloatComparator.compare(lhsTwo, rhsTwo).intValue());
        final Float lhsThree = 1.0001f;
        assertEquals("lhs shall be more than rhs (weak difference)",
                FloatComparator.MORE_CODE,
                FloatComparator.compare(lhsThree, rhsTwo).intValue());
        assertEquals("lhs shall be more than rhs (weak difference)",
                FloatComparator.MORE_CODE,
                FloatComparator.compare(lhsThree, lhsTwo).intValue());
    }

    @Test
    public void areEqualTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertFalse("lhs shall not be equal to rhs",
                FloatComparator.areEqual(lhsOne, rhsOne));
        final Float rhsTwo = 1.00000f;
        assertTrue("lhs shall be equal to rhs",
                FloatComparator.areEqual(lhsOne, rhsTwo));
        final Float lhsTwo = 1.00001f;
        assertTrue("lhs shall be equal to rhs (weak difference)",
                FloatComparator.areEqual(lhsTwo, rhsTwo));
        final Float lhsThree = 1.0001f;
        assertFalse("lhs shall not be equal to rhs (weak difference)",
                FloatComparator.areEqual(lhsThree, rhsTwo));
    }

    @Test
    public void isLessTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertTrue("lhs shall be less than rhs",
                FloatComparator.isLess(lhsOne, rhsOne));
        final Float rhsTwo = 1.00000f;
        assertFalse("lhs shall be equal to rhs",
                FloatComparator.isLess(lhsOne, rhsTwo));
        final Float lhsTwo = 1.00001f;
        assertFalse("lhs shall be equal to rhs (weak difference)",
                FloatComparator.isLess(lhsTwo, rhsTwo));
        final Float lhsThree = 1.0001f;
        assertTrue("lhs shall be less than rhs (weak difference)",
                FloatComparator.isLess(rhsTwo, lhsThree));
    }

    @Test
    public void isGreaterTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertTrue("lhs shall not be greater than rhs",
                FloatComparator.isGreater(rhsOne, lhsOne));
        final Float rhsTwo = 1.00000f;
        assertFalse("lhs shall be equal to rhs",
                FloatComparator.isGreater(lhsOne, rhsTwo));
        final Float lhsTwo = 1.00001f;
        assertFalse("lhs shall be equal to rhs (weak difference)",
                FloatComparator.isGreater(lhsTwo, rhsTwo));
        final Float lhsThree = 1.0001f;
        assertTrue("lhs shall be greater than rhs (weak difference)",
                FloatComparator.isGreater(lhsThree, rhsTwo));
    }
}
