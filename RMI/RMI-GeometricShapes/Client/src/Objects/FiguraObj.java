package Objects;

import java.io.Serializable;

public class FiguraObj implements Serializable {
    private float L1;
    private float L2;
    private float base;
    private float altura;

    public FiguraObj() {
    }

    public FiguraObj(float L1, float L2, float base, float altura) {
        this.L1 = L1;
        this.L2 = L2;
        this.base = base;
        this.altura = altura;
    }

    // GETTERS Y SETTERS

    // lado 1
    public float getL1() {
        return L1;
    }

    public void setL1(float L1) {
        this.L1 = L1;
    }

    // Lado 2
    public float getL2() {
        return L2;
    }

    public void setL2(float L2) {
        this.L2 = L2;
    }

    // Base
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    // Altura
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
