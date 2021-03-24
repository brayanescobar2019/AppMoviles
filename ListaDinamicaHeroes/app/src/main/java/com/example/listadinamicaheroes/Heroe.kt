package com.example.listadinamicaheroes

data class Heroe (var name:String, var alterEgo:String, var url:String) {
    fun getFullName():String = "$alterEgo as $name"
}