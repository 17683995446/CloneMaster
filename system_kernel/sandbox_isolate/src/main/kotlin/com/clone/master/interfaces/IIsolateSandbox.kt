package com.clone.master

import com.clone.master.common.SandboxParam
import com.clone.master.common.SandboxDTO
import com.clone.master.common.ResultDTO

interface IIsolateSandbox {
    fun createSandbox(param: SandboxParam): ResultDTO<SandboxDTO>
    fun destroySandbox(sandboxId: Int): Boolean
    fun suspendSandbox(sandboxId: Int): Boolean
    fun resumeSandbox(sandboxId: Int): Boolean
    fun getSandboxInfo(sandboxId: Int): ResultDTO<SandboxDTO>
    fun verifyIsolation(sandboxId: Int): Boolean
}
