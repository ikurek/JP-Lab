package com.ikurek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Klasa bazowa
public class Main {


    //Metoda bazowa
    public static void main(String[] args) {

        //Lista kół
        List<Circle> listOfCircles = new ArrayList<>();

        //Scanner do zbierania danych z konsoli
        Scanner scanner = new Scanner(System.in);


        for(int i = 0; i < 3; i++) {

            //Dane pojedyńczego koła
            Circle circle = new Circle();
            double pointx;
            double pointy;

            //Poranie danych z CMD
            System.out.println("Dane koła nr " + i);
            System.out.print("Promień: ");
            //Przypisanie promienia do koła
            circle.setRadius(scanner.nextDouble());
            System.out.print("X: ");
            pointx = scanner.nextDouble();
            System.out.print("Y: ");
            pointy = scanner.nextDouble();

            //Przypisanie środka do koła
            circle.setCenter(pointx, pointy);

            //Dodanie koła do arraylist
            listOfCircles.add(circle);

            System.out.println("Dodano koło " + i +
                    " o danych S=(" + listOfCircles.get(i).getCenter().getX() +
                    " , " + listOfCircles.get(i).getCenter().getY() +
                    ") r=" + listOfCircles.get(i).getRadius());

        }

        System.out.print("Ilość punktów przecięcia = " + checkForCommonPoints(listOfCircles));

    }



    //Funkcja wyszukuje punkty wspólne dla trzech kół
    //Przyjmuje arraylist zawierający koła
    //Zwraca int zawierający liczbę przecięć
    public static int checkForCommonPoints(List<Circle> listOfCircles) {

        double x1, x2, y1, y2, radiusSum, centerDistance;
        int numberOfCommonPoints = 0;

        //Magiczna pętla w pętli
        //Losuje wariacje bez powtórzeń zbioru
        //0,1 - 0,2 - 2,1
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {

                //Warunek unikający sprawdzania tego samego koła 2 razy
                //Wyklucza pary 1,1 - 2,2
                if(i == j) {
                    j++;
                } else {

                    x1 = listOfCircles.get(i).getCenter().getX();
                    x2 = listOfCircles.get(j).getCenter().getX();
                    y1 = listOfCircles.get(i).getCenter().getY();
                    y2 = listOfCircles.get(j).getCenter().getX();


                    radiusSum = listOfCircles.get(i).getRadius() + listOfCircles.get(j).getRadius();
                    centerDistance = Math.hypot(x1-x2, y1-y2);

                    System.out.println("dist = " + centerDistance + " rad = " + radiusSum);

                    //Jeżeli suma promieni jest większa od odległości środków zwiększ licznik przecięć o 2
                    //Jeżeli jest równa zwiększ o 1
                    //Jeżeli jest mniejsza to koła nie stykają się
                    //Chyba
                    if(radiusSum > centerDistance) {
                        System.out.println("Koła " + i + " i " + j + " przecinają się");
                        numberOfCommonPoints = numberOfCommonPoints + 2;
                    } else if(radiusSum == centerDistance) {
                        System.out.println("Koła " + i + " i " + j + " są styczne");
                        numberOfCommonPoints++;
                    } else {
                        System.out.println("Koła " + i + " i " + j + " nie mają punktów wspólnych");
                    }



                }
            }
        }
        return numberOfCommonPoints;
    }
}