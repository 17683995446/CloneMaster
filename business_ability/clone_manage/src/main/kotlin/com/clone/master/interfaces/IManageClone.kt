package com.clone.master

import com.clone.master.common.ResultDTO
import com.clone.master.common.CloneDTO
import com.clone.master.common.StatusEnum

interface IManageClone {
    fun startClone(cloneId: Int): ResultDTO<CloneDTO>
    fun stopClone(cloneId: Int): ResultDTO<CloneDTO>
    fun deleteClone(cloneId: Int): ResultDTO<Boolean>
    fun getCloneInfo(cloneId: Int): ResultDTO<CloneDTO>
    fun listAllClones(): ResultDTO<List<CloneDTO>>
    fun updateCloneStatus(cloneId: Int, status: StatusEnum): Boolean
}
