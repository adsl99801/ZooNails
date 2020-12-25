package com.lfo.zoonails.ui.main

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lfo.zoonails.R
import com.lfo.zoonails.util.CommonUtil
import com.lfo.zoonails.vo.MenuVo


class MenuAdapter(list: ArrayList<MenuVo>) :
    BaseQuickAdapter<MenuVo, BaseViewHolder>(R.layout.adapter_menu, list) {
    val commonUtil = CommonUtil()
    override fun convert(holder: BaseViewHolder, item: MenuVo) {
        val layoutParams = holder.itemView.layoutParams
        val displayMetrics = context.resources.displayMetrics
        layoutParams.height = ((displayMetrics.heightPixels.toDouble() - displayMetrics.heightPixels.toDouble()*0.3) / 3.0).toInt()
        holder.setText(R.id.rvTvText, item.text)
        Glide.with(context).load(commonUtil.getImage(context, item.image)).circleCrop()
            .into(holder.getView<ImageView>(R.id.rvIgIcon));
    }
}