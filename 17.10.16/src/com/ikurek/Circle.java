package com.ikurek;

import java.awt.geom.Point2D;

/**
 * Created by igor on 08.11.16.
 */
public class Circle {

    Point2D.Double center = new Point2D.Double(0, 0);
    Double radius = new Double(0);

    public Circle() {
        //Pusty konstruktor

    }

    public double getRadius() {

        return radius;

    }

    public void setRadius(Double newRadius) {

        this.radius = newRadius;
    }

    public Point2D.Double getCenter() {

        return center;
    }

    public void setCenter(Double x, Double y) {

        this.center = new Point2D.Double(x, y);

    }
}
