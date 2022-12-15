package org.ezrart

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object ConfigManager : AutoSavePluginConfig("miniapp-parser") {
    @ValueDescription("是否启用插件")
    val enable: Boolean by value(true)

    @ValueDescription("禁用解析的群列表")
    val groupBlackList: MutableList<Long> by value()

    @ValueDescription(
        """
        禁用解析的小程序列表
        默认不解析B站分享小程序，如果有其他不希望解析的小程序ID请加在这里
    """
    )
    val miniappBlackList: MutableList<Long> by value(mutableListOf(100951776))

}