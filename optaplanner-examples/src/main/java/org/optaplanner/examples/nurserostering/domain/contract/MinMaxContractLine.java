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

@XStreamAlias("MinMaxContractLine")
public class MinMaxContractLine extends ContractLine {

    private boolean minimumEnabled;
    private int minimumValue;
    private int minimumWeight;

    private boolean maximumEnabled;
    private int maximumValue;
    private int maximumWeight;

    public boolean isMinimumEnabled() {
        return minimumEnabled;
    }

    public void setMinimumEnabled(boolean minimumEnabled) {
        this.minimumEnabled = minimumEnabled;
    }

    public int getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
    }

    public int getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(int minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public boolean isMaximumEnabled() {
        return maximumEnabled;
    }

    public void setMaximumEnabled(boolean maximumEnabled) {
        this.maximumEnabled = maximumEnabled;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(int maximumValue) {
        this.maximumValue = maximumValue;
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    @Override
    public boolean isEnabled() {
        return minimumEnabled || maximumEnabled;
    }

    @Override
    public String toString() {
        String str = contractLineType.toString() + "minmax";
        switch (contractLineType) {
        case TOTAL_ASSIGNMENTS:
            str = "勤務シフト数の最小値は" + minimumValue + "人日、最大値は" + maximumValue +"人日とする。";
            break;
        case CONSECUTIVE_WORKING_DAYS:
            str = "最小連続勤務数は" + minimumValue + "人日、最大連続勤務数は" + maximumValue +"人日とする。";
            break;
        case CONSECUTIVE_FREE_DAYS:
            str = "最小の連続非勤務日数は" + minimumValue + "人日、最大の連続非勤務日数は" + maximumValue +"人日とする。";
            break;          
        default:
            break;
        }

        return str;
    }

}
