//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.goldmsg.logTool.utils;

public interface CommonConstants {
    public static enum ZFType {
        AUDIO_MENU_ZFDA_JTWF_JYCX,
        AUDIO_MENU_ZFDA_JTWF_FXCCL,
        AUDIO_MENU_ZFDA_JTWF_QZCS,
        AUDIO_MENU_ZFDA_SGCL,
        AUDIO_MENU_ZFDA_JQGL,
        AUDIO_MENU_ZFDA_AJGL;

        private ZFType() {
        }
    }

    public static enum RelevanceType {
        ZDGL,
        SDGL;

        private RelevanceType() {
        }
    }

    public static enum YesNo {
        YES("1"),
        NO("0");

        private String value;

        private YesNo(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static enum PoliceType {
        LEVAM_JYLB_LD,
        LEVAM_JYLB_ZONGDUI_LD,
        LEVAM_JYLB_ZHIDUI_LD,
        LEVAM_JYLB_DADUI_LD,
        LEVAM_JYLB_ZHONGDUI_LD,
        LEVAM_JYLB_JY,
        LEVAM_JYLB_FJ,
        LEVAM_JYLB_FZLD,
        LEVAM_JYLB_QT;

        private PoliceType() {
        }
    }

    public static enum EvaStatus {
        ALL,
        JCYKP,
        JCWKP,
        FZYKP,
        FZWKP;

        private EvaStatus() {
        }
    }

    public static enum EvaType {
        BASIC,
        LEGAL;

        private EvaType() {
        }
    }

    public static enum TrafficLEType {
        VIOLATION,
        SURVEIL,
        FORCE,
        ACCIDENT;

        private TrafficLEType() {
        }
    }

    public static enum LEDataType {
        PS,
        CM;

        private LEDataType() {
        }
    }

    public static enum TradeType {
        GA,
        JJ;

        private TradeType() {
        }
    }
}
