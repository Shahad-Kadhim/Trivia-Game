package com.example.triviatask.model.data.response.apiCountGlobal


import com.google.gson.annotations.SerializedName

data class ApiCountGlobalResponse(
    @SerializedName("categories")
    val categories: Categories?,
    @SerializedName("overall")
    val overall: Overall?
)