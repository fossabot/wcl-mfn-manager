/*
 * This project is licensed under the Apache 2.0  license.
 *
 *  For details see the LICENSE file which can be found at the base of this project archive.
 */

package com.wcl.mfnmanager.entities.player;

/**
 * A class wrapping player skill levels, containing both the current skill level and
 * the projected future skill level.
 *
 * @param current - the current skill level.
 * @param future - the projected future skill level.
 */
public record Potential(int current,
                        int future) {
}
