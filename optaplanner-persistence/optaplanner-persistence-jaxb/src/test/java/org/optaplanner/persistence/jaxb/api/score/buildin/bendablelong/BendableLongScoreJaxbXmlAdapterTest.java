/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.persistence.jaxb.api.score.buildin.bendablelong;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.junit.Test;
import org.optaplanner.core.api.score.buildin.bendablelong.BendableLongScore;
import org.optaplanner.persistence.jaxb.api.score.AbstractScoreJaxbXmlAdapterTest;

import static org.junit.Assert.*;

public class BendableLongScoreJaxbXmlAdapterTest extends AbstractScoreJaxbXmlAdapterTest {

    @Test
    public void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestBendableLongScoreWrapper(null));
        BendableLongScore score = BendableLongScore.valueOfInitialized(new long[]{1000L, 200L}, new long[]{34L});
        assertSerializeAndDeserialize(score, new TestBendableLongScoreWrapper(score));
        score = BendableLongScore.valueOf(-7, new long[]{1000L, 200L}, new long[]{34L});
        assertSerializeAndDeserialize(score, new TestBendableLongScoreWrapper(score));
    }

    @XmlRootElement
    public static class TestBendableLongScoreWrapper extends TestScoreWrapper<BendableLongScore> {

        @XmlJavaTypeAdapter(BendableLongScoreJaxbXmlAdapter.class)
        private BendableLongScore score;

        @SuppressWarnings("unused")
        private TestBendableLongScoreWrapper() {
        }

        public TestBendableLongScoreWrapper(BendableLongScore score) {
            this.score = score;
        }

        @Override
        public BendableLongScore getScore() {
            return score;
        }

    }

}
