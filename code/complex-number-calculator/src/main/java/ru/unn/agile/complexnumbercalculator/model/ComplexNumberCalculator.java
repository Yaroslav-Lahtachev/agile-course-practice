package ru.unn.agile.complexnumbercalculator.model;

public final class ComplexNumberCalculator {

    private ComplexNumberCalculator() { }

    static ComplexNumber add(final ComplexNumber z1, final ComplexNumber z2) {
        return ComplexNumber.createAlgebraicForm(z1.getRe() + z2.getRe(), z1.getIm() + z2.getIm());
    }

    static ComplexNumber subtract(final ComplexNumber z1, final ComplexNumber z2) {
        return ComplexNumber.createAlgebraicForm(z1.getRe() - z2.getRe(), z1.getIm() - z2.getIm());
    }

    static ComplexNumber multiply(final ComplexNumber z1, final ComplexNumber z2) {
        return ComplexNumber.createAlgebraicForm(z2.getRe() * z1.getRe() - z2.getIm() * z1.getIm(),
                z2.getRe() * z1.getIm() + z2.getIm() * z1.getRe());
    }

    static ComplexNumber divide(final ComplexNumber z1, final ComplexNumber z2)
            throws ArithmeticException {
        if ((z2.getIm() == 0) && (z2.getRe() == 0)) {
            throw new ArithmeticException("Can`t to be divided on zero");
        }

        double norma = z2.getIm() * z2.getIm() + z2.getRe() * z2.getRe();
        double rePart = z1.getRe() * z2.getRe() + z1.getIm() * z2.getIm();
        double imPart = z2.getRe() * z1.getIm() - z1.getRe() * z2.getIm();
        return ComplexNumber.createAlgebraicForm(rePart / norma, imPart / norma);
    }

    static ComplexNumber pow(final ComplexNumber z, final int degree) {
        double tempModule = Math.pow(z.getModule(), degree);
        double tempArgument = degree * z.getArgument();
        return ComplexNumber.createTrigonometricForm(tempModule, tempArgument);
    }

    public static ComplexNumber[] extractRoot(final ComplexNumber z, final int degree) {
        double phi0 = z.getArgument();
        ComplexNumber[] result = new ComplexNumber[degree];
        double tempModule = Math.pow(z.getModule(), 1 / degree);
        for (int k = 0; k < degree; k++) {
            double tempArgument = (phi0 + 2 * Math.PI * k) / degree;
            result[k] = ComplexNumber.createTrigonometricForm(tempModule, tempArgument);
        }
        return result;
    }

    static ComplexNumber conjugation(final ComplexNumber z) {
        return ComplexNumber.createAlgebraicForm(z.getRe(), -z.getIm());
    }
}
