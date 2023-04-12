package com.example.stepscounter.presentation.core

enum class BMILevelAdult(val index: Int, val value: Pair<Double, Double>) {
    BMI_1(1, Pair(0.0,16.0)),
    BMI_2(2, Pair(16.0,18.5)),
    BMI_3(3, Pair(18.5,25.0)),
    BMI_4(4, Pair(25.0,30.0)),
    BMI_5(5, Pair(30.0,35.0)),
    BMI_6(6, Pair(35.0,40.0)),
    BMI_7(7, Pair(40.0,100.0)),
}