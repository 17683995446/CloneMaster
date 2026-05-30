package com.clone.master

import com.clone.master.common.CreateParam
import com.clone.master.common.ResultDTO
import com.clone.master.common.CloneDTO

interface ICreateClone {
    fun createClone(param: CreateParam): ResultDTO<CloneDTO>
    fun prepareEnvironment(packageName: String): Boolean
    fun validatePackage(packageName: String): Boolean
    fun allocateCloneId(): Int
}
