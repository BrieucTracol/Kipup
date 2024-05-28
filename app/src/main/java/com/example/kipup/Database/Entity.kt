package com.example.kipup.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seance")
data class Seance(
    @PrimaryKey(autoGenerate = true)
    val seanceId: Int,

    val Nom: String,
)

@Entity(tableName = "serie")
data class Serie(
    @PrimaryKey(autoGenerate = true)
    val serieId: Int,

    val rep: Int,
    val poids: Int
)

@Entity(tableName = "exos")
data class Exo(
    @PrimaryKey(autoGenerate = true)
    val exoId: Int,
    val nom: String,
    val muscle: String
)

