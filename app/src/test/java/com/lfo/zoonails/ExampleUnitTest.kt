package com.lfo.zoonails

import com.google.gson.Gson
import com.lfo.zoonails.vo.MenuVo
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var list = arrayOf(
            MenuVo(image = "menu_case", text = "客人分享", link = "https://bit.ly/3mNkMBx"),
            MenuVo(image = "menu_price", text = "價目表", link = "https://bit.ly/2KxyyuI"),
            MenuVo(image = "menu_way", text = "預約方式", link = "https://bit.ly/3rlAJCe"),
            MenuVo(image = "menu_reserv", text = "開放預約時間", link = "https://bit.ly/2LYasts"),
            MenuVo(image = "menu_ad", text = "優惠活動", link = "https://bit.ly/3rscHpi"),
            MenuVo(image = "menu_pet", text = "店寵", link = "https://bit.ly/2JoOxuM")
        )
        var menuVoListStr = Gson().toJson(list)
        var result = Gson().fromJson<Array<MenuVo>>(menuVoListStr,Array<MenuVo>::class.java)
        assert(list.size == result.size)
    }
}