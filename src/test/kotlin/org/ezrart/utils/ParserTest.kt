package org.ezrart.utils

import org.junit.Test


class ParserTest {
    @Test()
    fun test() {
        val jsonString =
            """
            {
                "app": "com.tencent.structmsg",
                "config": {
                    "ctime": 1675945201,
                    "forward": true,
                    "token": "30eb31d083a71ed26130f6c323cc4a3f",
                    "type": "normal"
                },
                "desc": "新闻",
                "extra": {
                    "app_type": 1,
                    "appid": 1105910806,
                    "uin": 1577008507
                },
                "meta": {
                    "news": {
                        "action": "",
                        "android_pkg_name": "",
                        "app_type": 1,
                        "appid": 1105910806,
                        "ctime": 1675945201,
                        "desc": "在今天的任天堂直面会上，公布了大家期待已久的《塞尔达传说：王国之泪》、《猎天使魔",
                        "jumpUrl": "https://api.xiaoheihe.cn/v3/bbs/app/api/web/share?link_id=99646581",
                        "preview": "https://pic.ugcimg.cn/ddff737a0218355e8a66b0a3dd42f2b4/jpg1",
                        "source_icon": "https://open.gtimg.cn/open/app_icon/05/91/08/06/1105910806_100_m.png?t=1675754591",
                        "source_url": "",
                        "tag": "小黑盒",
                        "title": "任天堂直面会汇总：《王国之泪》发布实机演示；马8第四…",
                        "uin": 1577008507
                    }
                },
                "prompt": "[分享]任天堂直面会汇总：《王国之泪》发布实机演示；马8第四…",
                "ver": "0.0.0.1",
                "view": "news"
            }
        """.trimIndent();
        Parser.getAppID(jsonString);
    }
}