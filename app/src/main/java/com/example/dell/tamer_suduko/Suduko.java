package com.example.dell.tamer_suduko;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by DELL on 5/27/2016.
 */

public class Suduko {
    private int[][] suduko;
    static boolean r = true;
    static boolean c = true;
    static boolean block = true;


    public Suduko(int[][] suduko) {
        this.suduko = suduko;
    }



    // coordination f4 !filled
    private IndexPair startPoint() {
        int i = 0, j = 0;
        IndexPair indexPair = new IndexPair();

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (suduko[i][j] == 0) {
                    indexPair.rowIndex = i;
                    indexPair.columnIndex = j;
                    return indexPair;// coordination f4 !filled
                }
            }
        }

        indexPair.rowIndex = i - 1; //blshna mn zero
        indexPair.columnIndex = j - 1;
        return indexPair;
    }


    public boolean recursionSearch() {
        int rowIndex = startPoint().rowIndex;
        int columnIndex = startPoint().columnIndex;

        // awsl la25rha kolhom filled
        // as8ar mn 8 el puzzl not filled
        if (rowIndex >= 8 && columnIndex >= 8 && suduko[rowIndex][columnIndex] != 0) {
            return true;
        } // suduko solved    m3bya }

        // check el value qemtha iza redundent bl c r sqr
        for (int value = 1; value < 10; value++) {
            if (checkAll(rowIndex, columnIndex, value)) {// tripaaal true
                suduko[rowIndex][columnIndex] = value; // 5azn hay el qemma fel cell
                if (!recursionSearch()) { // To modify & so to erease
                    suduko[rowIndex][columnIndex] = 0; // erase last move

                } else {
                    // JOptionPane.showMessageDialog(frame, "Error !");
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Check whether a solution is valid
     */
    public static boolean isValid(int[][] suduko) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (suduko[i][j] < 1 || suduko[i][j] > 9 || !isValid(i, j, suduko))


                    return false;

        return true; // The solution is valid
    }


    public static boolean isValid(int i, int j, int[][] suduko) {
        for (int column = 0; column < 9; column++)
            if (column != j && suduko[i][column] == suduko[i][j]) {
                r = false; // row is wrong
                return false;
            }


        // Check whether grid[i][j] is valid in j's column
        for (int row = 0; row < 9; row++)
            if (row != i && suduko[row][j] == suduko[i][j]) {
                c = false;
                return false;
            }


        // Check whether grid[i][j] is valid in the 3-by-3 box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if (row != i && col != j && suduko[row][col] == suduko[i][j]) {
                    block = false;
                    return false;
                }


        return true; // The current value at grid[i][j] is valid
    }


    public void check(boolean r, boolean c, boolean block) {
        if (r == false) {

            String ErrBlock = "Error in row !";
            ;
        } else if (c == false) {

            String ErrBlock = "Error in Coulmn !";
        } else if (block == false) {

            String ErrBlock = "Error in Block 3*3 !";

        }


    }


// ==================================== Welcome TO CHeck =================

    private boolean checkRow(int rowIndex, int value) {
        for (int i = 0; i < 9; i++) {
            if (suduko[rowIndex][i] == value) {
                // System.out.println("error in row");
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int columnIndex, int value) {
        for (int i = 0; i < 9; i++) {
            if (suduko[i][columnIndex] == value) {
                // System.out.println("error in coulmn");
                return false;
            }
        }
        return true;
    }

    private boolean checkSquare(int rowIndex, int columnIndex, int value) {
        for (int i = 3 * (rowIndex / 3); i < 3 * (rowIndex / 3) + 3; i++) {
            for (int j = 3 * (columnIndex / 3); j < 3 * (columnIndex / 3) + 3; j++) {
                if (suduko[i][j] == value) {
                    // System.out.println("error in square");
                    return false;

                }
            }

        }

        return true;
    }

    private boolean checkAll(int rowIndex, int columnIndex, int value) {
        return checkRow(rowIndex, value) && checkColumn(columnIndex, value) && checkSquare(rowIndex, columnIndex, value);
    }


    // mjrd row & coulmn "coordination"
    private class IndexPair {
        public int rowIndex, columnIndex;
    }
}