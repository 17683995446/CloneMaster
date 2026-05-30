package com.clone.master

import android.content.Context
import com.clone.master.common.CloneDTO
import com.clone.master.common.ResultDTO
import com.clone.master.common.CreateParam
import com.clone.master.common.PermissionEnum

class CloneRouterImpl private constructor(
    private val _context: Context
) : ICloneRouter {
    
    private val _createService: ICreateClone by lazy {
        com.clone.master.impl.CreateCloneImpl.getInstance()
    }
    
    private val _manageService: IManageClone by lazy {
        com.clone.master.impl.ManageCloneImpl.getInstance()
    }
    
    private val _processService: IControlProcess by lazy {
        com.clone.master.impl.ControlProcessImpl.getInstance(_context)
    }
    
    override fun createClone(param: CreateParam): ResultDTO<CloneDTO> {
        return _createService.createClone(param)
    }
    
    override fun startClone(cloneId: Int): ResultDTO<CloneDTO> {
        return _manageService.startClone(cloneId)
    }
    
    override fun stopClone(cloneId: Int): ResultDTO<CloneDTO> {
        return _manageService.stopClone(cloneId)
    }
    
    override fun deleteClone(cloneId: Int): ResultDTO<Boolean> {
        return _manageService.deleteClone(cloneId)
    }
    
    override fun listClones(): ResultDTO<List<CloneDTO>> {
        return _manageService.listAllClones()
    }
    
    override fun requestPermission(permission: PermissionEnum): ResultDTO<Boolean> {
        return _processService.requestPermission(permission)
    }
    
    override fun checkPermission(permission: PermissionEnum): Boolean {
        return _processService.checkPermission(permission)
    }
    
    companion object {
        @Volatile
        private var _instance: CloneRouterImpl? = null
        
        fun getInstance(context: Context): CloneRouterImpl {
            return _instance ?: synchronized(this) {
                _instance ?: CloneRouterImpl(context.applicationContext).also { _instance = it }
            }
        }
    }
}
