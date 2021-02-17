package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.example.starwarsarchive.mvp.model.entity.interfaces.ISWItem
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Starships(
        @Expose val MGLT: String,
        @Expose val cargo_capacity: String,
        @Expose val consumables: String,
        @Expose val cost_in_credits: String,
        @Expose val created: String,
        @Expose val crew: String,
        @Expose val edited: String,
        @Expose val films: List<String>,
        @Expose val hyperdrive_rating: String,
        @Expose val length: String,
        @Expose val manufacturer: String,
        @Expose val max_atmosphering_speed: String,
        @Expose val model: String,
        @Expose override val name: String,
        @Expose val passengers: String,
        @Expose val pilots: List<String?>,
        @Expose val starship_class: String,
        @Expose val url: String
): Parcelable, ISWItem {
        override fun toString() =
                "Name: $name\n" +
                "\n" +
                "Model: $model\n" +
                "\n" +
                "MGLT: $MGLT\n" +
                "\n" +
                "Cargo capacity: $cargo_capacity\n" +
                "\n" +
                "Consumables: $consumables\n" +
                "\n" +
                "Cost in credits: $cost_in_credits\n" +
                "\n" +
                "Crew: $crew\n" +
                "\n" +
                "Hyperdrive rating: $hyperdrive_rating\n" +
                "\n" +
                "Length: $length\n" +
                "\n" +
                "Manufacturer: $manufacturer\n" +
                "\n" +
                "Max atmosphering speed: $max_atmosphering_speed\n" +
                "\n" +
                "Passengers: $passengers\n" +
                "\n" +
                "Starship class: $starship_class\n"
}