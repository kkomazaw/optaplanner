/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.nurserostering.domain.contract;

public enum ContractLineType {
    SINGLE_ASSIGNMENT_PER_DAY("一日当りのシフト数は、"),
    TOTAL_ASSIGNMENTS("foobar"),
    CONSECUTIVE_WORKING_DAYS("foobar"),
    CONSECUTIVE_FREE_DAYS("foobar"),
    CONSECUTIVE_WORKING_WEEKENDS("foobar"),
    TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS("foobar"),
    COMPLETE_WEEKENDS("foobar"),
    IDENTICAL_SHIFT_TYPES_DURING_WEEKEND("foobar"),
    NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND("foobar"),
    ALTERNATIVE_SKILL_CATEGORY("foobar");
    
    private final String jpText;

    private ContractLineType(String jpText) {
        this.jpText = jpText;
    }

    public String getJpText() {
        return jpText;
    }

}
