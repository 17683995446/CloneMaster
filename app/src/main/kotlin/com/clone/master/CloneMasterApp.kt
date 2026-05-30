package com.clone.master

import android.app.Application

class CloneMasterApp : Application() {
    
    lateinit var cloneRouter: ICloneRouter
        private set
    
    override fun onCreate() {
        super.onCreate()
        _initRouter()
    }
    
    private fun _initRouter() {
        cloneRouter = CloneRouterImpl.getInstance(this)
    }
}
