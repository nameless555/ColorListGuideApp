package com.nutchanok.colorlistguideapp.models

import com.google.gson.annotations.SerializedName

data class ListColorResponse(
    @SerializedName("page") val page: Int
    , @SerializedName("id") val id: Int
    , @SerializedName("total") val total: Int
    , @SerializedName("total_pages") val total_pages: Int
    , @SerializedName("data") val data: List<ListColor>
)

data class ListColor(
    @SerializedName("id") val id: Int
    , @SerializedName("name") val name: String
    , @SerializedName("year") val year: Int
    , @SerializedName("color") val color: String
    , @SerializedName("pantone_value") val pantone_value: String
    , var favourite: Int = 0

)

data class FavColor(
    @SerializedName("id") val id: Int
    , @SerializedName("name") val name: String
    , @SerializedName("year") val year: Int
    , @SerializedName("color") val color: String
    , @SerializedName("pantone_value") val pantone_value: String

)