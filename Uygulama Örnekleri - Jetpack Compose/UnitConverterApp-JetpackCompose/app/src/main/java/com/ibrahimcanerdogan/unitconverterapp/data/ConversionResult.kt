package com.ibrahimcanerdogan.unitconverterapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    val id : Int,
    @ColumnInfo(name = "result_first_unit")
    val firstUnit : String,
    @ColumnInfo(name = "result_second_unit")
    val secondUnit: String
)