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

import java.util.Arrays;

public class MethodReferenceWithGenerics {
    interface MyFunc<T> {
        int func(T[] array, T value);
    }

    public static class ArrayOperations {
        public static <T> int isEqual(T[] array, T value) {
            int count = 0;

            for (T elem : array) {
                if (elem.equals(value)) {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {21, 2, 67, 34, 21, 78, 90, 30};
        System.out.println("Input integer array is: " + Arrays.toString(intArray));
        System.out.println("There are " + invoke(ArrayOperations::<Integer>isEqual, intArray, 21) + " 21s");

        String[] strArray = {"One", "Two", "Four", "One", "Nine", "Six", "One", "Five"};
        System.out.println("Input string array is: " + Arrays.toString(strArray));
        System.out.println("There are " + invoke(ArrayOperations::<String>isEqual, strArray, "One") + " Ones");
    }

    static <T> int invoke(MyFunc<T> myFunc, T[] array, T value) {
        return myFunc.func(array, value);
    }
}
