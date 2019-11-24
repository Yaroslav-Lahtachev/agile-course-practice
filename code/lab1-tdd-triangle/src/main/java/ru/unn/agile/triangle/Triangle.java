package ru.unn.agile.triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.*;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;
    private final int sideNumber = 3;

    public Triangle(final Point a, final Point b, final Point c) {
        if (a.equals(b) || b.equals(c)) {
            throw new IllegalArgumentException("Points should not be in one place");
        }
        if (isOnSameLine(a, b, c)) {
            throw new IllegalArgumentException("Points should not be on one line");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public double getSideLength(final Point point1, final Point point2) {
        return sqrt(pow(point1.getX() - point2.getX(), 2) + pow(point1.getY() - point2.getY(), 2));
    }

    public double getAngleA() {
        return getAngle(a, b, c);
    }

    public double getAngleB() {
        return getAngle(b, a, c);
    }

    public double getAngleC() {
        return getAngle(c, a, b);
    }

    private double getAngle(final Point anglePoint,
                            final Point sidePoint1,
                            final Point sidePoint2) {
        double angle = acos(((sidePoint1.getX() - anglePoint.getX())
                * (sidePoint2.getX() - anglePoint.getX())
                + (sidePoint1.getY() - anglePoint.getY()) * (sidePoint2.getY() - anglePoint.getY()))
                / (sqrt(pow(sidePoint1.getX() - anglePoint.getX(), 2)
                + pow(sidePoint1.getY() - anglePoint.getY(), 2))
                * sqrt(pow(sidePoint2.getX() - anglePoint.getX(), 2)
                + pow(sidePoint2.getY() - anglePoint.getY(), 2))));
        return toDegrees(angle);
    }

    public List calculateAngles() {
        List<Double> angles = new ArrayList<Double>();
        double angle1 = getAngle(a, b, c);
        angles.add(angle1);
        double angle2 = getAngle(b, a, c);
        angles.add(angle2);
        double angle3 = getAngle(c, a, b);
        angles.add(angle3);
        return angles;
    }

    public double getPerimeter() {
        double ab = getSideLength(a, b);
        double ac = getSideLength(a, c);
        double bc = getSideLength(b, c);
        return ab + ac + bc;
    }

    public double getArea() {
        return (double) abs((a.getX() - c.getX()) * (b.getY() - c.getY())
                - (a.getY() - c.getY()) * (b.getX() - c.getX())) / 2;
    }

    public double getBisectorA() {
        return getBisector(a, b, c);
    }

    public double getBisectorB() {
        return getBisector(b, a, c);
    }

    public double getBisectorC() {
        return getBisector(c, a, b);
    }

    private double getBisector(final Point anglePoint,
                               final Point sidePoint1,
                               final Point sidePoint2) {
        double ab = getSideLength(anglePoint, sidePoint1);
        double ac = getSideLength(anglePoint, sidePoint2);
        double bc = getSideLength(sidePoint1, sidePoint2);
        double bisector = sqrt(ab * ac * (ab + ac + bc) * (ab + ac - bc)) / (ab + ac);
        return bisector;
    }

    public double getMedianA() {
        return getMedian(a, b, c);
    }

    public double getMedianB() {
        return getMedian(b, a, c);
    }

    public double getMedianC() {
        return getMedian(c, a, b);
    }

    private double getMedian(final Point anglePoint,
                             final Point sidePoint1,
                             final Point sidePoint2) {
        double medianX = (double) (sidePoint1.getX() + sidePoint2.getX()) / 2;
        double medianY = (double) (sidePoint1.getY() + sidePoint2.getY()) / 2;
        return sqrt(pow(medianX - anglePoint.getX(), 2) + pow(medianY - anglePoint.getY(), 2));
    }

    public double getHeightA() {
        return getHeight(a, b, c);
    }

    public double getHeightB() {
        return getHeight(b, a, c);
    }

    public double getHeightC() {
        return getHeight(c, a, b);
    }

    private double getHeight(final Point anglePoint,
                             final Point sidePoint1,
                             final Point sidePoint2) {
        return abs((sidePoint1.getY() - sidePoint2.getY()) * anglePoint.getX()
                + (sidePoint2.getX() - sidePoint1.getX()) * anglePoint.getY()
                + (sidePoint1.getX() * sidePoint2.getY() - sidePoint2.getX() * sidePoint1.getY()))
                / getSideLength(sidePoint1, sidePoint2);
    }

    public Point getMedianIntersection() {
        double centroidX = (a.getX() + b.getX() + c.getX()) / sideNumber;
        double centroidY = (a.getY() + b.getY() + c.getY()) / sideNumber;
        return new Point(centroidX, centroidY);
    }

    private boolean isOnSameLine(final Point point1, final Point point2, final Point point3) {
        return point3.getX() - point1.getX() * (point2.getY() - point1.getY())
                == (point3.getY() - point1.getY()) * (point2.getX() - point1.getX());
    }

    @Override
    public String toString() {
        return "A" + a
                + ", B" + b
                + ", C" + c;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return sideNumber == triangle.sideNumber
                && Objects.equals(getA(), triangle.getA())
                && Objects.equals(getB(), triangle.getB())
                && Objects.equals(getC(), triangle.getC());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getC(), sideNumber);
    }
}
