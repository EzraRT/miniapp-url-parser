package org.ezrart

import com.google.gson.Gson
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.info


object MiniappParser : KotlinPlugin(
    JvmPluginDescription(
        id = "org.ezrart.miniapp-parser",
        name = "小程序链接解析",
        version = "0.0.1"
    ) {
        author("EzraRT")
        info(
            """
            这是一个解析QQ分享小程序卡片真实链接的插件。
        """.trimIndent()
        )
    }
) {
    override fun onEnable() {
        logger.info { "小程序链接解析插件 已加载" }
        ConfigManager.reload()

        val eventChannel = GlobalEventChannel.parentScope(this)
        eventChannel.subscribeAlways<GroupMessageEvent> {
            // 群消息
            if (ConfigManager.groupBlackList.contains(group.id)) {
                return@subscribeAlways
            }
            if (message.serializeToMiraiCode().startsWith("[mirai:app")) {
                try {
                    var appMetaData = Gson().fromJson(message.content, MiniAppData::class.java)
                    if (ConfigManager.miniappBlackList.contains(appMetaData.extra.appid)) {
                        return@subscribeAlways
                    }
                    group.sendMessage(appMetaData.meta.detail_1.qqdocurl)
                    logger.debug("解析成功")
                } catch (e: com.google.gson.JsonSyntaxException) {
                    logger.warning("${message.content} 解析失败")
                }
            }
        }

        eventChannel.subscribeAlways<FriendMessageEvent> {
            // 好友信息
            if (message.serializeToMiraiCode().startsWith("[mirai:app")) {
                try {
                    var appMetaData = Gson().fromJson(message.content, MiniAppData::class.java)
                    if (ConfigManager.miniappBlackList.contains(appMetaData.extra.appid)) {
                        return@subscribeAlways
                    }
                    friend.sendMessage(appMetaData.meta.detail_1.qqdocurl)
                    logger.debug("解析成功")
                } catch (e: com.google.gson.JsonSyntaxException) {
                    logger.warning("${message.content} 解析失败")
                }
            }
        }
    }
}
