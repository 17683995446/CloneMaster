package com.clone.master.impl

import com.clone.master.IIsolateSandbox
import com.clone.master.common.SandboxParam
import com.clone.master.common.SandboxDTO
import com.clone.master.common.ResultDTO
import com.clone.master.common.KernelErrorEnum

class IsolateSandboxImpl private constructor() : IIsolateSandbox {
    
    private val _sandboxMap = mutableMapOf<Int, SandboxDTO>()
    private var _sandboxCounter = 0
    
    override fun createSandbox(param: SandboxParam): ResultDTO<SandboxDTO> {
        if (!_validateSandboxParam(param)) {
            return ResultDTO.error(KernelErrorEnum.KERNEL_SANDBOX_ERROR.code, "Invalid sandbox param")
        }
        if (!_allocateSandboxResources(param)) {
            return ResultDTO.error(KernelErrorEnum.KERNEL_RESOURCE_ERROR.code, "Resource allocation failed")
        }
        val sandbox = _buildSandboxEntity(param)
        _sandboxMap[sandbox.sandboxId] = sandbox
        return ResultDTO.success(sandbox, "Sandbox created")
    }
    
    override fun destroySandbox(sandboxId: Int): Boolean {
        val sandbox = _sandboxMap[sandboxId] ?: return false
        if (!_releaseSandboxResources(sandbox)) {
            return false
        }
        _sandboxMap.remove(sandboxId)
        return true
    }
    
    override fun suspendSandbox(sandboxId: Int): Boolean {
        val sandbox = _sandboxMap[sandboxId] ?: return false
        val updated = sandbox.copy(status = "SUSPENDED")
        _sandboxMap[sandboxId] = updated
        return true
    }
    
    override fun resumeSandbox(sandboxId: Int): Boolean {
        val sandbox = _sandboxMap[sandboxId] ?: return false
        val updated = sandbox.copy(status = "ACTIVE")
        _sandboxMap[sandboxId] = updated
        return true
    }
    
    override fun getSandboxInfo(sandboxId: Int): ResultDTO<SandboxDTO> {
        val sandbox = _sandboxMap[sandboxId]
        if (sandbox == null) {
            return ResultDTO.error(KernelErrorEnum.KERNEL_SANDBOX_ERROR.code, "Sandbox not found")
        }
        return ResultDTO.success(sandbox, "Success")
    }
    
    override fun verifyIsolation(sandboxId: Int): Boolean {
        val sandbox = _sandboxMap[sandboxId] ?: return false
        return _checkDataIsolation(sandbox) && _checkProcessIsolation(sandbox)
    }
    
    private fun _validateSandboxParam(param: SandboxParam): Boolean {
        return param.cloneId > 0
    }
    
    private fun _allocateSandboxResources(param: SandboxParam): Boolean {
        return true
    }
    
    private fun _releaseSandboxResources(sandbox: SandboxDTO): Boolean {
        return true
    }
    
    private fun _buildSandboxEntity(param: SandboxParam): SandboxDTO {
        _sandboxCounter++
        return SandboxDTO(
            sandboxId = _sandboxCounter,
            cloneId = param.cloneId,
            status = "ACTIVE",
            isolationLevel = param.isolationLevel,
            createdTime = System.currentTimeMillis()
        )
    }
    
    private fun _checkDataIsolation(sandbox: SandboxDTO): Boolean {
        return true
    }
    
    private fun _checkProcessIsolation(sandbox: SandboxDTO): Boolean {
        return true
    }
    
    companion object {
        @Volatile
        private var _instance: IsolateSandboxImpl? = null
        
        fun getInstance(): IsolateSandboxImpl {
            return _instance ?: synchronized(this) {
                _instance ?: IsolateSandboxImpl().also { _instance = it }
            }
        }
    }
}
