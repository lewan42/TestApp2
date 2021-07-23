package dev.fabula.android.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val uid: String,
    val email: String,
    val password: String,
    val name: String
)