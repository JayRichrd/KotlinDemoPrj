package com.tencent.cain.data

data class SiteVisit(val path: String,
                     val duration: Double,
                     val os: Os) {

}

enum class Os {
    WINDOWS, LINUX, MAC, IOS, ANDROID
}
