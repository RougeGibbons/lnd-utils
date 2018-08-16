import org.junit.jupiter.api.Test;
import ru.rougegibbons.landsanddungeons.utils.functions.FloatComparator;

import static org.junit.jupiter.api.Assertions.*;

public final class FloatComparatorTest {
    @Test
    public void compareTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertEquals(FloatComparator.LESS_CODE,
                FloatComparator.compare(lhsOne, rhsOne).intValue(),
                "lhs shall be less than rhs");
        assertEquals(FloatComparator.MORE_CODE,
                FloatComparator.compare(rhsOne, lhsOne).intValue(),
                "lhs shall be more than lhs");
        final Float rhsTwo = 1.00000f;
        assertEquals(FloatComparator.EQUAL_CODE,
                FloatComparator.compare(lhsOne, rhsTwo).intValue(),
                "lhs shall be equal to rhs");
        final Float lhsTwo = 1.00001f;
        assertEquals(FloatComparator.EQUAL_CODE,
                FloatComparator.compare(lhsTwo, rhsTwo).intValue(),
                "lhs shall be equal to rhs (weak difference)");
        final Float lhsThree = 1.0001f;
        assertEquals(FloatComparator.MORE_CODE,
                FloatComparator.compare(lhsThree, rhsTwo).intValue(),
                "lhs shall be more than rhs (weak difference)");
        assertEquals(FloatComparator.MORE_CODE,
                FloatComparator.compare(lhsThree, lhsTwo).intValue(),
                "lhs shall be more than rhs (weak difference)");
    }

    @Test
    public void areEqualTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertFalse(FloatComparator.areEqual(lhsOne, rhsOne),
                "lhs shall not be equal to rhs");
        final Float rhsTwo = 1.00000f;
        assertTrue(FloatComparator.areEqual(lhsOne, rhsTwo),
                "lhs shall be equal to rhs");
        final Float lhsTwo = 1.00001f;
        assertTrue(FloatComparator.areEqual(lhsTwo, rhsTwo),
                "lhs shall be equal to rhs (weak difference)");
        final Float lhsThree = 1.0001f;
        assertFalse(FloatComparator.areEqual(lhsThree, rhsTwo),
                "lhs shall not be equal to rhs (weak difference)");
    }

    @Test
    public void isLessTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertTrue(FloatComparator.isLess(lhsOne, rhsOne),
                "lhs shall be less than rhs");
        final Float rhsTwo = 1.00000f;
        assertFalse(FloatComparator.isLess(lhsOne, rhsTwo),
                "lhs shall be equal to rhs");
        final Float lhsTwo = 1.00001f;
        assertFalse(FloatComparator.isLess(lhsTwo, rhsTwo),
                "lhs shall be equal to rhs (weak difference)");
        final Float lhsThree = 1.0001f;
        assertTrue(FloatComparator.isLess(rhsTwo, lhsThree),
                "lhs shall be less than rhs (weak difference)");
    }

    @Test
    public void isGreaterTest() {
        final Float lhsOne = 1.0f;
        final Float rhsOne = 2.0f;
        assertTrue(FloatComparator.isGreater(rhsOne, lhsOne),
                "lhs shall not be greater than rhs");
        final Float rhsTwo = 1.00000f;
        assertFalse(FloatComparator.isGreater(lhsOne, rhsTwo),
                "lhs shall be equal to rhs");
        final Float lhsTwo = 1.00001f;
        assertFalse(FloatComparator.isGreater(lhsTwo, rhsTwo),
                "lhs shall be equal to rhs (weak difference)");
        final Float lhsThree = 1.0001f;
        assertTrue(FloatComparator.isGreater(lhsThree, rhsTwo),
                "lhs shall be greater than rhs (weak difference)");
    }
}
