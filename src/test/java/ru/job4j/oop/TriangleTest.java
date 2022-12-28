package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when52and64and31Then1dot499() {
        Point a = new Point(5, 2);
        Point b = new Point(6, 4);
        Point c = new Point(3, 1);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 1.499;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when18and11and12Then9() {
        Point a = new Point(1, 8);
        Point b = new Point(1, 1);
        Point c = new Point(1, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}