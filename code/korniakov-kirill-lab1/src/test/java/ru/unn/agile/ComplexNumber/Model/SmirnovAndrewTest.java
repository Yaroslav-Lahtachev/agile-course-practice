package ru.unn.agile.complexNumber.model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmirnovAndrewTest {

    @Test
    public void isEmptyConstructorEqualsZeroConstructor() {

        ComplexNumber complexNumberWithEmptyConstructor = new ComplexNumber();
        ComplexNumber complexNumberWithZeroConstructor = new ComplexNumber(0, 0);

        assertEquals(complexNumberWithEmptyConstructor, complexNumberWithZeroConstructor);
    }

    @Test
    public void canUseAddEnumOperation() {

        ComplexNumber z1 = new ComplexNumber(1, 2);
        ComplexNumber z2 = new ComplexNumber(3, 4);
        ComplexNumber addOperationResult = ComplexNumber.Operation.ADD.apply(z1, z2);

        ComplexNumber expectedAddOperationResult = new ComplexNumber(4, 6);
        assertEquals(expectedAddOperationResult, addOperationResult);
    }

    @Test
    public void canUseMultiplyEnumOperation() {

        ComplexNumber z1 = new ComplexNumber(5, 3);
        ComplexNumber z2 = new ComplexNumber(-3, -5);
        ComplexNumber multiplyOperationResult = ComplexNumber.Operation.MULTIPLY.apply(z1, z2);

        ComplexNumber expectedMultiplicationResult = new ComplexNumber(0, -34);
        assertEquals(expectedMultiplicationResult, multiplyOperationResult);
    }

    @Test
    public void isHashCodeDiffer() {

        ComplexNumber z1 = new ComplexNumber(1, 0);
        ComplexNumber z2 = new ComplexNumber(0, 0);

        assertTrue(z1.hashCode() != z2.hashCode());
    }

}
