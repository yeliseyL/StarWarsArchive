package com.example.starwarsarchive.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Vehicles(
        @Expose val cargo_capacity: String,
        @Expose val consumables: String,
        @Expose val cost_in_credits: String,
        @Expose val created: String,
        @Expose val crew: String,
        @Expose val edited: String,
        @Expose val films: List<String>,
        @Expose val length: String,
        @Expose val manufacturer: String,
        @Expose val max_atmosphering_speed: String,
        @Expose val model: String,
        @Expose override val name: String,
        @Expose val passengers: String,
        @Expose val pilots: List<String?>,
        @Expose val url: String,
        @Expose val vehicle_class: String
) : Parcelable, ISWItem {
        override fun toString() =
                "Name: $name\n" +
                "Model: $model\n" +
                "Cargo capacity: $cargo_capacity\n" +
                "Consumables: $consumables\n" +
                "Cost in credits: $cost_in_credits\n" +
                "Crew: $crew\n" +
                "Length: $length\n" +
                "Manufacturer: $manufacturer\n" +
                "Max atmosphering speed: $max_atmosphering_speed\n" +
                "Passengers: $passengers\n" +
                "Vehicle class: $vehicle_class\n"
}