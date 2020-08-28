/*-
 * ========================LICENSE_START=================================
 * TeamApps
 * ---
 * Copyright (C) 2014 - 2020 TeamApps.org
 * ---
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
 * =========================LICENSE_END==================================
 */
package org.teamapps.ux.component.timegraph;

import org.teamapps.dto.UiLongInterval;

import java.util.Objects;

public class Interval {

	private final long min;
	private final long max;

	public Interval(long min, long max) {
		this.min = min;
		this.max = max;
	}

	public static Interval union(Interval interval, Interval intervalB) {
		return new Interval(Math.min(interval.getMin(), intervalB.getMin()), Math.max(interval.getMax(), intervalB.getMax()));
	}

	public long getMin() {
		return min;
	}

	public long getMax() {
		return max;
	}

	public UiLongInterval createUiLongInterval() {
		return new UiLongInterval(min, max);
	}

	@Override
	public String toString() {
		return "Interval{" +
				"min=" + min +
				", max=" + max +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Interval interval = (Interval) o;
		return min == interval.min &&
				max == interval.max;
	}

	@Override
	public int hashCode() {
		return Objects.hash(min, max);
	}
}
