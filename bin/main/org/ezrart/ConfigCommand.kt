package org.ezrart

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.getGroupOrNull

class ConfigCommand : CompositeCommand(
    MiniappParser, "miniparser", "小程序解析管理"
) {
    @SubCommand("enable", "在本群启用解析功能")
    suspend fun CommandSender.enable() {
        // 执行 "/miniparser enable" 时调用这个函数
        var group = getGroupOrNull()
        if (group != null) {
            ConfigManager.groupBlackList.removeAll { it == group.id }
        }
    }

    @SubCommand("disable", "在本群禁用解析功能")
    suspend fun CommandSender.disable() {
        // 执行 "/miniparser disable" 时调用这个函数
        var group = getGroupOrNull()
        if (group != null) {
            if (!ConfigManager.groupBlackList.contains(group.id)) {
                // 加入到黑名单中
                ConfigManager.groupBlackList.add(group.id)
            }
        }
    }
}
