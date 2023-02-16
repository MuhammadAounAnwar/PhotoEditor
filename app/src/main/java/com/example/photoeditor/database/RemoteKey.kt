package com.example.photoeditor.database

import androidx.room.Entity

@Entity(tableName = "remote_keys")
data class RemoteKey(val label: String, val nextKey: String?)
