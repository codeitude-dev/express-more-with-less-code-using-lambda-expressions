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

public class BlockLambda {

    interface StringFunctions {
        String process(String sentence);
    }

    public static void main(String[] args) {

        StringFunctions capitalize = (input) -> {
            input = input.toUpperCase();
            return input;
        };

        String sentence = "Today is saturday.";
        System.out.println("Original sentence is: " + sentence);
        System.out.println("Sentence is capitalized: " + capitalize.process(sentence));
    }
}
