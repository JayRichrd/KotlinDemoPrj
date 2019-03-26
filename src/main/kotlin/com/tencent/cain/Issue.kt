package com.tencent.cain

data class Issue(val id: String,
                 val project: String,
                 val type: String,
                 val priority: String,
                 val description: String) {
}