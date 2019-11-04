package com.lahtachev.triangle;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Triangle {
    private final Point point1;
    private final Point point2;
    private final Point point3;
    private final int sideNumber = 3;

    public Triangle(final Point point1, final Point point2, final Point point3) {
        if (point1.equals(point2) || point2.equals(point3)) {
            throw new IllegalArgumentException("Points should not be in one place");
        }
        if (point3.getX() - point1.getX() * (point2.getY() - point1.getY())
                == (point3.getY() - point1.getY()) * (point2.getX() - point1.getX())) {
            throw new IllegalArgumentException("Points should not be on one line");
        }
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public double getSide(final Point point1, final Point point2) {
        return sqrt(pow(point1.getX() - point2.getX(), 2) + pow(point1.getY() - point2.getY(), 2));
    }

    public double getAngle(final Point anglePoint,
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
        double angle1 = getAngle(point1, point2, point3);
        angles.add(angle1);
        double angle2 = getAngle(point2, point1, point3);
        angles.add(angle2);
        double angle3 = getAngle(point3, point1, point2);
        angles.add(angle3);
        return angles;
    }

    public double getPerimeter() {
        double ab = getSide(point1, point2);
        double ac = getSide(point1, point3);
        double bc = getSide(point2, point3);
        return ab + ac + bc;
    }

    public double getArea() {
        return (double) abs((point1.getX() - point3.getX()) * (point2.getY() - point3.getY())
                - (point1.getY() - point3.getY()) * (point2.getX() - point3.getX())) / 2;
    }

    public double getBisector(final Point anglePoint,
                              final Point sidePoint1,
                              final Point sidePoint2) {
        double a = getSide(anglePoint, sidePoint1);
        double b = getSide(anglePoint, sidePoint2);
        double c = getSide(sidePoint1, sidePoint2);
        double bisector = sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        return bisector;
    }

    public double getMedian(final Point anglePoint,
                            final Point sidePoint1,
                            final Point sidePoint2) {
        double medianX = (double) (sidePoint1.getX() + sidePoint2.getX()) / 2;
        double medianY = (double) (sidePoint1.getY() + sidePoint2.getY()) / 2;
        return sqrt(pow(medianX - anglePoint.getX(), 2) + pow(medianY - anglePoint.getY(), 2));
    }

    public double getHeight(final Point anglePoint,
                            final Point sidePoint1,
                            final Point sidePoint2) {
        return abs((sidePoint1.getY() - sidePoint2.getY()) * anglePoint.getX()
                + (sidePoint2.getX() - sidePoint1.getX()) * anglePoint.getY()
                + (sidePoint1.getX() * sidePoint2.getY() - sidePoint2.getX() * sidePoint1.getY()))
                / getSide(sidePoint1, sidePoint2);
    }

    public Point getMedianIntersection() {
        double centroidX = (point1.getX() + point2.getX() + point3.getX()) / sideNumber;
        double centroidY = (point1.getY() + point2.getY() + point3.getY()) / sideNumber;
        return new Point(centroidX, centroidY);
    }

    @Override
    public String toString() {
        return "A" + point1
                + ", B" + point2
                + ", C" + point3;
    }
}
