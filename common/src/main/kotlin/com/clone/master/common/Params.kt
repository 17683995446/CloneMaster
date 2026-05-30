package com.clone.master.common

data class CreateParam(
    val packageName: String,
    val cloneName: String,
    val template: String? = null
)

data class ConfigParam(
    val key: String,
    val value: String
)

data class ProcessParam(
    val cloneId: Int,
    val command: String,
    val priority: Int = 0
)

data class SandboxParam(
    val cloneId: Int,
    val isolationLevel: Int,
    val resources: Map<String, Long>? = null
)
