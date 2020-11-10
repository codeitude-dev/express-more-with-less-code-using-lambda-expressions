/*
 * Copyright 2020 https://codeitude.dev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.codeitude.lambda.expression;

public class InstanceMethodReferenceV2 {
    interface MyFunc {
        boolean func(Month month, int days);
    }

    static class Month {
        private int days;
        private String name;

        public Month(String name, int days) {
            this.name = name;
            this.days = days;
        }

        boolean daysAreSameOrMore(int days) {
            return this.days >= days;
        }
    }

    static int counter(Month[] vals, MyFunc f, int days) {
        int count = 0;

        for (Month val : vals) {
            if (f.func(val, days)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = 0;
        Month[] months = {new Month("Jan", 31), new Month("Feb", 28),
                new Month("Mar", 31), new Month("Apr", 30), new Month("May", 31),
                new Month("Jun", 30), new Month("Jul", 31), new Month("Aug", 31),
                new Month("Sep", 30), new Month("Oct", 31), new Month("Nov", 30),
                new Month("Dec", 31)};

        int days = 31;
        count = counter(months, Month::daysAreSameOrMore, days);
        System.out.println("Number of months with days equal to or more than " + days + " are " + count);
    }
}
