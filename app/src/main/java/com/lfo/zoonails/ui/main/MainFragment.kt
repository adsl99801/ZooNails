package com.lfo.zoonails.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.lfo.zoonails.R
import com.lfo.zoonails.vo.MenuVo
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val TAG = "MainFragment"
    private lateinit var vm: MainVM
    private lateinit var menuAdapter: MenuAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = ViewModelProvider(this).get(MainVM::class.java)
        initRv()
        main_bt.setOnClickListener {
            reservationClick()
        }
        vm.load()
        vm.menuVoList.observe(this) { ob ->
            menuAdapter.data = ob;
            menuAdapter.notifyDataSetChanged()
        }
    }

    fun initRv() {
        menuAdapter = MenuAdapter(ArrayList());
        var manager = GridLayoutManager(context, 2)
        rvMenu.layoutManager = manager
        rvMenu.adapter = menuAdapter
        menuAdapter.notifyDataSetChanged()
        menuAdapter.setOnItemClickListener { adapter, view, position ->
            var data = adapter.data[position] as MenuVo
            open(data.link)
        }
    }

    fun reservationClick() {
        open("https://line.me/R/ti/p/@032mtphx")
    }

    fun open(link: String) {
        val browserIntent =
            Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }
}