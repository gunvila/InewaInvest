package buu.informatics.s59161125.myprojectterminewsinvest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock")
data class StockDatabaseModel (

    @PrimaryKey

    @ColumnInfo(name = "nameStock")
    val nameStock: String,

    @ColumnInfo(name = "nameThai")
    val nameThai: String,

    @ColumnInfo(name = "detail")
    var detail: String

)