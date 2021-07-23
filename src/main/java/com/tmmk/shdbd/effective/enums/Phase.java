package com.tmmk.shdbd.effective.enums;

import javafx.animation.Transition;

/**
 * TODO <功能详细描述>
 *
 * @author Lost
 * @version 4.10.0
 * @date 2021-03-09 9:31
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {

        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        public static Transition form(Phase src, Phase dst) {
            return TRANSITIONS[src.ordinal()][dst.ordinal()];
        }
    }

}
