package com.example.triviatask.model.data.apiCountGlobal


import com.google.gson.annotations.SerializedName

data class X14(
    @SerializedName("total_num_of_pending_questions")
    val totalNumOfPendingQuestions: Int,
    @SerializedName("total_num_of_questions")
    val totalNumOfQuestions: Int,
    @SerializedName("total_num_of_rejected_questions")
    val totalNumOfRejectedQuestions: Int,
    @SerializedName("total_num_of_verified_questions")
    val totalNumOfVerifiedQuestions: Int
)