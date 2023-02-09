package org.ezrart.utils

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.ezrart.MiniappParser
import org.ezrart.data.AppType
import org.ezrart.data.QQMiniAppData
import org.ezrart.data.TimMiniAppData

class Parser {

    companion object {
        fun getUrl(rawMessage: String): String {
            var message = "";
            val type = getAppType(rawMessage)
            try {
                if (type == AppType.QQApp) {
                    val appMetaData = Gson().fromJson(rawMessage, QQMiniAppData::class.java)
                    message = appMetaData.meta.detail_1.qqdocurl;
                } else if (type == AppType.TimAPP) {

                    val appMetaData = Gson().fromJson(rawMessage, TimMiniAppData::class.java)
                    message = appMetaData.meta.news.jumpUrl;
                }
            } catch (e: Exception) {
                MiniappParser.logger.error("$rawMessage 解析失败");
            }

            return message;
        }

        fun getAppID(rawMessage: String): Long {
            val element: JsonElement = JsonParser.parseString(rawMessage)
            val root: JsonObject = element.asJsonObject
            return root.getAsJsonObject("extra").getAsJsonPrimitive("appid").asLong;
        }

        private fun getAppType(rawMessage: String): AppType {
            val element: JsonElement = JsonParser.parseString(rawMessage)
            val root: JsonObject = element.asJsonObject
            val appType = root.getAsJsonPrimitive("app").asString

            return if (appType == "com.tencent.miniapp_01") {
                AppType.QQApp;
            } else {
                AppType.TimAPP;
            }

        }
    }
}