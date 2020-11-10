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

public class GeneticConstructorReference {

    interface NumberFunction<T> {
        NumberCreator<T> func(T number);
    }

    static class NumberCreator<T> {
        private T number;

        public NumberCreator() {
            this.number = null;
        }

        public NumberCreator(T number) {
            this.number = number;
        }

        public T getNumber() {
            return this.number;
        }
    }

    public static void main(String[] args) {
        NumberFunction<Integer> number = NumberCreator<Integer>::new;

        NumberCreator<Integer> creator = number.func(543);

        System.out.println(creator.getNumber());
    }
}
