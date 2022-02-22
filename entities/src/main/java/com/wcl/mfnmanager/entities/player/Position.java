/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.entities.player;

/**
 * An enumeration of the possible positions within the game.
 *
 * Two arrays are also provided to distinguish between Special team and non Special team positions.
 */
public enum Position {
    QB, RB, FB, TE, WR, LT, LG, C, RG, RT, P, K, LDE, DT, RDE, SLB, MLB, WLB, CB, CF, SS, FS, GUNNER, KH, KR, LS, PR, STBLK, STRUSH;

    public static final Position[] MAIN_POSITIONS = {QB, RB, FB, TE, WR, LT, LG, C, RG, RT, LDE, DT, RDE, SLB, MLB, WLB, CB, CF, SS, FS};
    public static final Position[] ST_POSITIONS = {P, K, GUNNER, KH, KR, LS, PR, STBLK, STRUSH};
}
