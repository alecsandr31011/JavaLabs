package org.example;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private int[][] matrix;
    private int width;
    private int height;

    public static void main(String[] args) {
        Main matrixOps = new Main();
        matrixOps.run();
    }

    public void run() {
        System.out.println("Введіть ширину матриці (не більше 20):");
        width = readIntFromUser();

        System.out.println("Введіть висоту матриці (не більше 20):");
        height = readIntFromUser();

        if (width <= 0 || height <= 0 || width > 20 || height > 20) {
            System.out.println("Невірні розміри матриці. Повинно бути від 1 до 20.");
            return;
        }

        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println("1. Ввести з клавіатури");
        System.out.println("2. Створити рандомно");

        int choice = readIntFromUser();

        switch (choice) {
            case 1:
                createMatrixFromUserInput();
                break;
            case 2:
                createRandomMatrix();
                break;
            default:
                System.out.println("Невірний вибір.");
                return;
        }

        printMatrix();
        findMinMaxAverage();
        calculateGeometricMean();
    }

    private void createMatrixFromUserInput() {
        matrix = new int[height][width];

        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = readIntFromUser();
            }
        }
    }

    private void createRandomMatrix() {
        matrix = new int[height][width];
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;

        System.out.println("Матриця (рандомні значення):");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(maxRange - minRange + 1) + minRange;
            }
        }
    }

    private void printMatrix() {
        System.out.println("Матриця:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void findMinMaxAverage() {
        int min = matrix[0][0];
        int max = matrix[0][0];
        int sum = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int current = matrix[i][j];
                if (current < min) {
                    min = current;
                }
                if (current > max) {
                    max = current;
                }
                sum += current;
            }
        }

        double average = (double) sum / (width * height);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }

    private void calculateGeometricMean() {
        double product = 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                product *= matrix[i][j];
            }
        }

        double geometricMean = Math.pow(product, 1.0 / (width * height));

        System.out.println("Середнє геометричне: " + geometricMean);
    }

    private int readIntFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}