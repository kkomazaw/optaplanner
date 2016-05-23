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

package org.optaplanner.examples.nurserostering.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.common.swingui.components.Labeled;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOnRequest;


@XStreamAlias("Employee")
public class Employee extends AbstractPersistable implements Labeled {

    private String code;
    private String name;
    private Contract contract;

    private Map<ShiftDate, DayOffRequest> dayOffRequestMap;
    private Map<ShiftDate, DayOnRequest> dayOnRequestMap;
    private Map<Shift, ShiftOffRequest> shiftOffRequestMap;
    private Map<Shift, ShiftOnRequest> shiftOnRequestMap;

    private List<SkillProficiency> skillProficiencyList;

    public List<SkillProficiency> getSkillProficiencyList() {
        if (skillProficiencyList == null)
            skillProficiencyList = new ArrayList<SkillProficiency>();
        return skillProficiencyList;
    }

    public void setSkillProficiencyList(List<SkillProficiency> skillProficiencyList) {
        this.skillProficiencyList = skillProficiencyList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getWeekendLength() {
        return getContract().getWeekendLength();
    }

    public Map<ShiftDate, DayOffRequest> getDayOffRequestMap() {
        return dayOffRequestMap;
    }

    public void setDayOffRequestMap(Map<ShiftDate, DayOffRequest> dayOffRequestMap) {
        this.dayOffRequestMap = dayOffRequestMap;
    }

    public Map<ShiftDate, DayOnRequest> getDayOnRequestMap() {
        return dayOnRequestMap;
    }

    public void setDayOnRequestMap(Map<ShiftDate, DayOnRequest> dayOnRequestMap) {
        this.dayOnRequestMap = dayOnRequestMap;
    }

    public Map<Shift, ShiftOffRequest> getShiftOffRequestMap() {
        return shiftOffRequestMap;
    }

    public void setShiftOffRequestMap(Map<Shift, ShiftOffRequest> shiftOffRequestMap) {
        this.shiftOffRequestMap = shiftOffRequestMap;
    }

    public Map<Shift, ShiftOnRequest> getShiftOnRequestMap() {
        return shiftOnRequestMap;
    }

    public void setShiftOnRequestMap(Map<Shift, ShiftOnRequest> shiftOnRequestMap) {
        this.shiftOnRequestMap = shiftOnRequestMap;
    }

    @Override
    public String getLabel() {

        // Modified by yhasegaw.
        List<Skill> skillList = new ArrayList<Skill>();
        if (skillProficiencyList != null) {
            for (SkillProficiency prof : skillProficiencyList) {
                Skill skill = prof.getSkill();
                skillList.add(skill);
            }
        }

        String role = null;
        if (skillList.size() == 1)
            role = "オペレーター";
        else if (skillList.size() == 2)
            role = "スーパーバイザー";
        else
            role = "No Role ";

        return role + name + "\n"; // + skillList;
    }


    @Override
    public String toString() {
        if (name == null) {
            return super.toString();
        }
        return name;
    }

}
