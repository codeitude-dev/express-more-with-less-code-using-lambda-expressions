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

public class InstanceMethodReference {

    interface NumberFunctions{
        int func(int number);
    }

    static class MyNumberLibrary {
        public int squareTheNumber(int number){
            return number * number;
        }
    }

    public static void main(String[] args) {
        int input = 10;
        MyNumberLibrary myNumberLibrary = new MyNumberLibrary();
        int output = numberFunc(myNumberLibrary::squareTheNumber, input);

        System.out.println("Input number: " + input);
        System.out.println("Square of number: " + output);
    }

    static int numberFunc(NumberFunctions functions, int number){
        return functions.func(number);
    }
}
