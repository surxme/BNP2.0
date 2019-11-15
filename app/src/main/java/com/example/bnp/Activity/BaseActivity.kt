package com.example.bnp.Activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : AppCompatActivity() {
    abstract var layoutResID:Int

    /**
     * 初始化视图控件
     */
    abstract fun initView()

    /**
     * 初始化绑定事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID)
        setSupportActionBar(toolbar)

        initView()
        initEvent()
        initData()
    }

    fun getUserID(): String {
        val sp: SharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        return sp.getString("id", "").toString()
    }

    //获取保存的用户名
    fun getUsername(): String {
        val sp: SharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        return sp.getString("username", "").toString()
    }

    fun get_is_remember(): Boolean {
        val sp: SharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        return sp.getBoolean("remember", false)
    }

    fun toast(content: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, content, duration).show()
    }
}