package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class KirillPetrovTest {
    @Test
    public void canAddComplexNumbers() {
        // Arrange
        var z1 = new ComplexNumber(1, 0);
        var z2 = new ComplexNumber(0, 1);

        // Act
        var z = z1.add(z2);

        // Assert
        assertEquals(new ComplexNumber(1, 1), z);
    }

    @Test
    public void canProductComplexNumbers() {
        // Arrange
        var z1 = new ComplexNumber(3, 2);
        var z2 = new ComplexNumber(2, 3);

        // Act
        var z = z1.multiply(z2);

        // Assert
        assertEquals(new ComplexNumber(0, 13), z);
    }
}
