package com.example.triviatask.model.data.response.apiCountGlobal


import com.google.gson.annotations.SerializedName

data class X25(
    @SerializedName("total_num_of_pending_questions")
    val totalNumOfPendingQuestions: Int?,
    @SerializedName("total_num_of_questions")
    val totalNumOfQuestions: Int?,
    @SerializedName("total_num_of_rejected_questions")
    val totalNumOfRejectedQuestions: Int?,
    @SerializedName("total_num_of_verified_questions")
    val totalNumOfVerifiedQuestions: Int?
)