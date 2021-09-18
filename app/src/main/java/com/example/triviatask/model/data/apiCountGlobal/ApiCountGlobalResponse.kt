package com.example.triviatask.model.data.apiCountGlobal


import com.google.gson.annotations.SerializedName

data class ApiCountGlobalResponse(
    @SerializedName("categories")
    val categories: Categories,
    @SerializedName("overall")
    val overall: Overall
)