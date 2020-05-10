package com.nutchanok.colorlistguideapp.models

class ListFavourite {
    var id: Int = 0
    var name: String? = null
    var year: Int = 0
    var color: String? = null
    var pantone_value: String? = null


    constructor(id: Int, name: String?, year: Int, color: String?, pantone_value: String?) {
        this.id = id
        this.name = name
        this.year = year
        this.color = color
        this.pantone_value = pantone_value
    }

}