package com.pjb.springbootjjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
class startMeta1{
    private String parentTagName;
    private int parentIndex;
    private int textOffset;

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class endMeta1{
    private String parentTagName;
    private int parentIndex;
    private int textOffset;

}
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Source {
    /**
     * fSourceId : d1fbad92-c4ee-4ed1-9fb2-8ed3e7af266b
     * startMeta : {"parentTagName":"P","parentIndex":10,"textOffset":0}
     * endMeta : {"parentTagName":"P","parentIndex":10,"textOffset":161}
     * text : 我们已经成功创建了第一个 Vue 应用！看起来这跟渲染一个字符串模板非常类似，但是 Vue 在背后做了大量工作。现在数据和 DOM 已经被建立了关联，所有东西都是响应式的。我们要怎么确认呢？打开你的浏览器的 JavaScript 控制台 (就在这个页面打开)，并修改 app.message 的值，你将看到上例相应地更新。
     * tint : rgb(255, 235, 59)
     * note : kvgugjhhihiu
     * link : https://cn.vuejs.org/v2/guide/
     */

    private String fSourceId;
    private StartMetaBean startMeta;
    private EndMetaBean endMeta;
    private String text;
    private String tint;
    private String note;
    private String link;

    public String getfSourceId() {
        return fSourceId;
    }

    public void setfSourceId(String fSourceId) {
        this.fSourceId = fSourceId;
    }

    public StartMetaBean getStartMeta() {
        return startMeta;
    }

    public void setStartMeta(StartMetaBean startMeta) {
        this.startMeta = startMeta;
    }

    public EndMetaBean getEndMeta() {
        return endMeta;
    }

    public void setEndMeta(EndMetaBean endMeta) {
        this.endMeta = endMeta;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTint() {
        return tint;
    }

    public void setTint(String tint) {
        this.tint = tint;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static class StartMetaBean {
        /**
         * parentTagName : P
         * parentIndex : 10
         * textOffset : 0
         */

        private String parentTagName;
        private int parentIndex;
        private int textOffset;

        public String getParentTagName() {
            return parentTagName;
        }

        public void setParentTagName(String parentTagName) {
            this.parentTagName = parentTagName;
        }

        public int getParentIndex() {
            return parentIndex;
        }

        public void setParentIndex(int parentIndex) {
            this.parentIndex = parentIndex;
        }

        public int getTextOffset() {
            return textOffset;
        }

        public void setTextOffset(int textOffset) {
            this.textOffset = textOffset;
        }
    }

    public static class EndMetaBean {
        /**
         * parentTagName : P
         * parentIndex : 10
         * textOffset : 161
         */

        private String parentTagName;
        private int parentIndex;
        private int textOffset;

        public String getParentTagName() {
            return parentTagName;
        }

        public void setParentTagName(String parentTagName) {
            this.parentTagName = parentTagName;
        }

        public int getParentIndex() {
            return parentIndex;
        }

        public void setParentIndex(int parentIndex) {
            this.parentIndex = parentIndex;
        }

        public int getTextOffset() {
            return textOffset;
        }

        public void setTextOffset(int textOffset) {
            this.textOffset = textOffset;
        }
    }
//    private String fSourceId;
//    private List<startMeta1> startMeta;
//    private List<endMeta1> endMeta;
//    private String text;
//    private String tint;
//    private String note;
//    private String link;
//
//    public String getfSourceId() {
//        return fSourceId;
//    }
//
//    public void setfSourceId(String fSourceId) {
//        this.fSourceId = fSourceId;
//    }

}

