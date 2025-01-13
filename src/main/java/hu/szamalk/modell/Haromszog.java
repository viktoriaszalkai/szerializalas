package hu.szamalk.modell;

import java.io.Serializable;
import java.util.Objects;

public class Haromszog implements Serializable {
    int A,B,C;

    public Haromszog(int oldal){
        this(oldal,oldal,oldal);
    }

    public Haromszog() {
        this(1,1,1);
    }

    public Haromszog(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
        nemSzerkesztheto();
    }

    public int getA(){
        return A;
    }
    public int getB(){
        return B;
    }
    public int getC(){
        return C;
    }

    public void setA(int a) {
        this.A = a;
        nemSzerkesztheto();
    }

    public void setB(int b) {
        this.B = b;
        nemSzerkesztheto();
    }

    public void setC(int c) {
        this.C = c;
        nemSzerkesztheto();
    }
    public void nemSzerkesztheto(){
        if ((A+B) <= C || (A+C) <= B || (B+C) <= A){
            throw new NemSzerkeszthetoException("a háromszög nem szerkeszthető");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Haromszog haromszog = (Haromszog) o;
        return A == haromszog.A && B == haromszog.B && C == haromszog.C;
    }

    //hashcode egy int, de minden objektum alapértelmezetten a memóriacímét adja vissza, ha a hashcode megegyezik, az equals is true lesz?
    @Override
    public int hashCode() {
        return Objects.hash(A,B,C);
    }

    @Override
    public String toString() {
        return "Haromszog{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }

    //JavaBean: újrafelhasználható, állapotot reprezentálni képes, átvitelt is segítő Java tervezési minta.
    // - Szerializálható, tehát implementálja Serializable interfészt
    // - Van publikus, paraméter nélküli konstruktora
    // - A tulajdonságokhoz való hozzáférést getter-ek és setter-ek segítségével teszi lehetővé

    //POJO: olyan Java-objektumok, amik teljesen hétköznapiak, nem rendelkeznek speciális tulajdonságokkal,
    // nem követnek semmilyen főbb Java-objektummodellt, megegyezést vagy keretrendszert.
    // - hashCode és equals
    // - toString a debughoz
    // - szükséges hierarchia --> jó gyakorlat
    //  --Abstract osztály interfészt implementál, minden más ebből származik
}