package hu.szamalk;

import hu.szamalk.modell.Haromszog;
import hu.szamalk.modell.NemSzerkeszthetoException;

import javax.swing.*;
import javax.xml.transform.Source;
import java.io.*;


public class Main {


    public static void main(String[] args) {
        new  Main();
    }

    public Main() {
        //hasznalat();
        //egyenloseg();
        //szerializalas();
        deszereializalas();
    }

    private void deszereializalas() {
        try (ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("egyHaromszog.ser"))){
            Haromszog h = (Haromszog) objBe.readObject();
            System.out.println("A beolvasott háromszög állapota: "+h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("kettoHaromszog.ser"))){
            Haromszog h1 = (Haromszog) objBe.readObject();
            System.out.println("Az 1. beolvasott háromszög állapota: "+h1);
            Haromszog h2 = (Haromszog) objBe.readObject();
            System.out.println("Az 2. beolvasott háromszög állapota: "+h2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("tombHaromszogek.dat"))){
            Haromszog[] haromszogek = (Haromszog[]) objBe.readObject();
            System.out.println("A háromszögek tömb állapota: ");
            for (Haromszog haromszog : haromszogek) {
                System.out.println(haromszog);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void szerializalas() {
        Haromszog h1 = new Haromszog();
        //másnéven sorosítás
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("egyHaromszog.ser"))){
            objKi.writeObject(h1);
        } catch (IOException e) {
           e.printStackTrace();

        }
        Haromszog h2 = new Haromszog(2);
        //másnéven sorosítás
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("kettoHaromszog.bin"))){
            objKi.writeObject(h1);
            objKi.writeObject(h2);
        } catch (IOException e) {
            e.printStackTrace();

        }
        Haromszog h3 = new Haromszog(3,4,5);
        Haromszog[] kiTomb = {h1,h2,h3};
        //másnéven sorosítás
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("tombHaromszogek.dat"))){
          objKi.writeObject(kiTomb);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void egyenloseg() {
        Haromszog h1 = new Haromszog();
        System.out.println("h1: " + h1);
        System.out.println("h1.hashCode: " +h1.hashCode());

        Haromszog h2 = new Haromszog();
        System.out.println("h2: " + h2);
        System.out.println("h2.hashCode: " +h2.hashCode());

        System.out.println("h1.equals(h2): " + h1.equals(h2));

    }

    void hasznalat(){
        //megfelelő  használat
        Haromszog hsz = new Haromszog(7);
        System.out.println("A háromszög létrejött.");
        System.out.println("hsz = "+hsz);
        hsz.setC(8);
        System.out.println("Módosítás után:");
        System.out.println("hsz = "+hsz);

        //hibás használat konstruktorral
        try{
            Haromszog h = new Haromszog(5, 6, 17);
        }catch (NemSzerkeszthetoException e){
            System.err.println("A háromszög nem jött létre!");
            System.err.println("A hiba oka: "+ e.getMessage());
        }

        //hibás használat setterrel
        Haromszog h = new Haromszog();
        h.setC(-3);
    }
}
