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

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BooleanContractLine")
public class BooleanContractLine extends ContractLine {

    private boolean enabled;
    private int weight;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        String str = contractLineType.toString();
        switch (contractLineType) {
        case SINGLE_ASSIGNMENT_PER_DAY:
            str = "1日当りのシフト数は" + weight + "とする。";
            break;
        case COMPLETE_WEEKENDS:
            str = "週末勤務の場合、週末の初日に勤務開始し、週末の最終日に勤務終了すること";
            break;
        case IDENTICAL_SHIFT_TYPES_DURING_WEEKEND:
            str = "週末勤務の場合、同じシフトパターン勤務とすること";
            break;          
        default:
            break;
        }
        return str;

    }

}
