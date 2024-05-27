package com.example.kipup.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seance")
data class Seance(
    @PrimaryKey val seanceId: Int,

    val Nom: String?,
)

@Entity(tableName = "serie")
data class Serie(
    @PrimaryKey val serieId: Int,

    val rep: Int,
    val poids: Int
)

@Entity(tableName = "exo")
data class Exo(
    @PrimaryKey val exoId: Int,
    val nom: String,
    val muscle: String
)

