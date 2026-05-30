package com.clone.master.common

data class CloneDTO(
    val cloneId: Int,
    val packageName: String,
    val cloneName: String,
    val status: String,
    val createdTime: Long
)

data class InfoDTO(
    val totalClones: Int,
    val activeClones: Int,
    val availableSpace: Long
)

data class ResourceDTO(
    val usedMemory: Long,
    val totalMemory: Long,
    val usedStorage: Long,
    val totalStorage: Long
)

data class ProcessDTO(
    val processId: Int,
    val cloneId: Int,
    val state: String,
    val memoryUsage: Long,
    val memoryLimit: Long,
    val startTime: Long
)

data class SandboxDTO(
    val sandboxId: Int,
    val cloneId: Int,
    val status: String,
    val isolationLevel: Int,
    val createdTime: Long
)
