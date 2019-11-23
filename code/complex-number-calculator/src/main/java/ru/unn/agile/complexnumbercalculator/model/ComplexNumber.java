package ru.unn.agile.complexnumbercalculator.model;

public class ComplexNumber {
    private double re;
    private double im;
    private static final double DELTA = 0.0001;
    private double module;
    private double argument;

    private ComplexNumber(final double re, final double im,
                          final double module, final double argument) {
        this.re = re;
        this.im = im;
        this.module = module;
        this.argument = argument;
    }

    public static ComplexNumber createAlgebraicForm(final double re, final double im) {
        double argument = calcArgument(re, im);
        double module = calcModule(re, im);

        return new ComplexNumber(re, im, module, argument);
    }

    public ComplexNumber(final ComplexNumber a) {
        re = a.getRe();
        im = a.getIm();
        module = a.getModule();
        argument = a.getArgument();
    }

   public static ComplexNumber createTrigonometricForm(final double module, final double argument) {
       double re = calcRe(module, argument);
       double im = calcIm(module, argument);
       return new ComplexNumber(re, im, module, argument);
   }

    private static double calcArgument(final double re, final double im) {
        if ((Math.abs(re) < DELTA) && (Math.abs(im) < DELTA)) {
            return 0.0;
        } else if (Math.abs(im) < DELTA) {
            return re > 0.0 ? 0.0 : Math.PI;
        } else if (Math.abs(re) < DELTA) {
            return im > 0.0 ? Math.PI / 2.0 : -Math.PI / 2.0;
        }

        return Math.atan(im / re);
    }

    private static double calcModule(final double re, final double im) {
        // Boundary value
        if ((Math.abs(re) < DELTA) && (Math.abs(im) < DELTA)) {
            return 0.0;
        }
        if (Math.abs(im) < DELTA) {
            return Math.abs(re);
        }
        if (Math.abs(re) < DELTA) {
            return Math.abs(im);
        }

        return Math.sqrt(re * re + im * im);
    }

    private static double calcRe(final double module, final double argument) {
        return module * Math.cos(argument);
    }

    private static double calcIm(final double module, final double argument) {
        return module * Math.sin(argument);
    }

    public double getRe() {
        return re;
    }
    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        final int shift = 32;
        int prime = (int) im;
        int result = 1;

        long longBits = Double.doubleToLongBits(re);
        result = prime * result + (int) (longBits - (longBits >>> shift));
        return result;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ComplexNumber)) {
            return false;
        }

        if ((Math.abs((((ComplexNumber) object).getIm() - im)) < DELTA)
                && (Math.abs((((ComplexNumber) object).getRe() - re)) < DELTA)
                && (Math.abs((((ComplexNumber) object).getModule() - module)) < DELTA)) {
            return true;
        }
        return object.hashCode() == hashCode();
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();
        buffer.append(getRe() < 0 ? "-" : "");
        buffer.append(Math.abs(re))
                .append(getIm() < 0 ? " - " : " + ")
                .append(Math.abs(im))
                .append("i");
        return buffer.toString();
    }

    public double getArgument() {
        return argument;
    }

    public double getModule() {
        return module;
    }

    public double getAccuracy() {
        return DELTA;
    }
}
