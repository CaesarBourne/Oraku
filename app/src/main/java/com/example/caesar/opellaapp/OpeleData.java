package com.example.caesar.opellaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class OpeleData extends AppCompatActivity {
    TextView displayResult;

    int  a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3, a4, b4, c4, d4, a5, b5, c5, d5, a6, b6, c6, d6, a7, b7, c7, d7;
    int  a8, b8, c8, d8, a9, b9, c9, d9, a10, b10, c10, d10, a11, b11, c11, d11, a12, b12, c12, d12, a13, b13, c13, d13;
    int  a14, b14, c14, d14, a15, b15, c15, d15, a16, b16, c16, d16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opele_data);

        Random number = new Random();
        int z = 1  + number.nextInt(2);
        displayResult =(TextView) findViewById(R.id.displayResult);


    }

    public void compute(View view){

        a4 = 2;   a3 = 1;           a2 = 1;  a1 = 1;
        b4 = 1;   b3 = 1;           b2 = 1;  b1 = 1;
        c4 = 1;   c3 = 2;           c2 = 1;  c1 = 1;
        d4 = 1;   d3 = 2;           d2 = 2;  d1 = 1;
        //given values
        int[] column1 = {a1, b1, c1, d1};
        int[] column2 = {a2, b2, c2, d2};
        int[] column3 = {a3, b3, c3, d3};
        int[] column4 = {a4, b4, c4, d4};

        //Head chest body and legs
        int[] column5 = {a1, a2, a3, a4};
        int[] column6 = {b1, b2, b3, b4};
        int[] column7 = {c1, c2, c3, c4};
        int[] column8 = {d1, d2, d3, d4};

        //concatenation
        int[] column9  = new int [4];
        int[] column10 = new int [4];
        int[] column11 = new int [4];
        int[] column12 = new int [4];
        int[] column13 = new int [4];
        int[] column14 = new int [4];
        int[] column15 = new int [4];
        int[] column16 = new int [4];

        //array for column 9
        for (int i  = 0; i < column9.length; i++){
            if (column1[i] == column2[i]){
                column9[i] = 2;
            }else {
                column9[i] = 1;
            }
        }

        //array for column 10
        for (int i  = 0; i < column9.length; i++){
            if (column3[i] == column4[i]){
                column10[i] = 2;
            }else {
                column10[i] = 1;
            }
        }

        //array for column 11
        for (int i  = 0; i < column9.length; i++){
            if (column5[i] == column6[i]){
                column11[i] = 2;
            }else {
                column11[i] = 1;
            }
        }

        //array for column 12
        for (int i  = 0; i < column9.length; i++){
            if (column7[i] == column8[i]){
                column12[i] = 2;
            }else {
                column12[i] = 1;
            }
        }

        //array for column 13
        for (int i  = 0; i < column9.length; i++){
            if (column9[i] == column10[i]){
                column13[i] = 2;
            }else {
                column13[i] = 1;
            }
        }

        //array for column 14
        for (int i  = 0; i < column9.length; i++){
            if (column11[i] == column12[i]){
                column14[i] = 2;
            }else {
                column14[i] = 1;
            }
        }

        //array for column 15
        for (int i  = 0; i < column9.length; i++){
            if (column13[i] == column13[i]){
                column15[i] = 2;
            }else {
                column15[i] = 1;
            }
        }

        //array for column 16
        for (int i  = 0; i < column9.length; i++){
            if (column1[i] == column15[i]){
                column16[i] = 2;
            }else {
                column16[i] = 1;
            }
        }



        int arrayofcolumns[][] = {column1, column2, column3, column4,column5,column6, column7, column8, column9,
                column10, column11, column12, column13, column14, column15, column16};
        Object arrayofcolumnsobject [] ={column1, column2, column3, column4,column5,column6, column7, column8, column9,
                column10, column11, column12, column13, column14, column15, column16};
        int counter = 0;
        for (int i = 0; i<arrayofcolumns.length; i++) {


            if (arrayofcolumns[i][0] == 1 && arrayofcolumns[i][3] == 1) {
                counter += 2;
            } else if (arrayofcolumns[i][0] == 1) {
                counter += 1;
            } else if (arrayofcolumns[i][3] == 1) {
                counter += 1;
            }
        }
        String result = String.valueOf(counter) ;



        int [] Life     = {1,1,2,1};
        int [] Wealth   = {1,2,2,2};
        int [] Mother   = {2,1,1,1};
        int [] Parents  = {2,2,1,2};
        int [] Children = {1,1,1,1};
        int [] Illness  = {1,2,1,2};
        int [] Marriage = {2,1,2,2};
        int [] Death    = {2,2,2,1};
        int [] Travel   = {1,1,2,2};
        int [] Leader   = {1,2,2,1};
        int [] Mind     = {2,1,1,2};
        int [] Enemy    = {2,2,1,1};
        int [] Demand   = {1,1,1,2};
        int [] Owner    = {1,2,1,1};
        int [] Country  = {2,1,2,1};
        int [] Abroad   = {2,2,2,2};

        int [][] Intepretations = {Life, Wealth, Mother, Parents, Children, Illness, Marriage, Death, Travel, Leader,
                                    Mind, Enemy, Demand, Owner, Country, Abroad};

        // answer is the final value gotten that is not greater than 12
        int answer = 0;
        if (counter > 12){
            answer = counter - 12;
        }else {
            answer = counter;
        }

        //this is the index value
        int indexAnswer = answer-1;
        ArrayList<Integer> transversedNumbers = new ArrayList<>();
        for ( int i = 0; i < 4; i++){
            //compare if the values of generated array and database array are equal to get direct answer

            if (Arrays.equals(Intepretations[indexAnswer], arrayofcolumns[indexAnswer])){
                displayResult.setText("confirmmatch");
            }
            else {
                //start transversing through the database array to find the location of the array that matches
                //first transverse to find the database array that matches value of the generated index array
                for (int j= 0; j < Intepretations.length; j++){//search for database value of the child of contents of array
                    if (Arrays.equals(arrayofcolumns[indexAnswer],Intepretations[j])){
//add the value of the tranversed number to the arraylist to know when to stop when you rotate because its 1st time NB (answer cannot be gotten now)
                        transversedNumbers.add(j);
                        for (int k = 0; k< Intepretations.length; k++ ){
 //compare the data gotten in the database with its index on the generated array, j is the database index, k checks if rotate happens
                            if (Arrays.equals(arrayofcolumns[j], Intepretations[k]) && transversedNumbers.contains(k)){
                                displayResult.setText("answer");//
                            }else if (Arrays.equals(arrayofcolumns[j], Intepretations[k])){
                                transversedNumbers.add(k);//add the index of what u checkd in database
     //if it just equals child of generated array but no rotate keep transversing with database index number which is k
                                for (int l = 0; l< Intepretations.length; l++){
                                    if (Arrays.equals(arrayofcolumns[k], Intepretations[l]) && transversedNumbers.contains(l)){
                                        displayResult.setText("anwser second");
                                    }
                                    else if (Arrays.equals(arrayofcolumns[k
                                            ], Intepretations[l])){
                                        transversedNumbers.add(l);
                                        while (!Arrays.equals(arrayofcolumns[k], Intepretations[l]) && transversedNumbers.contains(l)){
                                            for (int m = 0; m< Intepretations.length; m++){

                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

            }
        }


    }

    public void startNumberSearch(){

    }
}
