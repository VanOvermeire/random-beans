/*
 * The MIT License
 *
 *   Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */

package io.github.benas.randombeans.randomizers.collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.github.benas.randombeans.api.Randomizer;

import static io.github.benas.randombeans.randomizers.collection.QueueRandomizer.aNewQueueRandomizer;
import static io.github.benas.randombeans.randomizers.collection.SetRandomizer.aNewSetRandomizer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SetRandomizerTest {

    @Mock
    private Randomizer<String> elementRandomizer;

    @Before
    public void setUp() throws Exception {
        when(elementRandomizer.getRandomValue()).thenReturn("a", "b", "c");
    }

    @Test
    public void generatedSetSizeShouldBeEqualToTheSpecifiedSize() {
        assertThat(aNewQueueRandomizer(elementRandomizer, 3).getRandomValue()).hasSize(3);
    }

    @Test
    public void generatedSetShouldNotBeEmpty() {
        assertThat(aNewSetRandomizer(elementRandomizer).getRandomValue()).isNotEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void specifiedSizeShouldBePositive() {
        aNewSetRandomizer(elementRandomizer, -3);
    }
}
