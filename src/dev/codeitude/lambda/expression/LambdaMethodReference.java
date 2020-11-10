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

public class LambdaMethodReference {
    interface MyFunc<T> {
        boolean func(T v1, T v2);
    }

    static class HighTemp {
        private int hTemp;

        public HighTemp(int hTemp) {
            this.hTemp = hTemp;
        }

        boolean sameTemp(HighTemp ht2) {
            return hTemp == ht2.hTemp;
        }

        boolean lessThanTemp(HighTemp ht2) {
            return hTemp < ht2.hTemp;
        }
    }

    static <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;

        for (T val : vals) {
            if (f.func(val, v)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = 0;
        HighTemp[] weekDayHighs = {new HighTemp(90), new HighTemp(89), new HighTemp(92), new HighTemp(88),
                new HighTemp(90), new HighTemp(93), new HighTemp(91)};

        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
    }
}
