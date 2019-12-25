package com.duynam.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    Random rd;
    static int N = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        int arr[][] = { { 1, 2, 3},
                { 4, 5, 6},
                {7, 8, 9}};
        rotate(arr);
        printMatrix(arr);

    }

    private void rotate(int a[][]){
        for (int i = 0; i < N ; i++){
            for (int j = i; j < N ; j++) {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - i][j];
                a[N - 1 - i][j] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[i][N-1-j];
                a[i][N-1-j] = temp;
            }
        }
    }

    private static void printMatrix(int arr[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }

}
