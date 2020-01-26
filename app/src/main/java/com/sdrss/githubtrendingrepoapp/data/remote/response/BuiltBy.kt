package com.sdrss.githubtrendingrepoapp.data.remote.response


import androidx.annotation.Keep

@Keep
data class BuiltBy(
    val avatar: String = "", // https://avatars0.githubusercontent.com/u/376065
    val href: String = "", // https://github.com/viatsko
    val username: String = "" // viatsko
)