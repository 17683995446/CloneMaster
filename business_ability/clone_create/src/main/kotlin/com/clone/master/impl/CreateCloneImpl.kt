package com.clone.master.impl

import com.clone.master.ICreateClone
import com.clone.master.common.CreateParam
import com.clone.master.common.ResultDTO
import com.clone.master.common.CloneDTO
import com.clone.master.common.ErrorEnum

class CreateCloneImpl private constructor() : ICreateClone {
    
    private var _cloneCounter = 0
    
    override fun createClone(param: CreateParam): ResultDTO<CloneDTO> {
        if (!_validateInput(param)) {
            return ResultDTO.error(ErrorEnum.INVALID_PARAMETER.code, "Invalid create param")
        }
        if (!_checkPackageExists(param.packageName)) {
            return ResultDTO.error(ErrorEnum.RESOURCE_NOT_FOUND.code, "Package not found")
        }
        val cloneId = allocateCloneId()
        val clone = _buildCloneEntity(param, cloneId)
        return ResultDTO.success(clone, "Clone created successfully")
    }
    
    override fun prepareEnvironment(packageName: String): Boolean {
        if (!_checkPackageSignature(packageName)) {
            return false
        }
        if (!_allocateStorageSpace(packageName)) {
            return false
        }
        return true
    }
    
    override fun validatePackage(packageName: String): Boolean {
        if (packageName.isEmpty()) {
            return false
        }
        return _checkPackageValid(packageName)
    }
    
    override fun allocateCloneId(): Int {
        _cloneCounter++
        return _cloneCounter
    }
    
    private fun _validateInput(param: CreateParam): Boolean {
        return param.packageName.isNotEmpty() && param.cloneName.isNotEmpty()
    }
    
    private fun _checkPackageExists(packageName: String): Boolean {
        return true
    }
    
    private fun _checkPackageValid(packageName: String): Boolean {
        return true
    }
    
    private fun _checkPackageSignature(packageName: String): Boolean {
        return true
    }
    
    private fun _allocateStorageSpace(packageName: String): Boolean {
        return true
    }
    
    private fun _buildCloneEntity(param: CreateParam, cloneId: Int): CloneDTO {
        return CloneDTO(
            cloneId = cloneId,
            packageName = param.packageName,
            cloneName = param.cloneName,
            status = "CREATED",
            createdTime = System.currentTimeMillis()
        )
    }
    
    companion object {
        @Volatile
        private var _instance: CreateCloneImpl? = null
        
        fun getInstance(): CreateCloneImpl {
            return _instance ?: synchronized(this) {
                _instance ?: CreateCloneImpl().also { _instance = it }
            }
        }
    }
}
