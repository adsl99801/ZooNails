package com.lfo.zoonails.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.gson.Gson
import com.lfo.zoonails.vo.MenuVo

class MainVM : ViewModel() {
    var menuVoList: MutableLiveData<ArrayList<MenuVo>> = MutableLiveData()
    fun load() {
        var remoteConfig = Firebase.remoteConfig
        var menuVoListStr = remoteConfig.getString("menuVoList")
        var list = Gson().fromJson<Array<MenuVo>>(menuVoListStr, Array<MenuVo>::class.java)
        menuVoList.value = list.toCollection(ArrayList())
    }

}