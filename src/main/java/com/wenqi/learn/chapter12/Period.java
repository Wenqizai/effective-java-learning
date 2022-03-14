package com.wenqi.learn.chapter12;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Immutable class that uses defensive copying
 * 使用防御性复制的不可变类
 *
 * @author liangwenqi
 * @date 2022/3/14
 */
public class Period implements Serializable {
    private Date start;
    private Date end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    /**
     * readObject method with validity checking - insufficient!
     * @param s
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObjectBad(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // Check that our invariants are satisfied
        if (start.compareTo(end) > 0) {
            throw new InvalidObjectException(start +" after "+ end);
        }
    }


    /**
     * readObject method with defensive copying and validity checking
     * 具有防御性复制和有效性检查的 readObject 方法
     * @param s
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // Defensively copy our mutable components
        start = new Date(start.getTime());
        end = new Date(end.getTime());
        // Check that our invariants are satisfied
        if (start.compareTo(end) > 0) {
            throw new InvalidObjectException(start +" after "+ end);
        }
    }

    // writeReplace method for the serialization proxy pattern
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    /**
     * Serialization proxy for Period class
     */
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;
        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }
        private static final long serialVersionUID =234098243823485285L; // Any number will do (Item 87)
    }
}
