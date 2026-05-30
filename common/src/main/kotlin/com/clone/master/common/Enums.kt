package com.clone.master.common

enum class ErrorEnum(val code: Int, val message: String) {
    SUCCESS(0, "Success"),
    INVALID_PARAMETER(1001, "Invalid parameter"),
    RESOURCE_NOT_FOUND(1002, "Resource not found"),
    OPERATION_FAILED(1003, "Operation failed"),
    PERMISSION_DENIED(1004, "Permission denied"),
    UNKNOWN_ERROR(9999, "Unknown error")
}

enum class KernelErrorEnum(val code: Int, val message: String) {
    KERNEL_SUCCESS(0, "Kernel operation success"),
    KERNEL_INIT_FAILED(2001, "Kernel initialization failed"),
    KERNEL_PROCESS_ERROR(2002, "Kernel process error"),
    KERNEL_SANDBOX_ERROR(2003, "Sandbox error"),
    KERNEL_PERMISSION_ERROR(2004, "Permission error"),
    KERNEL_RESOURCE_ERROR(2005, "Resource error")
}

enum class TypeEnum {
    CLONE,
    SANDBOX,
    PROCESS
}

enum class StatusEnum {
    CREATING,
    RUNNING,
    STOPPED,
    ERROR
}

enum class SandboxEnum {
    ACTIVE,
    INACTIVE,
    SUSPENDED
}

enum class ProcessStateEnum {
    NEW,
    RUNNING,
    WAITING,
    TERMINATED
}

enum class PermissionEnum {
    READ,
    WRITE,
    EXECUTE,
    ADMIN
}
