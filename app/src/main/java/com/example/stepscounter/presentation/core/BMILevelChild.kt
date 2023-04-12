package com.example.stepscounter.presentation.core

enum class BMILevelChild(val index: Int, val value: Pair<Double, Double>) {
    BMI_1(1, Pair(0.0,3.0)),
    BMI_2(2, Pair(3.0,15.0)),
    BMI_3(3, Pair(15.0,85.0)),
    BMI_4(4, Pair(85.0,97.0)),
    BMI_5(5, Pair(97.0,100.0))
}