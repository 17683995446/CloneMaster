package com.clone.master

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clone.master.common.CreateParam
import com.clone.master.common.TypeEnum

class MainActivity : AppCompatActivity() {
    
    private lateinit var _router: ICloneRouter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _initRouter()
    }
    
    private fun _initRouter() {
        val app = application as CloneMasterApp
        _router = app.cloneRouter
    }
    
    fun createClone(name: String, packageName: String) {
        val param = CreateParam(
            packageName = packageName,
            cloneName = name
        )
        _router.createClone(param)
    }
}
