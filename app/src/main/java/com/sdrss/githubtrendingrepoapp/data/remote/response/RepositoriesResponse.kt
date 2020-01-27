package com.sdrss.githubtrendingrepoapp.data.remote.response


import androidx.annotation.Keep

@Keep
data class RepositoriesResponse(
    val author: String = "", // kusti8
    val avatar: String = "", // https://github.com/kusti8.png
    val builtBy: List<BuiltBy> = listOf(),
    val currentPeriodStars: Int = 0, // 1186
    val description: String = "", // A React environment for cross platform native desktop apps
    val forks: Int = 0, // 124
    val language: String? = null, // JavaScript
    val languageColor: String? = null, // #3572A5
    val name: String = "", // proton-native
    val stars: Int = 0, // 4711
    val url: String = "", // https://github.com/kusti8/proton-native
    var isExpanded: Boolean = false, //locally manage item Expending state
    var hasLanguage: Boolean = false //locally manage item LanguageWithColor state
)