package com.clone.master

import com.clone.master.common.CloneDTO
import com.clone.master.common.ResultDTO
import com.clone.master.common.CreateParam
import com.clone.master.common.PermissionEnum

interface ICloneRouter {
    fun createClone(param: CreateParam): ResultDTO<CloneDTO>
    fun startClone(cloneId: Int): ResultDTO<CloneDTO>
    fun stopClone(cloneId: Int): ResultDTO<CloneDTO>
    fun deleteClone(cloneId: Int): ResultDTO<Boolean>
    fun listClones(): ResultDTO<List<CloneDTO>>
    fun requestPermission(permission: PermissionEnum): ResultDTO<Boolean>
    fun checkPermission(permission: PermissionEnum): Boolean
}
