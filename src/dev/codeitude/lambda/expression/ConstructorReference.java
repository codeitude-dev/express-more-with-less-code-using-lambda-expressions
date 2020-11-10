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

public class ConstructorReference {

    interface NumberFunction {
        NumberCreator func(int number);
    }

    static class NumberCreator {
        private int number;

        public NumberCreator() {
            this.number = 189;
        }

        public NumberCreator(int number) {
            this.number = number;
        }

        public int getNumber() {
            return this.number;
        }
    }

    public static void main(String[] args) {
        NumberFunction number = NumberCreator::new;

        NumberCreator creator = number.func(543);

        System.out.println(creator.getNumber());
    }
}
