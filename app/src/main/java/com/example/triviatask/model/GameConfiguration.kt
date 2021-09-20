package com.example.triviatask.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class GameConfiguration(

    val categoryGameId: Int?,
    val questionNumber: Int,
    val difficultyGame: String?,
    val gameType:String?

): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}
