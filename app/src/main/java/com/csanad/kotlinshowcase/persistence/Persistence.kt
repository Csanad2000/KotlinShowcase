package com.csanad.kotlinshowcase.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persistence")
data class Persistence(
    val entry: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
