package myNew.myPckage

import myNew.MyClass

//как вариант для обращения к классам/интерфейсам, созданным в файле App.kt
//мы можем явно указать package myNew в файле App.kt и обращаться через имя
//данного пакета к классам, объявленным в нем
class ClassWithRefToAppKt {
    var c: myNew.MyClass = MyClass()
}