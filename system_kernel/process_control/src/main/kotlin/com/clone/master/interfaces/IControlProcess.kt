package com.clone.master

import com.clone.master.common.ProcessParam
import com.clone.master.common.ProcessDTO
import com.clone.master.common.ResultDTO
import com.clone.master.common.PermissionEnum

interface IControlProcess {
    fun launchProcess(param: ProcessParam): ResultDTO<ProcessDTO>
    fun killProcess(pid: Int): Boolean
    fun pauseProcess(pid: Int): Boolean
    fun resumeProcess(pid: Int): Boolean
    fun getProcessInfo(pid: Int): ResultDTO<ProcessDTO>
    fun monitorProcessHealth(pid: Int): Boolean
    fun requestPermission(permission: PermissionEnum): ResultDTO<Boolean>
    fun checkPermission(permission: PermissionEnum): Boolean
    fun requestAllPermissions(): ResultDTO<Boolean>
}
