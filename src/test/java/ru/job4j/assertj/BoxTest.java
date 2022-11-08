package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(100, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void getNumberOfVerticesCube() {
        Box box = new Box(8, 10);
        int num = box.getNumberOfVertices();
        assertThat(num).isEqualTo(8);
    }

    @Test
    void getNumberOfVerticesUnknown() {
        Box box = new Box(80, 10);
        int num = box.getNumberOfVertices();
        assertThat(num).isEqualTo(-1);
    }

    @Test
    void isExistFalse() {
        Box box = new Box(80, 10);
        boolean flag = box.isExist();
        assertThat(flag).isEqualTo(false);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(4, 2);
        boolean flag = box.isExist();
        assertThat(flag).isEqualTo(true);
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 10);
        double num = box.getArea();
        assertThat(num).isEqualTo(1256.6370614359173);
    }

    @Test
    void getAreaTetrahedron() {
        Box box = new Box(4, 10);
        double num = box.getArea();
        assertThat(num).isEqualTo(173.20508075688772);
    }

    @Test
    void getAreaCube() {
        Box box = new Box(8, 10);
        int num = (int) box.getArea();
        assertThat(num).isEqualTo(600);
    }

    @Test
    void getAreaUNKNOWN() {
        Box box = new Box(10, 10);
        double num = box.getArea();
        assertThat(num).isEqualTo(0);
    }
}