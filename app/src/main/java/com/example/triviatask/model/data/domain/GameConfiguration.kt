package com.example.triviatask.model.data.domain

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
    override fun describeContents()=0
    override fun writeToParcel(dest: Parcel?, flags: Int) {
    }
}
