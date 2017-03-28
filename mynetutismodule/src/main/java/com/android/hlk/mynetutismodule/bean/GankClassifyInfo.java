package com.android.hlk.mynetutismodule.bean;

import java.util.List;

/**
 * 分类数据
 * Created by user on 2017/3/28.
 */

public class GankClassifyInfo {

    /**
     * error : false
     * results : [{"_id":"58d92e65421aa969fd8a3dd6","createdAt":"2017-03-27T23:23:17.262Z","desc":"DrawerLayout-like ViewGroup, where a \"drawer\" is hidden under the content view, which can be shifted to make the drawer visible. ","images":["http://img.gank.io/7bf7a986-8ea3-48e2-bb55-5d2e61a7595d"],"publishedAt":"2017-03-28T12:05:55.791Z","source":"web","type":"Android","url":"https://github.com/yarolegovich/SlidingRootNav","used":true,"who":"Yaroslav"},{"_id":"58d9b7b0421aa969fb0fbec0","createdAt":"2017-03-28T09:09:04.432Z","desc":"一个超轻超薄的Android工具库，阻止三方SDK中常见的严重影响用户体验的『链式唤醒』行为。（对应用自身的功能无影响）","publishedAt":"2017-03-28T12:05:55.791Z","source":"web","type":"Android","url":"https://github.com/oasisfeng/condom","used":true,"who":null},{"_id":"58d9cd1a421aa969fb0fbec2","createdAt":"2017-03-28T10:40:26.11Z","desc":"热修复框架研究之Robust原理","publishedAt":"2017-03-28T12:05:55.791Z","source":"chrome","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwOTQ1MjAwMg==&mid=2247483865&idx=1&sn=55a2fbadf4ecf9ffed1f66180e8c1f73&chksm=9772ef54a00566424f0afd77ce2137562f90ec848ccdffe1452eb878014a88f5d70b72d29713&mpshare=1&scene=1&srcid=0328UmbhnqspIjS4Gfp2EAzM&key=37fbc9f7954b58efd06ddba64843a42ef37539694682aa69cf4255337438ad62c868e2c02bfc92859259bbd4bb968d292f0be3bcd399838671e04765c404389ec03adbfc87726a1e41d91c2eacd129cc&ascene=0&uin=MTY5MDI4NDA4Mg%3D%3D&devicetype=iMac+MacBookPro11%2C3+OSX+OSX+10.12.3+build(16D32)&version=12020110&nettype=WIFI&fontScale=100&pass_ticket=GrgT4%2F8z5Z6vuV8DwNMI745mbJuCP7SBDnopt58DCKnLlfs5g%2BvWhAParDyJuKDw","used":true,"who":"LHF"},{"_id":"58d9d6f7421aa969fd8a3dda","createdAt":"2017-03-28T11:22:31.426Z","desc":"一款炫酷的TabLayout","images":["http://img.gank.io/4d76e42b-df53-4080-b243-742c3a777cd3"],"publishedAt":"2017-03-28T12:05:55.791Z","source":"web","type":"Android","url":"https://github.com/simplezhli/ChangeTabLayout","used":true,"who":"唯鹿"},{"_id":"58d9db1b421aa969fd8a3ddc","createdAt":"2017-03-28T11:40:11.461Z","desc":"用 Python 开发 Android 应用程序。","publishedAt":"2017-03-28T12:05:55.791Z","source":"chrome","type":"Android","url":"https://python-for-android.readthedocs.io/en/latest/","used":true,"who":"带马甲"},{"_id":"58d9db57421aa969f75cedee","createdAt":"2017-03-28T11:41:11.86Z","desc":"Android N混合编译与对热补丁影响解析","publishedAt":"2017-03-28T12:05:55.791Z","source":"chrome","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzAwNDY1ODY2OQ==&mid=2649286341&idx=1&sn=054d595af6e824cbe4edd79427fc2706&scene=1&srcid=0811uOHr2RBQDKF0jKEdL4Vc##","used":true,"who":"LHF"},{"_id":"58d9dbd0421aa969fb0fbec3","createdAt":"2017-03-28T11:43:12.731Z","desc":"从两个摄像头同时拍下某一个瞬间","images":["http://img.gank.io/f7073029-38d0-496c-8c94-84027014241f"],"publishedAt":"2017-03-28T12:05:55.791Z","source":"chrome","type":"Android","url":"https://github.com/andyb129/FlipsideCamera","used":true,"who":"带马甲"},{"_id":"58d87141421aa93abb7d4e5c","createdAt":"2017-03-27T09:56:17.694Z","desc":"数据绑定验证工具，快速帮你验证表单数据绑定状况","images":["http://img.gank.io/2c47b670-8af3-4215-a2ad-2481dae3108c"],"publishedAt":"2017-03-27T11:48:52.828Z","source":"chrome","type":"Android","url":"https://github.com/Ilhasoft/data-binding-validator","used":true,"who":"代码家"},{"_id":"58d871c3421aa93abf5d3b7b","createdAt":"2017-03-27T09:58:27.614Z","desc":"一个能让你了解所有函数调用顺序的Android库（无需侵入式代码）","images":["http://img.gank.io/a2fcf6d2-c2d2-46f6-809e-1da56ae603aa"],"publishedAt":"2017-03-27T11:48:52.828Z","source":"chrome","type":"Android","url":"https://github.com/zjw-swun/AppMethodOrder","used":true,"who":"马甲"},{"_id":"58d8726a421aa93abb7d4e5e","createdAt":"2017-03-27T10:01:14.688Z","desc":"如何用 RecyclerView 打造一个不规则形状的旋转效果","images":["http://img.gank.io/8d65e5c1-56a5-46ae-873a-b6f3b3ffac91"],"publishedAt":"2017-03-27T11:48:52.828Z","source":"chrome","type":"Android","url":"https://github.com/danylovolokh/LondonEyeLayoutManager","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58d92e65421aa969fd8a3dd6
         * createdAt : 2017-03-27T23:23:17.262Z
         * desc : DrawerLayout-like ViewGroup, where a "drawer" is hidden under the content view, which can be shifted to make the drawer visible.
         * images : ["http://img.gank.io/7bf7a986-8ea3-48e2-bb55-5d2e61a7595d"]
         * publishedAt : 2017-03-28T12:05:55.791Z
         * source : web
         * type : Android
         * url : https://github.com/yarolegovich/SlidingRootNav
         * used : true
         * who : Yaroslav
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
